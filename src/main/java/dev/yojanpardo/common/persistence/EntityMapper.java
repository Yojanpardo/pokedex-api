package dev.yojanpardo.common.persistence;

/**
 * Generic interface for domain/persistence entity objects
 *
 * @param <T> the domain object
 * @param <S> the persistence entity object
 */
public interface EntityMapper<T, S> {
    T entityToDomain(S entityObject);
    S domainToEntity(T domainObject);
}
