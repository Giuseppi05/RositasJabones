package Vistas.Venta;

import Controlador.ClienteController;
import Controlador.ProductosController;
import Controlador.VentaController;
import ModeloDTO.ClienteDTO;
import ModeloDTO.ProductoDTO;
import ModeloDTO.UsuarioDTO;
import Vistas.Boleta.Boletas;
import Vistas.Boleta.DetalleBoleta;
import Vistas.Cliente.Clientes;
import Vistas.Login;
import Vistas.Principal;
import Vistas.Producto.Productos;
import Vistas.Reportes.Reportes;
import Vistas.Usuario.Usuarios;
import config.UserSession;
import java.awt.Color;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import util.ColorMethods;
import util.ImageLoader;
import util.InactividadUtil;

public class Venta extends javax.swing.JFrame {

    static Login login = new Login();
    static UsuarioDTO usuario = UserSession.getUsuario();
    static boolean Ven = false;

    ClienteDTO cliente = new ClienteDTO();
    ProductoDTO producto;

    public Venta() {
        initComponents();
        this.setLocationRelativeTo(null);

        ColorMethods.Entered(VentasButton);

        cliente = new ClienteDTO();
        producto = new ProductoDTO();
        usuario = UserSession.getUsuario();
        Ven = false;

        AutoCompleteDecorator.decorate(cbxClient);
        AutoCompleteDecorator.decorate(cbxProducts);
        VentaController.ModelSpinnerCantidad(spnCantidad);
        VentaController.mostrarCabecera(TableVenta);

        ClienteController.mostrarClientes(cbxClient);
        ProductosController.mostrarProductos(cbxProducts);

        txtTotal.setText(VentaController.calcularTotal(TableVenta) + "");

        if (usuario.getRol().getCodigo() == 1) {
            Ven = true;
            ReportButton.setBackground(new Color(110, 16, 80));
            UserButton.setBackground(new Color(110, 16, 80));
        }

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

        InactividadUtil.activarTemporizador(this);
    }

    public Float calcularSubtotal(Float precio) {
        int cantidad = (Integer) spnCantidad.getValue();
        return precio * cantidad;
    }

    public void mostrarDatosProducto() {
        txtPrecio.setText(producto.getPrecio() + "");

        int StockRestante = VentaController.calcularStockRestante(producto, TableVenta);
        txtStock.setText(StockRestante + "");

        VentaController.MaxSpinnerProducto(spnCantidad, StockRestante);

        txtSubtotal.setText(calcularSubtotal(producto.getPrecio()) + "");

        if (producto.getVencimiento() == null) {
            txtFecha.setText("No vence");
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fechaFormateada = sdf.format(producto.getVencimiento());
            txtFecha.setText(fechaFormateada);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Users = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbxClient = new javax.swing.JComboBox<>();
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
        CancelBtn = new util.PanelRound();
        jLabel4 = new javax.swing.JLabel();
        btnSearch = new util.PanelRound();
        jLabel7 = new javax.swing.JLabel();
        DeleteButton = new util.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        LogOutButton = new util.PanelRound();
        Logoutlbl = new javax.swing.JLabel();
        ProcessBtn = new util.PanelRound();
        jLabel14 = new javax.swing.JLabel();
        AddButton = new util.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableVenta = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        Search = new javax.swing.JLabel();
        cbxProducts = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        spnCantidad = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

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

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ó");
        Users.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 20, 30));

        cbxClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxClientActionPerformed(evt);
            }
        });
        Users.add(cbxClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 300, 30));

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

        CancelBtn.setBackground(new java.awt.Color(255, 51, 51));
        CancelBtn.setRoundBottomLeft(15);
        CancelBtn.setRoundBottomRight(15);
        CancelBtn.setRoundTopLeft(15);
        CancelBtn.setRoundTopRight(15);
        CancelBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CancelBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CancelBtnMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CANCELAR");

        javax.swing.GroupLayout CancelBtnLayout = new javax.swing.GroupLayout(CancelBtn);
        CancelBtn.setLayout(CancelBtnLayout);
        CancelBtnLayout.setHorizontalGroup(
            CancelBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CancelBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );
        CancelBtnLayout.setVerticalGroup(
            CancelBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CancelBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        Users.add(CancelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 460, 140, 40));

        btnSearch.setBackground(new java.awt.Color(255, 96, 205));
        btnSearch.setRoundBottomLeft(15);
        btnSearch.setRoundBottomRight(15);
        btnSearch.setRoundTopLeft(15);
        btnSearch.setRoundTopRight(15);
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchMouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("BUSCAR POR N° DOC");

        javax.swing.GroupLayout btnSearchLayout = new javax.swing.GroupLayout(btnSearch);
        btnSearch.setLayout(btnSearchLayout);
        btnSearchLayout.setHorizontalGroup(
            btnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnSearchLayout.setVerticalGroup(
            btnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        Users.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 170, 30));

        DeleteButton.setBackground(new java.awt.Color(255, 96, 205));
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

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUITAR");

        javax.swing.GroupLayout DeleteButtonLayout = new javax.swing.GroupLayout(DeleteButton);
        DeleteButton.setLayout(DeleteButtonLayout);
        DeleteButtonLayout.setHorizontalGroup(
            DeleteButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeleteButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );
        DeleteButtonLayout.setVerticalGroup(
            DeleteButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        Users.add(DeleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 190, 90, 30));

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

        ProcessBtn.setBackground(new java.awt.Color(189, 29, 139));
        ProcessBtn.setRoundBottomLeft(15);
        ProcessBtn.setRoundBottomRight(15);
        ProcessBtn.setRoundTopLeft(15);
        ProcessBtn.setRoundTopRight(15);
        ProcessBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProcessBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProcessBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProcessBtnMouseExited(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("PROCESAR");

        javax.swing.GroupLayout ProcessBtnLayout = new javax.swing.GroupLayout(ProcessBtn);
        ProcessBtn.setLayout(ProcessBtnLayout);
        ProcessBtnLayout.setHorizontalGroup(
            ProcessBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProcessBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addContainerGap())
        );
        ProcessBtnLayout.setVerticalGroup(
            ProcessBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProcessBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        Users.add(ProcessBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 460, 130, 40));

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

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("AÑADIR");

        javax.swing.GroupLayout AddButtonLayout = new javax.swing.GroupLayout(AddButton);
        AddButton.setLayout(AddButtonLayout);
        AddButtonLayout.setHorizontalGroup(
            AddButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );
        AddButtonLayout.setVerticalGroup(
            AddButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        Users.add(AddButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, 90, 30));

        TableVenta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TableVenta);

        Users.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 640, 220));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(109, 18, 63));
        jLabel3.setText("Ventas");
        Users.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, 60));

        Search.setText("Seleccione un producto:");
        Users.add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 140, 30));

        cbxProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProductsActionPerformed(evt);
            }
        });
        Users.add(cbxProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 500, 30));

        jLabel6.setText("Precio (S/.):");
        Users.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 70, 30));

        jLabel8.setText("Seleccione un cliente:");
        Users.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, 30));

        spnCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnCantidadStateChanged(evt);
            }
        });
        Users.add(spnCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 110, 30));

        jLabel9.setText("Ingrese la cantidad:");
        Users.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 110, 30));

        txtPrecio.setEditable(false);
        txtPrecio.setFocusable(false);
        Users.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 120, 30));

        jLabel10.setText("Stock:");
        Users.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 150, 40, 30));

        txtStock.setEditable(false);
        txtStock.setFocusable(false);
        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });
        Users.add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 150, 130, 30));

        txtTotal.setEditable(false);
        txtTotal.setFocusable(false);
        Users.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, 140, 30));

        jLabel12.setText("Total (S/.):");
        Users.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 70, 30));

        txtFecha.setEditable(false);
        txtFecha.setFocusable(false);
        Users.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 120, 30));

        jLabel11.setText("Fecha de vcto:");
        Users.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 80, 30));

        jLabel13.setText("Subtotal (S/.):");
        Users.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 80, 30));

        txtSubtotal.setEditable(false);
        txtSubtotal.setFocusable(false);
        Users.add(txtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 140, 30));

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
            .addComponent(Users, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Users, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReportButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportButtonMouseClicked
        if (!Ven) {
            Reportes r = new Reportes();
            r.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usted no cuenta con los permisos para ingresar a esta sección");
        }
    }//GEN-LAST:event_ReportButtonMouseClicked

    private void ReportButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportButtonMouseEntered
        if (!Ven) {
            ColorMethods.Entered(ReportButton);
        }
    }//GEN-LAST:event_ReportButtonMouseEntered

    private void ReportButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportButtonMouseExited
        if (!Ven) {
            ColorMethods.Exited(ReportButton);;
        }
    }//GEN-LAST:event_ReportButtonMouseExited

    private void UserButtonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UserButtonFocusGained

    }//GEN-LAST:event_UserButtonFocusGained

    private void UserButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserButtonMouseClicked
        if (!Ven) {
            Usuarios u = new Usuarios();
            u.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usted no cuenta con los permisos para ingresar a esta sección");
        }
    }//GEN-LAST:event_UserButtonMouseClicked

    private void UserButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserButtonMouseEntered
        if (!Ven) {
            ColorMethods.Entered(UserButton);
        }
    }//GEN-LAST:event_UserButtonMouseEntered

    private void UserButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserButtonMouseExited
        if (!Ven) {
            ColorMethods.Exited(UserButton);
        }
    }//GEN-LAST:event_UserButtonMouseExited

    private void ClientesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClientesButtonMouseClicked
        Clientes cli = new Clientes();
        cli.setVisible(true);
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
        ColorMethods.Exited(BoletaButton);
    }//GEN-LAST:event_BoletaButtonMouseExited

    private void VentasButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VentasButtonMouseEntered
        ColorMethods.Entered(VentasButton);
    }//GEN-LAST:event_VentasButtonMouseEntered

    private void VentasButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VentasButtonMouseExited

    }//GEN-LAST:event_VentasButtonMouseExited

    private void ProductButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductButtonMouseEntered
        ColorMethods.Entered(ProductButton);
    }//GEN-LAST:event_ProductButtonMouseEntered

    private void ProductButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductButtonMouseExited
        ColorMethods.Exited(ProductButton);
    }//GEN-LAST:event_ProductButtonMouseExited

    private void HomeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeButtonMouseClicked
        Principal p = new Principal();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_HomeButtonMouseClicked

    private void HomeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeButtonMouseEntered
        ColorMethods.Entered(HomeButton);
    }//GEN-LAST:event_HomeButtonMouseEntered

    private void HomeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeButtonMouseExited
        ColorMethods.Exited(HomeButton);
    }//GEN-LAST:event_HomeButtonMouseExited

    private void DeleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButtonMouseClicked
        VentaController.QuitarTabla(TableVenta);
        mostrarDatosProducto();
        txtTotal.setText(VentaController.calcularTotal(TableVenta) + "");
    }//GEN-LAST:event_DeleteButtonMouseClicked

    private void DeleteButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButtonMouseEntered
        ColorMethods.Entered(DeleteButton, new Color(204, 76, 164));
    }//GEN-LAST:event_DeleteButtonMouseEntered

    private void DeleteButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButtonMouseExited
        ColorMethods.Exited(DeleteButton, new Color(255, 96, 205));
    }//GEN-LAST:event_DeleteButtonMouseExited

    private void LogOutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutButtonMouseClicked
        UserSession.setUsuario(null);
        this.dispose();
        InactividadUtil.detenerTemporizador();
        login.setVisible(true);
    }//GEN-LAST:event_LogOutButtonMouseClicked

    private void LogOutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutButtonMouseEntered
        ColorMethods.Entered(LogOutButton);
    }//GEN-LAST:event_LogOutButtonMouseEntered

    private void LogOutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutButtonMouseExited
        ColorMethods.Exited(LogOutButton);
    }//GEN-LAST:event_LogOutButtonMouseExited

    private void AddButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButtonMouseClicked
        int cantidad = (Integer) spnCantidad.getValue();
        float subtotal = Float.parseFloat(txtSubtotal.getText());
        int stockRestante = Integer.parseInt(txtStock.getText());

        VentaController.AñadirDetalle(producto, cantidad, subtotal, stockRestante, TableVenta);
        mostrarDatosProducto();
        txtTotal.setText(VentaController.calcularTotal(TableVenta) + "");
    }//GEN-LAST:event_AddButtonMouseClicked

    private void AddButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButtonMouseEntered
        ColorMethods.Entered(AddButton);
    }//GEN-LAST:event_AddButtonMouseEntered

    private void AddButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButtonMouseExited
        ColorMethods.Exited(AddButton);
    }//GEN-LAST:event_AddButtonMouseExited

    private void bgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMouseClicked

    }//GEN-LAST:event_bgMouseClicked

    private void UsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsersMouseClicked

    }//GEN-LAST:event_UsersMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        cliente = ClienteController.BuscarClientePorDNI(cbxClient);
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseEntered
        ColorMethods.Entered(btnSearch, new Color(204, 76, 164));
    }//GEN-LAST:event_btnSearchMouseEntered

    private void btnSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseExited
        ColorMethods.Exited(btnSearch, new Color(255, 96, 205));
    }//GEN-LAST:event_btnSearchMouseExited

    private void CancelBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelBtnMouseExited
        ColorMethods.Exited(CancelBtn, new Color(255, 51, 51));
    }//GEN-LAST:event_CancelBtnMouseExited

    private void CancelBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelBtnMouseEntered
        ColorMethods.Entered(CancelBtn, new Color(211, 54, 30));
    }//GEN-LAST:event_CancelBtnMouseEntered

    private void CancelBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelBtnMouseClicked
        float total = VentaController.calcularTotal(TableVenta);

        if (total != 0) {
            int confirm = JOptionPane.showOptionDialog(
                    null,
                    "¿Está seguro de que desea cancelar la venta?",
                    "Confirmar Cancelación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Sí", "No"},
                    "Sí"
            );

            if (confirm == JOptionPane.YES_OPTION) {
                VentaController.Limpiar(TableVenta, cbxProducts);
                mostrarDatosProducto();
                txtTotal.setText(VentaController.calcularTotal(TableVenta) + "");
            }
        } else
            JOptionPane.showMessageDialog(null, "No hay ningún producto añadido a la venta");
    }//GEN-LAST:event_CancelBtnMouseClicked

    private void ProcessBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProcessBtnMouseClicked
        int confirm = JOptionPane.showOptionDialog(
                null,
                "¿Está seguro de que desea realizar la venta?\nRevise con cuidado los datos",
                "Confirmar Venta",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Sí", "No"},
                "Sí"
        );

        if (confirm == JOptionPane.YES_OPTION) {
            if (VentaController.ProcesarBoleta(TableVenta, usuario, cliente, this)) {
                VentaController.Limpiar(TableVenta, cbxProducts);
                mostrarDatosProducto();
                txtTotal.setText(VentaController.calcularTotal(TableVenta) + "");
            }
        }
    }//GEN-LAST:event_ProcessBtnMouseClicked

    private void ProcessBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProcessBtnMouseEntered
        ColorMethods.Entered(ProcessBtn);
    }//GEN-LAST:event_ProcessBtnMouseEntered

    private void ProcessBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProcessBtnMouseExited
        ColorMethods.Exited(ProcessBtn);
    }//GEN-LAST:event_ProcessBtnMouseExited

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActionPerformed

    private void cbxClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxClientActionPerformed
        if (cbxClient.getItemCount() > 0)
            cliente = ClienteController.BuscarClienteCBX(cbxClient);
    }//GEN-LAST:event_cbxClientActionPerformed

    private void cbxProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProductsActionPerformed
        if (cbxProducts.getItemCount() > 0) {
            producto = ProductosController.BuscarProductoCBX(cbxProducts);
            mostrarDatosProducto();
        }
    }//GEN-LAST:event_cbxProductsActionPerformed

    private void spnCantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnCantidadStateChanged
        txtSubtotal.setText(calcularSubtotal(producto.getPrecio()) + "");
    }//GEN-LAST:event_spnCantidadStateChanged

    private void ProductButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductButtonMouseClicked
        Productos pro = new Productos();
        pro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ProductButtonMouseClicked

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
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                    new Venta().setVisible(true);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private util.PanelRound AddButton;
    private util.PanelRound BoletaButton;
    private javax.swing.JLabel BoletaLbl;
    private util.PanelRound CancelBtn;
    private javax.swing.JLabel ClienteLbl;
    private util.PanelRound ClientesButton;
    private util.PanelRound DeleteButton;
    private util.PanelRound HomeButton;
    private javax.swing.JLabel HomeLbl;
    private util.PanelRound LogOutButton;
    private javax.swing.JLabel Logoutlbl;
    private util.PanelRound ProcessBtn;
    private util.PanelRound ProductButton;
    private javax.swing.JLabel ProductLbl;
    private util.PanelRound ReportButton;
    private javax.swing.JLabel ReportLbl;
    private javax.swing.JLabel Search;
    private javax.swing.JTable TableVenta;
    private util.PanelRound UserButton;
    private javax.swing.JLabel UserLbl;
    private javax.swing.JPanel Users;
    private util.PanelRound VentasButton;
    private javax.swing.JLabel bg;
    private util.PanelRound btnSearch;
    private javax.swing.JComboBox<String> cbxClient;
    private javax.swing.JComboBox<String> cbxProducts;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private util.PanelRound menu;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JLabel ventaLbl;
    // End of variables declaration//GEN-END:variables
}
