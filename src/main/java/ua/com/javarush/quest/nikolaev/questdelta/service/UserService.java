package ua.com.javarush.quest.nikolaev.questdelta.service;

import ua.com.javarush.quest.nikolaev.questdelta.dto.UserDto;
import ua.com.javarush.quest.nikolaev.questdelta.entity.Role;
import ua.com.javarush.quest.nikolaev.questdelta.entity.User;
import ua.com.javarush.quest.nikolaev.questdelta.mapper.Mapper;
import ua.com.javarush.quest.nikolaev.questdelta.mapper.UserMapper;
import ua.com.javarush.quest.nikolaev.questdelta.repository.Repository;
import ua.com.javarush.quest.nikolaev.questdelta.repository.UserRepository;

import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ua.com.javarush.quest.nikolaev.questdelta.utils.Const.*;

public enum UserService {
    INSTANCE;

    private final Repository<User> userRepository = UserRepository.getInstance();
    private final Mapper<UserDto, User> userMapper = new UserMapper();

    public Collection<UserDto> getAll(int pageNumber, int pageSize) {
        return userRepository.getAll().stream()
                .sorted(Comparator.comparing(User::getLogin))
                .skip((long) pageNumber * pageSize)
                .limit(pageSize)
                .map(userMapper::toDto)
                .toList();
    }

    public Integer getAllCount() {
        return userRepository.getAll().size();
    }

    public Optional<UserDto> findByCredentials(String login, String password) {
        Optional<User> userOptional = userRepository.find(User.builder()
                        .login(login)
                        .password(password)
                        .build()).stream()
                .findFirst();

        return userOptional.map(userMapper::toDto);
    }

    public Optional<UserDto> findByLogin(String login) {
        Optional<User> userOptional = userRepository.find(User.builder()
                        .login(login)
                        .build())
                .stream()
                .findFirst();

        return userOptional.map(userMapper::toDto);
    }

    public boolean validateLogin(String login) {
        String regex = "^[A-Za-z\\d]{1,20}$";
        return check(regex, login);
    }

    public boolean validatePassword(String password) {
        String regex = "^[A-Za-z\\d]{1,8}$";
        return check(regex, password);
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

    public void deleteById(long id) {
        userRepository.deleteById(id);
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
