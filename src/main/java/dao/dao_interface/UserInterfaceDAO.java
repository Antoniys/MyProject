package dao.dao_interface;

import model.User;

import java.sql.SQLException;

public interface UserInterfaceDAO {
    User findUser(String password, String login) throws SQLException;

}
