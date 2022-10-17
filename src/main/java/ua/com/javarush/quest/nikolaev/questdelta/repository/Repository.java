package ua.com.javarush.quest.nikolaev.questdelta.repository;

import ua.com.javarush.quest.nikolaev.questdelta.entity.User;

import java.util.Collection;
import java.util.Optional;

public interface Repository<T> {

    Optional<T> getById(long id);

    Optional<T> find(T entity);

    void create(T entity);

    void update(T entity);

    void deleteById(long id);

    Collection<User> getAll();
}
