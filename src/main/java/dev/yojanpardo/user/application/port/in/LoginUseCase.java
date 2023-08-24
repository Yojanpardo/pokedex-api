package dev.yojanpardo.user.application.port.in;

import dev.yojanpardo.user.domain.UserLogin;

public interface LoginUseCase {

    UserLogin login(final UserLoginCommand command);
}
