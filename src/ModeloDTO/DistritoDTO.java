package ModeloDTO;

public class DistritoDTO {
    String Codigo, Nombre; 
    ProvinciaDTO Provincia;
    DepartamentoDTO Departamento;

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
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
