package org.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {


    private final String url = "jdbc:mysql://localhost:3306/store_java";
    private final String username = "root";
    private final String password = "";

    public Connection connect() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        // 1 - connecion
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;

    }
}
