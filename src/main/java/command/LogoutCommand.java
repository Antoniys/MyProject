package command;

import command.DefaultHandler;
import command.ExecuteStatus;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand extends DefaultHandler {
    public LogoutCommand() {
        action = "logout";
    }

    @Override
    public ExecuteStatus execute(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return new ExecuteStatus(ExecuteStatus.OK, LOGIN_PAGE);
    }
}
