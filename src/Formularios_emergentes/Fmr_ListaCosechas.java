package Formularios_emergentes;

import Conexion.conexion;
import Formularios.Control_Cosecha;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Fmr_ListaCosechas extends javax.swing.JFrame {

    conexion conn = new conexion();
    Connection iniciarConexion = conn.conexion();

    public Fmr_ListaCosechas() {

        initComponents();
        this.setTitle("AgroControl - Lista Cosechas");
        this.setLocationRelativeTo(null);
        setResizable(false);

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
            Statement leer = iniciarConexion.createStatement();
            ResultSet resultado = leer.executeQuery("SELECT * FROM Cosecha");

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
            Statement leer = iniciarConexion.createStatement();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon1 = new ImageIcon(getClass().getResource("/Imagenes/fondo-submenu2.jpg"));
        Image image1 = icon1.getImage();
        jDesktopPane1 = new javax.swing.JDesktopPane(){

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
        setBackground(new java.awt.Color(240, 255, 240));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

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

        jDesktopPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txt_buscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addGap(39, 39, 39))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(333, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        busqueda(txt_buscar.getText());
    }//GEN-LAST:event_txt_buscarKeyReleased

    private void TablaCosechasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaCosechasMouseClicked

        JTable receptor = (JTable) evt.getSource();

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        String fechaSiembra = TablaCosechas.getValueAt(TablaCosechas.getSelectedRow(), 4).toString().trim();
        String fechaRecoleccion = TablaCosechas.getValueAt(TablaCosechas.getSelectedRow(), 5).toString().trim();
        Date dato, dato1 = null;

        try {
            dato = (Date) formato.parse(fechaSiembra);
            dato1 = (Date) formato.parse(fechaRecoleccion);

            Control_Cosecha.txt_FechaSiembra.setDate(dato);
            Control_Cosecha.txt_FechaRecoleccion.setDate(dato1);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        Control_Cosecha.txt_IdCosecha.setText(TablaCosechas.getValueAt(TablaCosechas.getSelectedRow(), 0).toString());
        //Control_Cosecha.txt_IdCosecha.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString());
        Control_Cosecha.txt_NombreCosecha.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 1).toString());
        Control_Cosecha.cbo_TipoCultivo.setSelectedItem(receptor.getModel().getValueAt(receptor.getSelectedRow(), 2).toString());
        Control_Cosecha.cbo_TipoCosecha.setSelectedItem(receptor.getModel().getValueAt(receptor.getSelectedRow(), 3).toString());

        this.hide();
    }//GEN-LAST:event_TablaCosechasMouseClicked

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
            java.util.logging.Logger.getLogger(Fmr_ListaCosechas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fmr_ListaCosechas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fmr_ListaCosechas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fmr_ListaCosechas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fmr_ListaCosechas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaCosechas;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
