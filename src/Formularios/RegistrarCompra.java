package Formularios;

import Conexion.conexion;
import Formularios_emergentes.Fmr_CompraProveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import Formularios_emergentes.Fmr_ProductosCompra;
import Formularios_emergentes.Fmr_MostrarListadoCompras;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

/**
 *
 * @author USUARIO
 */
public class RegistrarCompra extends javax.swing.JInternalFrame {

    public static void main(String[] args) {

    }

    public RegistrarCompra() {
        initComponents();
        MostrarProducto();
    }
    conexion conn = new conexion();
    Connection iniciarConexion = conn.conexion();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Logo = new javax.swing.JLabel();
        PanelRegistrarCompras = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Proveedor = new javax.swing.JTextField();
        Producto = new javax.swing.JTextField();
        NFactura = new javax.swing.JTextField();
        FechaCompra = new com.toedter.calendar.JDateChooser();
        btn_buscarProveedor = new javax.swing.JButton();
        btn_buscarProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        RC_Mostrarlistadocompras = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        ValorTotal = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        txt_valorunidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_lista = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btn_nuevo = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_elminar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registrar Compras");
        setAutoscrolls(true);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        Logo.setBackground(new java.awt.Color(255, 255, 255));
        Logo.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoCRUD.png"))); // NOI18N

