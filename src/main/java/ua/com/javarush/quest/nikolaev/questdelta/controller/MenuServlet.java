package ua.com.javarush.quest.nikolaev.questdelta.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static ua.com.javarush.quest.nikolaev.questdelta.utils.Const.*;

@WebServlet(name = MENUSERVLET, value = MENUSERVLETVALUE)
public class MenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher(PATH_TO_JSP + MENU); //("/WEB-INF/jsp/menu.jsp");
        rd.forward(req, resp);
    }
}
