package Clases;

import Conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
                System.out.println("aplicacion " + Id);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
        return Id;
    }
}
