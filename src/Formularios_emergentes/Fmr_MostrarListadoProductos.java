package Formularios_emergentes;

import Conexion.conexion;
import Formularios.RegistrarProducto;
import static Formularios.RegistrarProducto.txt_codigoProducto;
import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public final class Fmr_MostrarListadoProductos extends javax.swing.JFrame {

    conexion conn = new conexion();
    Connection iniciarConexion = conn.conexion();

    public Fmr_MostrarListadoProductos() {
        initComponents();
        
        setTitle("AgroControl - Lista de Productos");
        setLocationRelativeTo(null);
        
        MostrarlistadoProductos();
        bloquearListado();
    }
    
    public void bloquearListado() {

        for (Component a : TablaCliente.getComponents()) {
            a.setEnabled(true);
        }
    }

    public void BotonBuscar(String buscar) {

        DefaultTableModel tclientee = new DefaultTableModel();
        tclientee.addColumn("Codigo");
        tclientee.addColumn("Nombre");
        tclientee.addColumn("Descripcion");
        tclientee.addColumn("Ingrediente Activo");
        tclientee.addColumn("Fecha de Nacimiento");
        tclientee.addColumn("Unidad de Medida");
        tclientee.addColumn("Tipo de Producto");

        TablaCliente.setModel(tclientee);

        String[] datos = new String[7];

        try {
            Statement leer = iniciarConexion.createStatement();
            ResultSet resultado = leer.executeQuery("SELECT * FROM Productos WHERE Codigo  LIKE '%" + buscar + "%' OR Nombre LIKE '%" + buscar + "%'  OR IngredienteActivo LIKE '%" + buscar + "%' OR UnidaddeMedida LIKE '%" + buscar + "%' OR TipodeProducto LIKE '%" + buscar + "%'  OR FechadeVencimiento LIKE '%" + buscar + "%'");

            while (resultado.next()) {
                datos[0] = resultado.getString(1);
                datos[1] = resultado.getString(2);
                datos[2] = resultado.getString(3);
                datos[3] = resultado.getString(4);
                datos[4] = resultado.getString(5);
                datos[5] = resultado.getString(6);
                datos[6] = resultado.getString(7);

                tclientee.addRow(datos);
            }
            TablaCliente.setModel(tclientee);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "Error en la Consulta");
        }
    }

    public void verificarcodigo() {

        for (int i = 0; i < TablaCliente.getRowCount(); i++) {

            if (TablaCliente.getValueAt(i, 1).equals(txt_codigoProducto.getText())) {
                JOptionPane.showMessageDialog(null, "El Codigo ya Existe");

            }

        }

    }

    public void MostrarlistadoProductos() {

        DefaultTableModel tclienteListadoProductos = new DefaultTableModel();
        tclienteListadoProductos.addColumn("Codigo");
        tclienteListadoProductos.addColumn("Nombre");
        tclienteListadoProductos.addColumn("Descripción");
        tclienteListadoProductos.addColumn("Ingrediente Activo");
        tclienteListadoProductos.addColumn("Fecha de Vencimiento");
        tclienteListadoProductos.addColumn("Unidad de Medida");
        tclienteListadoProductos.addColumn("Tipo de Producto");

        TablaCliente.setModel(tclienteListadoProductos);

        String[] datos = new String[7];

        try {
            Statement leer = iniciarConexion.createStatement();
            ResultSet resultado = leer.executeQuery("SELECT * FROM Productos");

            while (resultado.next()) {
                datos[0] = resultado.getString(1);
                datos[1] = resultado.getString(2);
                datos[2] = resultado.getString(3);
                datos[3] = resultado.getString(4);
                datos[4] = resultado.getString(5);
                datos[5] = resultado.getString(6);
                datos[6] = resultado.getString(7);

                tclienteListadoProductos.addRow(datos);
            }
            TablaCliente.setModel(tclienteListadoProductos);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "Error en la Consulta");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        PanelDatosMostrarlistadoProductos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaCliente = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setText("Listado de Productos");

        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_buscarKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("BUSCAR");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));

        TablaCliente = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        TablaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Descripcion", "Ingrediente Activo", "Fecha de Vencimiento", "Unidad de Medida", "Tipo de Producto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TablaCliente.getTableHeader().setReorderingAllowed(false);
        TablaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaCliente);

        javax.swing.GroupLayout PanelDatosMostrarlistadoProductosLayout = new javax.swing.GroupLayout(PanelDatosMostrarlistadoProductos);
        PanelDatosMostrarlistadoProductos.setLayout(PanelDatosMostrarlistadoProductosLayout);
        PanelDatosMostrarlistadoProductosLayout.setHorizontalGroup(
            PanelDatosMostrarlistadoProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        PanelDatosMostrarlistadoProductosLayout.setVerticalGroup(
            PanelDatosMostrarlistadoProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(380, 380, 380))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelDatosMostrarlistadoProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addComponent(PanelDatosMostrarlistadoProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TablaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaClienteMouseClicked

        if (evt.getClickCount() == 1) {

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

            String fechavencimiento = TablaCliente.getValueAt(TablaCliente.getSelectedRow(), 4).toString().trim();
            Date dato = null;

            try {
                dato = (Date) formato.parse(fechavencimiento);
                RegistrarProducto.jDate_FechaVencimiento.setDate(dato);

            } catch (Exception e) {

            }

            RegistrarProducto.txt_codigoProducto.setText(TablaCliente.getModel().getValueAt(TablaCliente.getSelectedRow(), 0).toString());
            RegistrarProducto.txt_nombreProducto.setText(TablaCliente.getModel().getValueAt(TablaCliente.getSelectedRow(), 1).toString());
            RegistrarProducto.txt_descripcionProducto.setText(TablaCliente.getModel().getValueAt(TablaCliente.getSelectedRow(), 2).toString());
            RegistrarProducto.txt_Ingredienteactivo.setText(TablaCliente.getModel().getValueAt(TablaCliente.getSelectedRow(), 3).toString());
            RegistrarProducto.cbo_unidadMedida.setSelectedItem(TablaCliente.getModel().getValueAt(TablaCliente.getSelectedRow(), 5).toString());
            RegistrarProducto.cbo_categoria.setSelectedItem(TablaCliente.getModel().getValueAt(TablaCliente.getSelectedRow(), 6).toString());

        }
        this.hide();
        RegistrarProducto.btn_elminar.setEnabled(true);
        RegistrarProducto.btn_editar.setEnabled(true);
    }//GEN-LAST:event_TablaClienteMouseClicked

    private void txt_buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarKeyTyped

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        BotonBuscar(txt_buscar.getText());
    }//GEN-LAST:event_txt_buscarKeyReleased

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
            java.util.logging.Logger.getLogger(Fmr_MostrarListadoProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fmr_MostrarListadoProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fmr_MostrarListadoProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fmr_MostrarListadoProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fmr_MostrarListadoProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelDatosMostrarlistadoProductos;
    public static javax.swing.JTable TablaCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables

}
