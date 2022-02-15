
package agroo.empleadosDAL;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class conexion_respaldo {
 
    String strConecionDB="jdbc:sqlite:E:/base.s3db";
    Connection conn= null;
    
    public conexion_respaldo (){
        try {
            Class.forName("org.sqlite.JDBC");
            conn= DriverManager.getConnection(strConecionDB);
            
            System.out.println("conexion establecida");
            
        } catch (Exception e) {
            
            System.out.println("Error de conexion"+e);
   
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
    
    
    
    
    
    
    
    
}
