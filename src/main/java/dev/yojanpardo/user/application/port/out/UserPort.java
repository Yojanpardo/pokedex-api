package dev.yojanpardo.user.application.port.out;

import dev.yojanpardo.user.domain.User;

public interface UserPort {
    User registerUser(User user);
    User getUserByUsername(String username);
    User getUserByUserId(Long userId);
}
