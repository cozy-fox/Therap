package net.therap.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author: therapJavaFestTeam
 * @since: 10/2/12 4:11 PM
 */
public class DatabaseConnectionPool {

    private static DataSource dataSource;
    private static final String DRIVER_NAME;
    private static final String URL;
    private static final String USER_NAME;
    private static final String PASSWORD;
    /*private static final Logger log = LoggerFactory.getLogger(DatabaseConnectionPool.class);*/


    static {

        final ResourceBundle config = ResourceBundle.getBundle("db");
        DRIVER_NAME = config.getString("jdbc.driver");
        URL = config.getString("jdbc.url.address");
        USER_NAME = config.getString("db.user");
        PASSWORD = config.getString("db.password");

        try {
            dataSource = setupDataSource();
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    private static DataSource setupDataSource() throws PropertyVetoException {

        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        comboPooledDataSource.setDriverClass(DRIVER_NAME);
        comboPooledDataSource.setJdbcUrl(URL);
        comboPooledDataSource.setUser(USER_NAME);
        comboPooledDataSource.setPassword(PASSWORD);

        comboPooledDataSource.setMinPoolSize(5);
        comboPooledDataSource.setAcquireIncrement(5);
        comboPooledDataSource.setMaxPoolSize(20);
        return comboPooledDataSource;
    }
}

