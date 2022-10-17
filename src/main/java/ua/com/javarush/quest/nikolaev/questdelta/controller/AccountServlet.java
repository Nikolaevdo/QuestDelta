package ua.com.javarush.quest.nikolaev.questdelta.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ua.com.javarush.quest.nikolaev.questdelta.dto.UserDto;
import ua.com.javarush.quest.nikolaev.questdelta.service.UserService;
import ua.com.javarush.quest.nikolaev.questdelta.utils.*;

import java.io.IOException;
import java.util.Collection;

import static ua.com.javarush.quest.nikolaev.questdelta.utils.Const.*;

@WebServlet(name = ACCOUNTSERVLET, value = ACCOUNTSERVLETVALUE)
public class AccountServlet extends HttpServlet {

    private final UserService userService = UserService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<UserDto> users = userService.getAll();
        request.setAttribute(Attribute.USERS.getName(), users);
        Jsp.forward(request, response, ACCOUNTS);
    }

}