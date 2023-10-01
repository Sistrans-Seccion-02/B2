package uniandes.edu.co.proyecto.Modelo;

import java.io.Serializable;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class RestaurantePlatoPK implements Serializable{
    @ManyToOne
    @JoinColumn(name = "nombreRestaurante", referencedColumnName = "nombre")
    private Restaurante nombreRestaurante;

    @ManyToOne
    @JoinColumn(name = "nombrePlato", referencedColumnName = "nombre")
    private Plato nombrePlato;

    public RestaurantePlatoPK(Restaurante nombreRestaurante, Plato nombrePlato) {
        super();
        this.nombreRestaurante = nombreRestaurante;
        this.nombrePlato = nombrePlato;
    }

    public Restaurante getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(Restaurante nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public Plato getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(Plato nombrePlato) {
        this.nombrePlato = nombrePlato;
    }
}
