package uniandes.edu.co.proyecto.Modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class BarBebidaPK implements Serializable{
    @ManyToOne
    @JoinColumn(name = "nombreBar", referencedColumnName = "nombre")
    private Bar nombreBar;

    @ManyToOne
    @JoinColumn(name = "nombreBebida", referencedColumnName = "nombre")
    private Bebida nombreBebida;

    public BarBebidaPK(Bar nombreBar, Bebida nombreBebida) {
        super();
        this.nombreBar = nombreBar;
        this.nombreBebida = nombreBebida;
    }

    public Bar getNombreBar() {
        return nombreBar;
    }

    public void setNombreBar(Bar nombreBar) {
        this.nombreBar = nombreBar;
    }

    public Bebida getNombreBebida() {
        return nombreBebida;
    }

    public void setNombreBebida(Bebida nombreBebida) {
        this.nombreBebida = nombreBebida;
    }

    

}
