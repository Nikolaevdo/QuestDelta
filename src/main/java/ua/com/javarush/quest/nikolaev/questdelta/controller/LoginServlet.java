package ua.com.javarush.quest.nikolaev.questdelta.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ua.com.javarush.quest.nikolaev.questdelta.dto.UserDto;
import ua.com.javarush.quest.nikolaev.questdelta.entity.User;
import ua.com.javarush.quest.nikolaev.questdelta.mapper.Mapper;
import ua.com.javarush.quest.nikolaev.questdelta.mapper.UserMapper;
import ua.com.javarush.quest.nikolaev.questdelta.service.UserService;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private final UserService userService = UserService.INSTANCE;
    private final Mapper<UserDto, User> userMapper = new UserMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Optional<User> user = userService.validate(login,password);
        if(user.isPresent()){
            UserDto userDto = userMapper.toDto(user.get());
        }

    }
}
