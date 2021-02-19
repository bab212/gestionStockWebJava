/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Produit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NGSI
 */
public class DbConnect {
    
     public static Connection connecte(){
         Connection connect = null;
       try{  
            Class.forName("com.mysql.jdbc.Driver");  
            connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/tpdaws?","root","");  
            System.out.println("Connection Success");
 
        }
        catch(Exception e){ 
            System.out.println(e);
        }  
        return connect;
    }
    
}
