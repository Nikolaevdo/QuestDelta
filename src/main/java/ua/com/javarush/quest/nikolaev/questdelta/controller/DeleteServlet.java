package ua.com.javarush.quest.nikolaev.questdelta.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.javarush.quest.nikolaev.questdelta.dto.UserDto;
import ua.com.javarush.quest.nikolaev.questdelta.service.UserService;
import ua.com.javarush.quest.nikolaev.questdelta.utils.Attribute;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

import static ua.com.javarush.quest.nikolaev.questdelta.utils.ErrorMessage.*;

public class DeleteServlet extends HttpServlet {
    private final UserService userService = UserService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        if (Objects.isNull(login)) {
            req.setAttribute(Attribute.ERROR.getName(), USER_NOT_FOUND);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/accounts");
            requestDispatcher.forward(req, resp);
            return;
        }

        UserDto currentUser = (UserDto) req.getSession().getAttribute(Attribute.USER.getName());
        String userLogin = currentUser.getLogin();
        if (login.equals(userLogin)) {
            req.setAttribute(Attribute.ERROR.getName(), DELETE_YOURSELF);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/accounts");
            requestDispatcher.forward(req, resp);
            return;
        }

        Optional<UserDto> user = userService.findByLogin(login);
        user.ifPresent(userDto -> userService.deleteById(userDto.getId()));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/accounts");
        requestDispatcher.forward(req, resp);
    }
}
