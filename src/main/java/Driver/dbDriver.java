package Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author IVD Merwe, Saien Naidu
 */
public class dbDriver {

    private static final String DRIVER = "net.ucanaccess.jdbc.UcanaccessDriver";
    private static final String URL = "jdbc:ucanaccess://data/UniGo_DB.accdb";

    public Connection connection;
    private PreparedStatement statement;

    public dbDriver() {

        //Load
        try {
            Class.forName((DRIVER));
            System.out.println("Driver loaded.");
        } catch (ClassNotFoundException c) {
            System.out.println("Error #01: Driver class not found.");
        }

        //Connect
        try {
            connection = DriverManager.getConnection(URL);
            System.out.println("Driver connected.");
        } catch (SQLException e) {
            System.out.println("Error #02: SQL Connection failed.");
        }

    }

    //SELECT
    public ResultSet query(String query) throws SQLException {

        statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        return statement.executeQuery();

    }

    //INSERT, UPDATE, DELETE
    public void update(String query) throws SQLException {

        statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        statement.executeUpdate();
        statement.close();

    }
}
