package dev.yojanpardo.user.adapter.in.web;

import dev.yojanpardo.common.validation.Validation;
import jakarta.validation.constraints.NotNull;

public record UserResponse(
        String username,
        String email,
        Long userId
) {

    public UserResponse(String username, String email, Long userId) {
        this.username = username;
        this.email = email;
        this.userId = userId;
    }
}
