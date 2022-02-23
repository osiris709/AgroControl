/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author SENA
 */
public class ConexionP {
      String strConecionDB="jdbc:sqlite:E:/base_agro.s3db";
    Connection conn= null;
    
    public ConexionP (){
        try {
            Class.forName("org.sqlite.JDBC");
            conn= DriverManager.getConnection(strConecionDB);
            
            System.out.println("conexion establecida");
            
        } catch (Exception e) {
            
            System.out.println("Error de conexion"+e);
   
        }
        
    }
}
