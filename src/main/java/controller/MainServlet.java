package controller;


import command.CoR;
import command.DefaultHandler;
import command.ExecuteStatus;
import command.LogoutCommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@WebServlet("/mainServlet")
public class MainServlet extends HttpServlet {
    private static final Pattern emailPattern = Pattern
            .compile("[a-zA-Z]+[0-9a-zA-Z\\-\\._]*@[a-zA-Z]+([.][a-zA-Z]+)+"),
            passwordPattern = Pattern.compile("[0-9a-zA-Z_]+"),
            numberPattern = Pattern.compile("[0-9]+"), wordPattern = Pattern
            .compile("[a-zA-Z �-��-�]+");

    private static final String ERROR_PAGE = "/error.jsp";

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        ExecuteStatus status = null;
        DefaultHandler handler = CoR.getInstance().handle(action);
        if (handler == null)
            status = new ExecuteStatus(ExecuteStatus.FAIL, "wrong_action",
                    ERROR_PAGE, request.getLocale());
        else
            status = checkData(request, action);
        if (status.getStatus() == ExecuteStatus.OK)
            status = handler.execute(request);
        request.setAttribute("message", status.getMessage());
        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(status.getForwardPage());
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        if ("logout".equals(request.getParameter("action"))) {
            DefaultHandler handler = new LogoutCommand();
            ExecuteStatus status = handler.execute(request);
            request.setAttribute("message", status.getMessage());
            RequestDispatcher requestDispatcher = getServletContext()
                    .getRequestDispatcher(status.getForwardPage());
            requestDispatcher.forward(request, response);
        } else {
            request.setAttribute("message", "wrong_action");
            RequestDispatcher requestDispatcher = getServletContext()
                    .getRequestDispatcher(ERROR_PAGE);
            requestDispatcher.forward(request, response);
        }
    }

    private ExecuteStatus checkData(HttpServletRequest request, String action) {
        ExecuteStatus status;
        switch (action) {
            case "register":
                status = checkAll(
                        checkEmail(request.getParameter("email"), request),     // на будущее (дополнительно)
                        checkPassword(request.getParameter("password"), request),
                        checkWord(request.getParameter("firstName"), request),
                        checkWord(request.getParameter("surname"), request));
                return processStatus(status, DefaultHandler.LOGIN_PAGE, request);
            case "login":
                status = checkAll(
                        checkEmail(request.getParameter("email"), request),
                        checkPassword(request.getParameter("password"), request));
                return processStatus(status, DefaultHandler.MENU_PAGE, request);
            default:
                return new ExecuteStatus(ExecuteStatus.FAIL);
        }
    }


    private ExecuteStatus processStatus(ExecuteStatus status, String errorPage,
                                        HttpServletRequest request) {
        if (status.getStatus() == ExecuteStatus.OK)
            return new ExecuteStatus(ExecuteStatus.OK);
        else
            return new ExecuteStatus(ExecuteStatus.FAIL,
                    status.getMessageKey(), errorPage, request.getLocale());
    }

    private ExecuteStatus checkNumber(String number, HttpServletRequest request) {
        if (number == null)
            return new ExecuteStatus("null_data", request.getLocale());
        number = number.trim();
        Matcher matcher = numberPattern.matcher(number);
        if (!matcher.matches())
            return new ExecuteStatus("wrong_data", request.getLocale());
        return new ExecuteStatus(ExecuteStatus.OK);
    }

    private ExecuteStatus checkWord(String word, HttpServletRequest request) {
        if (word == null)
            return new ExecuteStatus("null_data", request.getLocale());
        word = word.trim();
        Matcher matcher = wordPattern.matcher(word);
        if (!matcher.matches())
            return new ExecuteStatus("wrong_data", request.getLocale());
        return new ExecuteStatus(ExecuteStatus.OK);
    }

    private ExecuteStatus checkEmail(String email, HttpServletRequest request) {
        if (email == null)
            return new ExecuteStatus("null_data", request.getLocale());
        email = email.trim();
        Matcher matcher = emailPattern.matcher(email);
        if (!matcher.matches())
            return new ExecuteStatus("wrong_data", request.getLocale());
        return new ExecuteStatus(ExecuteStatus.OK);
    }

    private ExecuteStatus checkPassword(String password,
                                        HttpServletRequest request) {
        if (password == null)
            return new ExecuteStatus("null_data", request.getLocale());
        password = password.trim();
        Matcher passwordMatcher = passwordPattern.matcher(password);
        if (!passwordMatcher.matches())
            return new ExecuteStatus("wrong_data", request.getLocale());
        else
            return new ExecuteStatus(ExecuteStatus.OK);
    }

    private ExecuteStatus checkAll(ExecuteStatus... statuses) {
        for (ExecuteStatus st : statuses)
            if (st.getStatus() == ExecuteStatus.FAIL)
                return st;
        return statuses[0];
    }

}
