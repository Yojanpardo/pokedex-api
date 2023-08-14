package dev.yojanpardo.user.adapter.out.persistence;

import dev.yojanpardo.common.persistence.EntityMapper;
import dev.yojanpardo.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("userEntityMapper")
@RequiredArgsConstructor
public class UserEntityMapper implements EntityMapper<User, UserEntity> {

    private final PasswordEncoder passwordEncoder;
    @Override
    public User entityToDomain(UserEntity entityObject) {
        return User.builder()
                .username(entityObject.getUsername())
                .id(entityObject.getId())
                .email(entityObject.getEmail())
                .build();
    }

    @Override
    public UserEntity domainToEntity(User domainObject) {
        return UserEntity.builder()
                .id(domainObject.getId())
                .email(domainObject.getEmail())
                .encodedPassword(passwordEncoder.encode(domainObject.getPassword()))
                .username(domainObject.getUsername())
                .build();
    }
}
