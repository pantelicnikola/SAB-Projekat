/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Nikola
 */
public class Connect {
        
    String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=GradjevinskaFirma";
    String username = "newuser";
    String password = "asd";   
    static Connection connection = null;

    public Connect() {
        try {
            Class.forName(driverClass);
            connection = DriverManager.getConnection(dbURL,username,password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
    
}
