package ModeloDTO;

import java.util.Date;

public class ProductoDTO {
  private int Codigo;
  private int Stock;
  private Date Vencimiento;
    private String Nombre;
    private Float Precio;

    /**
     * @return the Codigo
     */
    public int getCodigo() {
        return Codigo;
    }

    /**
     * @param Codigo the Codigo to set
     */
    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    /**
     * @return the Stock
     */
    public int getStock() {
        return Stock;
    }

    /**
     * @param Stock the Stock to set
     */
    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    /**
     * @return the Vencimiento
     */
    public Date getVencimiento() {
        return Vencimiento;
    }

    /**
     * @param Vencimiento the Vencimiento to set
     */
    public void setVencimiento(Date Vencimiento) {
        this.Vencimiento = Vencimiento;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Precio
     */
    public Float getPrecio() {
        return Precio;
    }

    /**
     * @param Precio the Precio to set
     */
    public void setPrecio(Float Precio) {
        this.Precio = Precio;
    }
  
  
}
