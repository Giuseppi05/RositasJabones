package config;

import ModeloDTO.UsuarioDTO;
import javax.swing.JFrame;

public class UserSession {
    private static UsuarioDTO usuario;
    private static JFrame lastFrame;

    public static void setUsuario(UsuarioDTO usuario) {
        UserSession.usuario = usuario;
    }

    public static UsuarioDTO getUsuario() {
        return usuario;
    }
    
    public void setLastFrame(JFrame frame) {
        lastFrame = frame;
    }

    public JFrame getLastFrame() {
        return lastFrame;
    }
}
