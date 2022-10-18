package ua.com.javarush.quest.nikolaev.questdelta.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ua.com.javarush.quest.nikolaev.questdelta.dto.UserDto;
import ua.com.javarush.quest.nikolaev.questdelta.service.UserService;
import ua.com.javarush.quest.nikolaev.questdelta.utils.*;

import java.io.IOException;
import java.util.Collection;
import java.util.Objects;

import static ua.com.javarush.quest.nikolaev.questdelta.utils.Const.*;

@WebServlet(name = ACCOUNTSERVLET, value = ACCOUNTSERVLETVALUE)
public class AccountServlet extends HttpServlet {

    private static final int DEFAULT_PAGE_SIZE = 10;
    private static final int DEFAULT_PAGE_NUMBER = 0;
    private final UserService userService = UserService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNumber = request.getParameter(Attribute.PAGE_NUMBER.getValue());
        int pageNumberValue;
        if (Objects.isNull(pageNumber)) {
            pageNumberValue = DEFAULT_PAGE_NUMBER;
        } else {
            try {
                pageNumberValue = Integer.parseInt(pageNumber);
            } catch (NumberFormatException e) {
                pageNumberValue = DEFAULT_PAGE_NUMBER;
            }
        }
        request.setAttribute(Attribute.PAGE_NUMBER.getValue(), pageNumberValue);

        Collection<UserDto> users = userService.getAll(pageNumberValue, DEFAULT_PAGE_SIZE);
        request.setAttribute(Attribute.USERS.getValue(), users);

        int pages = userService.getAllCount() / DEFAULT_PAGE_SIZE;
        request.setAttribute(Attribute.PAGE_COUNT.getValue(), pages);

        Jsp.forward(request, response, ACCOUNTS);
    }

}