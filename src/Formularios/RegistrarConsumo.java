package Formularios;

import Clases.ComunicationPopUp;
import Clases.Consumos;
import Conexion.conexion;
import Formularios_emergentes.Fmr_Area;
import Formularios_emergentes.Fmr_ProductosCompra;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Osiris
 */
public class RegistrarConsumo extends javax.swing.JInternalFrame implements ComunicationPopUp {

    conexion objConexion = new conexion();
    Connection con = objConexion.conexion();

    Consumos cargar_combobox = new Consumos();

    SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
    private int IdAplicacion;

    public RegistrarConsumo() {
        initComponents();
        cbo_TipoCultivo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        cargar_combobox.Cargar_Area(cbo_Area);

        Bloquear();
    }

    @Override
    public void updateBD() {

        cargar_combobox.Cargar_Cosecha(cbo_Cosecha, cbo_TipoCultivo.getSelectedItem().toString());
        cargar_combobox.Cargar_TipoCosecha(cbo_TipoCosecha, cbo_Cosecha.getSelectedItem().toString());
        cargar_combobox.Cargar_Area(cbo_Area);

    }

    public void agregar() {

        if (txt_producto.getText().equals("") || txt_cantidad.getText().equals("")) {

            javax.swing.JOptionPane.showMessageDialog(this, "Obligatorio llenar todos los campos \n", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);

        } else {

            //obtener el modelo de la tabla sobre el cual trabajaremos y agregamos las columnas.
            DefaultTableModel modelo = (DefaultTableModel) TablaProductos.getModel();

            Object[] fila = new Object[2];

            //Almacenamos los datos de acuerdo al orden de las columnas de la tabla.
            fila[0] = txt_producto.getText();
            fila[1] = txt_cantidad.getText();

            //Agregamos el array al modelo de la tabla.
            modelo.addRow(fila);

            txt_producto.setText("");
            txt_cantidad.setText("");

            //Aplicamos el modelo a la tabla.
            TablaProductos.setModel(modelo);
        }
    }

    public void Guardar() {
        // Si hay algun campo vacio, genera mensaje de advertencia
        if ((cbo_Cosecha.getSelectedItem().equals("Seleccionar"))
                || fechaConsumo.getDate().equals("") || cbo_TipoCultivo.getSelectedItem().equals("Seleccionar") || (cbo_Area.getSelectedItem().equals("Seleccionar")) || cbo_TipoCosecha.getSelectedItem().equals("Seleccionar")) {

            javax.swing.JOptionPane.showMessageDialog(this, "Obligatorio llenar todos los campos \n", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            fechaConsumo.requestFocus();
        } else {
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea Guardar los datos?");
            if (confirmar == JOptionPane.YES_OPTION) {
                // Guardar datos en la base de datos
                try {
                    // Definir Sentencia en base de Datos SQL
                    PreparedStatement guardar = con.prepareStatement("INSERT INTO consumos (IdAplicacion,Fecha_Aplicacion,Tipo_Cultivo,Nombre_Cosecha,Area,Tipo_Cosecha) VALUES (?,?,?,?,?,?)");
                    PreparedStatement guardar2 = con.prepareStatement("INSERT INTO detalleconsumos (IDConsumos,NombreProducto,Cantidad) VALUES (?,?,?)");

                    guardar.setString(1, null);
                    guardar.setString(2, formato.format(fechaConsumo.getDate()));
                    guardar.setString(3, cbo_TipoCultivo.getSelectedItem().toString());
                    guardar.setString(4, String.valueOf(cbo_Cosecha.getSelectedIndex()));
                    guardar.setString(5, String.valueOf(cbo_Area.getSelectedIndex()));
                    guardar.setString(6, String.valueOf(cbo_TipoCosecha.getSelectedIndex()));

                    guardar.executeUpdate();

                    String ConsultaID = "SELECT MAX(IdAplicacion) FROM consumos";

                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(ConsultaID);
                    
                    if (rs.next()) {
                        
                        IdAplicacion = rs.getInt(1);
                        System.out.println(IdAplicacion);
                    }

                    if (TablaProductos.getRowCount() > 0) {
                        for (int i = 0; i < TablaProductos.getRowCount(); i++) {

                            guardar2.setString(1, String.valueOf(IdAplicacion));
                            guardar2.setString(2, TablaProductos.getValueAt(i, 0).toString());
                            guardar2.setString(3, TablaProductos.getValueAt(i, 1).toString());

                            // Ejecuta la sentencia y obtiene el resultado
                            guardar2.executeUpdate();
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Consumo Registrado exitosamente");
                    guardar.close();

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, e + " Error, No se registro el Consumo");
                }
            }
        }
    }

    public void Borrar() {

        fechaConsumo.setDate(null);
        cbo_TipoCultivo.setSelectedIndex(0);
        cbo_Cosecha.removeAllItems();
        cbo_Area.removeAllItems();
        cbo_TipoCosecha.removeAllItems();
        updateBD();
        txt_producto.setText("");
        txt_cantidad.setText("");
        DefaultTableModel modelo = (DefaultTableModel) TablaProductos.getModel();
        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();
    }

    public void Bloquear() {

        fechaConsumo.setEnabled(false);
        cbo_TipoCultivo.setEnabled(false);
        cbo_Cosecha.setEnabled(false);
        cbo_Area.setEnabled(false);
        cbo_TipoCosecha.setEnabled(false);
        txt_producto.setEnabled(false);
        txt_cantidad.setEnabled(false);
        btn_nuevo.setEnabled(true);
        btn_guardar.setEnabled(false);
        btn_cancelar.setEnabled(false);
        btn_CrearArea.setEnabled(false);
        btn_buscar.setEnabled(false);
        btn_agregar_producto.setEnabled(false);
        btn_eliminar_producto.setEnabled(false);
    }

    public void Desbloquear() {

        fechaConsumo.setEnabled(true);
        cbo_TipoCultivo.setEnabled(true);
        cbo_Cosecha.setEnabled(true);
        cbo_Area.setEnabled(true);
        cbo_TipoCosecha.setEnabled(true);
        txt_producto.setEnabled(true);
        txt_cantidad.setEnabled(true);
        btn_guardar.setEnabled(true);
        btn_cancelar.setEnabled(true);
        btn_CrearArea.setEnabled(true);
        btn_buscar.setEnabled(true);
        btn_agregar_producto.setEnabled(true);
        btn_eliminar_producto.setEnabled(true);
        btn_nuevo.setEnabled(false);
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
        jDP_RConsumo = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image1,0,0,getWidth(),getHeight(),this);
            }
        }
        ;
        LogoCRUD = new javax.swing.JLabel();
        jP_Datos = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        txt_producto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fechaConsumo = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        cbo_TipoCosecha = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbo_Area = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbo_Cosecha = new javax.swing.JComboBox<>();
        btn_CrearArea = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProductos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cbo_TipoCultivo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        btn_eliminar_producto = new javax.swing.JButton();
        btn_agregar_producto = new javax.swing.JButton();
        jP_Listado = new javax.swing.JPanel();
        btn_lista = new javax.swing.JButton();
        jP_Botones = new javax.swing.JPanel();
        btn_nuevo = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setResizable(true);
        setTitle("Registar Consumos");
        setToolTipText("");
        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jDP_RConsumo.setBackground(new java.awt.Color(255, 255, 255));

