package Formularios;

import Clases.Proveedor;
import Conexion.conexion;
import Formularios_emergentes.Fmr_Proveedores;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
        this.setTitle("AgroControl - Registro Proveedores");
        
        
        Proveedor pro = new Proveedor("9.146.779-1","samuel","los patios","momail@hmail.com","3212652244");
        
    }

    public  void bloquear() {
        

        this.txt_direccion.setEnabled(false);
        this.txt_correo.setEnabled(false);
        this.txt_telefono.setEnabled(false);
        this.txt_nit.setEnabled(false);
        this.txt_nombre.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
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
        jPanel4 = new javax.swing.JPanel();
        btn_lista1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btn_guardar2 = new javax.swing.JButton();
        btn_editar2 = new javax.swing.JButton();
        btn_eliminar2 = new javax.swing.JButton();
        btn_cancelar2 = new javax.swing.JButton();
        btn_nuevo1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registrar Proveedores");
        setAutoscrolls(true);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoCRUD.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(240, 255, 240));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setMaximumSize(new java.awt.Dimension(700, 300));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 300));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_nit, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_nit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        jPanel4.setBackground(new java.awt.Color(240, 255, 240));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_lista1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lista.png"))); // NOI18N
        btn_lista1.setText("Mostrar listado de los Proveedores");
        btn_lista1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_lista1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lista1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(btn_lista1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_lista1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(240, 255, 240));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_guardar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar2.png"))); // NOI18N
        btn_guardar2.setText("Guardar");
        btn_guardar2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_guardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar2ActionPerformed(evt);
            }
        });

        btn_editar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar2.png"))); // NOI18N
        btn_editar2.setText("Editar");
        btn_editar2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_editar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editar2ActionPerformed(evt);
            }
        });

        btn_eliminar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar2.png"))); // NOI18N
        btn_eliminar2.setText("Eliminar");
        btn_eliminar2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_eliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar2ActionPerformed(evt);
            }
        });

        btn_cancelar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/desactivar.png"))); // NOI18N
        btn_cancelar2.setText("Cancelar");
        btn_cancelar2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_cancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelar2ActionPerformed(evt);
            }
        });

        btn_nuevo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo2.png"))); // NOI18N
        btn_nuevo1.setText("Nuevo");
        btn_nuevo1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_nuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btn_nuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btn_guardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btn_editar2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btn_cancelar2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btn_eliminar2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_eliminar2)
                    .addComponent(btn_editar2)
                    .addComponent(btn_guardar2)
                    .addComponent(btn_cancelar2)
                    .addComponent(btn_nuevo1))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(13, 13, 13)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_lista1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lista1ActionPerformed
        Fmr_Proveedores abrir = new Fmr_Proveedores();
        abrir.setVisible(true);
        abrir.txtBuscar.setEnabled(false);
    }//GEN-LAST:event_btn_lista1ActionPerformed

    private void btn_guardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar2ActionPerformed

        conexion objConexion = new conexion();
        Connection con = objConexion.conexion();

        Proveedor oProveedor = recuperarDatosGUI();
        if (txt_nit.getText().equals("") || txt_nombre.getText().equals("") || (txt_direccion.getText().equals(""))
                || (txt_correo.getText().equals("")) || txt_telefono.getText().equals("")) {

            javax.swing.JOptionPane.showMessageDialog(this, "Obligatorio llenar todos los campos \n", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_nit.requestFocus();
        } else {
            String strSentenciaInsert = String.format("INSERT INTO proveedores (Nit,Nombre,Direccion,Correo,Telefono) "
                    + "VALUES ('%s','%s','%s','%s','%s')", oProveedor.getNIt(), oProveedor.getNombre(), oProveedor.getDireccion(), oProveedor.getCorreo(), oProveedor.getTelefono());

            objConexion.ejecutarSentenciaSQL(strSentenciaInsert);
            mostrardatos();
            limpiar();
            bloquear();
        }
    }//GEN-LAST:event_btn_guardar2ActionPerformed

    private void btn_eliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar2ActionPerformed

        conexion objConexion = new conexion();
        Connection con = objConexion.conexion();

        Proveedor oProveedor = recuperarDatosGUI();
        if (txt_nit.getText().equals("") || txt_nombre.getText().equals("") || (txt_direccion.getText().equals(""))
                || (txt_correo.getText().equals("")) || txt_telefono.getText().equals("")) {

            javax.swing.JOptionPane.showMessageDialog(this, "Obligatorio llenar todos los campos \n", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_nit.requestFocus();
        } else {
            String strSentenciaInsert = String.format("DELETE FROM proveedores WHERE Nit=%s ", oProveedor.getNIt());

            objConexion.ejecutarSentenciaSQL(strSentenciaInsert);
            mostrardatos();
            limpiar();
        }
    }//GEN-LAST:event_btn_eliminar2ActionPerformed

    private void btn_editar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editar2ActionPerformed

        conexion objConexion = new conexion();
        Connection con = objConexion.conexion();

        Proveedor oProveedor = recuperarDatosGUI();
        if (txt_nit.getText().equals("") || txt_nombre.getText().equals("") || (txt_direccion.getText().equals(""))
                || (txt_correo.getText().equals("")) || txt_telefono.getText().equals("")) {

            javax.swing.JOptionPane.showMessageDialog(this, "Obligatorio llenar todos los campos \n", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_nit.requestFocus();
        } else {

            int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea modificar los datos?");
            if (confirmar == JOptionPane.YES_OPTION) {

                String strSentenciaInsert = String.format("UPDATE Proveedores SET Nombre='%s',Direccion='%s', Correo='%s', Telefono='%s' WHERE NIT=%s ", oProveedor.getNombre(), oProveedor.getDireccion(), oProveedor.getCorreo(), oProveedor.getTelefono(), oProveedor.getNIt());

                objConexion.ejecutarSentenciaSQL(strSentenciaInsert);
                System.out.println(objConexion.ejecutarSentenciaSQL(strSentenciaInsert));
                JOptionPane.showMessageDialog(null, "Datos modificados con exito");
                mostrardatos();
                limpiar();

                btn_nuevo1.setEnabled(true);
                btn_guardar2.setEnabled(true);
                btn_eliminar2.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btn_editar2ActionPerformed

    private void btn_cancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelar2ActionPerformed
        limpiar();
        this.txt_direccion.setEnabled(false);
        this.txt_correo.setEnabled(false);
        this.txt_telefono.setEnabled(false);
        this.txt_nit.setEnabled(false);
        this.txt_nombre.setEnabled(false);
    }//GEN-LAST:event_btn_cancelar2ActionPerformed

    private void btn_nuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevo1ActionPerformed
        txt_nit.setText("");
        txt_nombre.setText("");
        txt_direccion.setText("");
        txt_correo.setText("");
        txt_telefono.setText("");
        desbloquear();
    }//GEN-LAST:event_btn_nuevo1ActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        Fmr_Proveedores abrir = new Fmr_Proveedores();
        abrir.setVisible(true);
        desbloquear();
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void txt_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonoKeyTyped
        char carac = evt.getKeyChar();
        if ((carac < '0' || carac > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_telefonoKeyTyped

    public void mostrardatos() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        conexion objConexion = new conexion();
        Connection con = objConexion.conexion();
        try {
            ResultSet resultado = objConexion.consultarRegistro("SELECT * FROM proveedores");
            while (resultado.next()) {
                /*System.out.println(resultado.getString("Nit"));
                System.out.println(resultado.getString("Nombre"));
                System.out.println(resultado.getString("Direccion"));
                System.out.println(resultado.getString("Correo"));
                System.out.println(resultado.getString("Telefono"));*/

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

        btn_nuevo1.setEnabled(true);
        btn_guardar2.setEnabled(true);
        btn_editar2.setEnabled(false);
        btn_eliminar2.setEnabled(true);
    }

    public void desbloquear() {
        this.txt_direccion.setEnabled(true);
        this.txt_correo.setEnabled(true);
        this.txt_telefono.setEnabled(true);
        this.txt_nit.setEnabled(true);
        this.txt_nombre.setEnabled(true);
    }

    public void editar(String editar) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar2;
    public static javax.swing.JButton btn_editar2;
    private javax.swing.JButton btn_eliminar2;
    public static javax.swing.JButton btn_guardar2;
    private javax.swing.JButton btn_lista1;
    public static javax.swing.JButton btn_nuevo1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    public static javax.swing.JTextField txt_correo;
    public static javax.swing.JTextField txt_direccion;
    public static javax.swing.JTextField txt_nit;
    public static javax.swing.JTextField txt_nombre;
    public static javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables

}
