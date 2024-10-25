package config;

import ModeloDTO.UsuarioDTO;

public class UserSession {
    private static UsuarioDTO usuario;

    public static void setUsuario(UsuarioDTO usuario) {
        UserSession.usuario = usuario;
    }

    public static UsuarioDTO getUsuario() {
        return usuario;
    }
}
