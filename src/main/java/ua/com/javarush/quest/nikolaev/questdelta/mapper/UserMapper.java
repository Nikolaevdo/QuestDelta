package ua.com.javarush.quest.nikolaev.questdelta.mapper;

import ua.com.javarush.quest.nikolaev.questdelta.dto.UserDto;
import ua.com.javarush.quest.nikolaev.questdelta.entity.User;

public class UserMapper implements Mapper<UserDto, User> {

    @Override
    public UserDto toDto(User entity) {
        return UserDto.builder()
                .login(entity.getLogin())
                .role(entity.getRole())
                .build();
    }
}
