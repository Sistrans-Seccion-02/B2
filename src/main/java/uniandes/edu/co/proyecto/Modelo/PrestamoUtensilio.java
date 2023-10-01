package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "PrestamosUtensilios")
public abstract class PrestamoUtensilio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idutensilio;
    private Integer cantidad;
    private double precio;
    private String tipo;
    private Boolean estado;

    public PrestamoUtensilio(Integer cantidad, double precio, String tipo, Boolean estado) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.tipo = tipo;
        this.estado = estado;
    }

    public PrestamoUtensilio() 
    {;}

    public Integer getIdutensilio() {
        return idutensilio;
    }

    public void setIdutensilio(Integer idutensilio) {
        this.idutensilio = idutensilio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    

    
}
