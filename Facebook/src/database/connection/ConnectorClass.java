package database.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/27/14
 * Time: 9:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class ConnectorClass implements ConnectorInterface {
    private Connection connect = null;

    private static String dbHost = "";
    private static String dbName = "";
    private static String dbUser = "";
    private static String dbPass = "";
    private static String dbPort = "";

    public ConnectorClass(){
        Properties prop = new Properties();
        InputStream in  = null;

        try {
            in = new FileInputStream("database.properties");
            prop.load(in);

            this.dbHost = prop.getProperty("dbhost");
            this.dbName = prop.getProperty("dbname");
            this.dbUser = prop.getProperty("dbuser");
            this.dbPass = prop.getProperty("dbpass");
            this.dbPort = prop.getProperty("dbport");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Connection getDBConnection() throws SQLException, ClassNotFoundException {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://"+this.dbHost+":"+this.dbPort+"/"+this.dbName+"?user="+this.dbUser+"&password="+this.dbPass);
            return connect;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
        return null;
    }
}
