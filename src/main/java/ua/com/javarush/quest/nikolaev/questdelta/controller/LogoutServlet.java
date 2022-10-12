package ua.com.javarush.quest.nikolaev.questdelta.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import static ua.com.javarush.quest.nikolaev.questdelta.utils.Const.*;

@WebServlet(name = LOGOUTSERVLET, value = LOGOUTSERVLETVALUE)
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect(MENUSERVLETVALUE);
    }


}
