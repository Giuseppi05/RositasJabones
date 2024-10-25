
package Vistas.Boleta;

import Controlador.BoletaController;
import ModeloDAO.BoletaDAO;
import ModeloDTO.UsuarioDTO;
import Vistas.Cliente.Clientes;
import Vistas.Login;
import Vistas.Principal;
import Vistas.Producto.Productos;
import Vistas.Usuario.Usuarios;
import Vistas.Venta.Venta;
import config.UserSession;
import java.awt.Color;
import javax.swing.JOptionPane;
import util.ColorMethods;
import util.ImageLoader;

public class Boletas extends javax.swing.JFrame {
    static Login login = new Login();
    static UsuarioDTO usuario = UserSession.getUsuario();
    static boolean Ven = false;
    static BoletaDAO bd = new BoletaDAO();
    
    public Boletas() {
        initComponents();
        this.setLocationRelativeTo(null);
       
        
        usuario = UserSession.getUsuario();
        Ven = false;
        
        if (usuario.getRol().getCodigo() == 1) {
            Ven = true;
            ReportButton.setBackground(new Color(110, 16, 80));
            UserButton.setBackground(new Color(110, 16, 80));
        }
        
        BoletaController.mostrarCabecera(TableBoletas);
        ColorMethods.Entered(BoletaButton);
        BoletaController.listar();
        
        //IMAGENES
        ImageLoader.setImageToLabelFromResources(bg, "/imagenes/fondo.png");
        ImageLoader.setImageToLabelFromResources(HomeLbl, "/imagenes/home.png");
        ImageLoader.setImageToLabelFromResources(ProductLbl, "/imagenes/product.png");
        ImageLoader.setImageToLabelFromResources(ventaLbl, "/imagenes/ventas.png");
        ImageLoader.setImageToLabelFromResources(BoletaLbl, "/imagenes/boleta.png");
        ImageLoader.setImageToLabelFromResources(ClienteLbl, "/imagenes/clientes.png");
        ImageLoader.setImageToLabelFromResources(UserLbl, "/imagenes/user.png");
        ImageLoader.setImageToLabelFromResources(ReportLbl, "/imagenes/report.png");
        ImageLoader.setImageToLabelFromResources(Logoutlbl, "/imagenes/logout.png");
        
        //TOOLTIPS
        HomeButton.setToolTipText("Home");
        ProductButton.setToolTipText("Productos");
        VentasButton.setToolTipText("Ventas");
        BoletaButton.setToolTipText("Boleta");
        ClientesButton.setToolTipText("Clientes");
        UserButton.setToolTipText("Usuarios");
        ReportButton.setToolTipText("Reportes");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Boletas = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbxOrder = new javax.swing.JComboBox<>();
        menu = new util.PanelRound();
        ReportButton = new util.PanelRound();
        ReportLbl = new javax.swing.JLabel();
        UserButton = new util.PanelRound();
        UserLbl = new javax.swing.JLabel();
        ClientesButton = new util.PanelRound();
        ClienteLbl = new javax.swing.JLabel();
        BoletaButton = new util.PanelRound();
        BoletaLbl = new javax.swing.JLabel();
        VentasButton = new util.PanelRound();
        ventaLbl = new javax.swing.JLabel();
        ProductButton = new util.PanelRound();
        ProductLbl = new javax.swing.JLabel();
        HomeButton = new util.PanelRound();
        HomeLbl = new javax.swing.JLabel();
        LogOutButton = new util.PanelRound();
        Logoutlbl = new javax.swing.JLabel();
        ExpandButton = new util.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        FilterButton = new util.PanelRound();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableBoletas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        Search = new javax.swing.JLabel();
        DateSelect = new com.toedter.calendar.JDateChooser();
        CleanButton = new util.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Boletas.setBackground(new java.awt.Color(254, 235, 241));
        Boletas.setForeground(new java.awt.Color(255, 255, 255));
        Boletas.setToolTipText("");
        Boletas.setPreferredSize(new java.awt.Dimension(806, 500));
        Boletas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BoletasMouseClicked(evt);
            }
        });
        Boletas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Ordenar por:");
        Boletas.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 126, -1, 20));

        cbxOrder.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Usuario", "Cliente", "Fecha", "Total" }));
        cbxOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOrderActionPerformed(evt);
            }
        });
        Boletas.add(cbxOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 210, 30));

        menu.setBackground(new java.awt.Color(189, 29, 139));
        menu.setForeground(new java.awt.Color(255, 241, 235));
        menu.setRoundBottomLeft(100);
        menu.setRoundBottomRight(100);
        menu.setRoundTopLeft(100);
        menu.setRoundTopRight(100);
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

        ReportLbl.setFocusable(false);

        javax.swing.GroupLayout ReportButtonLayout = new javax.swing.GroupLayout(ReportButton);
        ReportButton.setLayout(ReportButtonLayout);
        ReportButtonLayout.setHorizontalGroup(
            ReportButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReportButtonLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(ReportLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        ReportButtonLayout.setVerticalGroup(
            ReportButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReportButtonLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(ReportLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menu.add(ReportButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 70, 50));

        UserButton.setBackground(new java.awt.Color(189, 29, 139));
        UserButton.setRoundBottomLeft(15);
        UserButton.setRoundBottomRight(15);
        UserButton.setRoundTopLeft(15);
        UserButton.setRoundTopRight(15);
        UserButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UserButtonFocusGained(evt);
            }
        });
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

        UserLbl.setFocusable(false);

        javax.swing.GroupLayout UserButtonLayout = new javax.swing.GroupLayout(UserButton);
        UserButton.setLayout(UserButtonLayout);
        UserButtonLayout.setHorizontalGroup(
            UserButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UserButtonLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(UserLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        UserButtonLayout.setVerticalGroup(
            UserButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UserButtonLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(UserLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menu.add(UserButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 70, 50));

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

        ClienteLbl.setFocusable(false);

        javax.swing.GroupLayout ClientesButtonLayout = new javax.swing.GroupLayout(ClientesButton);
        ClientesButton.setLayout(ClientesButtonLayout);
        ClientesButtonLayout.setHorizontalGroup(
            ClientesButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ClientesButtonLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(ClienteLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        ClientesButtonLayout.setVerticalGroup(
            ClientesButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ClientesButtonLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(ClienteLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menu.add(ClientesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 70, 50));

        BoletaButton.setBackground(new java.awt.Color(189, 29, 139));
        BoletaButton.setRoundBottomLeft(15);
        BoletaButton.setRoundBottomRight(15);
        BoletaButton.setRoundTopLeft(15);
        BoletaButton.setRoundTopRight(15);
        BoletaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BoletaButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BoletaButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BoletaButtonMousePressed(evt);
            }
        });

        BoletaLbl.setFocusable(false);

        javax.swing.GroupLayout BoletaButtonLayout = new javax.swing.GroupLayout(BoletaButton);
        BoletaButton.setLayout(BoletaButtonLayout);
        BoletaButtonLayout.setHorizontalGroup(
            BoletaButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BoletaButtonLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(BoletaLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        BoletaButtonLayout.setVerticalGroup(
            BoletaButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BoletaButtonLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(BoletaLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menu.add(BoletaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 70, 50));

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

        ventaLbl.setFocusable(false);

        javax.swing.GroupLayout VentasButtonLayout = new javax.swing.GroupLayout(VentasButton);
        VentasButton.setLayout(VentasButtonLayout);
        VentasButtonLayout.setHorizontalGroup(
            VentasButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VentasButtonLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(ventaLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        VentasButtonLayout.setVerticalGroup(
            VentasButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VentasButtonLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(ventaLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menu.add(VentasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 70, 50));

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

        ProductLbl.setFocusable(false);

        javax.swing.GroupLayout ProductButtonLayout = new javax.swing.GroupLayout(ProductButton);
        ProductButton.setLayout(ProductButtonLayout);
        ProductButtonLayout.setHorizontalGroup(
            ProductButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductButtonLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(ProductLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        ProductButtonLayout.setVerticalGroup(
            ProductButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductButtonLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(ProductLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menu.add(ProductButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 70, 50));

        HomeButton.setBackground(new java.awt.Color(189, 29, 139));
        HomeButton.setRoundBottomLeft(15);
        HomeButton.setRoundBottomRight(15);
        HomeButton.setRoundTopLeft(15);
        HomeButton.setRoundTopRight(15);
        HomeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HomeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HomeButtonMouseExited(evt);
            }
        });

        HomeLbl.setFocusable(false);

        javax.swing.GroupLayout HomeButtonLayout = new javax.swing.GroupLayout(HomeButton);
        HomeButton.setLayout(HomeButtonLayout);
        HomeButtonLayout.setHorizontalGroup(
            HomeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeButtonLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(HomeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        HomeButtonLayout.setVerticalGroup(
            HomeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeButtonLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(HomeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menu.add(HomeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 70, 50));

        Boletas.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 90, 480));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogOutButtonLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(Logoutlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        LogOutButtonLayout.setVerticalGroup(
            LogOutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogOutButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Logoutlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Boletas.add(LogOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 50, -1));

        ExpandButton.setBackground(new java.awt.Color(189, 29, 139));
        ExpandButton.setRoundBottomLeft(15);
        ExpandButton.setRoundBottomRight(15);
        ExpandButton.setRoundTopLeft(15);
        ExpandButton.setRoundTopRight(15);
        ExpandButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExpandButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExpandButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExpandButtonMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("EXPANDIR");

        javax.swing.GroupLayout ExpandButtonLayout = new javax.swing.GroupLayout(ExpandButton);
        ExpandButton.setLayout(ExpandButtonLayout);
        ExpandButtonLayout.setHorizontalGroup(
            ExpandButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExpandButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );
        ExpandButtonLayout.setVerticalGroup(
            ExpandButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExpandButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        Boletas.add(ExpandButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 460, 140, 40));

        FilterButton.setBackground(new java.awt.Color(189, 29, 139));
        FilterButton.setRoundBottomLeft(15);
        FilterButton.setRoundBottomRight(15);
        FilterButton.setRoundTopLeft(15);
        FilterButton.setRoundTopRight(15);
        FilterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FilterButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FilterButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FilterButtonMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("FILTRAR");

        javax.swing.GroupLayout FilterButtonLayout = new javax.swing.GroupLayout(FilterButton);
        FilterButton.setLayout(FilterButtonLayout);
        FilterButtonLayout.setHorizontalGroup(
            FilterButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FilterButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );
        FilterButtonLayout.setVerticalGroup(
            FilterButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        Boletas.add(FilterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 90, 30));

        TableBoletas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TableBoletas);

        Boletas.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 620, 290));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(109, 18, 63));
        jLabel3.setText("Boletas");
        Boletas.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        Search.setText("Filtrar por fecha:");
        Boletas.add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 90, 30));
        Boletas.add(DateSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 200, 30));

        CleanButton.setBackground(new java.awt.Color(255, 96, 205));
        CleanButton.setRoundBottomLeft(15);
        CleanButton.setRoundBottomRight(15);
        CleanButton.setRoundTopLeft(15);
        CleanButton.setRoundTopRight(15);
        CleanButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CleanButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CleanButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CleanButtonMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LIMPIAR");

        javax.swing.GroupLayout CleanButtonLayout = new javax.swing.GroupLayout(CleanButton);
        CleanButton.setLayout(CleanButtonLayout);
        CleanButtonLayout.setHorizontalGroup(
            CleanButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CleanButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );
        CleanButtonLayout.setVerticalGroup(
            CleanButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        Boletas.add(CleanButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 90, 30));

        bg.setFocusable(false);
        bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bgMouseClicked(evt);
            }
        });
        Boletas.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 520));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Boletas, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Boletas, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOrderActionPerformed
        int index = cbxOrder.getSelectedIndex();
        BoletaController.listar(BoletaController.ordenamiento(index));
    }//GEN-LAST:event_cbxOrderActionPerformed

    private void ReportButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportButtonMouseClicked
        if (!Ven){

        } else {
            JOptionPane.showMessageDialog(this, "Usted no cuenta con los permisos para ingresar a esta sección");
        }
    }//GEN-LAST:event_ReportButtonMouseClicked

    private void ReportButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportButtonMouseEntered
        if(!Ven)
        ColorMethods.Entered(ReportButton);
    }//GEN-LAST:event_ReportButtonMouseEntered

    private void ReportButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportButtonMouseExited
        if(!Ven)
        ColorMethods.Exited(ReportButton);
    }//GEN-LAST:event_ReportButtonMouseExited

    private void UserButtonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UserButtonFocusGained

    }//GEN-LAST:event_UserButtonFocusGained

    private void UserButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserButtonMouseClicked
        if (!Ven) {
            Usuarios u = new Usuarios();
            u.setVisible(true);
            this.dispose();
        } else
        JOptionPane.showMessageDialog(this, "Usted no cuenta con los permisos para ingresar a esta sección");
    }//GEN-LAST:event_UserButtonMouseClicked

    private void UserButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserButtonMouseEntered
        if(!Ven)
        ColorMethods.Entered(UserButton);
    }//GEN-LAST:event_UserButtonMouseEntered

    private void UserButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserButtonMouseExited
        if(!Ven)
        ColorMethods.Exited(UserButton);
    }//GEN-LAST:event_UserButtonMouseExited

    private void ClientesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClientesButtonMouseClicked
        Clientes c = new Clientes();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ClientesButtonMouseClicked

    private void ClientesButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClientesButtonMouseEntered
        ColorMethods.Entered(ClientesButton);
    }//GEN-LAST:event_ClientesButtonMouseEntered

    private void ClientesButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClientesButtonMouseExited
         ColorMethods.Exited(ClientesButton);
    }//GEN-LAST:event_ClientesButtonMouseExited

    private void BoletaButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BoletaButtonMouseEntered
        ColorMethods.Entered(BoletaButton);
    }//GEN-LAST:event_BoletaButtonMouseEntered

    private void BoletaButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BoletaButtonMouseExited
      
    }//GEN-LAST:event_BoletaButtonMouseExited

    private void VentasButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VentasButtonMouseClicked
        Venta ven = new Venta();
        ven.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_VentasButtonMouseClicked

    private void VentasButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VentasButtonMouseEntered
        ColorMethods.Entered(VentasButton);
    }//GEN-LAST:event_VentasButtonMouseEntered

    private void VentasButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VentasButtonMouseExited
        ColorMethods.Exited(VentasButton);
    }//GEN-LAST:event_VentasButtonMouseExited

    private void ProductButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductButtonMouseClicked
        Productos pro = new Productos();
        pro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ProductButtonMouseClicked

    private void ProductButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductButtonMouseEntered
        ColorMethods.Entered(ProductButton);
    }//GEN-LAST:event_ProductButtonMouseEntered

    private void ProductButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductButtonMouseExited
        ColorMethods.Exited(ProductButton);
    }//GEN-LAST:event_ProductButtonMouseExited

    private void HomeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeButtonMouseClicked
        Principal p = new Principal();
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_HomeButtonMouseClicked

    private void HomeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeButtonMouseEntered
        ColorMethods.Entered(HomeButton);
    }//GEN-LAST:event_HomeButtonMouseEntered

    private void HomeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeButtonMouseExited
        ColorMethods.Exited(HomeButton);
    }//GEN-LAST:event_HomeButtonMouseExited

    private void LogOutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutButtonMouseClicked
        UserSession.setUsuario(null);
        this.dispose();
        login.setVisible(true);
    }//GEN-LAST:event_LogOutButtonMouseClicked

    private void LogOutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutButtonMouseEntered
        ColorMethods.Entered(LogOutButton);
    }//GEN-LAST:event_LogOutButtonMouseEntered

    private void LogOutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutButtonMouseExited
        ColorMethods.Exited(LogOutButton);
    }//GEN-LAST:event_LogOutButtonMouseExited

    private void ExpandButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExpandButtonMouseClicked
        int fila = TableBoletas.getSelectedRow();
        if (fila != -1) {
            DetalleBoleta dbi = new DetalleBoleta(bd.listarUno(TableBoletas.getValueAt(fila, 0)+""));
            dbi.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_ExpandButtonMouseClicked

    private void ExpandButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExpandButtonMouseEntered
        ColorMethods.Entered(ExpandButton);
    }//GEN-LAST:event_ExpandButtonMouseEntered

    private void ExpandButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExpandButtonMouseExited
        ColorMethods.Exited(ExpandButton);
    }//GEN-LAST:event_ExpandButtonMouseExited

    private void bgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMouseClicked

    }//GEN-LAST:event_bgMouseClicked

    private void BoletasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BoletasMouseClicked

    }//GEN-LAST:event_BoletasMouseClicked

    private void CleanButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanButtonMouseClicked
        DateSelect.setDate(null);
        BoletaController.listar();
    }//GEN-LAST:event_CleanButtonMouseClicked

    private void CleanButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanButtonMouseEntered
        ColorMethods.Entered(CleanButton, new Color(204, 76, 164));
    }//GEN-LAST:event_CleanButtonMouseEntered

    private void CleanButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanButtonMouseExited
        ColorMethods.Exited(CleanButton, new Color(255,96,205));
    }//GEN-LAST:event_CleanButtonMouseExited

    private void FilterButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FilterButtonMouseClicked
        BoletaController.listar(BoletaController.filtrarPorFecha(DateSelect));
    }//GEN-LAST:event_FilterButtonMouseClicked

    private void FilterButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FilterButtonMouseEntered
        ColorMethods.Entered(FilterButton);
    }//GEN-LAST:event_FilterButtonMouseEntered

    private void FilterButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FilterButtonMouseExited
        ColorMethods.Exited(FilterButton);
    }//GEN-LAST:event_FilterButtonMouseExited

    private void BoletaButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BoletaButtonMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoletaButtonMousePressed

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
            java.util.logging.Logger.getLogger(Boletas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Boletas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Boletas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Boletas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (usuario == null) {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error en el inicio de sesión",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    
                    login.setVisible(true);
                } else 
                    new Boletas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private util.PanelRound BoletaButton;
    private javax.swing.JLabel BoletaLbl;
    private javax.swing.JPanel Boletas;
    private util.PanelRound CleanButton;
    private javax.swing.JLabel ClienteLbl;
    private util.PanelRound ClientesButton;
    private com.toedter.calendar.JDateChooser DateSelect;
    private util.PanelRound ExpandButton;
    private util.PanelRound FilterButton;
    private util.PanelRound HomeButton;
    private javax.swing.JLabel HomeLbl;
    private util.PanelRound LogOutButton;
    private javax.swing.JLabel Logoutlbl;
    private util.PanelRound ProductButton;
    private javax.swing.JLabel ProductLbl;
    private util.PanelRound ReportButton;
    private javax.swing.JLabel ReportLbl;
    private javax.swing.JLabel Search;
    private javax.swing.JTable TableBoletas;
    private util.PanelRound UserButton;
    private javax.swing.JLabel UserLbl;
    private util.PanelRound VentasButton;
    private javax.swing.JLabel bg;
    private javax.swing.JComboBox<String> cbxOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private util.PanelRound menu;
    private javax.swing.JLabel ventaLbl;
    // End of variables declaration//GEN-END:variables
}
