package Formularios;

import Conexion.conexion;
import Formularios_emergentes.Fmr_ListaCosechas;
import Formularios_emergentes.Fmr_TipoCosecha;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Control_Cosecha extends javax.swing.JInternalFrame {

    conexion objConexion = new conexion();
    Connection con = objConexion.conexion();

    DateFormat df = DateFormat.getDateInstance();

    public Control_Cosecha() {
        initComponents();

        this.setTitle("AgroControl - Control Cosechas");
        setResizable(false);
        Bloquear();
    }

    public void Guardar() {
        // Si hay algun campo vacio, genera error
        if (txt_IdCosecha.getText().equals("") || txt_NombreCosecha.getText().equals("") || (cbo_TipoCultivo.getSelectedItem().equals("Seleccionar"))
                || (cbo_TipoCosecha.getSelectedItem().equals("Seleccionar")) || txt_FechaSiembra.getDate().equals("") || txt_FechaRecoleccion.getDate().equals("")) {

            javax.swing.JOptionPane.showMessageDialog(this, "Obligatorio llenar todos los campos \n", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_IdCosecha.requestFocus();
        } else {
            // Guardar datos en la base de datos
            try {
                PreparedStatement guardar = con.prepareStatement("INSERT INTO Cosecha (IdCosecha,Nombre_Cosecha,Tipo_Cultivo,Tipo_Cosecha,Fecha_Siembra,Fecha_Recoleccion) VALUES (?,?,?,?,?,?)");
                guardar.setString(1, txt_IdCosecha.getText());
                guardar.setString(2, txt_NombreCosecha.getText());
                guardar.setString(3, cbo_TipoCultivo.getSelectedItem().toString());
                guardar.setString(4, cbo_TipoCosecha.getSelectedItem().toString());
                guardar.setString(5, df.format(txt_FechaSiembra.getDate()));
                guardar.setString(6, df.format(txt_FechaRecoleccion.getDate()));

                guardar.executeUpdate();

                JOptionPane.showMessageDialog(null, "Cosecha Registrada exitosamente");
                Bloquear();
                guardar.close();

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e + "Error, No se registro la Cosecha");
            }
        }
    }

    public void Modificar(String IdCosecha) {
        if (txt_IdCosecha.getText().equals("") || txt_NombreCosecha.getText().equals("") || (cbo_TipoCultivo.getSelectedItem().equals("Seleccionar"))
                || (cbo_TipoCosecha.getSelectedItem().equals("Seleccionar")) || txt_FechaSiembra.getDate().equals("") || txt_FechaRecoleccion.getDate().equals("")) {

            javax.swing.JOptionPane.showMessageDialog(this, "Obligatorio llenar todos los campos \n", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_IdCosecha.requestFocus();
        } else {
            try {
                PreparedStatement guardar = con.prepareStatement("UPDATE Cosecha SET IdCosecha=?,Nombre_Cosecha=?,Tipo_Cultivo=?,Tipo_Cosecha=?,Fecha_Siembra=?,Fecha_Recoleccion=? WHERE IdCosecha=?");
                guardar.setString(1, txt_IdCosecha.getText());
                guardar.setString(2, txt_NombreCosecha.getText());
                guardar.setString(3, cbo_TipoCultivo.getSelectedItem().toString());
                guardar.setString(4, cbo_TipoCosecha.getSelectedItem().toString());
                guardar.setString(5, df.format(txt_FechaSiembra.getDate()));
                guardar.setString(6, df.format(txt_FechaRecoleccion.getDate()));

                guardar.executeUpdate();

                JOptionPane.showMessageDialog(null, "Cosecha Registrada exitosamente");
                Bloquear();
                guardar.close();

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e + "Error, No se registro la Cosecha");
            }
        }
    }

    public void Eliminar(String IdCosecha) {
        if (txt_IdCosecha.getText().equals("") || txt_NombreCosecha.getText().equals("") || (cbo_TipoCultivo.getSelectedItem().equals("Seleccionar"))
                || (cbo_TipoCosecha.getSelectedItem().equals("Seleccionar")) || txt_FechaSiembra.getDate().equals("") || txt_FechaRecoleccion.getDate().equals("")) {

            javax.swing.JOptionPane.showMessageDialog(this, "Debe Seleccionar algun campo \n", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_IdCosecha.requestFocus();
        } else {
        // Eliminar datos en la base de datos
        try {
            PreparedStatement guardar = con.prepareStatement("DELETE FROM Cosecha WHERE IdCosecha=?");
            guardar.setString(1, txt_IdCosecha.getText());
            guardar.setString(2, txt_NombreCosecha.getText());
            guardar.setString(3, cbo_TipoCultivo.getSelectedItem().toString());
            guardar.setString(4, cbo_TipoCosecha.getSelectedItem().toString());
            guardar.setString(5, df.format(txt_FechaSiembra.getDate()));
            guardar.setString(6, df.format(txt_FechaRecoleccion.getDate()));
            
            guardar.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cosecha Registrada exitosamente");
            Bloquear();
            guardar.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e + "Error, No se registro la Cosecha");
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon1 = new ImageIcon(getClass().getResource("/Imagenes/fondo-submenu4.jpg"));
        Image image1 = icon1.getImage();
        jd_Cosecha = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image1,0,0,getWidth(),getHeight(),this);
            }
        }
        ;
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txt_FechaSiembra = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        txt_FechaRecoleccion = new com.toedter.calendar.JDateChooser();
        cbo_TipoCosecha = new javax.swing.JComboBox<>();
        btn_TipoCosecha = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbo_TipoCultivo = new javax.swing.JComboBox<>();
        txt_IdCosecha = new javax.swing.JTextField();
        txt_NombreCosecha = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btn_lista1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btn_nuevo1 = new javax.swing.JButton();
        btn_guardar1 = new javax.swing.JButton();
        btn_editar1 = new javax.swing.JButton();
        btn_elminar1 = new javax.swing.JButton();
        btn_cancelar1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Control Cosechas");
        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jd_Cosecha.setBackground(new java.awt.Color(255, 255, 255));
        jd_Cosecha.setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(240, 255, 240));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(730, 345));

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

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("ID Cosecha:");
        jLabel12.setPreferredSize(new java.awt.Dimension(72, 23));

        txt_FechaSiembra.setMinimumSize(new java.awt.Dimension(27, 23));
        txt_FechaSiembra.setPreferredSize(new java.awt.Dimension(80, 23));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Fecha de Recoleccion:");
        jLabel13.setPreferredSize(new java.awt.Dimension(132, 23));

        txt_FechaRecoleccion.setMinimumSize(new java.awt.Dimension(27, 23));
        txt_FechaRecoleccion.setPreferredSize(new java.awt.Dimension(80, 23));

        cbo_TipoCosecha.setEditable(true);
        cbo_TipoCosecha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Tomate" }));
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
        cbo_TipoCultivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Transitorio", "Permanente" }));
        cbo_TipoCultivo.setMinimumSize(new java.awt.Dimension(98, 23));
        cbo_TipoCultivo.setPreferredSize(new java.awt.Dimension(83, 23));

        txt_IdCosecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_IdCosechaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(cbo_TipoCultivo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(cbo_TipoCosecha, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(txt_FechaSiembra, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(152, 152, 152)
                        .addComponent(btn_TipoCosecha, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_FechaRecoleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_IdCosecha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_NombreCosecha, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_IdCosecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_NombreCosecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbo_TipoCultivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_TipoCosecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_FechaSiembra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_TipoCosecha, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_FechaRecoleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoCRUD2.png"))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(240, 255, 240));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setPreferredSize(new java.awt.Dimension(730, 52));

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
                .addContainerGap(264, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_lista1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(240, 255, 240));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_nuevo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo2.png"))); // NOI18N
        btn_nuevo1.setText("Nuevo");
        btn_nuevo1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_nuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevo1ActionPerformed(evt);
            }
        });

        btn_guardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar2.png"))); // NOI18N
        btn_guardar1.setText("Guardar");
        btn_guardar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_guardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar1ActionPerformed(evt);
            }
        });

        btn_editar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar2.png"))); // NOI18N
        btn_editar1.setText("Editar");
        btn_editar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_editar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editar1ActionPerformed(evt);
            }
        });

        btn_elminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar2.png"))); // NOI18N
        btn_elminar1.setText("Eliminar");
        btn_elminar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_cancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/desactivar.png"))); // NOI18N
        btn_cancelar1.setText("Cancelar");
        btn_cancelar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_cancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btn_nuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btn_guardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btn_editar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btn_cancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btn_elminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_elminar1)
                    .addComponent(btn_editar1)
                    .addComponent(btn_guardar1)
                    .addComponent(btn_nuevo1)
                    .addComponent(btn_cancelar1))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jd_Cosecha.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jd_Cosecha.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jd_Cosecha.setLayer(jPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jd_Cosecha.setLayer(jPanel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jd_CosechaLayout = new javax.swing.GroupLayout(jd_Cosecha);
        jd_Cosecha.setLayout(jd_CosechaLayout);
        jd_CosechaLayout.setHorizontalGroup(
            jd_CosechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_CosechaLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jd_CosechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jd_CosechaLayout.setVerticalGroup(
            jd_CosechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_CosechaLayout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jd_Cosecha, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jd_Cosecha)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TipoCosechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TipoCosechaActionPerformed
        Fmr_TipoCosecha TipoCosecha = new Fmr_TipoCosecha();
        TipoCosecha.setVisible(true);
        TipoCosecha.toFront();
        TipoCosecha.setAlwaysOnTop(true);
    }//GEN-LAST:event_btn_TipoCosechaActionPerformed

    private void btn_guardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar1ActionPerformed
        Guardar();
    }//GEN-LAST:event_btn_guardar1ActionPerformed


    private void btn_lista1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lista1ActionPerformed
        Fmr_ListaCosechas Cosecha = new Fmr_ListaCosechas();
        Cosecha.setVisible(true);
        Cosecha.toFront();
        Cosecha.setAlwaysOnTop(true);
    }//GEN-LAST:event_btn_lista1ActionPerformed

    private void btn_editar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editar1ActionPerformed
        Desbloquear();
    }//GEN-LAST:event_btn_editar1ActionPerformed

    private void btn_nuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevo1ActionPerformed
        Limpiar();
        Desbloquear();
    }//GEN-LAST:event_btn_nuevo1ActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        Fmr_ListaCosechas Cosecha = new Fmr_ListaCosechas();
        Cosecha.setVisible(true);
        Cosecha.toFront();
//        Cosecha.setAlwaysOnTop(true);
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelar1ActionPerformed
        Limpiar();
        Bloquear();
    }//GEN-LAST:event_btn_cancelar1ActionPerformed

    private void txt_IdCosechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_IdCosechaKeyTyped
        /*char carac = evt.getKeyChar();
        if ((carac < '0' || carac > '9')) {
            evt.consume();
        }*/
    }//GEN-LAST:event_txt_IdCosechaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_TipoCosecha;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar1;
    private javax.swing.JButton btn_editar1;
    private javax.swing.JButton btn_elminar1;
    private javax.swing.JButton btn_guardar1;
    private javax.swing.JButton btn_lista1;
    private javax.swing.JButton btn_nuevo1;
    public static javax.swing.JComboBox<String> cbo_TipoCosecha;
    public static javax.swing.JComboBox<String> cbo_TipoCultivo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JDesktopPane jd_Cosecha;
    public static com.toedter.calendar.JDateChooser txt_FechaRecoleccion;
    public static com.toedter.calendar.JDateChooser txt_FechaSiembra;
    public static javax.swing.JTextField txt_IdCosecha;
    public static javax.swing.JTextField txt_NombreCosecha;
    // End of variables declaration//GEN-END:variables

}
