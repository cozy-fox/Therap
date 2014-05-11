package database.connection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/27/14
 * Time: 9:31 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ConnectorInterface {

    Connection getDBConnection() throws SQLException, ClassNotFoundException;
}
