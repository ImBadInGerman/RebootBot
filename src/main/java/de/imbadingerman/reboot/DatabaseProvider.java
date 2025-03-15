package de.imbadingerman.reboot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseProvider {
    private static DatabaseProvider instance;
    private Connection connection;

    private DatabaseProvider() {
        // Private constructor to prevent instantiation
    }

    public static DatabaseProvider getInstance() {
        if (instance == null) {
            instance = new DatabaseProvider();
        }
        return instance;
    }

    public void connect(String url, String user, String password) throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, user, password);
        }
    }

    public void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
