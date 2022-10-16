package ua.com.javarush.quest.nikolaev.questdelta.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ua.com.javarush.quest.nikolaev.questdelta.dto.UserDto;
import ua.com.javarush.quest.nikolaev.questdelta.entity.User;
import ua.com.javarush.quest.nikolaev.questdelta.mapper.Mapper;
import ua.com.javarush.quest.nikolaev.questdelta.mapper.UserMapper;
import ua.com.javarush.quest.nikolaev.questdelta.service.UserService;
import ua.com.javarush.quest.nikolaev.questdelta.utils.Attribute;
import ua.com.javarush.quest.nikolaev.questdelta.utils.Jsp;

import java.io.IOException;
import java.util.Optional;

import static ua.com.javarush.quest.nikolaev.questdelta.utils.Const.*;
import static ua.com.javarush.quest.nikolaev.questdelta.utils.ErrorMessage.*;

@WebServlet(name = SIGNUPSERVLET, value = SIGNUPSERVLETVALUE)
public class SignupServlet extends HttpServlet {

    private final UserService userService = UserService.INSTANCE;
    private final Mapper<UserDto, User> userMapper = new UserMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsp.forward(req, resp, SIGNUP);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login"); //TODO Duplicate code with LoginServlet
        boolean validLogin = userService.validateLogin(login);
        if (!validLogin) {
            req.setAttribute(Attribute.ERROR.getName(), LOGIN_NOT_VALID);
            Jsp.forward(req, resp, SIGNUP);
        }

        String password = req.getParameter("password"); //TODO Validate in filter log/pass with AuthService?
        boolean validPass = userService.validatePassword(password);
        if (!validPass) {
            req.setAttribute(Attribute.ERROR.getName(), PASSWORD_NOT_VALID);
            Jsp.forward(req, resp, SIGNUP);
        }

        Optional<UserDto> user = userService.findByLogin(login);
        if (user.isPresent()) {
            req.setAttribute(Attribute.ERROR.getName(), LOGIN_ALREADY_USED);
            Jsp.forward(req, resp, SIGNUP);
        }

        userService.createUser(login, password);
        Optional<UserDto> userDtoFromDB = userService.findByCredentials(login, password);
        if (userDtoFromDB.isPresent()) {
            HttpSession session = req.getSession();
            session.setAttribute(Attribute.USER.getName(), userDtoFromDB);
            Jsp.forward(req, resp, MENU);
        } else {
            req.setAttribute(Attribute.ERROR.getName(), USER_NOT_CREATED);
            Jsp.forward(req, resp, SIGNUP);
        }
    }
}
