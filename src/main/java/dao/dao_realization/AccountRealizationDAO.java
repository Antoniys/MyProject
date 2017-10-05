package dao.dao_realization;

import dao.Connection.ConnectionFactory;
import model.Status;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountRealizationDAO {
    private static final Logger logger = Logger.getLogger(AccountRealizationDAO.class);

    //change balance
    public void updateBalance(int id_client, BigDecimal balance) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = ConnectionFactory.getConnection().prepareStatement("update account set balance=? where id_client=? ");
            preparedStatement.setBigDecimal(1, balance);
            preparedStatement.setInt(2, id_client);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can't get statement or execute query " + e.getMessage());
        }
    }

    public boolean changeStatusAccount(Status status, int id_account) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = ConnectionFactory.getConnection().prepareStatement("update account set status=? where id_account=? ");
            if (status.toString() == "block") {
                preparedStatement.setString(1, "block");
            } else {
                preparedStatement.setString(1, "unblock");
            }
            preparedStatement.setInt(2, id_account);
            preparedStatement.executeUpdate();
            logger.info("Account change status");
            return true;
        } catch (SQLException e) {
            logger.error("Can't get statement or execute query " + e.getMessage());
        }
        return false;
    }
}
