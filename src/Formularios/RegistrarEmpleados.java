package Formularios;

import agrocontrol.empleadosBl;
import Conexion.conexion;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SENA
 */
public class RegistrarEmpleados extends javax.swing.JFrame {

    DefaultTableModel modelo;

    /**
     * Creates new form frmEmpleados
     */
    public RegistrarEmpleados() {
        initComponents();

        String[] titulos = {"ID", "Nombre", "correo"};

        modelo = new DefaultTableModel(null, titulos);
        tblEmpleados.setModel(modelo);

        this.mostrarDatos();
        this.limpiar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btAgrerar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btBorrar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblEmpleados);

        jLabel1.setText("ID");

        jLabel2.setText("Nombre");

        jLabel3.setText("Correo");

        txtID.setEditable(false);

        btAgrerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton-agregar.png"))); // NOI18N
        btAgrerar.setText("Agregar");
        btAgrerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgrerarActionPerformed(evt);
            }
        });

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar.png"))); // NOI18N
        btBorrar.setText("Borrar");
        btBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBorrarActionPerformed(evt);
            }
        });

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/prohibicion.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btAgrerar)
                        .addGap(32, 32, 32)
                        .addComponent(btEditar)
                        .addGap(32, 32, 32)
                        .addComponent(btBorrar)
                        .addGap(28, 28, 28)
                        .addComponent(btCancelar)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addGap(3, 3, 3)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAgrerar)
                    .addComponent(btEditar)
                    .addComponent(btBorrar)
                    .addComponent(btCancelar))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAgrerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgrerarActionPerformed
        // TODO add your handling code here:
        conexion objconexion = new conexion();

        empleadosBl OEmpleados = recuperarDatosGUI();

        String strSentenciaInsert = String.format("INSERT INTO Empleados(ID, Nombre, Correo) VALUES (null, '%s', '%s')", OEmpleados.getNombre(), OEmpleados.getCorreo());

        objconexion.ejecutarSentenciaSQL(strSentenciaInsert);

        this.mostrarDatos();
        this.limpiar();

    }//GEN-LAST:event_btAgrerarActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        if (evt.getClickCount() == 1) {
            JTable receptor = (JTable) evt.getSource();

            txtID.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString());
            txtNombre.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 1).toString());
            txtCorreo.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 2).toString());

        }
        btAgrerar.setEnabled(false);
        btEditar.setEnabled(true);
        btBorrar.setEnabled(true);
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void btBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBorrarActionPerformed

        conexion objconexion = new conexion();

        empleadosBl OEmpleados = recuperarDatosGUI();

        String strSentenciaInsert = String.format("DELETE FROM Empleados WHERE ID =%d", OEmpleados.getID());

        objconexion.ejecutarSentenciaSQL(strSentenciaInsert);

        this.mostrarDatos();
        this.limpiar();

    }//GEN-LAST:event_btBorrarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed

        conexion objconexion = new conexion();

        empleadosBl OEmpleados = recuperarDatosGUI();

        String strSentenciaInsert = String.format(" UPDATE Empleados SET Nombre='%s'," + "Correo='%s'  WHERE ID=%d", OEmpleados.getNombre(), OEmpleados.getCorreo(), OEmpleados.getID());

        objconexion.ejecutarSentenciaSQL(strSentenciaInsert);

        this.mostrarDatos();
        this.limpiar();
    }//GEN-LAST:event_btEditarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.limpiar();
    }//GEN-LAST:event_btCancelarActionPerformed
    public void mostrarDatos() {

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        conexion objconexion = new conexion();
        try {
            ResultSet resultado = objconexion.consultarRegister("SELECT * FROM Empleados");

            while (resultado.next()) {

                System.out.println(resultado.getString("ID"));
                System.out.println(resultado.getString("Nombre"));
                System.out.println(resultado.getString("Correo"));

                Object[] oUsuario = {resultado.getString("ID"), resultado.getString("Nombre"), resultado.getString("Correo")};
                modelo.addRow(oUsuario);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public empleadosBl recuperarDatosGUI() {
        empleadosBl oEmpleados = new empleadosBl();

        int ID = (txtID.getText().isEmpty()) ? 0 : Integer.parseInt(txtID.getText());

        oEmpleados.setID(ID);
        oEmpleados.setNombre(txtNombre.getText());
        oEmpleados.setCorreo(txtCorreo.getText());
        return oEmpleados;
    }

    public void limpiar() {

        txtID.setText("");
        txtNombre.setText("");
        txtCorreo.setText("");

        btAgrerar.setEnabled(true);
        btEditar.setEnabled(false);
        btBorrar.setEnabled(false);
    }

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
            java.util.logging.Logger.getLogger(RegistrarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarEmpleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgrerar;
    private javax.swing.JButton btBorrar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}