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

    String iniciarConexion = "jdbc:sqlite:C:\\Users\\Osiris\\Documents\\NetBeansProjects\\Repositorios\\AgroControl/Agrocontrol.s3db";
    Connection conn = null;

    public Connection conexion() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(iniciarConexion);

            //System.out.println("Conexion Exitosa");
        } catch (Exception e) {

            System.out.println("Error de conexion" + e);
        } finally {

            return conn;
        }
    }

    /*public conexion() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(iniciarConexion);
            System.out.println("Conexion establecida");

        } catch (Exception e) {
            System.out.println("Error de conexion" + e);
        }
    }*/
    public int ejecutarSentenciaSQL(String strSentenciaSQL) {
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }
    
    public ResultSet consultarRegistro(String strSentenciaSQL){
        try {
            PreparedStatement pstm= conn.prepareStatement(strSentenciaSQL);
           ResultSet respuesta = pstm.executeQuery();
           return respuesta;
        } catch (Exception e) {
            System.out.println(e);
             return null;
        }
    }

    public PreparedStatement prepareStatement(String insert_into_Cosecha_IDTipo_CosechaNombre_) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
