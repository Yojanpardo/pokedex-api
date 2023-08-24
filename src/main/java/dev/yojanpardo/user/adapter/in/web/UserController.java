package dev.yojanpardo.user.adapter.in.web;

import dev.yojanpardo.user.application.port.in.LoginUseCase;
import dev.yojanpardo.user.application.port.in.RegisterUserUseCase;
import dev.yojanpardo.user.application.port.in.UserLoginCommand;
import dev.yojanpardo.user.application.port.in.UserRegisterCommand;
import dev.yojanpardo.user.domain.User;
import dev.yojanpardo.user.domain.UserLogin;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final RegisterUserUseCase registerUserUseCase;
    private final LoginUseCase userLoginUseCase;

    @PostMapping
    public ResponseEntity<UserResponse> registerUser(@RequestBody final UserRegisterCommand userRegisterCommand){
        final User user = registerUserUseCase.registerUser(userRegisterCommand);
        final UserResponse response = new UserResponse(
                user.getUsername(),
                user.getEmail(),
                user.getId()
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> userLogin(@RequestBody final UserLoginCommand command) {
        final UserLogin userLogin = userLoginUseCase.login(command);
        final UserLoginResponse response = buildResponse(userLogin);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private static UserLoginResponse buildResponse(UserLogin userLogin) {
        return new UserLoginResponse(
                userLogin.getUsername(),
                userLogin.getToken(),
                userLogin.getRefreshToken(),
                userLogin.getValidUntil()
        );
    }
}
