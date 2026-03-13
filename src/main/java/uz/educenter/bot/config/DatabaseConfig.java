package uz.educenter.bot.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    private static final String URL = ConfigLoader.get("db.url");
    private static final String USERNAME = ConfigLoader.get("db.username");
    private static final String PASSWORD = ConfigLoader.get("db.password");

    private DatabaseConfig() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}