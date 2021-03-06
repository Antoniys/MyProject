package command;

import java.util.Locale;
import java.util.ResourceBundle;

public class ExecuteStatus {
    public static final int OK = 1, FAIL = 2;
    private static final String RESOURSEC_BUNDLE = "messages2";
    private String messageKey;
    private int status;
    private String message;
    private String forwardPage;

    public ExecuteStatus(String errorMessageKey, Locale locale) {
        status = FAIL;
        setMessageFromKey(errorMessageKey, locale);
    }

    public ExecuteStatus(int status) {
        this.status = status;
    }

    public ExecuteStatus(int status, String forwardPage) {
        this.status = status;
        this.forwardPage = forwardPage;
    }

    public ExecuteStatus(int status, String key, String forwardPage,
                         Locale locale) {
        setMessageFromKey(key, locale);
        this.forwardPage = forwardPage;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getForwardPage() {
        return forwardPage;
    }

    public String getMessageKey() {
        return messageKey;
    }

    private void setMessageFromKey(String key, Locale locale) {
        messageKey = key;
        ResourceBundle resourceBundle = ResourceBundle.getBundle(
                RESOURSEC_BUNDLE, locale);
        this.message = resourceBundle.getString(key);
    }
}
