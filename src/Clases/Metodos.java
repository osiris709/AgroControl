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
public class Metodos {

    conexion objConexion = new conexion();
    Connection con = objConexion.conexion();

    public int Consultar(String SQL) {

        int Id = 0;
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {

                Id = rs.getInt(1);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
        return Id;
    }
    
    public void Cargar_Cosecha(JComboBox cbo_Cosecha, String TipoCultivo) {

        switch (TipoCultivo) {

            case "Transitorio":

                String SSQL = "SELECT Nombre_Cosecha FROM Cosecha WHERE Tipo_Cultivo= 'Transitorio' ORDER BY Nombre_Cosecha";

                try {

                    Statement leer = con.createStatement();
                    ResultSet resultado = leer.executeQuery(SSQL);

                    //LLenamos nuestro ComboBox
                    while (resultado.next()) {

                        cbo_Cosecha.addItem(resultado.getString("Nombre_Cosecha"));
                    }

                } catch (SQLException e) {

                    JOptionPane.showMessageDialog(null, e);
                }
                break;

            case "Permanente":

                String SSQL2 = "SELECT Nombre_Cosecha FROM Cosecha WHERE Tipo_Cultivo= 'Permanente' ORDER BY Nombre_Cosecha ASC";

                try {

                    Statement leer = con.createStatement();
                    ResultSet resultado = leer.executeQuery(SSQL2);

                    //LLenamos nuestro ComboBox
                    while (resultado.next()) {

                        cbo_Cosecha.addItem(resultado.getString("Nombre_Cosecha"));
                    }

                } catch (SQLException e) {

                    JOptionPane.showMessageDialog(null, e);
                }
                break;

            case "Seleccionar":

                cbo_Cosecha.addItem("Seleccionar");
        }
    }

    public void Cargar_Area(JComboBox cbo_Area) {

        String SSQL = "SELECT Nombre_Area FROM Area ORDER BY ID_Area";

        try {

            Statement leer = con.createStatement();
            ResultSet resultado = leer.executeQuery(SSQL);

            //LLenamos nuestro ComboBox
            while (resultado.next()) {

                cbo_Area.addItem(resultado.getString("Nombre_Area"));
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void Cargar_TipoCosecha(JComboBox cbo_TipoCosecha, String Cosecha) {

        String SSQL = "SELECT tipo_cosecha.TipoCosecha FROM tipo_cosecha INNER JOIN cosecha ON cosecha.Tipo_Cosecha = tipo_cosecha.IDTipoCosecha WHERE Nombre_Cosecha= '" + Cosecha + "'";

        try {

            Statement leer = con.createStatement();
            ResultSet resultado = leer.executeQuery(SSQL);

            //LLenamos nuestro ComboBox
            while (resultado.next()) {

                cbo_TipoCosecha.addItem(resultado.getString("tipo_cosecha.TipoCosecha"));
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }
    }
}