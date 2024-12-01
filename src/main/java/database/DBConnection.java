package database;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection conn;

    public static Connection getConnection() throws SQLException {
        if (conn == null) createConnection();
        return conn;
    }

    private static void createConnection() throws SQLException {
        String url  = String.format("jdbc:mysql://%s:%s/%s", SchemaDB.HOST, SchemaDB.PORT, SchemaDB.DB_NAME);
        conn = DriverManager.getConnection(url, SchemaDB.USER, SchemaDB.PASS);
    }
}
