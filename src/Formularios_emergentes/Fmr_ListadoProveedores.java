package Formularios_emergentes;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Conexion.conexion;
import Formularios.RegistrarProveedor;
import java.sql.Connection;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Fmr_ListadoProveedores extends javax.swing.JDialog {

    DefaultTableModel modelo;

    public Fmr_ListadoProveedores(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        String[] titulos = {"Nit", "Nombre", "Direccion", "Correo", "Telefono"};

        modelo = new DefaultTableModel(null, titulos);
        tblProveedor.setModel(modelo);
        mostrardatos();
        this.setLocationRelativeTo(null);
        this.setTitle("AgroControl - Tabla Proveedores");

    }

    public void mostrardatos() {

        conexion objConexion = new conexion();
        Connection con = objConexion.conexion();

        try {
            ResultSet resultado = objConexion.consultarRegistro("SELECT * FROM proveedores");
            while (resultado.next()) {

                Object[] oUsuario = {resultado.getString("Nit"), resultado.getString("Nombre"), resultado.getString("Direccion"), resultado.getString("Correo"), resultado.getString("Telefono")};
                modelo.addRow(oUsuario);

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void busqueda(String buscar) {

        conexion objConexion = new conexion();
        Connection con = objConexion.conexion();

        DefaultTableModel tbProveedor = new DefaultTableModel();
        tbProveedor.addColumn("NIT");
        tbProveedor.addColumn("Nombre");
        tbProveedor.addColumn("Direccion");
        tbProveedor.addColumn("Correo");
        tbProveedor.addColumn("Telefono");

        tblProveedor.setModel(tbProveedor);

        String[] datos = new String[6];

        try {

            ResultSet resultado = objConexion.consultarRegistro("SELECT * FROM  proveedores WHERE Nit LIKE '%" + buscar + "%' OR Nombre LIKE '%" + buscar + "%'");

            while (resultado.next()) {
                datos[0] = resultado.getString(1);
                datos[1] = resultado.getString(2);
                datos[2] = resultado.getString(3);
                datos[3] = resultado.getString(4);
                datos[4] = resultado.getString(5);
                tbProveedor.addRow(datos);
            }
            tblProveedor.setModel(tbProveedor);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "Error en la Consulta");
        }
    }

    public void bloquear() {
        txtBuscar.setEnabled(false);
    }

    public void desbloquear() {
        txtBuscar.setEnabled(true);
    }


    /*Fmr_Proveedores(RegistrarProveedor aThis, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon1 = new ImageIcon(getClass().getResource("/Imagenes/fondo-submenu2.jpg"));
        Image image1 = icon1.getImage();
        jDP_ListaProveedores = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image1,0,0,getWidth(),getHeight(),this);
            }
        };
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProveedor = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jDP_ListaProveedores.setBackground(new java.awt.Color(255, 255, 255));

        tblProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProveedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProveedor);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setText("Listado de Proveedores");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Buscar:");

        jDP_ListaProveedores.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDP_ListaProveedores.setLayer(txtBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDP_ListaProveedores.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDP_ListaProveedores.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDP_ListaProveedoresLayout = new javax.swing.GroupLayout(jDP_ListaProveedores);
        jDP_ListaProveedores.setLayout(jDP_ListaProveedoresLayout);
        jDP_ListaProveedoresLayout.setHorizontalGroup(
            jDP_ListaProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDP_ListaProveedoresLayout.createSequentialGroup()
                .addGroup(jDP_ListaProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDP_ListaProveedoresLayout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(jLabel1))
                    .addGroup(jDP_ListaProveedoresLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jDP_ListaProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jDP_ListaProveedoresLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jDP_ListaProveedoresLayout.setVerticalGroup(
            jDP_ListaProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDP_ListaProveedoresLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jDP_ListaProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(352, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDP_ListaProveedores)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDP_ListaProveedores)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedorMouseClicked

        if (evt.getClickCount() == 1) {

            JTable receptor = (JTable) evt.getSource();
            RegistrarProveedor.txt_nit.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString());
            RegistrarProveedor.txt_nombre.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 1).toString());;
            RegistrarProveedor.txt_direccion.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 2).toString());
            RegistrarProveedor.txt_correo.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 3).toString());
            RegistrarProveedor.txt_telefono.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 4).toString());
            RegistrarProveedor.btn_modificar.setEnabled(true);
            RegistrarProveedor.btn_guardar.setEnabled(false);
            RegistrarProveedor.btn_nuevo.setEnabled(false);

            this.hide();
        }
    }//GEN-LAST:event_tblProveedorMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        busqueda(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased
    
    
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
            java.util.logging.Logger.getLogger(Fmr_ListadoProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fmr_ListadoProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fmr_ListadoProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fmr_ListadoProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Fmr_ListadoProveedores dialog = new Fmr_ListadoProveedores(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDP_ListaProveedores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProveedor;
    public static javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}