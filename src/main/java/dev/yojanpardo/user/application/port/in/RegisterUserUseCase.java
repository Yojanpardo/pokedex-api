package dev.yojanpardo.user.application.port.in;

import dev.yojanpardo.user.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface RegisterUserUseCase {
    User registerUser(final UserRegisterCommand userRegisterCommand);

    User getUserByUsername(String username);

    UserDetailsService userDetailsService();
}
