package Vistas.Usuario;

import Controlador.UsuarioController;
import Vistas.Producto.Productos;
import ModeloDTO.UsuarioDTO;
import Vistas.Boleta.Boletas;
import Vistas.Cliente.Clientes;
import Vistas.Login;
import Vistas.Principal;
import Vistas.Venta.Venta;
import config.UserSession;
import java.awt.Color;
import javax.swing.JOptionPane;
import util.ColorMethods;
import util.ImageLoader;

public class Usuarios extends javax.swing.JFrame {
    static Login login = new Login();
    static UsuarioDTO usuario = UserSession.getUsuario();
    static boolean Ven = false;

    public Usuarios() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        usuario = UserSession.getUsuario();
        Ven = false;
        
        if (usuario.getRol().getCodigo() == 1) {
            Ven = true;
            ReportButton.setBackground(new Color(110, 16, 80));
            UserButton.setBackground(new Color(110, 16, 80));
        }
        
        UsuarioController.mostrarCabecera(TableUser);
        ColorMethods.Entered(UserButton);
        UsuarioController.listarTabla();
        
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
        ImageLoader.setImageToLabelFromResources(Search, "/imagenes/search.png");
        
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

        Users = new javax.swing.JPanel();
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
        DeleteButton = new util.PanelRound();
        jLabel4 = new javax.swing.JLabel();
        EditButton = new util.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        LogOutButton = new util.PanelRound();
        Logoutlbl = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        AddButton = new util.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableUser = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        Search = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        Users.setBackground(new java.awt.Color(254, 235, 241));
        Users.setForeground(new java.awt.Color(255, 255, 255));
        Users.setToolTipText("");
        Users.setPreferredSize(new java.awt.Dimension(806, 500));
        Users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UsersMouseClicked(evt);
            }
        });
        Users.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Ordenar por:");
        Users.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 126, -1, 20));

        cbxOrder.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Nombre", "Rol", "Correo" }));
        cbxOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOrderActionPerformed(evt);
            }
        });
        Users.add(cbxOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 210, 30));

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

        Users.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 90, 480));

        DeleteButton.setBackground(new java.awt.Color(255, 51, 51));
        DeleteButton.setRoundBottomLeft(15);
        DeleteButton.setRoundBottomRight(15);
        DeleteButton.setRoundTopLeft(15);
        DeleteButton.setRoundTopRight(15);
        DeleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeleteButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DeleteButtonMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ELIMINAR");

        javax.swing.GroupLayout DeleteButtonLayout = new javax.swing.GroupLayout(DeleteButton);
        DeleteButton.setLayout(DeleteButtonLayout);
        DeleteButtonLayout.setHorizontalGroup(
            DeleteButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeleteButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );
        DeleteButtonLayout.setVerticalGroup(
            DeleteButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeleteButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        Users.add(DeleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 460, 140, 40));

        EditButton.setBackground(new java.awt.Color(255, 96, 205));
        EditButton.setRoundBottomLeft(15);
        EditButton.setRoundBottomRight(15);
        EditButton.setRoundTopLeft(15);
        EditButton.setRoundTopRight(15);
        EditButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EditButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EditButtonMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EDITAR");

        javax.swing.GroupLayout EditButtonLayout = new javax.swing.GroupLayout(EditButton);
        EditButton.setLayout(EditButtonLayout);
        EditButtonLayout.setHorizontalGroup(
            EditButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EditButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );
        EditButtonLayout.setVerticalGroup(
            EditButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EditButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        Users.add(EditButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, 140, 40));

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

        Users.add(LogOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 50, -1));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(204, 204, 204));
        txtSearch.setText("Buscar por nombre");
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        Users.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 580, 30));

        AddButton.setBackground(new java.awt.Color(189, 29, 139));
        AddButton.setRoundBottomLeft(15);
        AddButton.setRoundBottomRight(15);
        AddButton.setRoundTopLeft(15);
        AddButton.setRoundTopRight(15);
        AddButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddButtonMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("AÑADIR");

        javax.swing.GroupLayout AddButtonLayout = new javax.swing.GroupLayout(AddButton);
        AddButton.setLayout(AddButtonLayout);
        AddButtonLayout.setHorizontalGroup(
            AddButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );
        AddButtonLayout.setVerticalGroup(
            AddButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        Users.add(AddButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 140, 40));

        TableUser.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TableUser);

        Users.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 620, 290));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(109, 18, 63));
        jLabel3.setText("Usuarios");
        Users.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));
        Users.add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 30, 30));

        bg.setFocusable(false);
        bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bgMouseClicked(evt);
            }
        });
        Users.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 520));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Users, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Users, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReportButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportButtonMouseEntered
        ColorMethods.Entered(ReportButton);
    }//GEN-LAST:event_ReportButtonMouseEntered

    private void ReportButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportButtonMouseExited
        ColorMethods.Exited(ReportButton);
    }//GEN-LAST:event_ReportButtonMouseExited

    private void UserButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserButtonMouseEntered
        ColorMethods.Entered(UserButton);
    }//GEN-LAST:event_UserButtonMouseEntered

    private void UserButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserButtonMouseExited
        
    }//GEN-LAST:event_UserButtonMouseExited

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
        ColorMethods.Exited(BoletaButton);
    }//GEN-LAST:event_BoletaButtonMouseExited

    private void VentasButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VentasButtonMouseEntered
        ColorMethods.Entered(VentasButton);
    }//GEN-LAST:event_VentasButtonMouseEntered

    private void VentasButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VentasButtonMouseExited
        ColorMethods.Exited(VentasButton);
    }//GEN-LAST:event_VentasButtonMouseExited

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

    private void LogOutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutButtonMouseEntered
        ColorMethods.Entered(LogOutButton);
    }//GEN-LAST:event_LogOutButtonMouseEntered

    private void LogOutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutButtonMouseExited
        ColorMethods.Exited(LogOutButton);
    }//GEN-LAST:event_LogOutButtonMouseExited

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        if (txtSearch.getText().equals("Buscar por nombre")) { 
            txtSearch.setText(""); 
            txtSearch.setForeground(Color.BLACK); 
        }
    }//GEN-LAST:event_txtSearchFocusGained

    private void UserButtonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UserButtonFocusGained
        
    }//GEN-LAST:event_UserButtonFocusGained

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        UserButton.requestFocusInWindow();
    }//GEN-LAST:event_formWindowOpened

    private void HomeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeButtonMouseClicked
       Principal p = new Principal();
       p.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_HomeButtonMouseClicked

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText().isEmpty()) {
            txtSearch.setText("Buscar por nombre"); 
            txtSearch.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void UserButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserButtonMouseClicked
        UserButton.requestFocusInWindow();
    }//GEN-LAST:event_UserButtonMouseClicked

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
         txtSearch.requestFocusInWindow();
         TableUser.clearSelection();
    }//GEN-LAST:event_txtSearchMouseClicked

    private void AddButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButtonMouseEntered
        ColorMethods.Entered(AddButton);
    }//GEN-LAST:event_AddButtonMouseEntered

    private void AddButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButtonMouseExited
        ColorMethods.Exited(AddButton);
    }//GEN-LAST:event_AddButtonMouseExited

    private void EditButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditButtonMouseExited
        ColorMethods.Exited(EditButton, new Color(255,96,205));
    }//GEN-LAST:event_EditButtonMouseExited

    private void EditButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditButtonMouseEntered
        ColorMethods.Entered(EditButton, new Color(204, 76, 164));
    }//GEN-LAST:event_EditButtonMouseEntered

    private void DeleteButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButtonMouseExited
        ColorMethods.Exited(DeleteButton, new Color(255,51,51));
    }//GEN-LAST:event_DeleteButtonMouseExited

    private void DeleteButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButtonMouseEntered
       ColorMethods.Entered(DeleteButton, new Color(211,54,30));
    }//GEN-LAST:event_DeleteButtonMouseEntered

    private void bgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMouseClicked
        
    }//GEN-LAST:event_bgMouseClicked

    private void UsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsersMouseClicked

    }//GEN-LAST:event_UsersMouseClicked

    private void AddButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButtonMouseClicked
        AddUser au = new AddUser();
        au.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AddButtonMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String nombre = txtSearch.getText();
    
        if (!nombre.isEmpty()) {
            UsuarioController.listarTabla(UsuarioController.busquedaSecuencial(nombre));
        } else {
            UsuarioController.listarTabla();
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void DeleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButtonMouseClicked
        boolean usuarioLogueadoEliminado = UsuarioController.EliminarUsuario(TableUser);
        
        if (usuarioLogueadoEliminado) {
            this.dispose();
            login.setVisible(true);
        } else {
            txtSearch.setText("Buscar por nombre");
            txtSearch.setForeground(Color.GRAY);
            UsuarioController.listarTabla();
        }
    }//GEN-LAST:event_DeleteButtonMouseClicked

    private void EditButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditButtonMouseClicked
        EditUser e = new EditUser(UsuarioController.SeleccionEdicion(TableUser));
        e.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_EditButtonMouseClicked

    private void LogOutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutButtonMouseClicked
        UserSession.setUsuario(null);
        this.dispose();
        login.setVisible(true);
    }//GEN-LAST:event_LogOutButtonMouseClicked

    private void cbxOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOrderActionPerformed
        int index = cbxOrder.getSelectedIndex();
        UsuarioController.listarTabla(UsuarioController.ordenamiento(index));
    }//GEN-LAST:event_cbxOrderActionPerformed

    private void ReportButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportButtonMouseClicked
        if (!Ven){
            
        } else {
            JOptionPane.showMessageDialog(this, "Usted no cuenta con los permisos para ingresar a esta sección");
        }
    }//GEN-LAST:event_ReportButtonMouseClicked

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
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (Ven || usuario == null) {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error en el inicio de sesión",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    login.setVisible(true);
                } else {
                    new Usuarios().setVisible(true);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private util.PanelRound AddButton;
    private util.PanelRound BoletaButton;
    private javax.swing.JLabel BoletaLbl;
    private javax.swing.JLabel ClienteLbl;
    private util.PanelRound ClientesButton;
    private util.PanelRound DeleteButton;
    private util.PanelRound EditButton;
    private util.PanelRound HomeButton;
    private javax.swing.JLabel HomeLbl;
    private util.PanelRound LogOutButton;
    private javax.swing.JLabel Logoutlbl;
    private util.PanelRound ProductButton;
    private javax.swing.JLabel ProductLbl;
    private util.PanelRound ReportButton;
    private javax.swing.JLabel ReportLbl;
    private javax.swing.JLabel Search;
    private javax.swing.JTable TableUser;
    private util.PanelRound UserButton;
    private javax.swing.JLabel UserLbl;
    private javax.swing.JPanel Users;
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
    private javax.swing.JTextField txtSearch;
    private javax.swing.JLabel ventaLbl;
    // End of variables declaration//GEN-END:variables
}
