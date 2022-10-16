package ua.com.javarush.quest.nikolaev.questdelta.service;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.javarush.quest.nikolaev.questdelta.dto.UserDto;
import ua.com.javarush.quest.nikolaev.questdelta.utils.Jsp;

import java.io.IOException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ua.com.javarush.quest.nikolaev.questdelta.utils.Const.*;
import static ua.com.javarush.quest.nikolaev.questdelta.utils.ErrorMessage.*;

public enum AuthService {
    INSTANCE;
    private final UserService userService = UserService.INSTANCE;

    public void validateCredentials(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        boolean validLogin = userService.validateLogin(login);
        if (!validLogin) {
            req.setAttribute(ERROR_ATTRIBUTE, LOGIN_NOT_VALID);
            Jsp.forward(req, resp, SIGNUP);
        }

        String password = req.getParameter("password"); //TODO Validate in filter log/pass with AuthService?
        boolean validPass = userService.validatePassword(password);
        if (!validPass) {
            req.setAttribute(ERROR_ATTRIBUTE, PASSWORD_NOT_VALID);
            Jsp.forward(req, resp, SIGNUP);
        }

        Optional<UserDto> user = userService.findByLogin(login);
        if (user.isPresent()) {
            req.setAttribute(ERROR_ATTRIBUTE, LOGIN_ALREADY_USED);
            Jsp.forward(req, resp, SIGNUP);
        }
    }


    public boolean validateLogin(String login) {
        return check(REGEX_LOGIN, login);
    }

    public boolean validatePassword(String password) {
        return check(REGEX_PASS, password);
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
