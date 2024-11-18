package ModeloDTO;

import java.time.LocalDateTime;

public class UsuarioDTO {
    private int codigo;
    private String nombre;
    private String correo;
    private String contraseña;
    private RolDTO rol;
    private String ClaveTemp;
    private LocalDateTime FechaTemp;

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the rol
     */
    public RolDTO getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(RolDTO rol) {
        this.rol = rol;
    }

    /**
     * @return the ClaveTemp
     */
    public String getClaveTemp() {
        return ClaveTemp;
    }

    /**
     * @param ClaveTemp the ClaveTemp to set
     */
    public void setClaveTemp(String ClaveTemp) {
        this.ClaveTemp = ClaveTemp;
    }

    /**
     * @return the FechaTemp
     */
    public LocalDateTime getFechaTemp() {
        return FechaTemp;
    }

    /**
     * @param FechaTemp the FechaTemp to set
     */
    public void setFechaTemp(LocalDateTime FechaTemp) {
        this.FechaTemp = FechaTemp;
    }
    
    
}
