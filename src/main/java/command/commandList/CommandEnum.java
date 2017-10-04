package command.commandList;

import command.LoginCommand;
import command.commandInterface.ActionCommand;

public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {

        }
    },
    BLOCK{
        {

        }
    },
    UNBLOCK{
        {

        }
    };
     ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }

}
