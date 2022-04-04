package Formularios;

import Conexion.conexion;
import Formularios_emergentes.Fmr_CrearTipodeProducto;
import Formularios_emergentes.Fmr_CrearUnidadMedida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import Formularios_emergentes.Fmr_MostrarListadoProductos;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public final class RegistrarProducto extends javax.swing.JInternalFrame {

    conexion conn = new conexion();
    Connection iniciarConexion = conn.conexion();

    public RegistrarProducto() {
        initComponents();

        LeerDatosComboBoxUnidadMedida();
        LeerDatosComboBoxTipoProducto();
        bloquearInicio();

        this.setTitle("AgroControl - Registrar Productos");
        setResizable(false);

        Fmr_MostrarListadoProductos TablaListadoProductos = new Fmr_MostrarListadoProductos();
        TablaListadoProductos.setVisible(false);
    }

    public void bloquearInicio() {
        txt_codigoProducto.setEnabled(false);
        txt_nombreProducto.setEnabled(false);
        txt_Ingredienteactivo.setEnabled(false);
        jDate_FechaVencimiento.setEnabled(false);
        txt_descripcionProducto.setEnabled(false);
        cbo_unidadMedida.setEnabled(false);
        cbo_categoria.setEnabled(false);
        btn_editar2.setEnabled(false);
        btn_editar1.setEnabled(false);
        btn_buscar.setEnabled(false);
        btn_guardar.setEnabled(false);
        btn_editar.setEnabled(false);
        btn_cancelar.setEnabled(false);
        btn_elminar.setEnabled(false);
    }

    public void BotonNuevo() {
        txt_codigoProducto.setEnabled(true);
        txt_nombreProducto.setEnabled(true);
        txt_Ingredienteactivo.setEnabled(true);
        jDate_FechaVencimiento.setEnabled(true);
        txt_descripcionProducto.setEnabled(true);
        cbo_unidadMedida.setEnabled(true);
        cbo_categoria.setEnabled(true);
        btn_editar2.setEnabled(true);
        btn_editar1.setEnabled(true);
        btn_buscar.setEnabled(true);
        btn_guardar.setEnabled(true);
        btn_editar.setEnabled(false);
        btn_cancelar.setEnabled(true);
        btn_elminar.setEnabled(false);

    }

    public void bloquearBotones() {

        btn_guardar.setEnabled(false);
        btn_editar.setEnabled(false);
        btn_cancelar.setEnabled(false);
        btn_elminar.setEnabled(false);
    }

    public void borrar() {

        txt_codigoProducto.setText("");
        txt_nombreProducto.setText("");
        txt_descripcionProducto.setText("");
        txt_Ingredienteactivo.setText("");
        jDate_FechaVencimiento.setDate(null);
        cbo_categoria.setSelectedIndex(0);
        cbo_unidadMedida.setSelectedIndex(0);
    }

    public DefaultComboBoxModel Obt_Datos() {
        DefaultComboBoxModel ListaModel = new DefaultComboBoxModel();
        cbo_unidadMedida.setModel(ListaModel);
        return null;
    }

    public DefaultComboBoxModel Obj_TipoProducto() {
        DefaultComboBoxModel ListaModell = new DefaultComboBoxModel();
        cbo_categoria.setModel(ListaModell);
        return null;

    }

    public void LeerDatosComboBoxUnidadMedida() {
        try {
            cbo_unidadMedida.removeAllItems();
            cbo_unidadMedida.addItem("Seleccionar");
            String consulta = "Select UnidaddeMedidaDato from UnimedidaTproducto Order by UnidaddeMedidaDato asc";
            PreparedStatement leer = iniciarConexion.prepareStatement(consulta);
            ResultSet resultado = leer.executeQuery();

            while (resultado.next()) {

                cbo_unidadMedida.addItem(resultado.getString("UnidaddeMedidaDato"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "error");
        }
    }

    public void LeerDatosComboBoxTipoProducto() {
        try {
            cbo_categoria.removeAllItems();
            cbo_categoria.addItem("Seleccionar");
            String consulta = "Select TipodeProductoo from TipodeProducto Order by TipodeProductoo asc";
            PreparedStatement leer = iniciarConexion.prepareStatement(consulta);
            ResultSet resultado = leer.executeQuery();

            while (resultado.next()) {
                cbo_categoria.addItem(resultado.getString("TipodeProductoo"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "error");
        }
    }

    public void Eliminar(String codigo) {
        if (txt_codigoProducto.getText().equals("") || txt_nombreProducto.getText().equals("") || txt_Ingredienteactivo.getText().equals("") || txt_descripcionProducto.getText().equals("") || (cbo_unidadMedida.getSelectedItem().equals("Seleccionar"))
                || (cbo_categoria.getSelectedItem().equals("Seleccionar"))) {

            javax.swing.JOptionPane.showMessageDialog(this, "Debe Seleccionar algun campo \n", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_codigoProducto.requestFocus();
        } else {
            // Eliminar datos en la base de datos
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar los datos?");
            if (confirmar == JOptionPane.YES_OPTION) {
                try {
                    PreparedStatement eliminar = iniciarConexion.prepareStatement("DELETE FROM Productos WHERE Codigo=?");

                    eliminar.setString(1, txt_codigoProducto.getText());
                    eliminar.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Cosecha Eliminada exitosamente");

                    borrar();
                    eliminar.close();

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, e + "Error, No se elimino la Cosecha");
                }
            }
        }
    }

    public void Modificar(String Codigo, String Nombre, String IngredienteActivo, String Descripcion, Date Fecha, String unidadmedida, String tipoproducto) {
        if (txt_codigoProducto.getText().equals("") || txt_nombreProducto.getText().equals("") || txt_Ingredienteactivo.getText().equals("") || txt_descripcionProducto.getText().equals("") || (cbo_unidadMedida.getSelectedItem().equals("Seleccionar"))
                || (cbo_categoria.getSelectedItem().equals("Seleccionar"))) {

            javax.swing.JOptionPane.showMessageDialog(this, "Obligatorio llenar todos los campos \n", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_codigoProducto.requestFocus();
        } else {
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea modificar los datos?");
            if (confirmar == JOptionPane.YES_OPTION) {
                try {
                    PreparedStatement modificar = iniciarConexion.prepareStatement("UPDATE Productos SET Nombre=?,Descripcion=?,IngredienteActivo=?,FechadeVencimiento=?,UnidaddeMedida=?,TipodeProducto =? WHERE codigo=?"); /// where codigo=?");/// WHERE IdCosecha=?");

                    modificar.setString(1, txt_nombreProducto.getText());
                    modificar.setString(2, txt_descripcionProducto.getText());
                    modificar.setString(3, txt_Ingredienteactivo.getText());
                    modificar.setString(4, ((JTextField) jDate_FechaVencimiento.getDateEditor().getUiComponent()).getText());
                    modificar.setString(5, cbo_unidadMedida.getSelectedItem().toString());
                    modificar.setString(6, cbo_categoria.getSelectedItem().toString());
                    modificar.setString(7, txt_codigoProducto.getText());
                    modificar.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Ventana Productos Modificada Exitosamente");

                    bloquearInicio();
                    modificar.close();

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, e + "Error, No se pudo Modificar la Ventana Productos");
                }
            }
        }
    }

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
        Panel_Listado = new javax.swing.JPanel();
        btn_lista = new javax.swing.JButton();
        Panel_Botones = new javax.swing.JPanel();
        btn_guardar = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_elminar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_nuevo = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setResizable(true);
        setTitle("Registrar Productos");
        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(800, 600));

        PanelDatos.setBackground(new java.awt.Color(240, 255, 240));
        PanelDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelDatos.setPreferredSize(new java.awt.Dimension(730, 290));
        PanelDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Tipo producto:");
        PanelDatos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 269, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nombre:");
        PanelDatos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 65, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Unidad de Medida:");
        PanelDatos.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 269, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Codigo:");
        PanelDatos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 24, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Descripcion");
        PanelDatos.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 199, -1, -1));

        txt_codigoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_codigoProductoKeyTyped(evt);
            }
        });
        PanelDatos.add(txt_codigoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 22, 185, -1));
        PanelDatos.add(txt_nombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 63, 525, -1));

        cbo_unidadMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Monoxido" }));
        cbo_unidadMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_unidadMedidaActionPerformed(evt);
            }
        });
        PanelDatos.add(cbo_unidadMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 180, -1));

        cbo_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Semillas", "Abonos", "Insectisidas", "Otros" }));
        cbo_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_categoriaActionPerformed(evt);
            }
        });
        PanelDatos.add(cbo_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, 180, -1));
        PanelDatos.add(txt_descripcionProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 199, 525, 40));

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        PanelDatos.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 16, 70, 30));

        btn_editar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo2.png"))); // NOI18N
        btn_editar1.setText("Crear tipo Producto");
        btn_editar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_editar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editar1MouseClicked(evt);
            }
        });
        btn_editar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editar1ActionPerformed(evt);
            }
        });
        PanelDatos.add(btn_editar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 308, 180, -1));

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
        PanelDatos.add(btn_editar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 308, 180, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Ingrediente Activo:");
        PanelDatos.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 106, -1, -1));
        PanelDatos.add(txt_Ingredienteactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 104, 525, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Fecha de Vencimiento:");
        PanelDatos.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 151, -1, -1));

        jDate_FechaVencimiento.setDateFormatString("dd/MM/yyyy\n");
        PanelDatos.add(jDate_FechaVencimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 146, 145, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoCRUD.png"))); // NOI18N

        Panel_Listado.setBackground(new java.awt.Color(240, 255, 240));
        Panel_Listado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Panel_Listado.setPreferredSize(new java.awt.Dimension(730, 50));

        btn_lista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lista.png"))); // NOI18N
        btn_lista.setText("Mostrar listado de Productos");
        btn_lista.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_ListadoLayout = new javax.swing.GroupLayout(Panel_Listado);
        Panel_Listado.setLayout(Panel_ListadoLayout);
        Panel_ListadoLayout.setHorizontalGroup(
            Panel_ListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_ListadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_lista)
                .addGap(293, 293, 293))
        );
        Panel_ListadoLayout.setVerticalGroup(
            Panel_ListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ListadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_lista)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        Panel_Botones.setBackground(new java.awt.Color(240, 255, 240));
        Panel_Botones.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo2.png"))); // NOI18N
        btn_nuevo.setText("Nuevo");
        btn_nuevo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_BotonesLayout = new javax.swing.GroupLayout(Panel_Botones);
        Panel_Botones.setLayout(Panel_BotonesLayout);
        Panel_BotonesLayout.setHorizontalGroup(
            Panel_BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_BotonesLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btn_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btn_elminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        Panel_BotonesLayout.setVerticalGroup(
            Panel_BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_BotonesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(Panel_BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_elminar)
                    .addComponent(btn_editar)
                    .addComponent(btn_guardar)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_nuevo))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Panel_Listado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addComponent(Panel_Botones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel_Listado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Panel_Botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbo_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_categoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_categoriaActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        String cp, np, dp, um, catg, ia;

        cp = txt_codigoProducto.getText();
        np = txt_nombreProducto.getText();
        dp = txt_descripcionProducto.getText();
        um = cbo_unidadMedida.getSelectedItem().toString();
        catg = cbo_categoria.getSelectedItem().toString();
        ia = txt_Ingredienteactivo.getText();

        if (txt_codigoProducto.getText().equals("") || txt_nombreProducto.getText().equals("") || txt_descripcionProducto.getText().equals("") || (cbo_unidadMedida.getSelectedItem().equals("Seleccionar"))
                || (cbo_categoria.getSelectedItem().equals("Seleccionar")) || txt_Ingredienteactivo.getText().equals("")) {

            javax.swing.JOptionPane.showMessageDialog(this, "Obligatorio llenar todos los campos \n", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_nombreProducto.requestFocus();
        } else {
            try {
                PreparedStatement guardar = iniciarConexion.prepareStatement("INSERT INTO Productos (Codigo,Nombre,Descripcion,IngredienteActivo,FechadeVencimiento,UnidaddeMedida,TipodeProducto)VALUES (?,?,?,?,?,?,?)");
                /*consulta ingresar y guardar datos*/
                guardar.setString(1, txt_codigoProducto.getText());
                guardar.setString(2, txt_nombreProducto.getText());
                guardar.setString(3, txt_descripcionProducto.getText());
                guardar.setString(4, txt_Ingredienteactivo.getText());
                guardar.setString(5, ((JTextField) jDate_FechaVencimiento.getDateEditor().getUiComponent()).getText());
                guardar.setString(6, cbo_unidadMedida.getSelectedItem().toString());
                guardar.setString(7, cbo_categoria.getSelectedItem().toString());
                guardar.executeUpdate();

                JOptionPane.showMessageDialog(null, "Datos Ingresados Correctamente.");
                guardar.close();
                bloquearInicio();
                borrar();
                btn_nuevo.setEnabled(true);

            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listaActionPerformed

        Fmr_MostrarListadoProductos ventana = new Fmr_MostrarListadoProductos();
        ventana.setVisible(true);
        Fmr_MostrarListadoProductos.TablaCliente.setEnabled(false);
    }//GEN-LAST:event_btn_listaActionPerformed


    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        borrar();
        bloquearInicio();
        btn_nuevo.setEnabled(true);
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void txt_codigoProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoProductoKeyTyped
        char carac = evt.getKeyChar();
        if ((carac < '0' || carac > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_codigoProductoKeyTyped

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed

        Modificar(txt_codigoProducto.getText(), txt_nombreProducto.getText(), txt_descripcionProducto.getText(), txt_Ingredienteactivo.getText(), jDate_FechaVencimiento.getDate(), cbo_unidadMedida.getSelectedItem().toString(), cbo_categoria.getSelectedItem().toString());
        btn_nuevo.setEnabled(true);
        borrar();

    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        borrar();
        BotonNuevo();
        btn_nuevo.setEnabled(false);
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_editar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editar2MouseClicked

    }//GEN-LAST:event_btn_editar2MouseClicked

    private void btn_editar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editar2ActionPerformed
        Fmr_CrearUnidadMedida ventana = new Fmr_CrearUnidadMedida();
        ventana.setVisible(true);

    }//GEN-LAST:event_btn_editar2ActionPerformed

    private void btn_editar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editar1MouseClicked

    }//GEN-LAST:event_btn_editar1MouseClicked

    private void btn_elminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elminarActionPerformed
        Eliminar(txt_codigoProducto.getText());
        borrar();
        bloquearInicio();
        btn_nuevo.setEnabled(true);
    }//GEN-LAST:event_btn_elminarActionPerformed

    private void btn_editar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editar1ActionPerformed
        Fmr_CrearTipodeProducto ventana = new Fmr_CrearTipodeProducto();
        ventana.setVisible(true);
    }//GEN-LAST:event_btn_editar1ActionPerformed

    private void cbo_unidadMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_unidadMedidaActionPerformed

    }//GEN-LAST:event_cbo_unidadMedidaActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        Fmr_MostrarListadoProductos ventana = new Fmr_MostrarListadoProductos();
        ventana.setVisible(true);
    }//GEN-LAST:event_btn_buscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelDatos;
    private javax.swing.JPanel Panel_Botones;
    private javax.swing.JPanel Panel_Listado;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar;
    public static javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_editar1;
    private javax.swing.JButton btn_editar2;
    public static javax.swing.JButton btn_elminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_lista;
    private javax.swing.JButton btn_nuevo;
    public static javax.swing.JComboBox<String> cbo_categoria;
    public static javax.swing.JComboBox<String> cbo_unidadMedida;
    public static com.toedter.calendar.JDateChooser jDate_FechaVencimiento;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField txt_Ingredienteactivo;
    public static javax.swing.JTextField txt_codigoProducto;
    public static javax.swing.JTextField txt_descripcionProducto;
    public static javax.swing.JTextField txt_nombreProducto;
    // End of variables declaration//GEN-END:variables

}
