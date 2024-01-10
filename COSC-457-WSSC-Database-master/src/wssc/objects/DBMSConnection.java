/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wssc.objects;

import java.sql.*;

public class DBMSConnection {
    
    static Connection con = null;
    static final String LOGIN = "dsoe1";
    static final String PASSWORD = "COSC*65lr7";
    static final String URL = "jdbc:mysql://triton.towson.edu:3360/?serverTimezone=EST#/"+LOGIN+"db";
    
    public static Connection getConnection(){
        if (con != null){
            return con;
        }
        
        return getConnection(LOGIN, PASSWORD, URL);
    }
    
    private static Connection getConnection(String username, String password, String url){
        
        try{
            con = DriverManager.getConnection(url, username, password);            
        }
        catch(SQLException e){
            System.err.println(e);
        }
        
        return con;        
    }
    
}
