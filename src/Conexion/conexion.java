
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author Jose Luis Quintero Navarro
 */
public class conexion {
    
        String iniciarConexion ="jdbc:sqlite:E:/CONTENEDORES/BASE DATOS AGROCONTROL/Agrocontrol.s3db";
        Connection conn = null;    
   
    public Connection conexion(){
        try {
            Class.forName("org.sqlite.JDBC");
            conn=DriverManager.getConnection(iniciarConexion);
	    
	    System.out.println("Conexion Exitosa");

        } catch (Exception e) {  

	    System.out.println("Error de conexion"+e);          
        }finally {
            
            return conn;
            
        }
        
    }

    public ResultSet consultarRegister(String select__from_Usuarios) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
