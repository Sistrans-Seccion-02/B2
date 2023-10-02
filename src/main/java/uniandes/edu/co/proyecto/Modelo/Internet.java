package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "Internets")
public class Internet {
    @Id
    private Integer capacidad;
    private double precio;
    @ManyToOne
    @JoinColumn(name = "Comsumos_idConsumo", referencedColumnName = "idConsumo")
    private Consumo Comsumos_idConsumo;

    
    public Internet(Integer capacidad, double precio, Consumo comsumos_idConsumo) {
        this.capacidad = capacidad;
        this.precio = precio;
        this.Comsumos_idConsumo = comsumos_idConsumo;
    }

    public Internet() {;}

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Consumo getComsumos_idConsumo() {
        return Comsumos_idConsumo;
    }

    public void setComsumos_idConsumo(Consumo comsumos_idConsumo) {
        Comsumos_idConsumo = comsumos_idConsumo;
    }

    
}
