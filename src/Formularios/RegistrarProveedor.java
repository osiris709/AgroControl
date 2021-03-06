package Formularios;

import Clases.Proveedor;
import Conexion.conexion;
import Formularios_emergentes.Fmr_ListadoProveedores;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class RegistrarProveedor extends javax.swing.JInternalFrame {

    conexion conn = new conexion();
    Connection iniciarConexion = conn.conexion();
    DefaultTableModel modelo;

    public RegistrarProveedor() {
        initComponents();

        String[] titulos = {"Nit", "Nombre", "Direccion", "Correo", "Telefono"};

        modelo = new DefaultTableModel(null, titulos);
        mostrardatos();
        limpiar();
        bloquear();
        setTitle("AgroControl - Registro Proveedores");
        BloqInicio();

        Proveedor pro = new Proveedor();

    }

    public void bloquear() {
        txt_direccion.setEnabled(false);
        txt_correo.setEnabled(false);
        txt_telefono.setEnabled(false);
        txt_nit.setEnabled(false);
        txt_nombre.setEnabled(false);
    }

    public void mostrardatos() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        conexion objConexion = new conexion();
        Connection con = objConexion.conexion();
        try {
            ResultSet resultado = objConexion.consultarRegistro("SELECT * FROM proveedores");
            while (resultado.next()) {

                Object[] oUsuario = {resultado.getString("Nit"), resultado.getString("Nombre"), resultado.getString("Direccion"), resultado.getString("Correo"), resultado.getString("Telefono")};
                modelo.addRow(oUsuario);
                desbloquear();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Proveedor recuperarDatosGUI() {
        Proveedor oProveedor = new Proveedor();

        oProveedor.setNIt(txt_nit.getText());
        oProveedor.setNombre(txt_nombre.getText());
        oProveedor.setDireccion(txt_direccion.getText());
        oProveedor.setCorreo(txt_correo.getText());
        oProveedor.setTelefono(txt_telefono.getText());

        return oProveedor;
    }

    public void limpiar() {
        txt_nit.setText("");
        txt_nombre.setText("");
        txt_direccion.setText("");
        txt_correo.setText("");
        txt_telefono.setText("");
    }

    public void desbloquear() {
        txt_direccion.setEnabled(true);
        txt_correo.setEnabled(true);
        txt_telefono.setEnabled(true);
        txt_nit.setEnabled(true);
        txt_nombre.setEnabled(true);
    }

    public void BloqInicio() {
        btn_buscar.setEnabled(true);
        btn_nuevo.setEnabled(true);
        btn_guardar.setEnabled(false);
        btn_modificar.setEnabled(false);
        btn_cancelar.setEnabled(false);
        btn_eliminar.setEnabled(false);
    }

    public void BloqBotonNuevo() {
        btn_buscar.setEnabled(false);
        btn_nuevo.setEnabled(false);
        btn_guardar.setEnabled(true);
        btn_modificar.setEnabled(false);
        btn_cancelar.setEnabled(true);
        btn_eliminar.setEnabled(false);
    }

    public void BloqBotonBuscar() {
        btn_buscar.setEnabled(true);
        btn_nuevo.setEnabled(false);
        btn_guardar.setEnabled(false);
        btn_modificar.setEnabled(true);
        btn_cancelar.setEnabled(true);
        btn_eliminar.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon1 = new ImageIcon(getClass().getResource("/Imagenes/fondo-submenu4.jpg"));
        Image image1 = icon1.getImage();
        jDP_RProveedor = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image1,0,0,getWidth(),getHeight(),this);
            }
        }
        ;
        LogoCRUD = new javax.swing.JLabel();
        jP_Datos = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_nit = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        jP_Listado = new javax.swing.JPanel();
        btn_lista1 = new javax.swing.JButton();
        jP_Botones = new javax.swing.JPanel();
        btn_nuevo = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setResizable(true);
        setTitle("Registrar Proveedores");
        setAutoscrolls(true);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jDP_RProveedor.setBackground(new java.awt.Color(255, 255, 255));

        LogoCRUD.setBackground(new java.awt.Color(255, 255, 255));
        LogoCRUD.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        LogoCRUD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoCRUD2.png"))); // NOI18N

        jP_Datos.setBackground(new java.awt.Color(240, 255, 240));
        jP_Datos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jP_Datos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jP_Datos.setMaximumSize(new java.awt.Dimension(730, 800));
        jP_Datos.setPreferredSize(new java.awt.Dimension(730, 320));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("NIT:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Nombre:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Direccion:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Telefono:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Correo:");

        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyTyped(evt);
            }
        });

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jP_DatosLayout = new javax.swing.GroupLayout(jP_Datos);
        jP_Datos.setLayout(jP_DatosLayout);
        jP_DatosLayout.setHorizontalGroup(
            jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_DatosLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jP_DatosLayout.createSequentialGroup()
                        .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_correo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jP_DatosLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jP_DatosLayout.createSequentialGroup()
                        .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jP_DatosLayout.createSequentialGroup()
                                .addComponent(txt_nit, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28))
        );
        jP_DatosLayout.setVerticalGroup(
            jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_DatosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_nit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(38, 38, 38)
                .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(38, 38, 38)
                .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jP_Listado.setBackground(new java.awt.Color(240, 255, 240));
        jP_Listado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_lista1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lista.png"))); // NOI18N
        btn_lista1.setText("Mostrar listado de los Proveedores");
        btn_lista1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_lista1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lista1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jP_ListadoLayout = new javax.swing.GroupLayout(jP_Listado);
        jP_Listado.setLayout(jP_ListadoLayout);
        jP_ListadoLayout.setHorizontalGroup(
            jP_ListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_ListadoLayout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(btn_lista1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jP_ListadoLayout.setVerticalGroup(
            jP_ListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_ListadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_lista1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jP_Botones.setBackground(new java.awt.Color(240, 255, 240));
        jP_Botones.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar2.png"))); // NOI18N
        btn_modificar.setText("Editar");
        btn_modificar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
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

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar2.png"))); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jP_BotonesLayout = new javax.swing.GroupLayout(jP_Botones);
        jP_Botones.setLayout(jP_BotonesLayout);
        jP_BotonesLayout.setHorizontalGroup(
            jP_BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_BotonesLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btn_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jP_BotonesLayout.setVerticalGroup(
            jP_BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_BotonesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jP_BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_eliminar)
                    .addComponent(btn_modificar)
                    .addComponent(btn_guardar)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_nuevo))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jDP_RProveedor.setLayer(LogoCRUD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDP_RProveedor.setLayer(jP_Datos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDP_RProveedor.setLayer(jP_Listado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDP_RProveedor.setLayer(jP_Botones, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDP_RProveedorLayout = new javax.swing.GroupLayout(jDP_RProveedor);
        jDP_RProveedor.setLayout(jDP_RProveedorLayout);
        jDP_RProveedorLayout.setHorizontalGroup(
            jDP_RProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDP_RProveedorLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jDP_RProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jP_Botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDP_RProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jP_Datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LogoCRUD)
                        .addComponent(jP_Listado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jDP_RProveedorLayout.setVerticalGroup(
            jDP_RProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDP_RProveedorLayout.createSequentialGroup()
                .addComponent(LogoCRUD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jP_Datos, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jP_Listado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jP_Botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDP_RProveedor)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDP_RProveedor)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_lista1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lista1ActionPerformed
        Frame listaProveedor = JOptionPane.getFrameForComponent(this);
        Fmr_ListadoProveedores abrir = new Fmr_ListadoProveedores(listaProveedor, true);
        abrir.setVisible(true);
        abrir.txtBuscar.setEnabled(false);
    }//GEN-LAST:event_btn_lista1ActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed

        conexion objConexion = new conexion();
        Connection con = objConexion.conexion();

        Proveedor oProveedor = recuperarDatosGUI();
        if (txt_nit.getText().equals("") || txt_nombre.getText().equals("") || (txt_direccion.getText().equals(""))
                || (txt_correo.getText().equals("")) || txt_telefono.getText().equals("")) {

            javax.swing.JOptionPane.showMessageDialog(this, "Obligatorio llenar todos los campos \n", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_nit.requestFocus();
        } else {
            int confirmar = JOptionPane.showConfirmDialog(null, "??Desea Guardar los datos?");
            if (confirmar == JOptionPane.YES_OPTION) {
                String strSentenciaInsert = String.format("INSERT INTO proveedores (Nit,Nombre,Direccion,Correo,Telefono) "
                        + "VALUES ('%s','%s','%s','%s','%s')", oProveedor.getNIt(), oProveedor.getNombre(), oProveedor.getDireccion(), oProveedor.getCorreo(), oProveedor.getTelefono());

                objConexion.ejecutarSentenciaSQL(strSentenciaInsert);
                JOptionPane.showMessageDialog(null, "Proveedor Registrado exitosamente");
                mostrardatos();
                limpiar();
                bloquear();
                BloqInicio();
            }
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed

        conexion objConexion = new conexion();
        Connection con = objConexion.conexion();

        Proveedor oProveedor = recuperarDatosGUI();
        if (txt_nit.getText().equals("") || txt_nombre.getText().equals("") || (txt_direccion.getText().equals(""))
                || (txt_correo.getText().equals("")) || txt_telefono.getText().equals("")) {

            javax.swing.JOptionPane.showMessageDialog(this, "Obligatorio llenar todos los campos \n", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_nit.requestFocus();
        } else {
            int confirmar = JOptionPane.showConfirmDialog(null, "??Desea Eliminar los datos?");
            if (confirmar == JOptionPane.YES_OPTION) {
                String strSentenciaInsert = String.format("DELETE FROM proveedores WHERE Nit=%s ", oProveedor.getNIt());

                objConexion.ejecutarSentenciaSQL(strSentenciaInsert);
                mostrardatos();
                limpiar();
                BloqInicio();
            }
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed

        conexion objConexion = new conexion();
        Connection con = objConexion.conexion();

        Proveedor oProveedor = recuperarDatosGUI();
        if (txt_nit.getText().equals("") || txt_nombre.getText().equals("") || (txt_direccion.getText().equals(""))
                || (txt_correo.getText().equals("")) || txt_telefono.getText().equals("")) {

            javax.swing.JOptionPane.showMessageDialog(this, "Obligatorio llenar todos los campos \n", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_nit.requestFocus();
        } else {

            int confirmar = JOptionPane.showConfirmDialog(null, "??Desea modificar los datos?");
            if (confirmar == JOptionPane.YES_OPTION) {

                String strSentenciaInsert = String.format("UPDATE Proveedores SET Nombre='%s',Direccion='%s', Correo='%s', Telefono='%s' WHERE NIT=%s ", oProveedor.getNombre(), oProveedor.getDireccion(), oProveedor.getCorreo(), oProveedor.getTelefono(), oProveedor.getNIt());

                objConexion.ejecutarSentenciaSQL(strSentenciaInsert);
                System.out.println(objConexion.ejecutarSentenciaSQL(strSentenciaInsert));
                JOptionPane.showMessageDialog(null, "Datos modificados con exito");
                mostrardatos();
                limpiar();

                BloqInicio();
            }
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        limpiar();
        bloquear();
        BloqInicio();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        limpiar();
        desbloquear();
        BloqBotonNuevo();
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        Frame listaProveedor = JOptionPane.getFrameForComponent(this);
        Fmr_ListadoProveedores abrir = new Fmr_ListadoProveedores(listaProveedor, true);
        abrir.setVisible(true);
        desbloquear();
        BloqBotonBuscar();
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void txt_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonoKeyTyped
        char carac = evt.getKeyChar();
        if ((carac < '0' || carac > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_telefonoKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LogoCRUD;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_eliminar;
    public static javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_lista1;
    public static javax.swing.JButton btn_modificar;
    public static javax.swing.JButton btn_nuevo;
    private javax.swing.JDesktopPane jDP_RProveedor;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jP_Botones;
    private javax.swing.JPanel jP_Datos;
    private javax.swing.JPanel jP_Listado;
    public static javax.swing.JTextField txt_correo;
    public static javax.swing.JTextField txt_direccion;
    public static javax.swing.JTextField txt_nit;
    public static javax.swing.JTextField txt_nombre;
    public static javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}