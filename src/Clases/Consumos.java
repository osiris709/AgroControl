package Clases;

import Conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Osiris
 */
public class Consumos {

    //Pool metodospool = new Pool();
    conexion objConexion = new conexion();
    Connection con = objConexion.conexion();

    public void Cargar_TipoCultivo(JComboBox cbo_TipoCultivo) {

        String SSQL = "SELECT Tipo_Cultivo FROM Cosecha ORDER BY Tipo_Cultivo ASC";

        try {

            Statement leer = con.createStatement();
            ResultSet resultado = leer.executeQuery(SSQL);

            //LLenamos nuestro ComboBox
            cbo_TipoCultivo.addItem("Seleccionar");

            while (resultado.next()) {

                cbo_TipoCultivo.addItem(resultado.getString("Tipo_Cultivo"));
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            /*if (con != null) {
                try {
                    con.close();
                    con = null;
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }*/
        }
    }

    public void Cargar_Cosecha(JComboBox cbo_Cosecha) {
        
        String SSQL = "SELECT Nombre_Cosecha FROM Cosecha ORDER BY Nombre_Cosecha ASC";

        try {

            Statement leer = con.createStatement();
            ResultSet resultado = leer.executeQuery(SSQL);

            //LLenamos nuestro ComboBox
            cbo_Cosecha.addItem("Seleccionar");

            while (resultado.next()) {

                cbo_Cosecha.addItem(resultado.getString("Nombre_Cosecha"));
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            /*if (con != null) {
                try {
                    con.close();
                    con = null;
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }*/
        }

    }
    
    public void Cargar_Area(JComboBox cbo_Area) {
        
        String SSQL = "SELECT Area FROM Consumos ORDER BY Area ASC";

        try {

            Statement leer = con.createStatement();
            ResultSet resultado = leer.executeQuery(SSQL);

            //LLenamos nuestro ComboBox
            cbo_Area.addItem("Seleccionar");

            while (resultado.next()) {

                cbo_Area.addItem(resultado.getString("Area"));
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

           /* if (con != null) {
                try {
                    con.close();
                    con = null;
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }*/
        }

    }
    
    public void Cargar_TipoCosecha(JComboBox cbo_TipoCosecha) {
        
        String SSQL = "SELECT Tipo_Cosecha FROM Cosecha ORDER BY Tipo_Cosecha ASC";

        try {

            Statement leer = con.createStatement();
            ResultSet resultado = leer.executeQuery(SSQL);

            //LLenamos nuestro ComboBox
            cbo_TipoCosecha.addItem("Seleccionar");

            while (resultado.next()) {

                cbo_TipoCosecha.addItem(resultado.getString("Tipo_Cosecha"));
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            if (con != null) {
                try {
                    con.close();
                    con = null;
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }

    }

}
