package dev.yojanpardo.user.application.service;

import dev.yojanpardo.common.authorization.JwtToken;
import dev.yojanpardo.user.application.port.in.LoginUseCase;
import dev.yojanpardo.user.application.port.in.RegisterUserUseCase;
import dev.yojanpardo.user.application.port.in.UserLoginCommand;
import dev.yojanpardo.user.application.port.in.UserRegisterCommand;
import dev.yojanpardo.user.application.port.out.UserPort;
import dev.yojanpardo.user.domain.Role;
import dev.yojanpardo.user.domain.User;
import dev.yojanpardo.user.domain.UserLogin;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static dev.yojanpardo.common.utils.TimeUtils.dateToString;

@Service
@RequiredArgsConstructor
public class UserService implements RegisterUserUseCase, LoginUseCase {

    private final UserPort userPort;
    private final PasswordEncoder encoder;
    private final JwtToken jwtTokenService;

    @Override
    public User registerUser(final UserRegisterCommand userRegisterCommand) {

        return userPort.registerUser(User.builder()
                        .email(userRegisterCommand.getEmail())
                        .password(userRegisterCommand.getPassword())
                        .username(userRegisterCommand.getUsername())
                        .role(Role.USER)
                        .build());
    }

    @Override
    public User getUserByUsername(String username) {
        return userPort.getUserByUsername(username);
    }

    @Override
    public UserDetailsService userDetailsService() {
        return userPort::getUserByUsername;
    }

    @Override
    public UserLogin login(final UserLoginCommand command) {

        final User user = validateLogin(command);
        return UserLogin.builder()
                .token(jwtTokenService.createToken(user.getUsername()))
                .username(user.getUsername())
                .refreshToken(jwtTokenService.createToken(user.getUsername()))
                .validUntil(dateToString(jwtTokenService.getExpirationTime()))
                .build();

    }

    private User validateLogin(final UserLoginCommand command) {
        if (Objects.isNull(command.getUsername()) || command.getUsername().isEmpty() || command.getUsername().isBlank()){
            throw new IllegalArgumentException("username is mandatory and can not be an empty or a blank string");
        }

        if (Objects.isNull(command.getPassword()) || command.getPassword().isEmpty()){
            throw new IllegalArgumentException("password is mandatory and can not be an empty string");
        }

        final var user = userPort.getUserByUsername(command.getUsername());

        if (!encoder.matches(command.getPassword(), user.getEncodedPassword())){
            throw new IllegalArgumentException("User or Password incorrect");
        }

        return user;
    }
}
