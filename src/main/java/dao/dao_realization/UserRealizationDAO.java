package dao.dao_realization;

import dao.Connection.ConnectionFactory;
import model.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRealizationDAO {
    private static final Logger logger = Logger.getLogger(AccountRealizationDAO.class);

    public User getClientWithEmailAndPassword(String password, String login) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionFactory.getConnection();
        try {
            preparedStatement = connection.prepareStatement("select* from login where user_login=? and password=?");
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = new User();
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            user.setEmail(resultSet.getString(1));
            user.setPassword(resultSet.getString(2));
            user.setId(resultSet.getInt(3));
            if (user != null) return user;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.error("Can't get statement or execute query " + e.getMessage());
            }
        }
        return null;
    }

}
