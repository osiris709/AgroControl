package Formularios;

import Conexion.conexion;
import Formularios_emergentes.Fmr_CompraProveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import Formularios_emergentes.Fmr_ProductosCompra;
import Formularios_emergentes.Fmr_MostrarListadoCompras;
import java.awt.Component;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

/**
 *
 * @author USUARIO
 */
public class RegistrarCompra extends javax.swing.JInternalFrame {

    public RegistrarCompra() {
        initComponents();
        txt_ValorTotal.setText("0");
        Bloquear();

    }

    conexion objConexion = new conexion();
    Connection con = objConexion.conexion();

    SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
    private int IdCompra;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Logo = new javax.swing.JLabel();
        PanelRegistrarCompras = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_Proveedor = new javax.swing.JTextField();
        txt_Producto = new javax.swing.JTextField();
        NFactura = new javax.swing.JTextField();
        FechaCompra = new com.toedter.calendar.JDateChooser();
        btn_buscarProveedor = new javax.swing.JButton();
        btn_buscarProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        RC_Mostrarlistadocompras = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txt_ValorTotal = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        txt_valorunidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_elminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btn_nuevo = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_lista = new javax.swing.JButton();

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
        PanelRegistrarCompras.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Producto:");
        PanelRegistrarCompras.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("N° Factura:");
        PanelRegistrarCompras.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, -1, -1));

        txt_Proveedor.setEditable(false);
        PanelRegistrarCompras.add(txt_Proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 200, -1));
        PanelRegistrarCompras.add(txt_Producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 200, -1));
        PanelRegistrarCompras.add(NFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 110, -1));

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
        PanelRegistrarCompras.add(btn_buscarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 30, 30));

        btn_buscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar2.png"))); // NOI18N
        btn_buscarProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_buscarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_buscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarProductoActionPerformed(evt);
            }
        });
        PanelRegistrarCompras.add(btn_buscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 30, 30));

        /*RC_Mostrarlistadocompras = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };*/
        RC_Mostrarlistadocompras.setAutoCreateRowSorter(true);
        RC_Mostrarlistadocompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCTOS", "CANTIDAD", "VALOR UNITARIO", "SUBTOTAL"
            }
        ));
        RC_Mostrarlistadocompras.setToolTipText("");
        RC_Mostrarlistadocompras.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(RC_Mostrarlistadocompras);
        RC_Mostrarlistadocompras.getAccessibleContext().setAccessibleName("");

        PanelRegistrarCompras.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 667, 180));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Valor Total:");
        PanelRegistrarCompras.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, -1, 20));

        txt_ValorTotal.setEditable(false);
        PanelRegistrarCompras.add(txt_ValorTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 380, 170, -1));

        txt_cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cantidadKeyTyped(evt);
            }
        });
        PanelRegistrarCompras.add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 70, -1));

        txt_valorunidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_valorunidadKeyTyped(evt);
            }
        });
        PanelRegistrarCompras.add(txt_valorunidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 70, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Cantidad:");
        PanelRegistrarCompras.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Valor Unitario: ");
        PanelRegistrarCompras.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, -1, -1));

        btn_elminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar2.png"))); // NOI18N
        btn_elminar.setText("Eliminar");
        btn_elminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_elminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_elminarActionPerformed(evt);
            }
        });
        PanelRegistrarCompras.add(btn_elminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 100, -1));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo2.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        PanelRegistrarCompras.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 100, -1));

        jPanel3.setBackground(new java.awt.Color(240, 255, 240));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo2.png"))); // NOI18N
        btn_nuevo.setText("Nuevo");
        btn_nuevo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar2.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/desactivar.png"))); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_lista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lista.png"))); // NOI18N
        btn_lista.setText("Mostrar listado de las Compras");
        btn_lista.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listaActionPerformed(evt);
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
                .addComponent(btn_lista)
                .addGap(76, 76, 76)
                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar)
                    .addComponent(btn_nuevo)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_lista))
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
                    .addComponent(PanelRegistrarCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelRegistrarCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void agregar() {

        if (txt_cantidad.getText().equals("") || txt_Producto.getText().equals("") || txt_valorunidad.getText().equals("")) {

            javax.swing.JOptionPane.showMessageDialog(this, "Obligatorio llenar todos los campos \n", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);

        } else {

            int ValorTotal;
            String VT;

            //obtener el modelo de la tabla sobre el cual trabajaremos y agregamos las columnas.
            DefaultTableModel modelo = (DefaultTableModel) RC_Mostrarlistadocompras.getModel();

            Object[] fila = new Object[4];

            //Almacenamos los datos de acuerdo al orden de las columnas de la tabla.
            fila[0] = txt_Producto.getText();
            fila[1] = txt_cantidad.getText();
            fila[2] = txt_valorunidad.getText();
            int fila1 = Integer.parseInt(fila[1].toString());
            int fila2 = Integer.parseInt(fila[2].toString());
            int SUBTOTAL = fila1 * fila2;
            fila[3] = SUBTOTAL;
            VT = txt_ValorTotal.getText().trim();
            ValorTotal = Integer.parseInt(VT) + SUBTOTAL;
            txt_ValorTotal.setText(Integer.toString(ValorTotal));

            //Agregamos el array al modelo de la tabla.
            modelo.addRow(fila);

            txt_Producto.setText("");
            txt_cantidad.setText("");
            txt_valorunidad.setText("");

            //Aplicamos el modelo a la tabla.
            RC_Mostrarlistadocompras.setModel(modelo);
        }
    }

    public void Guardar() {
        // Si hay algun campo vacio, genera mensaje de advertencia
        if (NFactura.getText().equals("") || txt_Proveedor.getText().equals("") || FechaCompra.getDateEditor().getUiComponent().toString().equals("")) {

            javax.swing.JOptionPane.showMessageDialog(this, "Obligatorio llenar todos los campos \n", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            FechaCompra.requestFocus();
        } else {
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea Guardar los datos?");
            if (confirmar == JOptionPane.YES_OPTION) {
                // Guardar datos en la base de datos
                try {
                    // Definir Sentencia en base de Datos SQL
                    PreparedStatement guardar = con.prepareStatement("INSERT INTO compras (IdCompra, Fecha_compra, N_Factura, Nombre_Proveedor, Total_Compra)VALUES (?,?,?,?,?)");
                    PreparedStatement guardar2 = con.prepareStatement("INSERT INTO detallecompra (id, Nombre_producto, Cantidad_Producto, Valor_Unitario, Subtotal) VALUES (?,?,?,?,?)");

                    guardar.setString(1, null);
                    guardar.setString(2, formato.format(FechaCompra.getDate()));
                    guardar.setString(3, NFactura.getText());
                    guardar.setString(4, txt_Proveedor.getText());
                    guardar.setString(5, txt_ValorTotal.getText());

                    guardar.executeUpdate();

                    String ConsultaID = "SELECT MAX(IdCompra) FROM compras";

                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(ConsultaID);

                    if (rs.next()) {

                        IdCompra = rs.getInt(1);
//                        System.out.println(IdCompra);
                    }

                    if (RC_Mostrarlistadocompras.getRowCount() > 0) {
                        for (int i = 0; i < RC_Mostrarlistadocompras.getRowCount(); i++) {

                            guardar2.setString(1, String.valueOf(IdCompra));
                            guardar2.setString(2, RC_Mostrarlistadocompras.getValueAt(i, 0).toString());
                            guardar2.setString(3, RC_Mostrarlistadocompras.getValueAt(i, 1).toString());
                            guardar2.setString(4, RC_Mostrarlistadocompras.getValueAt(i, 2).toString());
                            guardar2.setString(5, RC_Mostrarlistadocompras.getValueAt(i, 3).toString());
                            

                            // Ejecuta la sentencia y obtiene el resultado
                            guardar2.executeUpdate();
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Consumo Registrado exitosamente");
                    guardar.close();
                    borrar();

                } catch (HeadlessException | SQLException e) {

                    JOptionPane.showMessageDialog(null, e + " Error, No se registro la compra");
                }
            }
        }
    }

    public void borrar() {

        NFactura.setText("");
        txt_Proveedor.setText("");
        txt_Producto.setText("");
        FechaCompra.setDate(null);
        txt_cantidad.setText("");
        txt_valorunidad.setText("");
        txt_ValorTotal.setText("0");

        DefaultTableModel modelo = (DefaultTableModel) RC_Mostrarlistadocompras.getModel();
        int a = RC_Mostrarlistadocompras.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            modelo.removeRow(modelo.getRowCount() - 1);
        }
    }

    public void MostrarProducto() {

        DefaultTableModel tclientee = new DefaultTableModel();

        RC_Mostrarlistadocompras.setModel(tclientee);
        String[] datos = new String[1];

        try {
            Statement leer = con.createStatement();
            ResultSet resultado = leer.executeQuery("SELECT * FROM RegistroCompras");

            while (resultado.next()) {
                datos[0] = resultado.getString(1);

                tclientee.addRow(datos);
            }
            RC_Mostrarlistadocompras.setModel(tclientee);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e + "Error en la Consulta");
        }
    }

    public void Bloquear() {

        for (Component a : PanelRegistrarCompras.getComponents()) {
            a.setEnabled(false);

            btn_guardar.setEnabled(false);
            btn_cancelar.setEnabled(false);
        }
    }

    public void Desbloquear() {

        for (Component a : PanelRegistrarCompras.getComponents()) {
            a.setEnabled(true);

            btn_guardar.setEnabled(true);
            btn_cancelar.setEnabled(true);

        }
    }

    public void eliminar() {
        DefaultTableModel modelo = (DefaultTableModel) RC_Mostrarlistadocompras.getModel();
        int a = (RC_Mostrarlistadocompras.getSelectedRow());
        System.out.println(a);

        if (a < 0) {
            JOptionPane.showMessageDialog(null, "¡Debe seleccionar un producto o su tabla se encuentra vacia!");
        } else {

            int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro seleccionado?");
            if (confirmar == JOptionPane.OK_OPTION) {
                int SUBTOTAL = Integer.parseInt(RC_Mostrarlistadocompras.getValueAt(RC_Mostrarlistadocompras.getSelectedRow(), 3).toString());
                int ValorTotal;
                for (int i = a; i >= 0; i--) {
                    modelo.removeRow(RC_Mostrarlistadocompras.getSelectedRow());
                    ValorTotal = Integer.parseInt(txt_ValorTotal.getText()) - SUBTOTAL;
                    txt_ValorTotal.setText(Integer.toString(ValorTotal));
                }
            }
        }
    }

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        Guardar();
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
        borrar();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listaActionPerformed
        Fmr_MostrarListadoCompras ventana = new Fmr_MostrarListadoCompras();
        ventana.setVisible(true);
    }//GEN-LAST:event_btn_listaActionPerformed

    private void btn_elminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elminarActionPerformed
        eliminar();

    }//GEN-LAST:event_btn_elminarActionPerformed

    private void txt_cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidadKeyTyped
        //para pedir solo numeros.
        char carac = evt.getKeyChar();
        if ((carac < '0' || carac > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "¡Debe introducir solo numeros!");
        }
    }//GEN-LAST:event_txt_cantidadKeyTyped

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        Desbloquear();
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void txt_valorunidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valorunidadKeyTyped
        //para pedir solo numeros.
        char carac = evt.getKeyChar();
        if ((carac < '0' || carac > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "¡Debe introducir solo numeros!");
        }
    }//GEN-LAST:event_txt_valorunidadKeyTyped

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        agregar();
    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser FechaCompra;
    private javax.swing.JLabel Logo;
    private javax.swing.JTextField NFactura;
    private javax.swing.JPanel PanelRegistrarCompras;
    private javax.swing.JTable RC_Mostrarlistadocompras;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btn_buscarProducto;
    private javax.swing.JButton btn_buscarProveedor;
    private javax.swing.JButton btn_cancelar;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField txt_Producto;
    public static javax.swing.JTextField txt_Proveedor;
    private javax.swing.JTextField txt_ValorTotal;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_valorunidad;
    // End of variables declaration//GEN-END:variables

}
