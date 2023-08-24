package dev.yojanpardo.user.adapter.in.web;

public record UserLoginResponse(
        String username,
        String token,
        String refreshToken,
        String validUntil
) {
}
