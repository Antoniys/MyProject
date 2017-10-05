package command;


public abstract class DefaultHandler implements Command {
    private DefaultHandler nextHandler;
    public static final String MENU_PAGE = "/menu.jsp",
            LOGIN_PAGE = "/login.jsp", REPLANISH_ACCOUNT = "/replanish.jsp";
    protected String action;

    public void setNextHandler(DefaultHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public DefaultHandler handle(String action) {
        if (this.action.equals(action)) {
            return this;
        } else {
            return (nextHandler == null) ? null : nextHandler.handle(action);
        }
    }
}
