
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jose Luis Quintero Navarro
 */
public class conexion {
    
        String iniciarConexion ="jdbc:sqlite:E:/ARCHIVOS JOSE/INFO JOSE/CONTENEDORES/BASE DATOS AGROCONTROL/Agrocontrol.s3db";
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
    
    public int  ejecutarSentenciaSQL(String strSentenciaSQL){
        try {
           PreparedStatement pstm= conn.prepareStatement(strSentenciaSQL);
           pstm.execute();
           return 1;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
        
    }
    
    public ResultSet consultarRegister(String strSentenciaSQL){
        
        try {
            
           PreparedStatement pstm= conn.prepareStatement(strSentenciaSQL);
           ResultSet respuestas = pstm.executeQuery();
           return respuestas;
           
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    
    }

    /*public ResultSet consultarRegister(String select__from_Usuarios) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
  /* public ResultSet ver(){
       Connection con = conectar();
       ResultSet rs = null;
       try{
           PreparedStatement ps = con.prepareStatement("selet * from Usuarios");
           rs =ps.executeQuery();
      }catch(Exception e){
          System.out.println("Error de consulta");
      }
       return rs;
    }  cambios  

    public Connection conectar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
   
}
