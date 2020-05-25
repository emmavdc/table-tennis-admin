package dataAccessPackage;

import java.sql.*;

public class SingletonConnection {

    private static Connection uniqueConnection;

    public static Connection getInstance() throws SQLException {

        if(uniqueConnection == null){

            uniqueConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tabletennisclub?serverTimezone=Europe/Paris", "root", "MyPass");

        }

        return uniqueConnection;
    }
}
