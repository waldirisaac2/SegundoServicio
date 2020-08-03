/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Acer
 */
public class Conexion {
    private static String JDBC_URL = "jdbc:mysql://localhost:3306/sistema";
    private static String JDBC_USER = "root";
    private static String JDBC_PASS = "";
     public static Connection connectDatabase(){
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            connection = (Connection) DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
            
            
            System.out.println("conexion exitosa");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }   
 
}
