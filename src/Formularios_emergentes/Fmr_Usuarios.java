package Formularios_emergentes;

import Conexion.conexion;
import Ventanas.MenuSuper;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SENA
 */
public class Fmr_Usuarios extends javax.swing.JFrame {

    //objeto "conn", variable tipo "Connection" se le asigna el metodo "conexion"
    conexion conn = new conexion();
    Connection iniciarConexion = conn.conexion();

    public Fmr_Usuarios() {
        initComponents();
        listarUsuarios();
    }

    public void listarUsuarios() {
        DefaultTableModel tlista = new DefaultTableModel();
        tlista.addColumn("Id");
        tlista.addColumn("TipoUsuario");
        tlista.addColumn("Usuario");
        tlista.addColumn("Contraseña");
        tlista.addColumn("Nombres");
        tlista.addColumn("Apellidos");
        tlista.addColumn("Dirección");
        tlista.addColumn("Telefono");
        tlista.addColumn("Email");
        tblD_Usuarios.setModel(tlista);

        String[] registros = new String[9];

        try {
            Statement leer = iniciarConexion.createStatement();
            ResultSet resultado = leer.executeQuery("SELECT * FROM Usuarios");

            while (resultado.next()) {
                registros[0] = resultado.getString(1);
                registros[1] = resultado.getString(2);
                registros[2] = resultado.getString(3);
                registros[3] = resultado.getString(4);
                registros[4] = resultado.getString(5);
                registros[5] = resultado.getString(6);
                registros[6] = resultado.getString(7);
                registros[7] = resultado.getString(8);
                registros[8] = resultado.getString(9);
                tlista.addRow(registros);

            }

            tblD_Usuarios.setModel(tlista);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e, "Error durante la consulta", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblD_Usuarios = new javax.swing.JTable();
        Titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(240, 255, 240));

        tblD_Usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblD_Usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblD_UsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblD_Usuarios);

        Titulo.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Listado de Usuarios");
        Titulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Titulo)
                        .addGap(270, 270, 270))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblD_UsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblD_UsuariosMouseClicked
        int filaseleccionada;

        try {

            filaseleccionada = tblD_Usuarios.getSelectedRow();

            if (filaseleccionada == -1) {

                JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");

            } else {

                DefaultTableModel modelotabla = (DefaultTableModel) tblD_Usuarios.getModel();

                String Id = (String) modelotabla.getValueAt(filaseleccionada, 0);
                String TipoUsuario = (String) modelotabla.getValueAt(filaseleccionada, 1);
                String Usuario = (String) modelotabla.getValueAt(filaseleccionada, 2);
                String Contraseña = (String) modelotabla.getValueAt(filaseleccionada, 3);
                String Nombres = (String) modelotabla.getValueAt(filaseleccionada, 4);
                String Apellidos = (String) modelotabla.getValueAt(filaseleccionada, 5);
                String Dirección = (String) modelotabla.getValueAt(filaseleccionada, 6);
                String Telefono = (String) modelotabla.getValueAt(filaseleccionada, 7);
                String Email = (String) modelotabla.getValueAt(filaseleccionada, 8);

                MenuSuper.txt_Id.setText(Id);
                MenuSuper.jTipo.setSelectedItem(TipoUsuario);
                MenuSuper.txt_Alias.setText(Usuario);
                MenuSuper.txt_Contra.setText(Contraseña);
                MenuSuper.txt_Nom.setText(Nombres);
                MenuSuper.txt_Ape.setText(Apellidos);
                MenuSuper.txt_Direc.setText(Dirección);
                MenuSuper.txt_Tel.setText(Telefono);
                MenuSuper.txt_Email.setText(Email);
                this.dispose();
            }

        } catch (HeadlessException ex) {

            JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente", " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_tblD_UsuariosMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Fmr_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fmr_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fmr_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fmr_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fmr_Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblD_Usuarios;
    // End of variables declaration//GEN-END:variables
}
