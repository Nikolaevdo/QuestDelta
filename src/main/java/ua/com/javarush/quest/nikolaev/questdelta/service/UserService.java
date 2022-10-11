package ua.com.javarush.quest.nikolaev.questdelta.service;

import ua.com.javarush.quest.nikolaev.questdelta.entity.User;
import ua.com.javarush.quest.nikolaev.questdelta.repository.Repository;
import ua.com.javarush.quest.nikolaev.questdelta.repository.UserRepository;

import java.util.Optional;

public enum UserService {
    INSTANCE;

    private final Repository<User> userRepository = UserRepository.getInstance();

    public Optional<User> validate(String login, String password) {
        return  userRepository.find(User.builder()
                .login(login)
                .password(password)
                .build());
    }
}
