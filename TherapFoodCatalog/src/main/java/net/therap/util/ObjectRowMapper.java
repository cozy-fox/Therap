package net.therap.util;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author: therapJavaFestTeam
 * @since: 10/2/12 4:11 PM
 */
public interface ObjectRowMapper<E> {

     E mapRowToObject(ResultSet resultSet) throws SQLException;
}