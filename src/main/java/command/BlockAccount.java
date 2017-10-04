package command;

import command.commandInterface.ActionCommand;
import dao.dao_realization.AccountRealizationDAO;
import dao.dao_realization.CardRealizationDAO;
import model.Status;

import javax.servlet.http.HttpServletRequest;

public class BlockAccount implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String card = request.getParameter("card");
        CardRealizationDAO cardRealizationDAO=new CardRealizationDAO();
        int account_id= cardRealizationDAO.getAccountId(card);
        AccountRealizationDAO accountRealizationDAO=new AccountRealizationDAO();
        accountRealizationDAO.changeStatusAccount(Status.BLOCK,account_id);
        return null;
    }
}
