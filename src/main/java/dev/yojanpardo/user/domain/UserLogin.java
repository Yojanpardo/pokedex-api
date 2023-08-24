package dev.yojanpardo.user.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLogin {
    private String username;
    private String token;
    private String refreshToken;
    private String validUntil;
}
