package Controlador;

import ModeloDAO.UsuarioDAO;
import ModeloDTO.UsuarioDTO;
import config.UserSession;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;

public class LoginController {
    static UsuarioDAO ud = new UsuarioDAO();
    static ArrayList<UsuarioDTO> mu;
    
    public static boolean Login(String mail, String pass){
        try {
            mu = ud.listarTodo();

            if (mail.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese datos válidos");
                return false;
            }

            UsuarioDTO foundUser = null;
            for (UsuarioDTO user : mu) {
                if (mail.equals(user.getCorreo())) {
                    foundUser = user;
                    break;
                }
            }

            if (foundUser != null) {
                boolean verified = BCrypt.checkpw(pass, foundUser.getContraseña());
                if (verified) {
                    UserSession u = new UserSession();
                    u.setUsuario(foundUser);
                    
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "La contraseña ingresada es incorrecta");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "El correo ingresado no existe");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión: " + e.getMessage());
            return false;
        }
    }
}
