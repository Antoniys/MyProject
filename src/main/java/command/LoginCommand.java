package command;

import command.DefaultHandler;
import command.ExecuteStatus;
import dao.dao_realization.UserRealizationDAO;
import model.Role;
import model.User;
import model.UserClient;


import javax.servlet.http.HttpServletRequest;

public class LoginCommand extends DefaultHandler {
    public LoginCommand() {
        action = "login";
    }

    @Override
    public ExecuteStatus execute(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserRealizationDAO userRealizationDAO=new UserRealizationDAO();
        User user = userRealizationDAO.getClientWithEmailAndPassword(email, password);
        if (user != null && user.getRole()== Role.CLIENT) {
            request.getSession().setAttribute("user", user);
            return new ExecuteStatus(ExecuteStatus.OK, MENU_PAGE);
        }
        else if(user != null && user.getRole()== Role.ADMIN){
            request.getSession().setAttribute("user", user);
            return new ExecuteStatus(ExecuteStatus.OK, MENU_PAGE);  //admin.jsp- пока нет
        }
        else {
            return new ExecuteStatus(ExecuteStatus.FAIL, "wrong_login_data",
                    LOGIN_PAGE, request.getLocale());
        }
    }
}
