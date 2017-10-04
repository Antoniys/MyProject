package dao.dao_realization;

import dao.Connection.ConnectionFactory;
import dao.dao_interface.UserInterfaceDAO;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRealizationDAO implements UserInterfaceDAO {


    @Override
    public User findUser(String password, String login) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = ConnectionFactory.getConnection().prepareStatement("select* from login where user_login=? and password=?");
            ResultSet resultSet = preparedStatement.executeQuery();
            User user=new User();
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            user.setEmail(resultSet.getString(1));
            user.setPassword(resultSet.getString(2));
            user.setId(resultSet.getInt(3));
            if(user!=null) return user;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
