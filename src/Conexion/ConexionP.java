/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author SENA
 */
public class ConexionP {

    String strConexionDB = "jdbc:sqlite:C:\\Users\\Osiris\\Documents\\BASE DATOS AGROCONTROL/baseProveedor.s3db";
    Connection conn = null;

    public ConexionP() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(strConexionDB);
            System.out.println("Conexion establecida");

        } catch (Exception e) {
            System.out.println("Error de conexion" + e);
        }
    }

    public int ejecutarSentenciaSQL(String strSentenciaSQL) {
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;

        } catch (Exception e) {
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
