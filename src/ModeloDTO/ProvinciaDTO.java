package ModeloDTO;

public class ProvinciaDTO {
    String Codigo, Nombre;
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

    public DepartamentoDTO getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(DepartamentoDTO Departamento) {
        this.Departamento = Departamento;
    }
    
}
