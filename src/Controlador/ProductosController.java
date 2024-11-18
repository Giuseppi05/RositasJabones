package Controlador;

import ModeloDAO.ProductoDAO;
import ModeloDAO.TipoProductoDAO;
import ModeloDTO.ProductoDTO;
import ModeloDTO.TipoProductoDTO;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class ProductosController {
    //MODELODAO
    static ProductoDAO pd = new ProductoDAO();
    static TipoProductoDAO tpd = new TipoProductoDAO();
    
    //MODELODTO
    static ProductoDTO p = new ProductoDTO();
    
    //ARREGLO
    static ArrayList<ProductoDTO> listaProductos = new ArrayList<>();
    static ArrayList<TipoProductoDTO> listaTipos = new ArrayList<>();
    
    //MODELOS DE SPINNER
    static SpinnerNumberModel spnStock = new SpinnerNumberModel();
    static SpinnerNumberModel spnPrecio = new SpinnerNumberModel();
    
    //MODELO DE TABLA
    static DefaultTableModel x = new DefaultTableModel();
    
    //METODOS DE MANEJO Y MUESTRA DE DATOS
    public static void mostrarProductos(JComboBox c){
        c.removeAllItems();
        
        listaProductos = pd.listarTodo();
        
        for (int i = 0; i < listaProductos.size(); i++) {
            c.addItem(listaProductos.get(i).getNombre());
        }
    }
    
    public static void mostrarTipos(JComboBox c){
        c.removeAllItems();
        
        listaTipos = tpd.listarTodo();
        
        for (int i = 0; i < listaTipos.size(); i++) {
            c.addItem(listaTipos.get(i).getNombre());
        }
    }
    
    public static void mostrarTipos(JComboBox c, boolean filtro){
        
        c.removeAllItems();
        
        listaTipos = tpd.listarTodo();
        
        if(filtro){
            c.addItem("Todos");
        }
        
        for (int i = 0; i < listaTipos.size(); i++) {
            c.addItem(listaTipos.get(i).getNombre());
        }
    }
    
    public static ProductoDTO BuscarProductoCBX(JComboBox<String> cbx){
        listaProductos = pd.listarTodo();
        
        int selectedIndex = cbx.getSelectedIndex();

        if (selectedIndex >= 0 && selectedIndex < listaProductos.size()) {
            return listaProductos.get(selectedIndex);
        } else {
            return null;
        }
    }
    
    public static void mostrarProductoVenta(ProductoDTO p, JTextField precio, JTextField stock, JTextField st, int c){
        precio.setText(p.getPrecio()+"");
        stock.setText(p.getStock()+"");
        st.setText(p.getPrecio()*c+"");
    }
    
    public static void ModelSpinnerStock(JSpinner s){
        spnStock.setMinimum(0);
        spnStock.setValue(0);
        s.setModel(spnStock);
    }
    
    public static void ModelSpinnerPre(JSpinner s){
        spnPrecio.setMinimum(0.0);
        spnPrecio.setValue(0.0);   
        spnPrecio.setStepSize(0.1); 
        s.setModel(spnPrecio);
        s.setEditor(new JSpinner.NumberEditor(s, "#0.0"));
    }
    
    public static void mostrarCabecera(JTable t) {
        if (x.getColumnCount() == 0) {
            x.addColumn("Código");
            x.addColumn("Tipo");
            x.addColumn("Nombre");
            x.addColumn("Stock");
            x.addColumn("Precio");
            x.addColumn("Vencimiento");
            x.addColumn("Estado");
        }
        t.setModel(x);
    }
    
    public static void listar() {
        x.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
        Date fechaActual = new Date();
        
        listaProductos = pd.listarTodo();

        for (int i = 0; i < listaProductos.size(); i++) {
            Object vencimiento;
            String estado;

            if (listaProductos.get(i).getVencimiento() == null) {
                vencimiento = "No vence";
                estado = "No aplica"; 
            } else {
                Date fechaVencimiento = listaProductos.get(i).getVencimiento();
                vencimiento = sdf.format(fechaVencimiento);
                
                long diferenciaDias = TimeUnit.DAYS.convert(fechaVencimiento.getTime() - fechaActual.getTime(), TimeUnit.MILLISECONDS);

                if (diferenciaDias <= 0) {
                    estado = "Vencido"; 
                } else if (diferenciaDias <= 7) {
                    estado = "Por vencer"; 
                } else {
                    estado = "En buen estado"; 
                }
            }

            Object[] data = {
                listaProductos.get(i).getCodigo(),
                listaProductos.get(i).getTipo().getNombre(),
                listaProductos.get(i).getNombre(),
                listaProductos.get(i).getStock(),
                listaProductos.get(i).getPrecio(),
                vencimiento,
                estado 
            };

            x.addRow(data);
        }
    }
    
    public static void listar(ArrayList<ProductoDTO> datos) {
        x.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
        Date fechaActual = new Date();

        for (int i = 0; i < datos.size(); i++) {
            Object vencimiento;
            String estado;

            if (datos.get(i).getVencimiento() == null) {
                vencimiento = "No vence";
                estado = "No aplica"; 
            } else {
                Date fechaVencimiento = datos.get(i).getVencimiento();
                vencimiento = sdf.format(fechaVencimiento);
                
                long diferenciaDias = TimeUnit.DAYS.convert(fechaVencimiento.getTime() - fechaActual.getTime(), TimeUnit.MILLISECONDS);

                if (diferenciaDias <= 0) {
                    estado = "Vencido"; 
                } else if (diferenciaDias <= 7) {
                    estado = "Por vencer"; 
                } else {
                    estado = "En buen estado"; 
                }
            }

            Object[] data = {
                datos.get(i).getCodigo(),
                datos.get(i).getTipo().getNombre(),
                datos.get(i).getNombre(),
                datos.get(i).getStock(),
                datos.get(i).getPrecio(),
                vencimiento,
                estado 
            };

            x.addRow(data);
        }
    }
    
    public static ArrayList<ProductoDTO> busquedaSecuencial(String nombre) {
        ArrayList<ProductoDTO> resultados = new ArrayList<>();
        String nom= nombre.toLowerCase();
        
        listaProductos = pd.listarTodo();

        for (ProductoDTO producto : listaProductos) {
            if (producto.getNombre().toLowerCase().contains(nom)) {
                resultados.add(producto);
            }
        }
        
        return resultados;
    }
    
    public static ArrayList<ProductoDTO> ordenarProductos(int index) {
        switch (index) {
            case 0 ->
                listaProductos.sort(Comparator.comparingInt(ProductoDTO::getCodigo));
            case 1 ->
                listaProductos.sort(Comparator.comparing(ProductoDTO::getNombre, String.CASE_INSENSITIVE_ORDER));
            case 2 ->
                listaProductos.sort(Comparator.comparingInt(ProductoDTO::getStock));
            case 3 ->
                listaProductos.sort(Comparator.comparingDouble(ProductoDTO::getPrecio));
            case 4 ->
                listaProductos.sort(Comparator.comparing(ProductoDTO::getVencimiento,
                        Comparator.nullsLast(Comparator.naturalOrder())));
            case 5 ->
                listaProductos.sort(Comparator.comparing(producto -> producto.getTipo().getNombre(),
                    Comparator.nullsLast(Comparator.naturalOrder())
                ));
            default ->
                JOptionPane.showMessageDialog(null, "Seleccione una opción válida para ordenar");
        }
        
        return listaProductos;
    }
    
    public static ProductoDTO SeleccionEdicion(JTable t){
        int fila = t.getSelectedRow();
        if(fila != -1){
            ProductoDTO product = pd.listarUno((Integer)(t.getValueAt(fila, 0)));
            return product;
            
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un elemento de la tabla de usuarios");
            return null;
        }
    }
    
    //CRUD
    public static boolean InsertarProducto(String nombre, int stock, 
            float precio, boolean Vencimiento, JDateChooser d,
            JComboBox c){
        try {
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor complete todos los datos");
                return false;
            }

            p = new ProductoDTO(); 
            p.setNombre(nombre);
            p.setStock(stock);
            p.setPrecio(precio);
            
            Date FechaVen = null;
            
            if (Vencimiento) {
                FechaVen = d.getDate(); 
                if (FechaVen != null) {
                    java.sql.Date sqlFechaVen = new java.sql.Date(FechaVen.getTime());
                    p.setVencimiento(sqlFechaVen); 
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor complete todos los datos");
                    return false;
                }
            } 
            
            TipoProductoDTO t = tpd.listarUnoNom(c.getSelectedItem()+"");
            
            p.setTipo(t);
            p.setVencimiento(FechaVen);
            pd.insertar(p); 
            
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al ingresar el producto, por favor asegúrese de ingresar los datos correctamente: " + ex.getMessage());
            return false;
        }
    }
    
    public static boolean EditarProducto(ProductoDTO p, String nombre, int stock, 
            float precio, boolean Vencimiento, JDateChooser d, JComboBox c){
        try {
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor complete todos los datos");
                return false;
            }
            
            p.setNombre(nombre);
            p.setStock(stock);
            p.setPrecio(precio);
            
            Date FechaVen = null;
            
            if (Vencimiento) {
                FechaVen = d.getDate(); 
                if (FechaVen != null) {
                    java.sql.Date sqlFechaVen = new java.sql.Date(FechaVen.getTime());
                    p.setVencimiento(sqlFechaVen); 
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor complete todos los datos");
                    return false;
                }
            } 
            
            TipoProductoDTO t = tpd.listarUnoNom(c.getSelectedItem()+"");
            
            p.setTipo(t);
            p.setVencimiento(FechaVen);
            pd.actualizar(p); 
            
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al ingresar el producto, por favor asegúrese de ingresar los datos correctamente: " + ex.getMessage());
            return false;
        }
    }
    
    public static boolean EliminarUsuario(JTable t) {
        try {
            int fila = -1;
            fila = t.getSelectedRow();
            if (fila != -1) {
                pd.eliminar((Integer) (t.getValueAt(fila, 0)));
                JOptionPane.showMessageDialog(null, "Producto eliminado satisfactoriamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un elemento de la tabla de productos");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar el producto " + e);
            return false;
        }
    }
    
    public static void AlertasBajoStock() {
        listaProductos = pd.listarTodo();
        StringBuilder mensaje = new StringBuilder("Productos con stock bajo:\n\n");
        boolean hayProductosBajoStock = false;

        for (ProductoDTO p : listaProductos) {
            if (p.getStock() <= 10) {
                mensaje.append("- ").append(p.getNombre())
                        .append(": ").append(p.getStock())
                        .append(" unidades\n");
                hayProductosBajoStock = true;
            }
        }

        if (hayProductosBajoStock) {
            JOptionPane.showMessageDialog(null, mensaje.toString(),
                    "Alerta de Stock", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static ArrayList<ProductoDTO> filtrarPorTipo(JComboBox c) {
        listaProductos = pd.listarTodo();

        if (c.getSelectedIndex() == 0) {
            return listaProductos;
        }

        String tipo = c.getSelectedItem().toString();

        listaProductos.removeIf(producto -> 
            producto.getTipo() == null || 
            !producto.getTipo().getNombre().equals(tipo)
        );

        return listaProductos;
    }

}
