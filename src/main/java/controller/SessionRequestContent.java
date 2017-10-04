package controller;

import command.commandList.CommandEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class SessionRequestContent {
    private HashMap<String, Object> requestAttributes;
    private HashMap<String, String[]> requestParametrs;
    private HashMap<String, Object> sessionAttributes;
    CommandEnum currentCommand;

    public SessionRequestContent() {
        sessionAttributes = new HashMap<>();
        requestAttributes = new HashMap<>();
        requestParametrs = new HashMap<>();
    }

    // извлечение данных из запроса
    public CommandEnum extractValues(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        Enumeration<String> attributeSessionNames = session.getAttributeNames();
        while (attributeSessionNames.hasMoreElements()) {
            String key;
            key = attributeSessionNames.nextElement();
            sessionAttributes.put(key, session.getAttribute(key));
        }
        // список пришедших элементов (параметров) из запроса
        Enumeration<String> params = request.getParameterNames();
        while (params.hasMoreElements()) {
            String key = params.nextElement();
            String value = request.getParameter(key);
            //отсеиваем пустые
            if (value != null && !(value.isEmpty())) {
                try {
                    //по сути, определелинем типа комманды должен заниматься CommandClient
                    currentCommand = CommandEnum.valueOf(key.toUpperCase());
                //    requestAttributes.put(ICommand.PARAM_CMD, value); //.trim()
//					System.out.println("<br/>***<b>currentCommand:" + key + " cmdValue:"+ value  + "- успешно " + "</b>***<br/>");
                } catch (IllegalArgumentException e) {
                    requestAttributes.put(key, value);
//					System.out.println("<br/>***<b>key:" + key + "| - value:|" + value + "|-успешно </b>***<br/>");
                }
            }
        }
        return currentCommand;
    }

    // добавление в запрос данных для передачи в jsp
    public HttpServletRequest insertAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if (sessionAttributes == null) {
            session.invalidate();
       //     request.setAttribute(ICommand.PARAM_MESSAGE, MessageManager.getProperty("message.logout"));
        } else {
            for (Map.Entry<String, Object> entry : sessionAttributes.entrySet()) {
                String key = (String) entry.getKey();
                Object value = (Object) entry.getValue();
                session.setAttribute(key, value);
            }
        }
        for (Map.Entry<String, String[]> entry : requestParametrs.entrySet()) {
            String key = (String) entry.getKey();
            String[] value = (String[]) entry.getValue();
            session.setAttribute(key, value);
        }
        return request;
    }


}


