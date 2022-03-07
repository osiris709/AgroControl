package Formularios;

import Conexion.conexion;
import Formularios.MenuPrincipal;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import Formularios_emergentes.RP_Mostrarlistadoproductos;

public class RegistrarProductos extends javax.swing.JInternalFrame {

    conexion conn = new conexion();
    Connection iniciarConexion = conn.conexion();

    public RegistrarProductos() {
        initComponents();

        this.setTitle("AgroControl - Registrar Productos");
        setResizable(false);

        RP_Mostrarlistadoproductos TablaListadoProductos = new RP_Mostrarlistadoproductos();
        TablaListadoProductos.setVisible(false);

    }

    public void bloquear() {

        for (Component a : PanelDatos.getComponents()) {
            a.setEnabled(false);
        }
    }

    public void desbloquear() {

        for (Component b : PanelDatos.getComponents()) {
            b.setEnabled(true);
        }

    }

    public void borrar() {

        txt_codigoProducto.setText("");
        txt_nombreProducto.setText("");
        txt_descripcionProducto.setText("");
        cbo_categoria.setSelectedIndex(0);
        cbo_unidadMedida.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelDatos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_codigoProducto = new javax.swing.JTextField();
        txt_nombreProducto = new javax.swing.JTextField();
        cbo_unidadMedida = new javax.swing.JComboBox<>();
        cbo_categoria = new javax.swing.JComboBox<>();
        txt_descripcionProducto = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        btn_editar1 = new javax.swing.JButton();
        btn_editar2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_Ingredienteactivo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jDate_FechaVencimiento = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
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
        setTitle("Registrar Productos");
        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(800, 600));

        PanelDatos.setBackground(new java.awt.Color(240, 255, 240));
        PanelDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelDatos.setPreferredSize(new java.awt.Dimension(730, 290));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Tipo producto:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Unidad de Medida:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Codigo:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Descripcion");

