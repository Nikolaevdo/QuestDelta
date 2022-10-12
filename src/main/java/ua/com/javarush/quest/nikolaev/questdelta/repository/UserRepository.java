package ua.com.javarush.quest.nikolaev.questdelta.repository;

import ua.com.javarush.quest.nikolaev.questdelta.entity.Role;
import ua.com.javarush.quest.nikolaev.questdelta.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class UserRepository implements Repository<User> {

    private static UserRepository userRepository;

    private final Map<Long, User> users = new HashMap<>();

    private static final AtomicLong id = new AtomicLong(0);

    // Create start userAccounts
    private UserRepository() {
        users.put(1L, User.builder()
                .id(1L)
                .login("admin")
                .password("123")
                .role(Role.ADMIN)
                .build());
        users.put(2L, User.builder()
                .id(2L)
                .login("user")
                .password("321")
                .role(Role.USER)
                .build());
        users.put(3L, User.builder()
                .id(3L)
                .login("guest")
                .password("333")
                .role(Role.GUEST)
                .build());
    }

    @Override
    public Optional<User> getById(long id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public Optional<User> find(User user) {
        return users.values().stream()
                .filter(userInDB -> userInDB.getLogin().equals(user.getLogin()))
                .findFirst();
    }

    @Override
    public void create(User entity) {
        entity.setId(id.incrementAndGet());
        update(entity);
    }

    @Override
    public void update(User entity) {
        users.put(entity.getId(), entity);
    }

    @Override
    public void deleteById(long id) {
        users.remove(id);
    }

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }

}
