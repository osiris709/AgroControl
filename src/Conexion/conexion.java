package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Osiris
 */
public class conexion {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/agrocontrol";

    Connection conn = null;

    public Connection conexion() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception e) {

            System.out.println("Error de conexion" + e);
        } finally {

            return conn;
        }
    }

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

    public ResultSet consultarRegistro(String strSentenciaSQL) {
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}