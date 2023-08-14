package dev.yojanpardo.user.adapter.out.persistence;

import dev.yojanpardo.common.persistence.EntityMapper;
import dev.yojanpardo.user.application.port.out.UserPort;
import dev.yojanpardo.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class UserPersistenceAdapter implements UserPort {

    private final UserJpaRepository userJpaRepository;
    private final EntityMapper<User, UserEntity> mapper;

    public UserPersistenceAdapter(
            UserJpaRepository userJpaRepository,
            @Qualifier("userEntityMapper") EntityMapper<User, UserEntity> mapper) {
        this.userJpaRepository = userJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public User registerUser(User user) {
        return mapper.entityToDomain(userJpaRepository.save(mapper.domainToEntity(user)));
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public User getUserByUserId(Long userId) {
        return null;
    }
}