        txt_codigoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_codigoProductoKeyTyped(evt);
            }
        });

        txt_nombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreProductoKeyTyped(evt);
            }
        });

        cbo_unidadMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Unidad", "Peso", "Volumen" }));

        cbo_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Semillas", "Abonos", "Insectisidas", "Otros" }));
        cbo_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_categoriaActionPerformed(evt);
            }
        });

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btn_editar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo2.png"))); // NOI18N
        btn_editar1.setText("Crear tipo Producto");
        btn_editar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_editar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editar1MouseClicked(evt);
            }
        });

        btn_editar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo2.png"))); // NOI18N
        btn_editar2.setText("Crear Unidad de Medida");
        btn_editar2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_editar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editar2MouseClicked(evt);
            }
        });
        btn_editar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editar2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Ingrediente Activo:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Fecha de Vencimiento:");

        javax.swing.GroupLayout PanelDatosLayout = new javax.swing.GroupLayout(PanelDatos);
        PanelDatos.setLayout(PanelDatosLayout);
        PanelDatosLayout.setHorizontalGroup(
            PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelDatosLayout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(btn_editar2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(34, 34, 34)
                                .addComponent(cbo_unidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_editar1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelDatosLayout.createSequentialGroup()
                                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addGap(252, 252, 252)
                                .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDate_FechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(78, 78, 78)
                                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_codigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Ingredienteactivo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                                    .addComponent(txt_descripcionProducto, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_nombreProducto))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        PanelDatosLayout.setVerticalGroup(
            PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDatosLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_codigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_Ingredienteactivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jDate_FechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_descripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_unidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(cbo_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_editar2)
                    .addComponent(btn_editar1))
                .addGap(29, 29, 29))
        );

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoCRUD.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(240, 255, 240));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(730, 50));

        btn_lista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lista.png"))); // NOI18N
        btn_lista.setText("Mostrar listado de Productos");
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
                .addGap(281, 281, 281))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_lista)
                .addContainerGap(12, Short.MAX_VALUE))
        );

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

        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar2.png"))); // NOI18N
        btn_editar.setText("Editar");
        btn_editar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_elminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar2.png"))); // NOI18N
        btn_elminar.setText("Eliminar");
        btn_elminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_elminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_elminarActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btn_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btn_elminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbo_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_categoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_categoriaActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        String cp, np, dp, um, catg;

        cp = txt_codigoProducto.getText();
        np = txt_nombreProducto.getText();
        dp = txt_descripcionProducto.getText();
        um = cbo_unidadMedida.getSelectedItem().toString();
        catg = cbo_categoria.getSelectedItem().toString();

        if (txt_codigoProducto.getText().equals("") || txt_nombreProducto.getText().equals("") || txt_descripcionProducto.getText().equals("") || (cbo_unidadMedida.getSelectedItem().equals("Seleccionar"))
                || (cbo_categoria.getSelectedItem().equals("Seleccionar"))) {

            javax.swing.JOptionPane.showMessageDialog(this, "Obligatorio llenar todos los campos \n", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_nombreProducto.requestFocus();

        }
        try {
            PreparedStatement guardar = iniciarConexion.prepareStatement("INSERT INTO Productos (Codigo,Nombre,Descripcion,IngredienteActivo,FechadeVencimiento,UnidaddeMedida,TipodeProducto)VALUES (?,?,?,?,?,?,?)");
            /*consulta ingresar y guardar datos*/

            guardar.setString(1, txt_codigoProducto.getText());
            guardar.setString(2, txt_nombreProducto.getText());
            guardar.setString(3, txt_descripcionProducto.getText());
            guardar.setString(4, txt_Ingredienteactivo.getText());
            guardar.setString(5, jDate_FechaVencimiento.getDateFormatString());
            guardar.setString(6, cbo_unidadMedida.getSelectedItem().toString());
            guardar.setString(7, cbo_categoria.getSelectedItem().toString());

            guardar.executeUpdate();

            JOptionPane.showMessageDialog(null, "Datos Ingresados Correctamente.");
            bloquear();
            guardar.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "No se logro registrar el usuario \n Intente nuevamente.");
        }

    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listaActionPerformed
        RP_Mostrarlistadoproductos ventana = new RP_Mostrarlistadoproductos();
        ventana.setVisible(true);
    }//GEN-LAST:event_btn_listaActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        this.hide();
        //MenuPrincipal Mp = new MenuPrincipal();
        //Mp.setVisible(true);
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void txt_nombreProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreProductoKeyTyped

    }//GEN-LAST:event_txt_nombreProductoKeyTyped

    private void txt_codigoProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoProductoKeyTyped
        char carac = evt.getKeyChar();
        if ((carac < '0' || carac > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_codigoProductoKeyTyped

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        desbloquear();
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        borrar();
        desbloquear();
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_editar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editar2MouseClicked
        String unidadmedida = "";
        unidadmedida = JOptionPane.showInputDialog("ingresa nueva unidad de medida");
        cbo_unidadMedida.addItem(unidadmedida);
    }//GEN-LAST:event_btn_editar2MouseClicked

    private void btn_editar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editar2ActionPerformed

    }//GEN-LAST:event_btn_editar2ActionPerformed

    private void btn_editar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editar1MouseClicked
        String tipoproducto = "";
        tipoproducto = JOptionPane.showInputDialog("Ingrese el Nuevo Tipo de Producto");
        cbo_categoria.addItem(tipoproducto);
    }//GEN-LAST:event_btn_editar1MouseClicked

    private void btn_elminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elminarActionPerformed

    }//GEN-LAST:event_btn_elminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelDatos;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_editar1;
    private javax.swing.JButton btn_editar2;
    private javax.swing.JButton btn_elminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_lista;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JComboBox<String> cbo_categoria;
    private javax.swing.JComboBox<String> cbo_unidadMedida;
    private com.toedter.calendar.JDateChooser jDate_FechaVencimiento;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txt_Ingredienteactivo;
    private javax.swing.JTextField txt_codigoProducto;
    private javax.swing.JTextField txt_descripcionProducto;
    private javax.swing.JTextField txt_nombreProducto;
    // End of variables declaration//GEN-END:variables

}
