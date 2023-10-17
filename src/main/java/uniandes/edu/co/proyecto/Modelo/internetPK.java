package uniandes.edu.co.proyecto.Modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Embeddable

public class internetPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "consumos_idconsumo", referencedColumnName = "idconsumo")
    private Consumo consumos_idconsumo;
    private Integer capacidad;

    public internetPK() { super();}

    public internetPK(Consumo consumos_idconsumo, Integer capacidad) {
        super();
        this.consumos_idconsumo = consumos_idconsumo;
        this.capacidad = capacidad;
    }

    public Consumo getConsumos_idconsumo() {
        return consumos_idconsumo;
    }

    public void setConsumos_idconsumo(Consumo consumos_idconsumo) {
        this.consumos_idconsumo = consumos_idconsumo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
    
}
