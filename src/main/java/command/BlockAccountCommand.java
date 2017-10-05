package command;

import command.Command;
import command.DefaultHandler;
import command.ExecuteStatus;
import dao.dao_realization.AccountRealizationDAO;
import dao.dao_realization.CardRealizationDAO;
import model.Status;
import model.User;

import javax.servlet.http.HttpServletRequest;

public class BlockAccountCommand extends DefaultHandler {
    @Override
    public ExecuteStatus execute(HttpServletRequest request) {
        String card = request.getParameter("card");
        CardRealizationDAO cardRealizationDAO = new CardRealizationDAO();
        int account_id = cardRealizationDAO.getAccountId(card);
        AccountRealizationDAO accountRealizationDAO = new AccountRealizationDAO();
        boolean result = accountRealizationDAO.changeStatusAccount(Status.BLOCK, account_id);
        if(result==true){
            return new ExecuteStatus(ExecuteStatus.OK, MENU_PAGE);
        }
       else{
            return new ExecuteStatus(ExecuteStatus.FAIL,MENU_PAGE);
        }
    }
}
