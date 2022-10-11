package ua.com.javarush.quest.nikolaev.questdelta.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Long id;
    private String login;
    private String password;
    private Role role;
}
