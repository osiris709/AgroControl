/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Formularios.RegistrarCosecha;
import Formularios.RegistrarCompra;
import Formularios.RegistrarConsumo;
import Formularios.RegistrarProducto;
import Formularios.RegistrarProveedor;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.ImageIcon;


/**
 *
 * @author SENA
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();

        this.setTitle("AgroControl - Menu Principal");
        this.setLocationRelativeTo(null);
        setResizable(false);
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Imagenes/icono.png"));

        return retValue;
    }

    public void salir() {

        Login inicio = new Login();
        inicio.setVisible(true);
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ImageIcon icon1 = new ImageIcon(getClass().getResource("/Imagenes/fondo-menu.jpg"));
        Image image1 = icon1.getImage();
        Escritorio = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image1,0,0,getWidth(),getHeight(),this);
            }
        };
        lbl_logo = new javax.swing.JLabel();
        lbl_cosecha = new javax.swing.JLabel();
        lbl_proveedores = new javax.swing.JLabel();
        lbl_salir = new javax.swing.JLabel();
        lbl_consumos = new javax.swing.JLabel();
        lbl_compras = new javax.swing.JLabel();
        lbl_productos = new javax.swing.JLabel();
        lbl_reportes = new javax.swing.JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/fondo-ventana.png"));
        Image image = icon.getImage();
        mostrar = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1280, 720));
        jPanel1.setMinimumSize(new java.awt.Dimension(1280, 720));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        Escritorio.setBackground(new java.awt.Color(240, 255, 240));
        Escritorio.setPreferredSize(new java.awt.Dimension(1280, 720));

        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo-login.png"))); // NOI18N

        lbl_cosecha.setBackground(new java.awt.Color(255, 255, 255));
        lbl_cosecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_cosecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cosecha.png"))); // NOI18N
        lbl_cosecha.setText("Cosecha");
        lbl_cosecha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbl_cosecha.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lbl_cosecha.setOpaque(true);
        lbl_cosecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_cosechaMouseClicked(evt);
            }
        });

        lbl_proveedores.setBackground(new java.awt.Color(255, 255, 255));
        lbl_proveedores.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_proveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Proveedor.png"))); // NOI18N
        lbl_proveedores.setText("Proveedores");
        lbl_proveedores.setToolTipText("");
        lbl_proveedores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbl_proveedores.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lbl_proveedores.setOpaque(true);
        lbl_proveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_proveedoresMouseClicked(evt);
            }
        });

        lbl_salir.setBackground(new java.awt.Color(255, 255, 255));
        lbl_salir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Salir.png"))); // NOI18N
        lbl_salir.setText("Salir");
        lbl_salir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbl_salir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lbl_salir.setOpaque(true);
        lbl_salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_salirMouseClicked(evt);
            }
        });

        lbl_consumos.setBackground(new java.awt.Color(255, 255, 255));
        lbl_consumos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_consumos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Consumo.png"))); // NOI18N
        lbl_consumos.setText("Consumos");
        lbl_consumos.setToolTipText("");
        lbl_consumos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbl_consumos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lbl_consumos.setOpaque(true);
        lbl_consumos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_consumosMouseClicked(evt);
            }
        });

        lbl_compras.setBackground(new java.awt.Color(255, 255, 255));
        lbl_compras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_compras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Compra.png"))); // NOI18N
        lbl_compras.setText("Compras");
        lbl_compras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbl_compras.setOpaque(true);
        lbl_compras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_comprasMouseClicked(evt);
            }
        });

        lbl_productos.setBackground(new java.awt.Color(255, 255, 255));
        lbl_productos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_productos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Productos.png"))); // NOI18N
        lbl_productos.setText("Productos");
        lbl_productos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbl_productos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lbl_productos.setOpaque(true);
        lbl_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_productosMouseClicked(evt);
            }
        });

        lbl_reportes.setBackground(new java.awt.Color(255, 255, 255));
        lbl_reportes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_reportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reporte.png"))); // NOI18N
        lbl_reportes.setText("Reportes");
        lbl_reportes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbl_reportes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lbl_reportes.setOpaque(true);

        mostrar.setBackground(new java.awt.Color(240, 255, 240));
        mostrar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mostrar.setForeground(new java.awt.Color(240, 255, 240));
        mostrar.setAutoscrolls(true);
        mostrar.setMaximumSize(new java.awt.Dimension(800, 600));
        mostrar.setMinimumSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout mostrarLayout = new javax.swing.GroupLayout(mostrar);
        mostrar.setLayout(mostrarLayout);
        mostrarLayout.setHorizontalGroup(
            mostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 796, Short.MAX_VALUE)
        );
        mostrarLayout.setVerticalGroup(
            mostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );

        Escritorio.setLayer(lbl_logo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(lbl_cosecha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(lbl_proveedores, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(lbl_salir, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(lbl_consumos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(lbl_compras, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(lbl_productos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(lbl_reportes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(mostrar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EscritorioLayout.createSequentialGroup()
                .addGroup(EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EscritorioLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_proveedores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_salir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_productos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_compras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_consumos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_cosecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_reportes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(EscritorioLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lbl_logo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(mostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EscritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(EscritorioLayout.createSequentialGroup()
                        .addComponent(lbl_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(lbl_proveedores)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_productos)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_compras)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_consumos)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_cosecha)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_reportes)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_salir)))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Registrar Proveedor");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Registrar Producto");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Registrar Compra");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Registrar Consumo");
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Registrar Cosecha");
        jMenu1.add(jMenuItem5);

        jMenuItem13.setText("Salir");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem13);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ver");

        jMenuItem7.setText("Listado de Proveedores");
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Listado de Productos");
        jMenu2.add(jMenuItem8);

        jMenuItem9.setText("Listado de Compras");
        jMenu2.add(jMenuItem9);

        jMenuItem10.setText("Listado de Consumos");
        jMenu2.add(jMenuItem10);

        jMenuItem11.setText("Listado de Cosechas");
        jMenu2.add(jMenuItem11);

        jMenuItem12.setText("Listado de Areas");
        jMenu2.add(jMenuItem12);

        jMenuItem14.setText("Listado Tipo de Productos");
        jMenu2.add(jMenuItem14);

        jMenuItem15.setText("Listado Unidades de Medida");
        jMenu2.add(jMenuItem15);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Consultas");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_proveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_proveedoresMouseClicked

        RegistrarProveedor ventana = new RegistrarProveedor();
        mostrar.add(ventana);
        ventana.show();

    }//GEN-LAST:event_lbl_proveedoresMouseClicked

    private void lbl_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_productosMouseClicked

        RegistrarProducto ventana2 = new RegistrarProducto();
        mostrar.add(ventana2);
        ventana2.show();

    }//GEN-LAST:event_lbl_productosMouseClicked

    private void lbl_comprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_comprasMouseClicked

        RegistrarCompra ventana3 = new RegistrarCompra();
        mostrar.add(ventana3);
        ventana3.show();
    }//GEN-LAST:event_lbl_comprasMouseClicked

    private void lbl_consumosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_consumosMouseClicked

        RegistrarConsumo ventana4 = new RegistrarConsumo();
        mostrar.add(ventana4);
        ventana4.show();

    }//GEN-LAST:event_lbl_consumosMouseClicked

    private void lbl_cosechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_cosechaMouseClicked

        RegistrarCosecha ventana5 = new RegistrarCosecha();
        mostrar.add(ventana5);
        ventana5.show();

    }//GEN-LAST:event_lbl_cosechaMouseClicked

    private void lbl_salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_salirMouseClicked

        salir();
    }//GEN-LAST:event_lbl_salirMouseClicked

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        salir();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_compras;
    private javax.swing.JLabel lbl_consumos;
    private javax.swing.JLabel lbl_cosecha;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_productos;
    private javax.swing.JLabel lbl_proveedores;
    private javax.swing.JLabel lbl_reportes;
    private javax.swing.JLabel lbl_salir;
    public static javax.swing.JDesktopPane mostrar;
    // End of variables declaration//GEN-END:variables
}
