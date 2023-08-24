package dev.yojanpardo.user.adapter.out.persistence;

import dev.yojanpardo.user.domain.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Column(name = "password")
    private String encodedPassword;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
}
