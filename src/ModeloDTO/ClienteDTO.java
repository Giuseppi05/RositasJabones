/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDTO;

/**
 *
 * @author giosu
 */
public class ClienteDTO {
    int Codigo;
    String DNI, Nombre, Telefono, Correo, Direccion;
    DistritoDTO Distrito;
    ProvinciaDTO Provincia;
    DepartamentoDTO Departamento;

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public DistritoDTO getDistrito() {
        return Distrito;
    }

    public void setDistrito(DistritoDTO Distrito) {
        this.Distrito = Distrito;
    }

    public ProvinciaDTO getProvincia() {
        return Provincia;
    }

    public void setProvincia(ProvinciaDTO Provincia) {
        this.Provincia = Provincia;
    }

    public DepartamentoDTO getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(DepartamentoDTO Departamento) {
        this.Departamento = Departamento;
    }
    
}
