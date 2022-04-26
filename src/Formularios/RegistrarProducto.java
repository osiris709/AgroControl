package Formularios;

import Conexion.conexion;
import Formularios_emergentes.Fmr_CrearTipodeProducto;
import Formularios_emergentes.Fmr_CrearUnidadMedida;
import Formularios_emergentes.Fmr_ListadoProductos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.awt.Frame;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;

public final class RegistrarProducto extends javax.swing.JInternalFrame {

    conexion conn = new conexion();
    Connection iniciarConexion = conn.conexion();

    public RegistrarProducto() {
        initComponents();

        LeerDatosComboBoxUnidadMedida();
        LeerDatosComboBoxTipoProducto();
        Bloquear();
        BloqInicio();

        setTitle("AgroControl - Registrar Productos");
        setResizable(false);
    }

        public void BloqInicio() {
        btn_buscar.setEnabled(true);
        btn_crearUnidad.setEnabled(false);
        btn_crearTipoProducto.setEnabled(false);
        btn_nuevo.setEnabled(true);
        btn_guardar.setEnabled(false);
        btn_editar.setEnabled(false);
        btn_cancelar.setEnabled(false);
        btn_eliminar.setEnabled(false);
    }

    public void BloqBotonNuevo() {
        btn_buscar.setEnabled(false);
        btn_crearUnidad.setEnabled(true);
        btn_crearTipoProducto.setEnabled(true);
        btn_nuevo.setEnabled(false);
        btn_guardar.setEnabled(true);
        btn_editar.setEnabled(false);
        btn_cancelar.setEnabled(true);
        btn_eliminar.setEnabled(false);
    }

    public void BloqBotonBuscar(){
        btn_buscar.setEnabled(true);
        btn_crearUnidad.setEnabled(true);
        btn_crearTipoProducto.setEnabled(true);
        btn_nuevo.setEnabled(false);
        btn_guardar.setEnabled(false);
        btn_editar.setEnabled(true);
        btn_cancelar.setEnabled(true);
        btn_eliminar.setEnabled(true);
    }
    
    public void Bloquear() {
        txt_codigoProducto.setEnabled(false);
        txt_nombreProducto.setEnabled(false);
        txt_Ingredienteactivo.setEnabled(false);
        jDate_FechaVencimiento.setEnabled(false);
        txt_descripcionProducto.setEnabled(false);
        cbo_unidadMedida.setEnabled(false);
        cbo_categoria.setEnabled(false);
    }

