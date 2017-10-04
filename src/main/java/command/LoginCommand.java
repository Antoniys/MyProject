package command;

import command.commandInterface.ActionCommand;
import dao.dao_realization.UserRealizationDAO;
import model.User;
import model.UserClient;


import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "email";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
// извлечение из запроса логина и пароля
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
// проверка логина и пароля
        UserRealizationDAO userRealizationDAO = new UserRealizationDAO();
        User user = userRealizationDAO.findUser(pass, login);
        if (user != null) {
            if (user instanceof UserClient) {
                page = "jsp/menu.jsp";
            } else {
                page = "jsp/admin.jsp";
            }
        } else {
            page = "jsp/error.jsp";
        }

        return page;
    }
}
