package command;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    ExecuteStatus execute(HttpServletRequest request);
}