        PanelRegistrarCompras.setBackground(new java.awt.Color(240, 255, 240));
        PanelRegistrarCompras.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelRegistrarCompras.setPreferredSize(new java.awt.Dimension(730, 436));
        PanelRegistrarCompras.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Fecha de compra:");
        PanelRegistrarCompras.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Proveedor:");
        PanelRegistrarCompras.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Producto:");
        PanelRegistrarCompras.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("N° Factura:");
        PanelRegistrarCompras.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, -1));
        PanelRegistrarCompras.add(Proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 200, -1));
        PanelRegistrarCompras.add(Producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 200, -1));

        NFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NFacturaKeyTyped(evt);
            }
        });
        PanelRegistrarCompras.add(NFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 185, -1));

        FechaCompra.setDateFormatString("dd/MM/yyyy");
        PanelRegistrarCompras.add(FechaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 185, -1));

        btn_buscarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar2.png"))); // NOI18N
        btn_buscarProveedor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_buscarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_buscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarProveedorActionPerformed(evt);
            }
        });
        PanelRegistrarCompras.add(btn_buscarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 30, 30));

        btn_buscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar2.png"))); // NOI18N
        btn_buscarProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_buscarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_buscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarProductoActionPerformed(evt);
            }
        });
        PanelRegistrarCompras.add(btn_buscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 30, 30));

        RC_Mostrarlistadocompras.setAutoCreateRowSorter(true);
        RC_Mostrarlistadocompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        RC_Mostrarlistadocompras.setToolTipText("");
        jScrollPane1.setViewportView(RC_Mostrarlistadocompras);
        RC_Mostrarlistadocompras.getAccessibleContext().setAccessibleName("Nombre\nCantidad\nValor Unitario\nSubtotal");
        RC_Mostrarlistadocompras.getAccessibleContext().setAccessibleDescription("Nombre\nCantidad\nValor Unitario\nSubtotal");

        PanelRegistrarCompras.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 179, 667, 126));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Valor Total:");
        PanelRegistrarCompras.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 325, -1, -1));
        PanelRegistrarCompras.add(ValorTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 323, 170, -1));
        PanelRegistrarCompras.add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 110, -1));
        PanelRegistrarCompras.add(txt_valorunidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 110, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Cantidad:");
        PanelRegistrarCompras.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Valor Unitario: ");
        PanelRegistrarCompras.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, -1, -1));

        jPanel2.setBackground(new java.awt.Color(240, 255, 240));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_lista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lista.png"))); // NOI18N
        btn_lista.setText("Mostrar listado de las Compras");
        btn_lista.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_lista)
                .addGap(283, 283, 283))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_lista)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(240, 255, 240));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo2.png"))); // NOI18N
        btn_nuevo.setText("Nuevo");
        btn_nuevo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar2.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar2.png"))); // NOI18N
        btn_editar.setText("Editar");
        btn_editar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_elminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar2.png"))); // NOI18N
        btn_elminar.setText("Eliminar");
        btn_elminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/desactivar.png"))); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btn_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btn_elminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_elminar)
                    .addComponent(btn_editar)
                    .addComponent(btn_guardar)
                    .addComponent(btn_nuevo)
                    .addComponent(btn_cancelar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Logo)
                    .addComponent(PanelRegistrarCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelRegistrarCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void MostrarProducto() {

        DefaultTableModel tclientee = new DefaultTableModel();
        tclientee.addColumn("PRODUCTO");
        tclientee.addColumn("CANTIDAD");
        tclientee.addColumn("VALOR UNITARIO");
        tclientee.addColumn("SUBTOTAL");

        RC_Mostrarlistadocompras.setModel(tclientee);
        String[] datos = new String[1];

        try {
            Statement leer = iniciarConexion.createStatement();
            ResultSet resultado = leer.executeQuery("SELECT * FROM Productos");

            while (resultado.next()) {
                datos[0] = resultado.getString(1);

                tclientee.addRow(datos);
            }
            RC_Mostrarlistadocompras.setModel(tclientee);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e + "Error en la Consulta");
        }
    }

    public void bloquear() {

        for (Component a : PanelRegistrarCompras.getComponents()) {
            a.setEnabled(false);
        }
    }

    public void borrar() {

        NFactura.setText("");
        Proveedor.setText("");
        Producto.setText("");
        ValorTotal.setText("");
        FechaCompra.setDate(null);
        //  jDate_FechaVencimiento.setText("yyyy-MM-dd");

    }

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed

        String nFtra, Prov, Prod, fVen;
        nFtra = NFactura.getText();
        Prov = Proveedor.getText();
        Prod = Producto.getText();
        fVen = FechaCompra.getDateEditor().getUiComponent().toString();

        if (NFactura.getText().equals("") || Proveedor.getText().equals("") || Producto.getText().equals("") || FechaCompra.getDateEditor().getUiComponent().toString().equals("")) {

            javax.swing.JOptionPane.showMessageDialog(this, "Obligatorio llenar todos los campos \n", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
        try {
            PreparedStatement guardarCompras = iniciarConexion.prepareStatement("INSERT INTO Compras(CodigoPro,Proveedor,NumeroFactura,FechaCompra,Cantidadcompra,Valorporunidad)VALUES (?,?,?,?,?,?)");

            guardarCompras.setString(1, Producto.getText());
            guardarCompras.setString(2, Proveedor.getText());
            guardarCompras.setString(3, NFactura.getText());
            guardarCompras.setString(4, ((JTextField) FechaCompra.getDateEditor().getUiComponent()).getText());
            guardarCompras.setString(5, txt_cantidad.getText());
            guardarCompras.setString(6, txt_valorunidad.getText());

            guardarCompras.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Ingresados Correctamente.");
            guardarCompras.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "No se logro registrar el usuario \n Intente nuevamente.");
        }

    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_buscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarProductoActionPerformed
        Fmr_ProductosCompra ventana = new Fmr_ProductosCompra();
        ventana.setVisible(true);


    }//GEN-LAST:event_btn_buscarProductoActionPerformed


    private void btn_buscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarProveedorActionPerformed
        Fmr_CompraProveedor ventana = new Fmr_CompraProveedor();
        ventana.setVisible(true);

    }//GEN-LAST:event_btn_buscarProveedorActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        bloquear();
        borrar();

    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listaActionPerformed
        Fmr_MostrarListadoCompras ventana = new Fmr_MostrarListadoCompras();
        ventana.setVisible(true);
    }//GEN-LAST:event_btn_listaActionPerformed

    private void NFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NFacturaKeyTyped
        char carac = evt.getKeyChar();
        if ((carac < '0' || carac > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_NFacturaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser FechaCompra;
    private javax.swing.JLabel Logo;
    private javax.swing.JTextField NFactura;
    private javax.swing.JPanel PanelRegistrarCompras;
    public static javax.swing.JTextField Producto;
    public static javax.swing.JTextField Proveedor;
    private javax.swing.JTable RC_Mostrarlistadocompras;
    private javax.swing.JTextField ValorTotal;
    private javax.swing.JButton btn_buscarProducto;
    private javax.swing.JButton btn_buscarProveedor;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_elminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_lista;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_valorunidad;
    // End of variables declaration//GEN-END:variables

}
