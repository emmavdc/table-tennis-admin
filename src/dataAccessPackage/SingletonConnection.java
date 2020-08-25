package dataAccessPackage;

import exceptionPackage.CloseApplicationException;

import java.sql.*;

public class SingletonConnection {

    private static Connection uniqueConnection;

    private SingletonConnection(){};

    public static Connection getInstance() throws SQLException {

        if(uniqueConnection == null){

            uniqueConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tabletennisclub?serverTimezone=Europe/Paris", "root", "MyPass");

        }
        return uniqueConnection;
    }

    // close connection
    public static void closeConnection() throws CloseApplicationException {
        try{
            if(uniqueConnection != null){
                uniqueConnection.close();
                uniqueConnection = null;
            }
        }
        catch (SQLException e){
            throw new CloseApplicationException();
        }
    }
}
