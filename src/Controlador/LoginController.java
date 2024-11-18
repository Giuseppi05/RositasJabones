package Controlador;

import ModeloDAO.UsuarioDAO;
import ModeloDTO.UsuarioDTO;
import Vistas.NewPassword;
import Vistas.Principal;
import config.UserSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;
import util.InactividadUtil;

public class LoginController {
    static UsuarioDAO ud = new UsuarioDAO();
    static ArrayList<UsuarioDTO> mu;
    static int count = 0;
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9]).{8,}$";
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    
    public static boolean Login(String mail, String pass, JFrame frame) {
        if (count >= 3) {
            JOptionPane.showMessageDialog(null, "Ha superado el número máximo de intentos.");
            frame.dispose();
            return false;
        }

        try {
            mu = ud.listarTodo();

            // Verificar si los campos están vacíos
            if (mail.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese datos válidos");
                count++; // Incrementar el contador de intentos
                JOptionPane.showMessageDialog(null, "Le quedan " + (3 - count) + " intentos");
                return false;
            }

            UsuarioDTO foundUser = null;
            for (UsuarioDTO user : mu) {
                if (mail.equals(user.getCorreo())) {
                    foundUser = user;
                    break;
                }
            }

            if (foundUser == null) {
                JOptionPane.showMessageDialog(null, "El correo ingresado no existe");
                count++;
                JOptionPane.showMessageDialog(null, "Le quedan " + (3 - count) + " intentos");
                return false;
            }
            
            if(foundUser.getContraseña() == null && foundUser.getClaveTemp() != null){
                NewPassword n = new NewPassword(foundUser);
                n.setVisible(true);
                frame.dispose();
                return false;
            }
            
            if (pass.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese datos válidos");
                count++; // Incrementar el contador de intentos
                JOptionPane.showMessageDialog(null, "Le quedan " + (3 - count) + " intentos");
                return false;
            }

            if (!BCrypt.checkpw(pass, foundUser.getContraseña())) {
                JOptionPane.showMessageDialog(null, "La contraseña ingresada es incorrecta");
                count++;
                JOptionPane.showMessageDialog(null, "Le quedan " + (3 - count) + " intentos");
                return false;
            }

            count = 0;

            UserSession session = new UserSession();
            UsuarioDTO previousUser = session.getUsuario();
            session.setUsuario(foundUser);

            JFrame lastFrame = session.getLastFrame();
            if (previousUser != null && foundUser.getCodigo() == previousUser.getCodigo() && lastFrame != null) {
                JOptionPane.showMessageDialog(null, "Bienvenido de nuevo");
                lastFrame.setVisible(true);
                InactividadUtil.activarTemporizador(lastFrame);
                return true;
            } else {
                session.setLastFrame(null);
                Principal p = new Principal();
                p.setVisible(true);
                return true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión: " + e.getMessage());
            return false;
        }
    }

    public static boolean ForgetPassword(JFrame f) {
        String correo = JOptionPane.showInputDialog(null, "Ingrese su correo");
        
        if (correo.isBlank() || correo.isEmpty() || !correo.matches(EMAIL_PATTERN)) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un correo válido");
            return false;
        }
        
        mu = ud.listarTodo();
        
        UsuarioDTO foundUser = null;
        for (UsuarioDTO user : mu) {
            if (correo.equals(user.getCorreo())) {
                foundUser = user;
                break;
            }
        }
        
        if(foundUser == null){
            JOptionPane.showMessageDialog(null, "No se encontró un usuario registrado con ese correo");
            return false;
        }
        
        if(foundUser.getContraseña() == null){
            JOptionPane.showMessageDialog(null, "La contraseña del usuario ingresado no ha sido generada aún");
            return false;
        }
        
        if(foundUser.getClaveTemp() == null){
            JOptionPane.showMessageDialog(null, "Usted no cuenta con una clave temporal, solicite una a su administrador");
            return false;
        }
        
        NewPassword n = new NewPassword(foundUser);
        n.setVisible(true);
        f.dispose();
        return true;
    }
    
    public static boolean ValidarContraseña(String txt){
        return txt.matches(PASSWORD_PATTERN);
    }
    
    public static boolean ValidarVer(String pass, String Ver){
        return pass.equals(Ver);
    }
    
    public static boolean CambiarContraseña(UsuarioDTO u, String clave, String contraseña, String verificar){
        
        if(clave.isEmpty() 
           || contraseña.isEmpty()
           || verificar.isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese datos válidos");
            return false;
        }
        
        LocalDateTime actual = LocalDateTime.now();
        
        if(actual.isAfter(u.getFechaTemp())){
            JOptionPane.showMessageDialog(null, "Su clave de 6 dígitos ha expirado ");
            return false;
        }
        
        if(!BCrypt.checkpw(clave, u.getClaveTemp())){
            JOptionPane.showMessageDialog(null, "La clave de 6 dígitos es incorrecta");
            return false;
        }
        
        if(!ValidarContraseña(contraseña)){
            JOptionPane.showMessageDialog(null, "Ingrese una contraseña válida\nSu contraseña debe tener 8 dígitos y al menos un número");
            return false;
        }
        
        if(!ValidarVer(contraseña, verificar)){
            JOptionPane.showMessageDialog(null, "Las contraseñas deben ser iguales");
            return false;
        }
        
        if(u.getContraseña() != null){
            if(BCrypt.checkpw(contraseña, u.getContraseña())){
                JOptionPane.showMessageDialog(null, "La nueva contraseña no puede ser igual a la anterior");
                return false;
            }
        }
        
        try {
            u.setContraseña(BCrypt.hashpw(contraseña, BCrypt.gensalt()));
            u.setFechaTemp(null);
            u.setClaveTemp(null);

            ud.actualizar(u);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return false;
        }
        
    }
}
