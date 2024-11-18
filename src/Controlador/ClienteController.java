package Controlador;

import ModeloDAO.TipoDocumentoDAO;
import ModeloDAO.ClienteDAO;
import ModeloDAO.DistritoDAO;
import ModeloDTO.ClienteDTO;
import ModeloDTO.DistritoDTO;
import ModeloDTO.TipoDocumentoDTO;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClienteController {
    static DefaultTableModel x = new DefaultTableModel();
    
    static ClienteDAO cd = new ClienteDAO();
    static DistritoDAO disd = new DistritoDAO();
    static TipoDocumentoDAO tdd = new TipoDocumentoDAO();
    
    static ClienteDTO c = new ClienteDTO();
    
    static ArrayList<ClienteDTO> listaClientes = new ArrayList<>();
    static ArrayList<TipoDocumentoDTO> listaTipoDocumento = new ArrayList<>();
    
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final String CELLPHONE_PATTERN = "9\\d{8}";
    private static final String DNI_PATTERN = "\\d{8}";
    private static final String EXTRANJERIA_PATTERN = "\\d{12}";
    private static final String LANDLINE_PATTERN = "^\\(0\\d{1,2}\\)\\s?\\d{6,7}$";
    
    //MANEJO DE DATOS
    public static void mostrarCabecera(JTable t) {
        if (x.getColumnCount() == 0) {
            x.addColumn("Código");
            x.addColumn("Tipo de Documento");
            x.addColumn("Número de Documento");
            x.addColumn("Nombre");
            x.addColumn("Telefono");
            x.addColumn("Correo");
            x.addColumn("Dirección");
            x.addColumn("Distrito");
            x.addColumn("Provincia");
            x.addColumn("Departamento");
        }
        t.setModel(x);
    }
    
    public static void listar(){
        x.setRowCount(0);
        listaClientes = cd.listarTodo();
        for(int i=0; i<listaClientes.size(); i++){
            Object[] data = {
                listaClientes.get(i).getCodigo(),
                listaClientes.get(i).getTipoDocumento().getNombre(),
                listaClientes.get(i).getDNI(),
                listaClientes.get(i).getNombre(), 
                listaClientes.get(i).getTelefono(),
                listaClientes.get(i).getCorreo(),
                listaClientes.get(i).getDireccion(),
                listaClientes.get(i).getDistrito().getNombre(),
                listaClientes.get(i).getProvincia().getNombre(),
                listaClientes.get(i).getDepartamento().getNombre()
            };
            x.addRow(data);
        }
    }
    
    public static void listar(ArrayList<ClienteDTO> datos){
        x.setRowCount(0);
        for(int i=0; i<datos.size(); i++){
            Object[] data = {
                datos.get(i).getCodigo(),
                datos.get(i).getTipoDocumento().getNombre(),
                datos.get(i).getDNI(),
                datos.get(i).getNombre(), 
                datos.get(i).getTelefono(),
                datos.get(i).getCorreo(),
                datos.get(i).getDireccion(),
                datos.get(i).getDistrito().getNombre(),
                datos.get(i).getProvincia().getNombre(),
                datos.get(i).getDepartamento().getNombre()
            };
            x.addRow(data);
        }
    }
    
    public static ArrayList<ClienteDTO> busquedaSecuencial(String nombre) {
        ArrayList<ClienteDTO> resultados = new ArrayList<>();
        String nom= nombre.toLowerCase();
        
        listaClientes = cd.listarTodo();
        
        for (ClienteDTO cliente : listaClientes) {
            if (cliente.getNombre().toLowerCase().contains(nom)) {
                resultados.add(cliente);
            }
        }
        return resultados;
    }
    
    public static ArrayList<ClienteDTO> ordenamiento(int index){
        switch (index) {
            case 0 -> listaClientes.sort(Comparator.comparingInt(ClienteDTO::getCodigo));

            case 1 -> listaClientes.sort(Comparator.comparing(ClienteDTO::getNombre, String.CASE_INSENSITIVE_ORDER));

            case 2 -> listaClientes.sort(Comparator.comparing(cliente -> cliente.getDistrito().getNombre(), String.CASE_INSENSITIVE_ORDER));

            case 3 -> listaClientes.sort(Comparator.comparing(cliente -> cliente.getProvincia().getNombre(), String.CASE_INSENSITIVE_ORDER));

            case 4 -> listaClientes.sort(Comparator.comparing(cliente -> cliente.getDepartamento().getNombre(), String.CASE_INSENSITIVE_ORDER));

            default -> JOptionPane.showMessageDialog(null, "Seleccione una opción válida para ordenar");
        }
        
        return listaClientes;
    }
    
    public static ClienteDTO SeleccionEdicion(JTable t){
        int fila = t.getSelectedRow();
        if(fila != -1){
            ClienteDTO client = cd.listarUno((Integer)(t.getValueAt(fila, 0)));
            return client;
            
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un elemento de la tabla de usuarios");
            return null;
        }
    }
    
    public static void mostrarClientes(JComboBox c){
        c.removeAllItems();
        
        listaClientes = cd.listarTodo();
        
        for (int i = 0; i < listaClientes.size(); i++) {
            c.addItem(listaClientes.get(i).getNombre());
        }
    }
    
    public static void mostrarTipoDocumento(JComboBox c){
        c.removeAllItems();
        
        listaTipoDocumento = tdd.listarTodo();
        
        for (int i = 0; i < listaTipoDocumento.size(); i++) {
            c.addItem(listaTipoDocumento.get(i).getNombre());
        }
    }
    
    public static ClienteDTO BuscarClientePorDNI(JComboBox<String> cbx) {
        String dni = JOptionPane.showInputDialog("Ingrese un número de documento");
        
        if(dni.matches(DNI_PATTERN) || dni.matches(EXTRANJERIA_PATTERN)){
            ClienteDTO cliente = cd.listarUnoDNI(dni);
            listaClientes = cd.listarTodo();

            if (cliente != null) {
                for (int i = 0; i < listaClientes.size(); i++) {
                    if (listaClientes.get(i).getDNI().equals(dni)) {
                        cbx.setSelectedIndex(i);
                        break;
                    }
                }
                return cliente;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con el número de documento ingresado");
                return null;
            }
        }  else {
            JOptionPane.showMessageDialog(null, "El número de documento ingresado no es válido");
            return null;
        }
    }
    
    
    public static ClienteDTO BuscarClienteCBX(JComboBox<String> cbx){
        listaClientes = cd.listarTodo();
        
        int selectedIndex = cbx.getSelectedIndex();

        if (selectedIndex >= 0 && selectedIndex < listaClientes.size()) {
            return listaClientes.get(selectedIndex);
        } else {
            return null;
        }
    }
    //VALIDACIONES
    public static void ComprobarTipoTel(String txt, JComboBox j) {
        j.setSelectedIndex(txt.matches(CELLPHONE_PATTERN) ? 0 : 1);
    }

    
    public static boolean ValidarCorreo(String txt){
        return txt.matches(EMAIL_PATTERN);
    }
    
    public static boolean ValidarTelefono(String txt, JComboBox j){
        return switch (j.getSelectedIndex()) {
            case 0 -> txt.matches(CELLPHONE_PATTERN);
            case 1 -> txt.matches(LANDLINE_PATTERN);
            default -> false;
        };
    }
    
    public static boolean ValidarDNI(String txt, JComboBox j){
        TipoDocumentoDTO t = tdd.listarUnoNom(j.getSelectedItem()+"");
        
        return switch (t.getCodigo()) {
            case 1 -> txt.matches(DNI_PATTERN);
            case 2 -> txt.matches(EXTRANJERIA_PATTERN);
            default -> false;
        };
    }
    
    public static boolean ValidarVacio(String nombre, String dni, String telefono, String correo, String direccion, JComboBox pro, JComboBox dep, JComboBox dis) {
        return nombre.isEmpty()
                || dni.isEmpty()
                || telefono.isEmpty()
                || correo.isEmpty()
                || direccion.isEmpty()
                || pro.getItemCount() == 0
                || dep.getItemCount() == 0
                || dis.getItemCount() == 0;
    }
    
    public static boolean VerificarCliente(String dni) {
        listaClientes = cd.listarTodo();
        return listaClientes.stream().noneMatch(cliente -> cliente.getDNI().equals(dni));
    }
    
    public static boolean VerificarCliente(String dni, int usuarioId) {
        listaClientes = cd.listarTodo();
        return listaClientes.stream().noneMatch(cliente -> cliente.getDNI().equals(dni) && cliente.getCodigo() != usuarioId);
    }
    
    //CRUD
    public static boolean Insertar(String nombre, String dni, 
            String telefono, String correo, String direccion, 
            JComboBox pro, JComboBox dep, JComboBox dis, JComboBox tipoDocumento, JComboBox tipoTelefono){
        listaClientes = cd.listarTodo();
        
        try {
            if(ValidarVacio(nombre, dni, telefono, correo, direccion, pro, dep, dis)){
                JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos");
                return false;
            }
            
            if(!ValidarDNI(dni, tipoDocumento)){
                JOptionPane.showMessageDialog(null, "Por favor favor ingrese un número de documento válido");
                return false;
            }
            
            if (!VerificarCliente(dni)) {
                JOptionPane.showMessageDialog(null, "El DNI ingresado ya existe.");
                return false;
            }
            
            if (!ValidarTelefono(telefono, tipoTelefono)) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un telefono válido");
                return false;
            }
            
            if (!ValidarCorreo(correo)) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un correo válido");
                return false;
            }
            
            DistritoDTO distrito = disd.listarUnoNom(dis.getSelectedItem().toString());
            if (distrito == null) {
                JOptionPane.showMessageDialog(null, "El distrito seleccionado no existe");
                return false;
            }
            
            TipoDocumentoDTO tipdoc = tdd.listarUnoNom(tipoDocumento.getSelectedItem()+"");
            
            c.setNombre(nombre);
            c.setTipoDocumento(tipdoc);
            c.setDNI(dni);
            c.setTelefono(telefono);
            c.setCorreo(correo);
            c.setDireccion(direccion);
            c.setDistrito(distrito);
            c.setProvincia(distrito.getProvincia());
            c.setDepartamento(distrito.getDepartamento());

            cd.insertar(c);
            return true;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al ingresar al cliente, por favor asegúrese de ingresar los datos correctamente: " + ex.getMessage());
            return false;
        }
    }
    
    public static boolean Editar(ClienteDTO c, String nombre, String dni, 
            String telefono, String correo, String direccion, 
            JComboBox pro, JComboBox dep, JComboBox dis, JComboBox tipoDocumento, JComboBox tipoTelefono){
        listaClientes = cd.listarTodo();
        
        try {
            if(ValidarVacio(nombre, dni, telefono, correo, direccion, pro, dep, dis)){
                JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos");
                return false;
            }
            
            if(!ValidarDNI(dni, tipoDocumento)){
                JOptionPane.showMessageDialog(null, "Por favor favor ingrese un número de documento válido");
                return false;
            }
            
            if (!VerificarCliente(dni, c.getCodigo())) {
                JOptionPane.showMessageDialog(null, "El DNI ingresado ya existe.");
                return false;
            }
            
            if (!ValidarTelefono(telefono,tipoTelefono)) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un telefono válido");
                return false;
            }
            
            if (!ValidarCorreo(correo)) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un correo válido");
                return false;
            }
            
            DistritoDTO distrito = disd.listarUnoNom(dis.getSelectedItem().toString());
            if (distrito == null) {
                JOptionPane.showMessageDialog(null, "El distrito seleccionado no existe");
                return false;
            }
            
            TipoDocumentoDTO tipdoc = tdd.listarUnoNom(tipoDocumento.getSelectedItem()+"");
            
            c.setNombre(nombre);
            c.setTipoDocumento(tipdoc);
            c.setDNI(dni);
            c.setTelefono(telefono);
            c.setCorreo(correo);
            c.setDireccion(direccion);
            c.setDistrito(distrito);
            c.setProvincia(distrito.getProvincia());
            c.setDepartamento(distrito.getDepartamento());

            cd.actualizar(c);
            return true;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar al cliente, por favor asegúrese de ingresar los datos correctamente: " + ex.getMessage());
            return false;
        }
    }
    
    public static boolean Eliminar(JTable t) {
        try {
            int fila = -1;
            fila = t.getSelectedRow();
            if (fila != -1) {
                cd.eliminar((Integer) (t.getValueAt(fila, 0)));
                JOptionPane.showMessageDialog(null, "Cliente eliminado satisfactoriamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un elemento de la tabla de clientes");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar el cliente " + e);
            return false;
        }
    }
}
