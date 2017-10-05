package dao.Connection;



import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
   private static Connection connection = null;
    private static final Logger logger = Logger.getLogger(ConnectionFactory.class);

    static {
        try {
           Context initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource)envContext.lookup("jdbc/my_payment_system");
            connection = ds.getConnection();

        } catch (NamingException e) {
            logger.fatal("Naming exception  ");
        } catch (SQLException e) {
            logger.warn("Removed bad connection ");
        }
    }

    public static Connection getConnection() {
        return connection;
    }




}
