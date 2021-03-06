package Formularios_emergentes;

import Conexion.conexion;
import Formularios.RegistrarCosecha;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Fmr_ListadoCosechas extends javax.swing.JDialog {

    conexion objConexion = new conexion();
    Connection con = objConexion.conexion();

    public Fmr_ListadoCosechas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("AgroControl - Listado Cosechas");
        this.setLocationRelativeTo(null);
        MostrarListaCosechas();
    }

    public void MostrarListaCosechas() {

        DefaultTableModel tCosechas = new DefaultTableModel();
        tCosechas.addColumn("Id Cosecha");
        tCosechas.addColumn("Nombre Cosecha");
        tCosechas.addColumn("Tipo Cultivo");
        tCosechas.addColumn("Tipo Cosecha");
        tCosechas.addColumn("Fecha Siembra");
        tCosechas.addColumn("Fecha Recoleccion");

        TablaCosechas.setModel(tCosechas);

        String[] datos = new String[6];

        try {
            Statement leer = con.createStatement();
            ResultSet resultado = leer.executeQuery("SELECT IdCosecha, Nombre_Cosecha, Tipo_Cultivo, tipo_cosecha.TipoCosecha, Fecha_Siembra, Fecha_Recoleccion \n"
                    + "FROM Cosecha INNER JOIN tipo_cosecha \n"
                    + "ON Cosecha.Tipo_Cosecha = tipo_cosecha.IDTipoCosecha");

            while (resultado.next()) {
                datos[0] = resultado.getString(1);
                datos[1] = resultado.getString(2);
                datos[2] = resultado.getString(3);
                datos[3] = resultado.getString(4);
                datos[4] = resultado.getString(5);
                datos[5] = resultado.getString(6);
                tCosechas.addRow(datos);
            }
            TablaCosechas.setModel(tCosechas);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "Error en la Consulta");
        }
    }

    public void busqueda(String buscar) {

        DefaultTableModel tCosechas = new DefaultTableModel();
        tCosechas.addColumn("Id Cosecha");
        tCosechas.addColumn("Nombre Cosecha");
        tCosechas.addColumn("Tipo Cultivo");
        tCosechas.addColumn("Tipo Cosecha");
        tCosechas.addColumn("Fecha Siembra");
        tCosechas.addColumn("Fecha Recoleccion");

        TablaCosechas.setModel(tCosechas);

        String[] datos = new String[6];

        try {
            Statement leer = con.createStatement();
            ResultSet resultado = leer.executeQuery("SELECT * FROM Cosecha WHERE IdCosecha LIKE '%" + buscar + "%' OR Nombre_Cosecha LIKE '%" + buscar + "%'");

            while (resultado.next()) {
                datos[0] = resultado.getString(1);
                datos[1] = resultado.getString(2);
                datos[2] = resultado.getString(3);
                datos[3] = resultado.getString(4);
                datos[4] = resultado.getString(5);
                datos[5] = resultado.getString(6);
                tCosechas.addRow(datos);
            }
            TablaCosechas.setModel(tCosechas);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "Error en la Consulta");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon1 = new ImageIcon(getClass().getResource("/Imagenes/fondo-submenu2.jpg"));
        Image image1 = icon1.getImage();
        jDP_ListaCosechas = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image1,0,0,getWidth(),getHeight(),this);
            }
        }
        ;
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaCosechas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jDP_ListaCosechas.setBackground(new java.awt.Color(255, 255, 255));

        TablaCosechas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaCosechas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaCosechasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaCosechas);

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setText("Listado de Cosechas");

        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Buscar:");

        jDP_ListaCosechas.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDP_ListaCosechas.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDP_ListaCosechas.setLayer(txt_buscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDP_ListaCosechas.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDP_ListaCosechasLayout = new javax.swing.GroupLayout(jDP_ListaCosechas);
        jDP_ListaCosechas.setLayout(jDP_ListaCosechasLayout);
        jDP_ListaCosechasLayout.setHorizontalGroup(
            jDP_ListaCosechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDP_ListaCosechasLayout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDP_ListaCosechasLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jDP_ListaCosechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(jDP_ListaCosechasLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );
        jDP_ListaCosechasLayout.setVerticalGroup(
            jDP_ListaCosechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDP_ListaCosechasLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jDP_ListaCosechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(368, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDP_ListaCosechas)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDP_ListaCosechas)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TablaCosechasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaCosechasMouseClicked

        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");

        String fechaSiembra = TablaCosechas.getValueAt(TablaCosechas.getSelectedRow(), 4).toString().trim();
        String fechaRecoleccion = TablaCosechas.getValueAt(TablaCosechas.getSelectedRow(), 5).toString().trim();
        Date dato, dato1;

        try {
            dato = (Date) formato.parse(fechaSiembra);
            dato1 = (Date) formato.parse(fechaRecoleccion);

            RegistrarCosecha.txt_FechaSiembra.setDate(dato);
            RegistrarCosecha.txt_FechaRecoleccion.setDate(dato1);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        RegistrarCosecha.txt_Id.setText(TablaCosechas.getValueAt(TablaCosechas.getSelectedRow(), 0).toString());
        RegistrarCosecha.txt_NombreCosecha.setText(TablaCosechas.getModel().getValueAt(TablaCosechas.getSelectedRow(), 1).toString());
        RegistrarCosecha.cbo_TipoCultivo.setSelectedItem(TablaCosechas.getModel().getValueAt(TablaCosechas.getSelectedRow(), 2).toString());
        RegistrarCosecha.cbo_TipoCosecha.setSelectedItem(TablaCosechas.getModel().getValueAt(TablaCosechas.getSelectedRow(), 3).toString());

        RegistrarCosecha.Desbloquear();

        this.hide();
    }//GEN-LAST:event_TablaCosechasMouseClicked

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        busqueda(txt_buscar.getText());
    }//GEN-LAST:event_txt_buscarKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Fmr_ListadoCosechas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fmr_ListadoCosechas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fmr_ListadoCosechas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fmr_ListadoCosechas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Fmr_ListadoCosechas dialog = new Fmr_ListadoCosechas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable TablaCosechas;
    private javax.swing.JDesktopPane jDP_ListaCosechas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}