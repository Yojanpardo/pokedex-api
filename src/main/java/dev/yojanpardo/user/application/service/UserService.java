package dev.yojanpardo.user.application.service;

import dev.yojanpardo.user.application.port.in.RegisterUserUseCase;
import dev.yojanpardo.user.application.port.in.UserRegisterCommand;
import dev.yojanpardo.user.application.port.out.UserPort;
import dev.yojanpardo.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements RegisterUserUseCase {
    private final UserPort userPort;

    @Override
    public User registerUser(UserRegisterCommand userRegisterCommand) {
        return userPort.registerUser(User.builder()
                        .email(userRegisterCommand.getEmail())
                        .password(userRegisterCommand.getPassword())
                        .username(userRegisterCommand.getUsername())
                        .build());
    }
}
