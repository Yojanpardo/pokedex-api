package dev.yojanpardo.user.application.port.in;

import dev.yojanpardo.user.domain.User;

public interface RegisterUserUseCase {
    User registerUser(final UserRegisterCommand userRegisterCommand);
}
