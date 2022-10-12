package ua.com.javarush.quest.nikolaev.questdelta.service;

import ua.com.javarush.quest.nikolaev.questdelta.entity.Role;
import ua.com.javarush.quest.nikolaev.questdelta.entity.User;
import ua.com.javarush.quest.nikolaev.questdelta.repository.Repository;
import ua.com.javarush.quest.nikolaev.questdelta.repository.UserRepository;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ua.com.javarush.quest.nikolaev.questdelta.utils.Const.*;
public enum UserService {
    INSTANCE;

    private final Repository<User> userRepository = UserRepository.getInstance();

    public Optional<User> findByCredentials(String login, String password) {
        return userRepository.find(User.builder()
                .login(login)
                .password(password)
                .build());
    }

    public Optional<User> findByLogin(String login) {
        return userRepository.find(User.builder()
                .login(login)
                .build());
    }

    public boolean validateLogin(String login) {
        return check(REGEX_LOGIN, login);
    }

    public boolean validatePassword(String password) {
        return check(REGEX_PASS, password);
    }

    public void createUser(String login, String password, Role role) {
        userRepository.create(User.builder()
                .login(login)
                .password(password)
                .role(role)
                .build());
    }

    public void createUser(String login, String password) {
        userRepository.create(User.builder()
                .login(login)
                .password(password)
                .role(Role.USER)
                .build());
    }

    private boolean check(String regex, String input) {
        if (input == null) {
            return false;
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
