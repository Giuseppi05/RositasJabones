package Vistas;

import Controlador.ProductosController;
import Vistas.Usuario.Usuarios;
import Vistas.Producto.Productos;
import ModeloDTO.UsuarioDTO;
import Vistas.Boleta.Boletas;
import Vistas.Cliente.Clientes;
import Vistas.Reportes.Reportes;
import Vistas.Venta.Venta;
import config.UserSession;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import util.ColorMethods;
import util.ImageLoader;
import util.InactividadUtil;

public class Principal extends javax.swing.JFrame {
    static boolean Ven = false;
    static Login login = new Login();
    static UsuarioDTO usuario = UserSession.getUsuario();

    public Principal() { 
        initComponents();
        this.setLocationRelativeTo(null);
        
        usuario = UserSession.getUsuario();
        Ven = false;
        
        if (usuario.getRol().getCodigo() == 1) {
            Ven = true;
            ReportButton.setBackground(new Color(110, 16, 80));
            UserButton.setBackground(new Color(110, 16, 80));
        }

        // Cargamos las imágenes
        ImageLoader.setImageToLabelFromResources(bg, "/imagenes/background.png");
        ImageLoader.setImageToLabelFromResources(HomeLbl, "/imagenes/home.png");
        ImageLoader.setImageToLabelFromResources(ProductLbl, "/imagenes/product.png");
        ImageLoader.setImageToLabelFromResources(ventaLbl, "/imagenes/ventas.png");
        ImageLoader.setImageToLabelFromResources(BoletaLbl, "/imagenes/boleta.png");
        ImageLoader.setImageToLabelFromResources(ClienteLbl, "/imagenes/clientes.png");
        ImageLoader.setImageToLabelFromResources(UserLbl, "/imagenes/user.png");
        ImageLoader.setImageToLabelFromResources(ReportLbl, "/imagenes/report.png");
        ImageLoader.setImageToLabelFromResources(Logoutlbl, "/imagenes/logout.png");
        
        //ALERTAS DE STOCK
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                ProductosController.AlertasBajoStock();
            }
        });
        
        InactividadUtil.activarTemporizador(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Inicio = new javax.swing.JPanel();
        menu = new util.PanelRound();
        ReportButton = new util.PanelRound();
        jLabel10 = new javax.swing.JLabel();
        ReportLbl = new javax.swing.JLabel();
        UserButton = new util.PanelRound();
        jLabel9 = new javax.swing.JLabel();
        UserLbl = new javax.swing.JLabel();
        ClientesButton = new util.PanelRound();
        jLabel8 = new javax.swing.JLabel();
        ClienteLbl = new javax.swing.JLabel();
        BoletaButton = new util.PanelRound();
        jLabel7 = new javax.swing.JLabel();
        BoletaLbl = new javax.swing.JLabel();
        VentasButton = new util.PanelRound();
        jLabel6 = new javax.swing.JLabel();
        ventaLbl = new javax.swing.JLabel();
        ProductButton = new util.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        ProductLbl = new javax.swing.JLabel();
        HomeButton = new util.PanelRound();
        jLabel5 = new javax.swing.JLabel();
        HomeLbl = new javax.swing.JLabel();
        LogOutButton = new util.PanelRound();
        Logoutlbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Inicio.setBackground(new java.awt.Color(254, 235, 241));
        Inicio.setForeground(new java.awt.Color(255, 255, 255));
        Inicio.setToolTipText("");
        Inicio.setPreferredSize(new java.awt.Dimension(806, 500));
        Inicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu.setBackground(new java.awt.Color(189, 29, 139));
        menu.setForeground(new java.awt.Color(255, 241, 235));
        menu.setRoundBottomLeft(50);
        menu.setRoundBottomRight(50);
        menu.setRoundTopLeft(50);
        menu.setRoundTopRight(50);
        menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ReportButton.setBackground(new java.awt.Color(189, 29, 139));
        ReportButton.setRoundBottomLeft(15);
        ReportButton.setRoundBottomRight(15);
        ReportButton.setRoundTopLeft(15);
        ReportButton.setRoundTopRight(15);
        ReportButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReportButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ReportButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ReportButtonMouseExited(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("REPORTES");

        ReportLbl.setFocusable(false);

        javax.swing.GroupLayout ReportButtonLayout = new javax.swing.GroupLayout(ReportButton);
        ReportButton.setLayout(ReportButtonLayout);
        ReportButtonLayout.setHorizontalGroup(
            ReportButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReportButtonLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(ReportLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
        );
        ReportButtonLayout.setVerticalGroup(
            ReportButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReportButtonLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(ReportLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menu.add(ReportButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 200, 50));

        UserButton.setBackground(new java.awt.Color(189, 29, 139));
        UserButton.setRoundBottomLeft(15);
        UserButton.setRoundBottomRight(15);
        UserButton.setRoundTopLeft(15);
        UserButton.setRoundTopRight(15);
        UserButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UserButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UserButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UserButtonMouseExited(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("USUARIOS");

        UserLbl.setFocusable(false);

        javax.swing.GroupLayout UserButtonLayout = new javax.swing.GroupLayout(UserButton);
        UserButton.setLayout(UserButtonLayout);
        UserButtonLayout.setHorizontalGroup(
            UserButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UserButtonLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(UserLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
        );
        UserButtonLayout.setVerticalGroup(
            UserButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UserButtonLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(UserLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menu.add(UserButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 200, 50));

        ClientesButton.setBackground(new java.awt.Color(189, 29, 139));
        ClientesButton.setRoundBottomLeft(15);
        ClientesButton.setRoundBottomRight(15);
        ClientesButton.setRoundTopLeft(15);
        ClientesButton.setRoundTopRight(15);
        ClientesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClientesButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ClientesButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ClientesButtonMouseExited(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("CLIENTES");

        ClienteLbl.setFocusable(false);

        javax.swing.GroupLayout ClientesButtonLayout = new javax.swing.GroupLayout(ClientesButton);
        ClientesButton.setLayout(ClientesButtonLayout);
        ClientesButtonLayout.setHorizontalGroup(
            ClientesButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ClientesButtonLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(ClienteLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
        );
        ClientesButtonLayout.setVerticalGroup(
            ClientesButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ClientesButtonLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(ClienteLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menu.add(ClientesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 200, 50));

        BoletaButton.setBackground(new java.awt.Color(189, 29, 139));
        BoletaButton.setRoundBottomLeft(15);
        BoletaButton.setRoundBottomRight(15);
        BoletaButton.setRoundTopLeft(15);
        BoletaButton.setRoundTopRight(15);
        BoletaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BoletaButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BoletaButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BoletaButtonMouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("BOLETAS");

        BoletaLbl.setFocusable(false);

        javax.swing.GroupLayout BoletaButtonLayout = new javax.swing.GroupLayout(BoletaButton);
        BoletaButton.setLayout(BoletaButtonLayout);
        BoletaButtonLayout.setHorizontalGroup(
            BoletaButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BoletaButtonLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(BoletaLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
        );
        BoletaButtonLayout.setVerticalGroup(
            BoletaButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BoletaButtonLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(BoletaLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menu.add(BoletaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 200, 50));

        VentasButton.setBackground(new java.awt.Color(189, 29, 139));
        VentasButton.setRoundBottomLeft(15);
        VentasButton.setRoundBottomRight(15);
        VentasButton.setRoundTopLeft(15);
        VentasButton.setRoundTopRight(15);
        VentasButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VentasButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                VentasButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                VentasButtonMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("VENTAS");

        ventaLbl.setFocusable(false);

        javax.swing.GroupLayout VentasButtonLayout = new javax.swing.GroupLayout(VentasButton);
        VentasButton.setLayout(VentasButtonLayout);
        VentasButtonLayout.setHorizontalGroup(
            VentasButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VentasButtonLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(ventaLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
        );
        VentasButtonLayout.setVerticalGroup(
            VentasButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VentasButtonLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(ventaLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menu.add(VentasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 200, 50));

        ProductButton.setBackground(new java.awt.Color(189, 29, 139));
        ProductButton.setRoundBottomLeft(15);
        ProductButton.setRoundBottomRight(15);
        ProductButton.setRoundTopLeft(15);
        ProductButton.setRoundTopRight(15);
        ProductButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProductButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProductButtonMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PRODUCTOS");

        ProductLbl.setFocusable(false);

        javax.swing.GroupLayout ProductButtonLayout = new javax.swing.GroupLayout(ProductButton);
        ProductButton.setLayout(ProductButtonLayout);
        ProductButtonLayout.setHorizontalGroup(
            ProductButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductButtonLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(ProductLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
        );
        ProductButtonLayout.setVerticalGroup(
            ProductButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductButtonLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(ProductLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menu.add(ProductButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 200, 50));

        HomeButton.setBackground(new java.awt.Color(189, 29, 139));
        HomeButton.setRoundBottomLeft(15);
        HomeButton.setRoundBottomRight(15);
        HomeButton.setRoundTopLeft(15);
        HomeButton.setRoundTopRight(15);
        HomeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HomeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HomeButtonMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("HOME");

        HomeLbl.setFocusable(false);

        javax.swing.GroupLayout HomeButtonLayout = new javax.swing.GroupLayout(HomeButton);
        HomeButton.setLayout(HomeButtonLayout);
        HomeButtonLayout.setHorizontalGroup(
            HomeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeButtonLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(HomeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        HomeButtonLayout.setVerticalGroup(
            HomeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeButtonLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(HomeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menu.add(HomeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 200, 50));

        Inicio.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 240, 480));

        LogOutButton.setBackground(new java.awt.Color(189, 29, 139));
        LogOutButton.setRoundBottomLeft(15);
        LogOutButton.setRoundBottomRight(15);
        LogOutButton.setRoundTopLeft(15);
        LogOutButton.setRoundTopRight(15);
        LogOutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogOutButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LogOutButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LogOutButtonMouseExited(evt);
            }
        });

        Logoutlbl.setFocusable(false);

        javax.swing.GroupLayout LogOutButtonLayout = new javax.swing.GroupLayout(LogOutButton);
        LogOutButton.setLayout(LogOutButtonLayout);
        LogOutButtonLayout.setHorizontalGroup(
            LogOutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(LogOutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LogOutButtonLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Logoutlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(9, Short.MAX_VALUE)))
        );
        LogOutButtonLayout.setVerticalGroup(
            LogOutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
            .addGroup(LogOutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogOutButtonLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Logoutlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        Inicio.add(LogOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 450, 60, 60));

        jLabel3.setFont(new java.awt.Font("Segoe Print", 1, 60)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(109, 18, 63));
        jLabel3.setText("Rositas");
        Inicio.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe Print", 0, 60)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(187, 62, 129));
        jLabel4.setText("shop");
        Inicio.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 140, 100));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(109, 18, 63));
        jLabel1.setText("COSMETICOS NATURALES");
        Inicio.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, -1, 20));

        bg.setFocusable(false);
        Inicio.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 520));

        getContentPane().add(Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ProductButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductButtonMouseEntered
        ColorMethods.Entered(ProductButton);
    }//GEN-LAST:event_ProductButtonMouseEntered

    private void ProductButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductButtonMouseExited
        ColorMethods.Exited(ProductButton);
    }//GEN-LAST:event_ProductButtonMouseExited

    private void HomeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeButtonMouseEntered
        ColorMethods.Entered(HomeButton);
    }//GEN-LAST:event_HomeButtonMouseEntered

    private void HomeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeButtonMouseExited
        ColorMethods.Exited(HomeButton);
    }//GEN-LAST:event_HomeButtonMouseExited

    private void VentasButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VentasButtonMouseEntered
        ColorMethods.Entered(VentasButton);
    }//GEN-LAST:event_VentasButtonMouseEntered

    private void VentasButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VentasButtonMouseExited
        ColorMethods.Exited(VentasButton);
    }//GEN-LAST:event_VentasButtonMouseExited

    private void BoletaButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BoletaButtonMouseEntered
        ColorMethods.Entered(BoletaButton);
    }//GEN-LAST:event_BoletaButtonMouseEntered

    private void BoletaButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BoletaButtonMouseExited
        ColorMethods.Exited(BoletaButton);
    }//GEN-LAST:event_BoletaButtonMouseExited

    private void ClientesButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClientesButtonMouseEntered
        ColorMethods.Entered(ClientesButton);
    }//GEN-LAST:event_ClientesButtonMouseEntered

    private void ClientesButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClientesButtonMouseExited
        ColorMethods.Exited(ClientesButton);
    }//GEN-LAST:event_ClientesButtonMouseExited

    private void UserButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserButtonMouseEntered
       if(!Ven){
          ColorMethods.Entered(UserButton);
       }
    }//GEN-LAST:event_UserButtonMouseEntered

    private void UserButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserButtonMouseExited
        if(!Ven){
            ColorMethods.Exited(UserButton);
        }
    }//GEN-LAST:event_UserButtonMouseExited

    private void ReportButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportButtonMouseEntered
        if(!Ven){
            ColorMethods.Entered(ReportButton);
        }
    }//GEN-LAST:event_ReportButtonMouseEntered

    private void ReportButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportButtonMouseExited
        if(!Ven){
            ColorMethods.Exited(ReportButton);
        }
    }//GEN-LAST:event_ReportButtonMouseExited

    private void LogOutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutButtonMouseEntered
        ColorMethods.Entered(LogOutButton);
    }//GEN-LAST:event_LogOutButtonMouseEntered

    private void LogOutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutButtonMouseExited
        ColorMethods.Exited(LogOutButton);
    }//GEN-LAST:event_LogOutButtonMouseExited

    private void UserButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserButtonMouseClicked
        if (!Ven){
                Usuarios u = new Usuarios();
                u.setVisible(true);
                this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usted no cuenta con los permisos para ingresar a esta sección");
        }
    }//GEN-LAST:event_UserButtonMouseClicked

    private void ReportButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportButtonMouseClicked
       if (!Ven){
               Reportes r = new Reportes();
               r.setVisible(true);
               this.dispose();
        } else JOptionPane.showMessageDialog(this, "Usted no cuenta con los permisos para ingresar a esta sección");
        
    }//GEN-LAST:event_ReportButtonMouseClicked

    private void LogOutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutButtonMouseClicked
        UserSession.setUsuario(null);
        this.dispose();
        InactividadUtil.detenerTemporizador();
        login.setVisible(true);
    }//GEN-LAST:event_LogOutButtonMouseClicked

    private void ProductButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductButtonMouseClicked
        Productos pro = new Productos();
        pro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ProductButtonMouseClicked

    private void ClientesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClientesButtonMouseClicked
        Clientes cli = new Clientes();
        cli.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ClientesButtonMouseClicked

    private void VentasButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VentasButtonMouseClicked
        Venta ven = new Venta();
        ven.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_VentasButtonMouseClicked

    private void BoletaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BoletaButtonMouseClicked
        Boletas b = new Boletas();
        b.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BoletaButtonMouseClicked

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (usuario == null) {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error en el inicio de sesión",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    login.setVisible(true);
                } else {
                    new Principal().setVisible(true);
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private util.PanelRound BoletaButton;
    private javax.swing.JLabel BoletaLbl;
    private javax.swing.JLabel ClienteLbl;
    private util.PanelRound ClientesButton;
    private util.PanelRound HomeButton;
    private javax.swing.JLabel HomeLbl;
    private javax.swing.JPanel Inicio;
    private util.PanelRound LogOutButton;
    private javax.swing.JLabel Logoutlbl;
    private util.PanelRound ProductButton;
    private javax.swing.JLabel ProductLbl;
    private util.PanelRound ReportButton;
    private javax.swing.JLabel ReportLbl;
    private util.PanelRound UserButton;
    private javax.swing.JLabel UserLbl;
    private util.PanelRound VentasButton;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private util.PanelRound menu;
    private javax.swing.JLabel ventaLbl;
    // End of variables declaration//GEN-END:variables
}
