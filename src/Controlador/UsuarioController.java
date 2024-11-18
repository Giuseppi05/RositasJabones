package Controlador;

import ModeloDAO.RolDAO;
import ModeloDAO.UsuarioDAO;
import ModeloDTO.RolDTO;
import ModeloDTO.UsuarioDTO;
import config.UserSession;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.mindrot.jbcrypt.BCrypt;

public class UsuarioController {
    //MODELODAO NECESARIO
    static RolDAO rd = new RolDAO();
    static UsuarioDAO ud = new UsuarioDAO();
    
    //MODELODTO NECESARIO
    static UsuarioDTO u = new UsuarioDTO();
    
    //ARREGLOS NECESARIOS
    static ArrayList<UsuarioDTO> listaUsuarios = new ArrayList<>();
    
    //CADENAS DE VALIDACION
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9]).{8,}$";
    
    //MODELO DE TABLA
    static DefaultTableModel tableUsers = new DefaultTableModel();
    
    //METODOS DE VALIDACION
    public static boolean ValidarCorreo(String correo){
        return correo.matches(EMAIL_PATTERN);
    }
    
    public static boolean ValidarPassword(String contraseña){
        return contraseña.matches(PASSWORD_PATTERN);
    }
    
    public static boolean VerificarContraseña(String contraseña, String Verificacion) {
        return contraseña.equals(Verificacion);
    }
    
    public static boolean VerificarVacio(String nombre, String correo, String rol, JComboBox c) {
        return nombre.isEmpty() || 
               correo.isEmpty() || 
               rol.isEmpty() ||
               c.getItemCount() == 0;
    }
    
    public static boolean VerificarUsuario(String txtmail) {
        listaUsuarios = ud.listarTodo();
        return listaUsuarios.stream().noneMatch(usuario -> usuario.getCorreo().equals(txtmail));
    }
    
    public static boolean VerificarUsuario(String txtmail, int usuarioId) {
        listaUsuarios = ud.listarTodo();
        return listaUsuarios.stream().noneMatch(usuario -> usuario.getCorreo().equals(txtmail) && usuario.getCodigo() != usuarioId);
    }

    //METODOS CRUD
    public static boolean InsertarUsuario(String nombre, String correo, String rol, JComboBox c) {
        try {
            if (VerificarVacio(nombre, correo, rol, c)) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos");
                return false;
            }
            
            if (!ValidarCorreo(correo)) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un correo válido");
                return false;
            }

            if (!VerificarUsuario(correo)) {
                JOptionPane.showMessageDialog(null, "El correo ingresado ya existe.");
                return false;
            }

            u.setNombre(nombre);
            u.setCorreo(correo);
            u.setContraseña(null);
            u.setClaveTemp(null);
            u.setFechaTemp(null);

            RolDTO r = rd.listarUnoNom(rol);
            u.setRol(r);

            ud.insertar(u);
            return true;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al ingresar al usuario, por favor asegúrese de ingresar los datos correctamente: " + ex.getMessage());
            return false;
        }
    }
    
    public static boolean EditarUsuario(UsuarioDTO u, String nombre, String correo, String rol, JComboBox c){
        try {
            if (VerificarVacio(nombre, correo, rol, c)) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos");
                return false;
            }
            
            if (!ValidarCorreo(correo)) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un correo válido");
                return false;
            }
            
            if (!VerificarUsuario(correo, u.getCodigo())) {
                JOptionPane.showMessageDialog(null, "El correo ya está en uso");
                return false;
            }
            
            String ph = u.getContraseña();
            String ct = u.getClaveTemp();
            LocalDateTime ft = u.getFechaTemp();

            u.setNombre(nombre);
            u.setCorreo(correo);
            u.setContraseña(ph);
            u.setClaveTemp(ct);
            u.setFechaTemp(ft);

            RolDTO r = rd.listarUnoNom(rol);
            u.setRol(r);

            ud.actualizar(u);
            return true;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar al usuario, por favor asegúrese de ingresar los datos correctamente: " + ex.getMessage());
            return false;
        }
    }
    
    public static boolean EliminarUsuario(JTable t) {
        try{
            int fila = t.getSelectedRow();
            if (fila != -1) {
                Integer codigoUsuario = (Integer) t.getValueAt(fila, 0);
                ud.eliminar(codigoUsuario);
                JOptionPane.showMessageDialog(null, "Usuario eliminado satisfactoriamente");

                listaUsuarios = ud.listarTodo();
                boolean existe = listaUsuarios.stream()
                    .anyMatch(user -> UserSession.getUsuario().getCodigo() == user.getCodigo());

                if (!existe) {
                    JOptionPane.showMessageDialog(null, "El usuario logueado ya no existe");
                    UserSession.setUsuario(null);
                    return true;
                } else {
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un elemento de la tabla de usuarios");
                return false;
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrió un error al eliminar al usuario, por favor asegúrese de ingresar los datos correctamente: " + ex.getMessage());
            return false;
        }
    }
    
    //METODOS DE MANEJO Y MUESTRA DE DATOS
    public static void mostrarCabecera(JTable t) {
        if (tableUsers.getColumnCount() == 0) {
            tableUsers.addColumn("Código");
            tableUsers.addColumn("Nombre");
            tableUsers.addColumn("Rol");
            tableUsers.addColumn("Correo");
        }
        t.setModel(tableUsers);
    }
    
    public static void listarTabla(){
        tableUsers.setRowCount(0);
        listaUsuarios = ud.listarTodo();
        for(int i=0; i<listaUsuarios.size(); i++){
            Object[] data = {listaUsuarios.get(i).getCodigo(),listaUsuarios.get(i).getNombre(), listaUsuarios.get(i).getRol().getNombre(),
            listaUsuarios.get(i).getCorreo()};
            tableUsers.addRow(data);
        }
    }
    
    public static void listarTabla(ArrayList<UsuarioDTO> datos){
        tableUsers.setRowCount(0);
        for(int i=0; i<datos.size(); i++){
            Object[] data = {datos.get(i).getCodigo(),datos.get(i).getNombre(), datos.get(i).getRol().getNombre(),
            datos.get(i).getCorreo()};
            tableUsers.addRow(data);
        }
    }
    
    public static ArrayList<UsuarioDTO> busquedaSecuencial(String nombre) {
        ArrayList<UsuarioDTO> resultados = new ArrayList<>();
        String nom= nombre.toLowerCase();
        
        listaUsuarios = ud.listarTodo();

        for (UsuarioDTO usuario : listaUsuarios) {
            if (usuario.getNombre().toLowerCase().contains(nom)) {
                resultados.add(usuario);
            }
        }
        
        return resultados;
    }
    
    public static ArrayList<UsuarioDTO> ordenamiento(int index){
        switch (index) {
            case 0 -> listaUsuarios.sort(Comparator.comparingInt(UsuarioDTO::getCodigo));

            case 1 -> listaUsuarios.sort(Comparator.comparing(UsuarioDTO::getNombre, String.CASE_INSENSITIVE_ORDER));

            case 2 -> listaUsuarios.sort(Comparator.comparing(usuario -> usuario.getRol().getNombre(), String.CASE_INSENSITIVE_ORDER));

            case 3 -> listaUsuarios.sort(Comparator.comparing(UsuarioDTO::getCorreo, String.CASE_INSENSITIVE_ORDER));

            default -> JOptionPane.showMessageDialog(null, "Seleccione una opción válida para ordenar");
        }
        
        return listaUsuarios;
    }
    
    public static UsuarioDTO SeleccionEdicion(JTable t){
        int fila = t.getSelectedRow();
        if(fila != -1){
            UsuarioDTO user = ud.listarUno((Integer)(t.getValueAt(fila, 0)));
            return user;
            
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un elemento de la tabla de usuarios");
            return null;
        }
    }
    
    public static boolean GenerarClave(JTable t){
        UsuarioDTO user = SeleccionEdicion(t);
        
        if(user == null){
            return false;
        }
        
        try {
            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_+=<>?";
        
            SecureRandom random = new SecureRandom();
            String clave = "";

            for (int i = 0; i < 6; i++) {
                int index = random.nextInt(caracteres.length());
                clave += caracteres.charAt(index);
            }

            LocalDateTime fecha = LocalDateTime.now().plusMinutes(30);

            String hash = BCrypt.hashpw(clave, BCrypt.gensalt());

            user.setClaveTemp(hash);
            user.setFechaTemp(fecha);

            ud.actualizar(user);

            JOptionPane.showMessageDialog(null, "Su clave temporal es: "+clave+
                    "\nEsta clave solo permanecerá activa por 30 minutos");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
            return false;
        }
    }
}
