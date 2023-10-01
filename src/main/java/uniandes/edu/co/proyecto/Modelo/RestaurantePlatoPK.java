package uniandes.edu.co.proyecto.Modelo;

import java.io.Serializable;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class RestaurantePlatoPK implements Serializable{
    @ManyToOne
    @JoinColumn(name = "nombreRestaurante", referencedColumnName = "nombre")
    private Bar nombreRestaurante;

    @ManyToOne
    @JoinColumn(name = "nombrePlato", referencedColumnName = "nombre")
    private Bebida nombrePlato;

    public RestaurantePlatoPK(Bar nombreRestaurante, Bebida nombrePlato) {
        super();
        this.nombreRestaurante = nombreRestaurante;
        this.nombrePlato = nombrePlato;
    }

    public Bar getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(Bar nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public Bebida getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(Bebida nombrePlato) {
        this.nombrePlato = nombrePlato;
    }
}
