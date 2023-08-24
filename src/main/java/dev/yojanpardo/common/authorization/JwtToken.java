package dev.yojanpardo.common.authorization;

import dev.yojanpardo.user.domain.User;

import java.util.Date;

public interface JwtToken {
    String createToken(final String username);
    Date getExpirationTime();

    String getUsername(String jwt);

    boolean isTokenValid(String jwt, User user);
}
