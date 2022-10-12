package ua.com.javarush.quest.nikolaev.questdelta.utils;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.experimental.UtilityClass;

import java.io.IOException;

import static ua.com.javarush.quest.nikolaev.questdelta.utils.Const.*;

@UtilityClass
public class Jsp {


    public void forward(HttpServletRequest request, HttpServletResponse response, String filename) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(PATH_TO_JSP + filename);
        requestDispatcher.forward(request, response);
    }
}