        LogoCRUD.setBackground(new java.awt.Color(255, 255, 255));
        LogoCRUD.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        LogoCRUD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoCRUD2.png"))); // NOI18N

        jP_Datos.setBackground(new java.awt.Color(240, 255, 240));
        jP_Datos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jP_Datos.setMaximumSize(new java.awt.Dimension(730, 364));
        jP_Datos.setPreferredSize(new java.awt.Dimension(730, 364));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Producto:");

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar2.png"))); // NOI18N
        btn_buscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        txt_producto.setEditable(false);
        txt_producto.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Fecha de Aplicacion:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Tipo de Cosecha:");

        cbo_TipoCosecha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Area:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Cosecha:");

        cbo_Cosecha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        cbo_Cosecha.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_CosechaItemStateChanged(evt);
            }
        });

        btn_CrearArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo2.png"))); // NOI18N
        btn_CrearArea.setText("Crear Area");
        btn_CrearArea.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_CrearArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CrearAreaActionPerformed(evt);
            }
        });

        TablaProductos.setAutoCreateRowSorter(true);
        TablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCTO", "CANTIDAD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaProductos.setToolTipText("");
        TablaProductos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TablaProductos);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Tipo de Cultivo:");

        cbo_TipoCultivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Transitorio", "Permanente" }));
        cbo_TipoCultivo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_TipoCultivoItemStateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Cantidad:");

        txt_cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cantidadKeyTyped(evt);
            }
        });

        btn_eliminar_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar2.png"))); // NOI18N
        btn_eliminar_producto.setText("Eliminar");
        btn_eliminar_producto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_agregar_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo2.png"))); // NOI18N
        btn_agregar_producto.setText("Agregar");
        btn_agregar_producto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_agregar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregar_productoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jP_DatosLayout = new javax.swing.GroupLayout(jP_Datos);
        jP_Datos.setLayout(jP_DatosLayout);
        jP_DatosLayout.setHorizontalGroup(
            jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_DatosLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jP_DatosLayout.createSequentialGroup()
                        .addComponent(btn_agregar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_eliminar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jP_DatosLayout.createSequentialGroup()
                        .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jP_DatosLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(71, 71, 71)
                                .addComponent(txt_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jP_DatosLayout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                                    .addComponent(cbo_Area, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jP_DatosLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(fechaConsumo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(btn_CrearArea, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jP_DatosLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(cbo_TipoCosecha, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jP_DatosLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbo_Cosecha, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jP_DatosLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jP_DatosLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbo_TipoCultivo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 45, Short.MAX_VALUE))
        );
        jP_DatosLayout.setVerticalGroup(
            jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_DatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(fechaConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cbo_TipoCultivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_Cosecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(cbo_Area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbo_TipoCosecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_CrearArea))
                .addGap(18, 18, 18)
                .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txt_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jP_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_eliminar_producto)
                    .addComponent(btn_agregar_producto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jP_Listado.setBackground(new java.awt.Color(240, 255, 240));
        jP_Listado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_lista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lista.png"))); // NOI18N
        btn_lista.setText("Mostrar listado de los Consumos");
        btn_lista.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jP_ListadoLayout = new javax.swing.GroupLayout(jP_Listado);
        jP_Listado.setLayout(jP_ListadoLayout);
        jP_ListadoLayout.setHorizontalGroup(
            jP_ListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jP_ListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jP_ListadoLayout.createSequentialGroup()
                    .addGap(258, 258, 258)
                    .addComponent(btn_lista)
                    .addContainerGap(287, Short.MAX_VALUE)))
        );
        jP_ListadoLayout.setVerticalGroup(
            jP_ListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
            .addGroup(jP_ListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jP_ListadoLayout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(btn_lista)
                    .addContainerGap(13, Short.MAX_VALUE)))
        );

        jP_Botones.setBackground(new java.awt.Color(240, 255, 240));
        jP_Botones.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jP_Botones.setPreferredSize(new java.awt.Dimension(730, 65));

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

        javax.swing.GroupLayout jP_BotonesLayout = new javax.swing.GroupLayout(jP_Botones);
        jP_Botones.setLayout(jP_BotonesLayout);
        jP_BotonesLayout.setHorizontalGroup(
            jP_BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_BotonesLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(btn_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );
        jP_BotonesLayout.setVerticalGroup(
            jP_BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_BotonesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jP_BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar)
                    .addComponent(btn_nuevo)
                    .addComponent(btn_cancelar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jDP_RConsumo.setLayer(LogoCRUD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDP_RConsumo.setLayer(jP_Datos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDP_RConsumo.setLayer(jP_Listado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDP_RConsumo.setLayer(jP_Botones, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDP_RConsumoLayout = new javax.swing.GroupLayout(jDP_RConsumo);
        jDP_RConsumo.setLayout(jDP_RConsumoLayout);
        jDP_RConsumoLayout.setHorizontalGroup(
            jDP_RConsumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDP_RConsumoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jDP_RConsumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jP_Botones, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                    .addComponent(jP_Datos, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                    .addComponent(LogoCRUD)
                    .addComponent(jP_Listado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDP_RConsumoLayout.setVerticalGroup(
            jDP_RConsumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDP_RConsumoLayout.createSequentialGroup()
                .addComponent(LogoCRUD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jP_Datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jP_Listado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jP_Botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDP_RConsumo)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDP_RConsumo, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CrearAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CrearAreaActionPerformed
        Frame Area = JOptionPane.getFrameForComponent(this);
        Fmr_Area ventana = new Fmr_Area(Area, true);
        ventana.show();
    }//GEN-LAST:event_btn_CrearAreaActionPerformed

    private void cbo_CosechaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_CosechaItemStateChanged

        cbo_TipoCosecha.removeAllItems();
        cbo_TipoCosecha.addItem("Seleccionar");
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            cargar_combobox.Cargar_TipoCosecha(cbo_TipoCosecha, cbo_Cosecha.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cbo_CosechaItemStateChanged

    private void cbo_TipoCultivoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_TipoCultivoItemStateChanged

        cbo_Cosecha.removeAllItems();
        cbo_Cosecha.addItem("Seleccionar");
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            cargar_combobox.Cargar_Cosecha(cbo_Cosecha, cbo_TipoCultivo.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cbo_TipoCultivoItemStateChanged

    private void btn_agregar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregar_productoActionPerformed
        agregar();
    }//GEN-LAST:event_btn_agregar_productoActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        Guardar();
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        Fmr_ProductosCompra ventana = new Fmr_ProductosCompra();
        ventana.show();
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        Desbloquear();
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        Borrar();
        Bloquear();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void txt_cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidadKeyTyped
        //para pedir solo numeros.
        char carac = evt.getKeyChar();
        if ((carac < '0' || carac > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_cantidadKeyTyped

    private void btn_listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_listaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LogoCRUD;
    private javax.swing.JTable TablaProductos;
    private javax.swing.JButton btn_CrearArea;
    private javax.swing.JButton btn_agregar_producto;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_eliminar_producto;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_lista;
    private javax.swing.JButton btn_nuevo;
    public static javax.swing.JComboBox<String> cbo_Area;
    private javax.swing.JComboBox<String> cbo_Cosecha;
    private javax.swing.JComboBox<String> cbo_TipoCosecha;
    private javax.swing.JComboBox<String> cbo_TipoCultivo;
    private com.toedter.calendar.JDateChooser fechaConsumo;
    private javax.swing.JDesktopPane jDP_RConsumo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jP_Botones;
    private javax.swing.JPanel jP_Datos;
    private javax.swing.JPanel jP_Listado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_cantidad;
    public static javax.swing.JTextField txt_producto;
    // End of variables declaration//GEN-END:variables

}
