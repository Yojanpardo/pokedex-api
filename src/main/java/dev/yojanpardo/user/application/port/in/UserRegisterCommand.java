package dev.yojanpardo.user.application.port.in;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRegisterCommand{
        private String username;
         private String password;
         private String email;
    public UserRegisterCommand( String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
