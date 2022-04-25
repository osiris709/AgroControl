package Clases;

import Conexion.conexion;
import Formularios.RegistrarConsumo;
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

            Statement cos = con.createStatement();
            ResultSet rscos = cos.executeQuery(SQL);

            if (rscos.next()) {

                Id = rscos.getInt(1);
                System.out.println("aplicacion " + Id);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
        return Id;
    }
}
