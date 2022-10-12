package ua.com.javarush.quest.nikolaev.questdelta.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ua.com.javarush.quest.nikolaev.questdelta.utils.*;

import java.io.IOException;

import static ua.com.javarush.quest.nikolaev.questdelta.utils.Const.*;

@WebServlet(name = ACCOUNTSERVLET, value = ACCOUNTSERVLETVALUE)
public class AccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Jsp.forward(request, response, ACCOUNTS);
    }

}