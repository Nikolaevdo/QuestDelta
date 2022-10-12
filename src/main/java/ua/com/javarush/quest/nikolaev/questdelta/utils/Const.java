package ua.com.javarush.quest.nikolaev.questdelta.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Const {

    //Name servet for Lombok
    public final String ACCOUNTSERVLET = "AccountServlet";
    public final String LOGINSERVLET = "LoginServlet";
    public final String LOGOUTSERVLET = "LogoutServlet";
    public final String MENUSERVLET = "MenuServlet";
    public final String SIGNUPSERVLET = "SignupServlet";

    //Value servlet for Lombok
    public final String ACCOUNTSERVLETVALUE = "/accounts";
    public final String LOGINSERVLETVALUE = "/login";
    public final String LOGOUTSERVLETVALUE = "/logout";
    public final String MENUSERVLETVALUE = "/menu";
    public final String SIGNUPSERVLETVALUE = "/signup";
    public final String PATH_TO_JSP = "/WEB-INF/jsp/";
    public final String MENU = "menu.jsp";
    public final String LOGIN = "login.jsp";
    public final String SIGNUP = "signup.jsp";
    public final String ACCOUNTS = "accounts.jsp";


    public static final String ERROR_ATTRIBUTE = "error";
    public static final String USER_ATTRIBUTE = "user";

    public static final String REGEX_LOGIN = "^[A-Za-z\\d]{1,20}$";
    public static final String REGEX_PASS = "^[A-Za-z\\d]{1,8}$";
}


