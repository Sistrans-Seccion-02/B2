package uniandes.edu.co.proyecto.Modelo;
import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class RestauranteBebidaPK implements Serializable{
    @ManyToOne
    @JoinColumn(name = "nombreRestaurante", referencedColumnName = "nombre")
    private Restaurante nombreRestaurante;

    @ManyToOne
    @JoinColumn(name = "nombreBebida", referencedColumnName = "nombre")
    private Bebida nombreBebida;

    public RestauranteBebidaPK(Restaurante nombreRestaurante, Bebida nombreBebida) {
        super();
        this.nombreRestaurante = nombreRestaurante;
        this.nombreBebida = nombreBebida;
    }

    public Restaurante getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(Restaurante nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public Bebida getNombreBebida() {
        return nombreBebida;
    }

    public void setNombreBebida(Bebida nombreBebida) {
        this.nombreBebida = nombreBebida;
    }

    
}
