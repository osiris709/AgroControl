package Formularios_emergentes;

import Conexion.conexion;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Fmr_ListadoConsumos extends javax.swing.JDialog {

    conexion objConexion = new conexion();
    Connection con = objConexion.conexion();

    public Fmr_ListadoConsumos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("AgroControl - Lista Consumos");
        setLocationRelativeTo(null);
        MostrarListaConsumos();
    }

        public void MostrarListaConsumos() {

        DefaultTableModel tConsumos = new DefaultTableModel();
        tConsumos.addColumn("Id");
        tConsumos.addColumn("Fecha Aplicacion");
        tConsumos.addColumn("Tipo Cultivo");
        tConsumos.addColumn("Nombre Cosecha");
        tConsumos.addColumn("Area");
        tConsumos.addColumn("Tipo Cosecha");

        TablaConsumos.setModel(tConsumos);

        String[] datos = new String[6];

        try {
            Statement leer = con.createStatement();
            ResultSet resultado = leer.executeQuery("SELECT idAplicacion, Fecha_Aplicacion, consumos.Tipo_Cultivo, cosecha.Nombre_Cosecha, area.Nombre_Area, tipo_cosecha.TipoCosecha FROM consumos INNER JOIN cosecha ON consumos.Nombre_Cosecha = cosecha.IdCosecha INNER JOIN area ON consumos.Area = area.ID_Area INNER JOIN tipo_cosecha ON consumos.Tipo_Cosecha = tipo_cosecha.IDTipoCosecha");

            while (resultado.next()) {
                datos[0] = resultado.getString(1);
                datos[1] = resultado.getString(2);
                datos[2] = resultado.getString(3);
                datos[3] = resultado.getString(4);
                datos[4] = resultado.getString(5);
                datos[5] = resultado.getString(6);
                tConsumos.addRow(datos);
            }
            TablaConsumos.setModel(tConsumos);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "Error en la Consulta");
        }
    }

    public void busqueda(String buscar) {

        DefaultTableModel tConsumos = new DefaultTableModel();
        tConsumos.addColumn("Id");
        tConsumos.addColumn("Fecha Aplicacion");
        tConsumos.addColumn("Tipo Cultivo");
        tConsumos.addColumn("Nombre Cosecha");
        tConsumos.addColumn("Area");
        tConsumos.addColumn("Tipo Cosecha");

        TablaConsumos.setModel(tConsumos);

        String[] datos = new String[6];

        try {
            Statement leer = con.createStatement();
            ResultSet resultado = leer.executeQuery("SELECT * FROM Consumos WHERE IdAplicacion LIKE '%" + buscar + "%'");

            while (resultado.next()) {
                datos[0] = resultado.getString(1);
                datos[1] = resultado.getString(2);
                datos[2] = resultado.getString(3);
                datos[3] = resultado.getString(4);
                datos[4] = resultado.getString(5);
                datos[5] = resultado.getString(6);
                tConsumos.addRow(datos);
            }
            TablaConsumos.setModel(tConsumos);
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
        TablaConsumos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jDP_ListaCosechas.setBackground(new java.awt.Color(255, 255, 255));

        TablaConsumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(TablaConsumos);

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setText("Listado de Consumos");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDP_ListaCosechasLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jDP_ListaCosechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDP_ListaCosechasLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE))
                .addGap(50, 50, 50))
            .addGroup(jDP_ListaCosechasLayout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(352, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(Fmr_ListadoConsumos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fmr_ListadoConsumos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fmr_ListadoConsumos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fmr_ListadoConsumos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Fmr_ListadoConsumos dialog = new Fmr_ListadoConsumos(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable TablaConsumos;
    private javax.swing.JDesktopPane jDP_ListaCosechas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}