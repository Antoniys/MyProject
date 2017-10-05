package command;

public class CoR {
    private static CoR instance;
    private DefaultHandler root;

    public static synchronized CoR getInstance() {
        if (instance == null) {
            instance = new CoR();
        }
        return instance;
    }

    private CoR() {
        addHandler(new LoginCommand());
        addHandler(new BlockAccountCommand());
        addHandler(new ReplanishAccountCommand());
        addHandler(new UnblockAccountClient());
        addHandler(new UnblockAccountAdmin());
        addHandler(new PayCommand());
        addHandler(new LogoutCommand());
    }

    public DefaultHandler handle(String action) {
        return root.handle(action);
    }

    private void addHandler(DefaultHandler handler) {
        handler.setNextHandler(root);
        root = handler;
    }
}