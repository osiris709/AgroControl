package Formularios;

import Clases.ComunicationPopUp;
import Conexion.conexion;
import Formularios_emergentes.Fmr_ListadoCosechas;
import Formularios_emergentes.Fmr_TipoCosecha;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class RegistrarCosecha  extends javax.swing.JInternalFrame implements ComunicationPopUp   {

    conexion objConexion = new conexion();
    Connection con = objConexion.conexion();

    DateFormat df = DateFormat.getDateInstance();

    public RegistrarCosecha() {
        initComponents();

        this.setTitle("AgroControl - Control Cosechas");
        setResizable(false);
        Bloquear();
        LlamarComboBox();
    }
    
    @Override
    public void updateBD(){
        LlamarComboBox();
    }

    public void Guardar() {
        // Si hay algun campo vacio, genera mensaje de advertencia
        if (txt_IdCosecha.getText().equals("") || txt_NombreCosecha.getText().equals("") || (cbo_TipoCultivo.getSelectedItem().equals("Seleccionar"))
                || (cbo_TipoCosecha.getSelectedItem().equals("Seleccionar")) || txt_FechaSiembra.getDate().equals("") || txt_FechaRecoleccion.getDate().equals("")) {

            javax.swing.JOptionPane.showMessageDialog(this, "Obligatorio llenar todos los campos \n", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_IdCosecha.requestFocus();
        } else {
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea Guardar los datos?");
            if (confirmar == JOptionPane.YES_OPTION) {
                // Guardar datos en la base de datos
                try {
                    // Definir Sentencia en base de Datos SQL
                    PreparedStatement guardar = con.prepareStatement("INSERT INTO Cosecha (IdCosecha,Nombre_Cosecha,Tipo_Cultivo,Tipo_Cosecha,Fecha_Siembra,Fecha_Recoleccion) VALUES (?,?,?,?,?,?)");
                    guardar.setString(1, txt_IdCosecha.getText());
                    guardar.setString(2, txt_NombreCosecha.getText());
                    guardar.setString(3, cbo_TipoCultivo.getSelectedItem().toString());
                    guardar.setString(4, cbo_TipoCosecha.getSelectedItem().toString());
                    guardar.setString(5, df.format(txt_FechaSiembra.getDate()));
                    guardar.setString(6, df.format(txt_FechaRecoleccion.getDate()));

                    // Ejecuta la sentencia y obtiene el resultado
                    guardar.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Cosecha Registrada exitosamente");
                    Bloquear();
                    guardar.close();
                    Limpiar();

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, e + "Error, No se registro la Cosecha");
                }
            }
        }
    }

    public void Modificar(String IdCosecha, String Nombre_Cosecha, String Tipo_Cultivo, String Tipo_Cosecha, Date Fecha_Siembra, Date Fecha_Recoleccion) {
        // Si hay algun campo vacio, genera mensaje de advertencia
        if (txt_IdCosecha.getText().equals("") || txt_NombreCosecha.getText().equals("") || (cbo_TipoCultivo.getSelectedItem().equals("Seleccionar"))
                || (cbo_TipoCosecha.getSelectedItem().equals("Seleccionar")) || txt_FechaSiembra.getDate().equals("") || txt_FechaRecoleccion.getDate().equals("")) {

            javax.swing.JOptionPane.showMessageDialog(this, "Obligatorio llenar todos los campos \n", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_IdCosecha.requestFocus();
        } else {
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea Modificar los datos?");
            if (confirmar == JOptionPane.YES_OPTION) {
                // Guardar datos en la base de datos
                try {
                    // Definir Sentencia en base de Datos SQL
                    PreparedStatement modificar = con.prepareStatement("UPDATE Cosecha SET Nombre_Cosecha=?,Tipo_Cultivo=?,Tipo_Cosecha=?,Fecha_Siembra=?,Fecha_Recoleccion=? WHERE IdCosecha=?");
                    modificar.setString(1, txt_NombreCosecha.getText());
                    modificar.setString(2, cbo_TipoCultivo.getSelectedItem().toString());
                    modificar.setString(3, cbo_TipoCosecha.getSelectedItem().toString());
                    modificar.setString(4, df.format(txt_FechaSiembra.getDate()));
                    modificar.setString(5, df.format(txt_FechaRecoleccion.getDate()));
                    modificar.setString(6, txt_IdCosecha.getText());

                    // Ejecuta la sentencia y obtiene el resultado modificado
                    modificar.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Cosecha Modificada exitosamente");
                    Bloquear();
                    modificar.close();

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, e + "Error, No se Modifico la Cosecha");
                }
            }
        }
    }

    public void Eliminar(String IdCosecha) {
        // Si hay algun campo vacio, genera mensaje de advertencia
        if (txt_IdCosecha.getText().equals("") || txt_NombreCosecha.getText().equals("") || (cbo_TipoCultivo.getSelectedItem().equals("Seleccionar"))
                || (cbo_TipoCosecha.getSelectedItem().equals("Seleccionar")) || txt_FechaSiembra.getDate().equals("") || txt_FechaRecoleccion.getDate().equals("")) {

            javax.swing.JOptionPane.showMessageDialog(this, "Debe Seleccionar algun campo \n", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_IdCosecha.requestFocus();
        } else {
            // Eliminar datos en la base de datos
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Seguro que desea ELIMINAR los datos?");
            if (confirmar == JOptionPane.YES_OPTION) {
                try {
                    // Definir Sentencia en base de Datos SQL
                    PreparedStatement eliminar = con.prepareStatement("DELETE FROM Cosecha WHERE IdCosecha=?");
                    eliminar.setString(1, txt_IdCosecha.getText());

                    // Ejecuta la sentencia y obtiene el resultado de eliminar
                    eliminar.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Cosecha Eliminada exitosamente");
                    Limpiar();
                    eliminar.close();

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, e + "Error, No se elimino la Cosecha");
                }
            }
        }
    }

    public void Desbloquear() {

        this.txt_IdCosecha.setEnabled(true);
        this.txt_NombreCosecha.setEnabled(true);
        this.cbo_TipoCultivo.setEnabled(true);
        this.cbo_TipoCosecha.setEnabled(true);
        this.txt_FechaSiembra.setEnabled(true);
        this.txt_FechaRecoleccion.setEnabled(true);
        txt_IdCosecha.requestFocus();
    }

    public void Bloquear() {

        this.txt_IdCosecha.setEnabled(false);
        this.txt_NombreCosecha.setEnabled(false);
        this.cbo_TipoCultivo.setEnabled(false);
        this.cbo_TipoCosecha.setEnabled(false);
        this.txt_FechaSiembra.setEnabled(false);
        this.txt_FechaRecoleccion.setEnabled(false);
        txt_IdCosecha.requestFocus();
    }

    public void Limpiar() {

        txt_IdCosecha.setText("");
        txt_NombreCosecha.setText("");
        cbo_TipoCultivo.setSelectedIndex(0);
        cbo_TipoCosecha.setSelectedIndex(0);
        txt_IdCosecha.requestFocus();
        txt_FechaSiembra.setDate(null);
        txt_FechaRecoleccion.setDate(null);
    }

    public void LlamarComboBox() {

        try {

            cbo_TipoCosecha.removeAllItems();
            cbo_TipoCosecha.addItem("Seleccionar");
            String consulta = "SELECT Nombre_TipoCosecha FROM Tipo_Cosecha ORDER BY Nombre_TipoCosecha ASC";
            PreparedStatement leer = con.prepareStatement(consulta);
            ResultSet resultado = leer.executeQuery();

            while (resultado.next()) {
                cbo_TipoCosecha.addItem(resultado.getString("Nombre_TipoCosecha"));
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e + "Error");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon1 = new ImageIcon(getClass().getResource("/Imagenes/fondo-submenu4.jpg"));
        Image image1 = icon1.getImage();
        jDP_RCosecha = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image1,0,0,getWidth(),getHeight(),this);
            }
        }
        ;
        LogoCRUD = new javax.swing.JLabel();
        jP_Datos = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        txt_FechaSiembra = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        txt_FechaRecoleccion = new com.toedter.calendar.JDateChooser();
        cbo_TipoCosecha = new javax.swing.JComboBox<>();
        btn_TipoCosecha = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbo_TipoCultivo = new javax.swing.JComboBox<>();
        txt_IdCosecha = new javax.swing.JTextField();
        txt_NombreCosecha = new javax.swing.JTextField();
        jP_Listado = new javax.swing.JPanel();
        btn_lista1 = new javax.swing.JButton();
        jP_Botones = new javax.swing.JPanel();
        btn_nuevo = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_elminar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Control Cosechas");
        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jDP_RCosecha.setBackground(new java.awt.Color(255, 255, 255));
        jDP_RCosecha.setForeground(new java.awt.Color(255, 255, 255));

        LogoCRUD.setBackground(new java.awt.Color(255, 255, 255));
        LogoCRUD.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        LogoCRUD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoCRUD2.png"))); // NOI18N

        jP_Datos.setBackground(new java.awt.Color(240, 255, 240));
        jP_Datos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jP_Datos.setPreferredSize(new java.awt.Dimension(730, 345));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("ID Cosecha:");
        jLabel12.setPreferredSize(new java.awt.Dimension(72, 23));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Nombre:");
        jLabel5.setPreferredSize(new java.awt.Dimension(51, 23));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Fecha de Siembra:");
        jLabel6.setPreferredSize(new java.awt.Dimension(110, 23));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Tipo cosecha:");
        jLabel9.setPreferredSize(new java.awt.Dimension(82, 23));

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        txt_FechaSiembra.setDateFormatString("dd/MM/yyyy");
        txt_FechaSiembra.setMinimumSize(new java.awt.Dimension(27, 23));
        txt_FechaSiembra.setPreferredSize(new java.awt.Dimension(80, 23));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Fecha de Recoleccion:");
        jLabel13.setPreferredSize(new java.awt.Dimension(132, 23));

        txt_FechaRecoleccion.setDateFormatString("dd/MM/yyyy");
        txt_FechaRecoleccion.setMinimumSize(new java.awt.Dimension(27, 23));
        txt_FechaRecoleccion.setPreferredSize(new java.awt.Dimension(80, 23));

        cbo_TipoCosecha.setEditable(true);
        cbo_TipoCosecha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        cbo_TipoCosecha.setMinimumSize(new java.awt.Dimension(98, 23));
        cbo_TipoCosecha.setPreferredSize(new java.awt.Dimension(79, 23));

        btn_TipoCosecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo2.png"))); // NOI18N
        btn_TipoCosecha.setText("Crear tipo Cosecha");
        btn_TipoCosecha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_TipoCosecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TipoCosechaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Tipo de Cultivo:");
        jLabel7.setPreferredSize(new java.awt.Dimension(96, 23));

        cbo_TipoCultivo.setEditable(true);
        cbo_TipoCultivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        cbo_TipoCultivo.setMinimumSize(new java.awt.Dimension(98, 23));
        cbo_TipoCultivo.setPreferredSize(new java.awt.Dimension(83, 23));

        txt_IdCosecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_IdCosechaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jP_DatosLayout = new javax.swing.GroupLayout(jP_Datos);
        jP_Datos.setLayout(jP_DatosLayout);
        jP_DatosLayout.setHorizontalGroup(
            jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_DatosLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jP_DatosLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_FechaRecoleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jP_DatosLayout.createSequentialGroup()
                        .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(78, 78, 78)
                        .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jP_DatosLayout.createSequentialGroup()
                                .addComponent(txt_IdCosecha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_NombreCosecha, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jP_DatosLayout.createSequentialGroup()
                        .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jP_DatosLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(txt_FechaSiembra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jP_DatosLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(cbo_TipoCultivo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jP_DatosLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(cbo_TipoCosecha, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_DatosLayout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addComponent(btn_TipoCosecha, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jP_DatosLayout.setVerticalGroup(
            jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_DatosLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_IdCosecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_NombreCosecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jP_DatosLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbo_TipoCultivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_TipoCosecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38)
                .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_FechaSiembra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_TipoCosecha, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_FechaRecoleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jP_Listado.setBackground(new java.awt.Color(240, 255, 240));
        jP_Listado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jP_Listado.setPreferredSize(new java.awt.Dimension(730, 52));

        btn_lista1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lista.png"))); // NOI18N
        btn_lista1.setText("Mostrar listado de los Cosechas");
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_ListadoLayout.createSequentialGroup()
                .addContainerGap(277, Short.MAX_VALUE)
                .addComponent(btn_lista1)
                .addGap(272, 272, 272))
        );
        jP_ListadoLayout.setVerticalGroup(
            jP_ListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_ListadoLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(btn_lista1)
                .addContainerGap())
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

        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar2.png"))); // NOI18N
        btn_editar.setText("Modificar");
        btn_editar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
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

        btn_elminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar2.png"))); // NOI18N
        btn_elminar.setText("Eliminar");
        btn_elminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_elminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_elminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jP_BotonesLayout = new javax.swing.GroupLayout(jP_Botones);
        jP_Botones.setLayout(jP_BotonesLayout);
        jP_BotonesLayout.setHorizontalGroup(
            jP_BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_BotonesLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btn_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btn_elminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jP_BotonesLayout.setVerticalGroup(
            jP_BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_BotonesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jP_BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_elminar)
                    .addComponent(btn_editar)
                    .addComponent(btn_guardar)
                    .addComponent(btn_nuevo)
                    .addComponent(btn_cancelar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jDP_RCosecha.setLayer(LogoCRUD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDP_RCosecha.setLayer(jP_Datos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDP_RCosecha.setLayer(jP_Listado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDP_RCosecha.setLayer(jP_Botones, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDP_RCosechaLayout = new javax.swing.GroupLayout(jDP_RCosecha);
        jDP_RCosecha.setLayout(jDP_RCosechaLayout);
        jDP_RCosechaLayout.setHorizontalGroup(
            jDP_RCosechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDP_RCosechaLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jDP_RCosechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jP_Botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jP_Listado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LogoCRUD)
                    .addComponent(jP_Datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jDP_RCosechaLayout.setVerticalGroup(
            jDP_RCosechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDP_RCosechaLayout.createSequentialGroup()
                .addComponent(LogoCRUD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jP_Datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jP_Listado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jP_Botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDP_RCosecha, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDP_RCosecha)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TipoCosechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TipoCosechaActionPerformed
        Fmr_TipoCosecha TipoCosecha = new Fmr_TipoCosecha();
        TipoCosecha.setComu(this);
        TipoCosecha.setVisible(true);
        TipoCosecha.toFront();
//        TipoCosecha.setAlwaysOnTop(true);
    }//GEN-LAST:event_btn_TipoCosechaActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        Guardar();
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_lista1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lista1ActionPerformed
        Fmr_ListadoCosechas Cosecha = new Fmr_ListadoCosechas();
        Cosecha.setVisible(true);
        Cosecha.toFront();
        Cosecha.setAlwaysOnTop(true);
        Cosecha.TablaCosechas.setEnabled(false);
    }//GEN-LAST:event_btn_lista1ActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        Modificar(txt_IdCosecha.getText(), txt_NombreCosecha.getText(), cbo_TipoCultivo.getSelectedItem().toString(), cbo_TipoCosecha.getSelectedItem().toString(), txt_FechaSiembra.getDate(), txt_FechaRecoleccion.getDate());
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        Desbloquear();
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        Fmr_ListadoCosechas Cosecha = new Fmr_ListadoCosechas();
        Cosecha.setVisible(true);
        Cosecha.toFront();
        Cosecha.setAlwaysOnTop(true);
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        Limpiar();
        Bloquear();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void txt_IdCosechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_IdCosechaKeyTyped
        /*char carac = evt.getKeyChar();
        if ((carac < '0' || carac > '9')) {
            evt.consume();
        }*/
    }//GEN-LAST:event_txt_IdCosechaKeyTyped

    private void btn_elminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elminarActionPerformed
        Eliminar(txt_IdCosecha.getText());
    }//GEN-LAST:event_btn_elminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LogoCRUD;
    private javax.swing.JButton btn_TipoCosecha;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_elminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_lista1;
    private javax.swing.JButton btn_nuevo;
    public static javax.swing.JComboBox<String> cbo_TipoCosecha;
    public static javax.swing.JComboBox<String> cbo_TipoCultivo;
    private javax.swing.JDesktopPane jDP_RCosecha;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jP_Botones;
    private javax.swing.JPanel jP_Datos;
    private javax.swing.JPanel jP_Listado;
    public static com.toedter.calendar.JDateChooser txt_FechaRecoleccion;
    public static com.toedter.calendar.JDateChooser txt_FechaSiembra;
    public static javax.swing.JTextField txt_IdCosecha;
    public static javax.swing.JTextField txt_NombreCosecha;
    // End of variables declaration//GEN-END:variables

}
