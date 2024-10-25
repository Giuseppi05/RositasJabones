package Controlador;

import ModeloDAO.BoletaDAO;
import ModeloDAO.DetalleBoletaDAO;
import ModeloDAO.ProductoDAO;
import ModeloDTO.BoletaDTO;
import ModeloDTO.DetalleBoletaDTO;
import ModeloDTO.ProductoDTO;
import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BoletaController {
    static BoletaDTO b = new BoletaDTO();
    static BoletaDAO bd = new BoletaDAO();
    static ProductoDAO pd = new ProductoDAO();
    static ArrayList<BoletaDTO> listaBoletas = new ArrayList<>();
    static DefaultTableModel x = new DefaultTableModel();
    static DefaultTableModel d = new DefaultTableModel();
    static DetalleBoletaDAO dbd= new DetalleBoletaDAO();
    
    public static void mostrarCabecera(JTable t) {
        if (x.getColumnCount() == 0) {
            x.addColumn("Código");
            x.addColumn("Nombre de Usuario");
            x.addColumn("Nombre de Cliente");
            x.addColumn("Fecha");
            x.addColumn("Total");
            x.addColumn("Estado del pago");
        }
        t.setModel(x);
    }
    
    public static void mostrarCabeceraDet(JTable t) {
        if (d.getColumnCount() == 0) {
            d.addColumn("Nombre de Producto");
            d.addColumn("Cantidad");
            d.addColumn("Precio");
            d.addColumn("Subtotal");
        }
        t.setModel(d);
    }
    
    public static void listar(){
        x.setRowCount(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        listaBoletas = bd.listarTodo();
         for (BoletaDTO boleta : listaBoletas) {
            Object fecha = boleta.getFecha().format(formatter);
            Object estado = boleta.getStatus() == 0 ? "Pendiente" : "Pagado";

            Object[] data = {
                boleta.getCodigo(),
                boleta.getUsuario().getNombre(),
                boleta.getCliente().getNombre(),
                fecha,
                boleta.getTotal(),
                estado
            };
            x.addRow(data); 
        }
    }
    
    public static void listar(ArrayList<BoletaDTO> datos){
        x.setRowCount(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        for(int i=0; i<datos.size(); i++){
            Object fecha = listaBoletas.get(i).getFecha().format(formatter);
             Object estado = listaBoletas.get(i).getStatus() == 0 ? "Pendiente" : "Pagado";
             
            Object[] data = {
                datos.get(i).getCodigo(),
                datos.get(i).getUsuario().getNombre(),
                datos.get(i).getCliente().getNombre(),
                fecha,
                datos.get(i).getTotal(),
                estado
            };
            x.addRow(data);
        }
    }
   
    public static ArrayList<BoletaDTO> ordenamiento(int index) {
        switch (index) {
            case 0 ->
                listaBoletas.sort(Comparator.comparing(BoletaDTO::getCodigo));
            case 1 ->
                listaBoletas.sort(Comparator.comparing(b -> b.getUsuario().getNombre(), String.CASE_INSENSITIVE_ORDER));
            case 2 ->
                listaBoletas.sort(Comparator.comparing(b -> b.getCliente().getNombre(), String.CASE_INSENSITIVE_ORDER));
            case 3 ->
                listaBoletas.sort(Comparator.comparing(BoletaDTO::getFecha));
            case 4 ->
                listaBoletas.sort(Comparator.comparingDouble(BoletaDTO::getTotal));
            default ->
                JOptionPane.showMessageDialog(null, "Seleccione una opción válida para ordenar");
        }

        return listaBoletas;
    }
    
    public static ArrayList<BoletaDTO> filtrarPorFecha(JDateChooser dateChooser) {
        Date fechaSeleccionada = dateChooser.getDate(); 
        listaBoletas = bd.listarTodo();

        if (fechaSeleccionada != null) {
            LocalDate fechaFiltro = fechaSeleccionada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            listaBoletas = (ArrayList<BoletaDTO>) listaBoletas.stream()
                    .filter(boleta -> boleta.getFecha().toLocalDate().equals(fechaFiltro))
                    .collect(Collectors.toList());
            
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fecha válida.");
        }
        
        return listaBoletas;
    }
    
    public static void listarDetalleBoleta(BoletaDTO b, JTextField fechatxt, JTextField horatxt){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Object fecha = b.getFecha().format(formatter);
        fechatxt.setText(fecha+"");
        
        DateTimeFormatter formatterHour = DateTimeFormatter.ofPattern("hh:mm a");
        Object hora = b.getFecha().format(formatterHour);
        horatxt.setText(hora+"");
        
        ArrayList<DetalleBoletaDTO> listaDetalle = dbd.listarPorBoleta(b.getCodigo());
        d.setRowCount(0);
        
        for(int i=0; i<listaDetalle.size(); i++){
            Object[] data = {
                listaDetalle.get(i).getProducto().getNombre(),
                listaDetalle.get(i).getCantidad(),
                listaDetalle.get(i).getProducto().getPrecio(),
                listaDetalle.get(i).getSubtotal()
            };
            d.addRow(data);
        }
    }
    
    public static boolean EliminarBoleta(String codigo) {
        try {
            ArrayList<DetalleBoletaDTO> listaDetalles = dbd.listarPorBoleta(codigo);
            
            for(DetalleBoletaDTO detalle : listaDetalles){
                ProductoDTO p = detalle.getProducto();
                p.setStock(p.getStock() + detalle.getCantidad());
                pd.actualizar(p);
            }
            
            bd.eliminar(codigo);
            JOptionPane.showMessageDialog(null, "Boleta anulada satisfactoriamente");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al anular la boleta " + e);
            return false;
        }
    }
    
    public static boolean CambiarEstado(JTable t){
        try {
            int fila = -1;
            fila = t.getSelectedRow();
            if (fila != -1) {
                
                BoletaDTO bol = bd.listarUno(t.getValueAt(fila, 0)+"");
                bol.setStatus(bol.getStatus() == 0 ? 1 : 0);
                bd.actualizar(bol);
                listar();
                JOptionPane.showMessageDialog(null, "Estado actualizado correctamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un elemento de la tabla de boletas");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al cambiar el estado " + e);
            return false;
        }
        
    }
}
