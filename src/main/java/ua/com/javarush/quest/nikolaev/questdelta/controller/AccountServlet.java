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

        String pageNumber = request.getParameter("pageNumber");
        int pageNumberValue;
        try {
            pageNumberValue = Integer.parseInt(pageNumber);
        } catch (NumberFormatException e) {
            pageNumberValue = 0;
        }


        String pageSize = request.getParameter("pageSize");
        int pageSizeValue;
        try {
            pageSizeValue = Integer.parseInt(pageSize);
        } catch (NumberFormatException e) {
            pageSizeValue = 5;
        }

        Collection<UserDto> users = userService.getAll(pageNumberValue, pageSizeValue);
        request.setAttribute(Attribute.USERS.getName(), users);

        int countUsers = userService.getAllCount();
        request.setAttribute(Attribute.COUNT_USERS.getName(), countUsers);

        Jsp.forward(request, response, ACCOUNTS);
    }

}