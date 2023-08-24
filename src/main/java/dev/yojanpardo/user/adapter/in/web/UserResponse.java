package dev.yojanpardo.user.adapter.in.web;

public record UserResponse(
        String username,
        String email,
        Long userId
) {}