    public void Desbloquear() {
        txt_codigoProducto.setEnabled(true);
        txt_nombreProducto.setEnabled(true);
        txt_Ingredienteactivo.setEnabled(true);
        jDate_FechaVencimiento.setEnabled(true);
        txt_descripcionProducto.setEnabled(true);
        cbo_unidadMedida.setEnabled(true);
        cbo_categoria.setEnabled(true);
        txt_codigoProducto.requestFocus();
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
            String consulta = "Select UnidaddeMedidaDato from UnimedidaTproducto Order by IDuniMedida";
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
            String consulta = "Select TipodeProducto from TipodeProducto Order by idtipoproducto";
            PreparedStatement leer = iniciarConexion.prepareStatement(consulta);
            ResultSet resultado = leer.executeQuery();

            while (resultado.next()) {
                cbo_categoria.addItem(resultado.getString("TipodeProducto"));
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
                    eliminar.close();
                    borrar();
                    
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
                    PreparedStatement modificar = iniciarConexion.prepareStatement("UPDATE Productos SET Nombre=?,Descripcion=?,IngredienteActivo=?,FechadeVencimiento=?,UnidaddeMedida=?,TipodeProducto =? WHERE codigo=?"); 

                    modificar.setString(1, txt_nombreProducto.getText());
                    modificar.setString(2, txt_descripcionProducto.getText());
                    modificar.setString(3, txt_Ingredienteactivo.getText());
                    modificar.setString(4, ((JTextField) jDate_FechaVencimiento.getDateEditor().getUiComponent()).getText());
                    modificar.setString(5, String.valueOf(cbo_unidadMedida.getSelectedIndex()));
                    modificar.setString(6, String.valueOf(cbo_categoria.getSelectedIndex()));
                    modificar.setString(7, txt_codigoProducto.getText());
                    modificar.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Ventana Productos Modificada Exitosamente");

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

        ImageIcon icon1 = new ImageIcon(getClass().getResource("/Imagenes/fondo-submenu4.jpg"));
        Image image1 = icon1.getImage();
        jDP_RProducto = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image1,0,0,getWidth(),getHeight(),this);
            }
        }
        ;
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
        btn_crearTipoProducto = new javax.swing.JButton();
        btn_crearUnidad = new javax.swing.JButton();
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
        btn_eliminar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_nuevo = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setResizable(true);
        setTitle("Registrar Productos");
        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jDP_RProducto.setBackground(new java.awt.Color(255, 255, 255));
        jDP_RProducto.setForeground(new java.awt.Color(255, 255, 255));

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

        cbo_unidadMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Monoxido" }));

        cbo_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Semillas", "Abonos", "Insectisidas", "Otros" }));

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        btn_crearTipoProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo2.png"))); // NOI18N
        btn_crearTipoProducto.setText("Crear tipo Producto");
        btn_crearTipoProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_crearTipoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crearTipoProductoActionPerformed(evt);
            }
        });

        btn_crearUnidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo2.png"))); // NOI18N
        btn_crearUnidad.setText("Crear Unidad de Medida");
        btn_crearUnidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_crearUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crearUnidadActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Ingrediente Activo:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Fecha de Vencimiento:");

        jDate_FechaVencimiento.setDateFormatString("dd/MM/yyyy\n");

        javax.swing.GroupLayout PanelDatosLayout = new javax.swing.GroupLayout(PanelDatos);
        PanelDatos.setLayout(PanelDatosLayout);
        PanelDatosLayout.setHorizontalGroup(
            PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosLayout.createSequentialGroup()
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jDate_FechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDatosLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(PanelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(84, 84, 84)
                                .addComponent(txt_descripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelDatosLayout.createSequentialGroup()
                                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_crearUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PanelDatosLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(39, 39, 39)
                                        .addComponent(cbo_unidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelDatosLayout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbo_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDatosLayout.createSequentialGroup()
                                        .addGap(157, 157, 157)
                                        .addComponent(btn_crearTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelDatosLayout.createSequentialGroup()
                                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelDatosLayout.createSequentialGroup()
                                        .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel4))
                                        .addGap(35, 35, 35))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDatosLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(107, 107, 107)))
                                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelDatosLayout.createSequentialGroup()
                                        .addComponent(txt_codigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Ingredienteactivo))))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        PanelDatosLayout.setVerticalGroup(
            PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(16, 16, 16)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(21, 21, 21)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel9))
                    .addComponent(txt_Ingredienteactivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jDate_FechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txt_descripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_unidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(cbo_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_crearUnidad)
                    .addComponent(btn_crearTipoProducto))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoCRUD2.png"))); // NOI18N

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
                .addContainerGap(255, Short.MAX_VALUE)
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
        btn_editar.setText("Modificar");
        btn_editar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        Panel_BotonesLayout.setVerticalGroup(
            Panel_BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_BotonesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(Panel_BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_eliminar)
                    .addComponent(btn_editar)
                    .addComponent(btn_guardar)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_nuevo))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jDP_RProducto.setLayer(PanelDatos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDP_RProducto.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDP_RProducto.setLayer(Panel_Listado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDP_RProducto.setLayer(Panel_Botones, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDP_RProductoLayout = new javax.swing.GroupLayout(jDP_RProducto);
        jDP_RProducto.setLayout(jDP_RProductoLayout);
        jDP_RProductoLayout.setHorizontalGroup(
            jDP_RProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDP_RProductoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jDP_RProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel_Botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(Panel_Listado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jDP_RProductoLayout.setVerticalGroup(
            jDP_RProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDP_RProductoLayout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel_Listado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel_Botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDP_RProducto)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDP_RProducto)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                guardar.setString(6, String.valueOf(cbo_unidadMedida.getSelectedIndex()));            
                guardar.setString(7, String.valueOf(cbo_categoria.getSelectedIndex()));
                guardar.executeUpdate();

                JOptionPane.showMessageDialog(null, "Datos Ingresados Correctamente.");
                guardar.close();
                Bloquear();
                borrar();
                BloqInicio();

            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, e + " Error, No se registro el Producto");
            }
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listaActionPerformed

        Frame ListaProductos = JOptionPane.getFrameForComponent(this);
        Fmr_ListadoProductos ventana = new Fmr_ListadoProductos(ListaProductos, false);
        ventana.setVisible(true);
        Fmr_ListadoProductos.TablaCliente.setEnabled(false);
    }//GEN-LAST:event_btn_listaActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        borrar();
        Bloquear();
        btn_nuevo.setEnabled(true);
        BloqInicio();
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
        Bloquear();
        BloqInicio();
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        borrar();
        Desbloquear();
        BloqBotonNuevo();
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_crearUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearUnidadActionPerformed
        Frame CrearUM = JOptionPane.getFrameForComponent(this);
        Fmr_CrearUnidadMedida ventana = new Fmr_CrearUnidadMedida(CrearUM, true);
        ventana.setVisible(true);

    }//GEN-LAST:event_btn_crearUnidadActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        Eliminar(txt_codigoProducto.getText());
        borrar();
        Bloquear();
        BloqInicio();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_crearTipoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearTipoProductoActionPerformed
        Frame CrearTP = JOptionPane.getFrameForComponent(this);
        Fmr_CrearTipodeProducto ventana = new Fmr_CrearTipodeProducto(CrearTP, true);
        ventana.setVisible(true);
    }//GEN-LAST:event_btn_crearTipoProductoActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        Frame ListaProductos = JOptionPane.getFrameForComponent(this);
        Fmr_ListadoProductos ventana = new Fmr_ListadoProductos(ListaProductos, false);
        ventana.setVisible(true);
        BloqBotonBuscar();
        Desbloquear();
    }//GEN-LAST:event_btn_buscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelDatos;
    private javax.swing.JPanel Panel_Botones;
    private javax.swing.JPanel Panel_Listado;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_crearTipoProducto;
    private javax.swing.JButton btn_crearUnidad;
    public static javax.swing.JButton btn_editar;
    public static javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_lista;
    private javax.swing.JButton btn_nuevo;
    public static javax.swing.JComboBox<String> cbo_categoria;
    public static javax.swing.JComboBox<String> cbo_unidadMedida;
    private javax.swing.JDesktopPane jDP_RProducto;
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