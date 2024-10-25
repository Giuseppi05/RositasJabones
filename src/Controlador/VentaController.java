package Controlador;

import ModeloDAO.BoletaDAO;
import ModeloDAO.DetalleBoletaDAO;
import ModeloDAO.ProductoDAO;
import ModeloDTO.BoletaDTO;
import ModeloDTO.ClienteDTO;
import ModeloDTO.DetalleBoletaDTO;
import ModeloDTO.ProductoDTO;
import ModeloDTO.UsuarioDTO;
import Vistas.Boleta.DetalleBoleta;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class VentaController {
    static DefaultTableModel x = new DefaultTableModel();
    static BoletaDAO bd = new BoletaDAO();
    static ProductoDAO pd = new ProductoDAO();
    static DetalleBoletaDAO dbd= new DetalleBoletaDAO();
    
    public static void ModelSpinnerCantidad(JSpinner s){
        SpinnerNumberModel spnCan = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
        s.setModel(spnCan);
    }
    
    public static void MaxSpinnerProducto(JSpinner s, int maximo){
        SpinnerNumberModel spnCan = (SpinnerNumberModel) s.getModel();
        if(maximo == 0){
            spnCan.setValue(0);
        } else {
            spnCan.setValue(1);
            spnCan.setMaximum(maximo);
        }
    }
    
    public static void mostrarCabecera(JTable t) {
        if (x.getColumnCount() == 0) {
            x.addColumn("Código de producto");
            x.addColumn("Nombre de producto");
            x.addColumn("Precio");
            x.addColumn("Cantidad");
            x.addColumn("Subtotal");
        }
        t.setModel(x);
    }
    
    public static int calcularStockRestante(ProductoDTO p, JTable t){
        int stockInicial = p.getStock();
        int stockEnTabla = 0;
        
        for (int i = 0; i < t.getRowCount(); i++) {
            int codigoTabla = (Integer) t.getValueAt(i, 0);
            if(p.getCodigo() == codigoTabla){
                stockEnTabla += (Integer) t.getValueAt(i, 3);
            }
        }
        
        return stockInicial - stockEnTabla;
    }
    
    public static boolean AñadirDetalle(ProductoDTO p, int cantidad, float subtotal, int stkRes, JTable t) {
        if (stkRes <= 0) {
            JOptionPane.showMessageDialog(null, "El producto seleccionado no cuenta con stock restante");
            return false;
        }
        
        if (p.getVencimiento() != null) {
            Date fechaActual = new Date();
            long diferenciaDias = TimeUnit.DAYS.convert(p.getVencimiento().getTime() - fechaActual.getTime(), TimeUnit.MILLISECONDS);

            if (diferenciaDias <= 0) {
                JOptionPane.showMessageDialog(null, "El producto seleccionado ha pasado su fecha de vencimiento, no puede ser añadido");
                return false;
            }
        }

        if (cantidad < 1) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese una cantidad válida");
            return false;
        }

        if (cantidad > stkRes) {
            JOptionPane.showMessageDialog(null, "El producto no cuenta con stock suficiente");
            return false;
        }

        int filaProductoTabla = -1;
        for (int i = 0; i < t.getRowCount(); i++) {
            int codigoTabla = (Integer) t.getValueAt(i, 0);
            if (p.getCodigo() == codigoTabla) {
                filaProductoTabla = i;
                break;
            }
        }

        if (filaProductoTabla != -1) {
            int cantidadTabla = (Integer) t.getValueAt(filaProductoTabla, 3);
            float subtotalTabla = (float) t.getValueAt(filaProductoTabla, 4);
            t.setValueAt(cantidad + cantidadTabla, filaProductoTabla, 3);
            t.setValueAt(subtotal + subtotalTabla, filaProductoTabla, 4);
        } else {
            Object[] data = {p.getCodigo(), p.getNombre(), p.getPrecio(), cantidad, subtotal};
            x.addRow(data);
        }

        return true;
    }

    public static float calcularTotal(JTable t){
        float total = 0;
        
        for (int i = 0; i < t.getRowCount(); i++) {
            total += (float) t.getValueAt(i, 4);
        }
        
        return total;
    }
    
    public static void QuitarTabla(JTable t) {
        int fila = t.getSelectedRow(); 

        if (fila != -1) { 
            DefaultTableModel modelo = (DefaultTableModel) t.getModel();
            modelo.removeRow(fila); 
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila de la tabla para eliminar.");
        }
    }

    public static void Limpiar(JTable t, JComboBox c) {
        c.setSelectedIndex(0);
        DefaultTableModel modelo = (DefaultTableModel) t.getModel();
        modelo.setRowCount(0);
    }
    
    public static boolean ProcesarBoleta(JTable t, UsuarioDTO u, ClienteDTO c, JFrame v) {
        if (t.getRowCount() > 0) {
            BoletaDTO b = new BoletaDTO();
            LocalDateTime fechaActual = LocalDateTime.now();
            
            b.setTotal(calcularTotal(t));
            b.setCliente(c);
            b.setUsuario(u);
            b.setFecha(fechaActual);

            if (bd.insertar(b)) {
                String codigoBoleta = bd.obtenerUltimoIdBol(); 

                for (int i = 0; i < t.getRowCount(); i++) {
                    DetalleBoletaDTO db = new DetalleBoletaDTO();
                    ProductoDTO p = pd.listarUno((Integer) t.getValueAt(i, 0));
                    int cantidad = (Integer) t.getValueAt(i, 3);
                    
                    db.setBoleta(bd.listarUno(codigoBoleta)); 
                    db.setProducto(p); 
                    db.setCantidad(cantidad);
                    db.setSubtotal((Float) t.getValueAt(i, 4));
                    
                    dbd.insertar(db);
                    
                    p.setStock(p.getStock()-cantidad);
                    pd.actualizar(p);
                }
                
                
                DetalleBoleta dbi = new DetalleBoleta(bd.listarUno(codigoBoleta));
                dbi.setVisible(true);
                v.dispose();
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Error al procesar la boleta.");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese al menos un producto para procesar la venta");
            return false;
        }
    }

}
