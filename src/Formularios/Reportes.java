/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Reportes.Compras;
import Reportes.Consumo;
import java.awt.Frame;
import javax.swing.JOptionPane;
import Reportes.Cosecha;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Reportes extends javax.swing.JInternalFrame {

    /**
     * Creates new form Reporte
     */
    public Reportes() {
        
        setTitle("AgroControl - Reportes");
        initComponents();
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
        jDP_Reportes = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image1,0,0,getWidth(),getHeight(),this);
            }
        }
        ;
        jLabel1 = new javax.swing.JLabel();
        LogoCRUD = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btCosecha = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        bncompras = new javax.swing.JButton();
        Bnconsumo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 600));

        jDP_Reportes.setBackground(new java.awt.Color(204, 204, 204));
        jDP_Reportes.setPreferredSize(new java.awt.Dimension(784, 570));

        jLabel1.setBackground(new java.awt.Color(240, 255, 240));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reportes ");

        LogoCRUD.setBackground(new java.awt.Color(255, 255, 255));
        LogoCRUD.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        LogoCRUD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoCRUD2.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(240, 255, 240));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Reportes cosecha");

        btCosecha.setText("Entra ");
        btCosecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCosechaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Reportes compra");

        bncompras.setText("Entra");
        bncompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bncomprasActionPerformed(evt);
            }
        });

        Bnconsumo.setText("Entra");
        Bnconsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BnconsumoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Reportes consumo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(135, 135, 135)
                        .addComponent(btCosecha)
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bncompras))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Bnconsumo)))
                        .addGap(37, 37, 37))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCosecha)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(bncompras))
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Bnconsumo)
                    .addComponent(jLabel3))
                .addGap(37, 37, 37))
        );

        jDP_Reportes.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDP_Reportes.setLayer(LogoCRUD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDP_Reportes.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDP_ReportesLayout = new javax.swing.GroupLayout(jDP_Reportes);
        jDP_Reportes.setLayout(jDP_ReportesLayout);
        jDP_ReportesLayout.setHorizontalGroup(
            jDP_ReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDP_ReportesLayout.createSequentialGroup()
                .addGroup(jDP_ReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDP_ReportesLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(LogoCRUD))
                    .addGroup(jDP_ReportesLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDP_ReportesLayout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(jLabel1)))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        jDP_ReportesLayout.setVerticalGroup(
            jDP_ReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDP_ReportesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoCRUD)
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDP_Reportes, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDP_Reportes, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCosechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCosechaActionPerformed
        Frame listaProveedor = JOptionPane.getFrameForComponent(this);
        Cosecha abrir = new Cosecha();
        abrir.setVisible(true);
    }//GEN-LAST:event_btCosechaActionPerformed

    private void bncomprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bncomprasActionPerformed
        Compras abrir = new Compras();
        abrir.setVisible(true);
    }//GEN-LAST:event_bncomprasActionPerformed

    private void BnconsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BnconsumoActionPerformed
        Consumo abrir = new Consumo();
        abrir.setVisible(true);
    }//GEN-LAST:event_BnconsumoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bnconsumo;
    private javax.swing.JLabel LogoCRUD;
    private javax.swing.JButton bncompras;
    private javax.swing.JButton btCosecha;
    private javax.swing.JDesktopPane jDP_Reportes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}