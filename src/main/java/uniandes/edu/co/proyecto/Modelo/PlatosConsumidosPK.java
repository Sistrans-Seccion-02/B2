package uniandes.edu.co.proyecto.Modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class PlatosConsumidosPK implements Serializable{
    @ManyToOne
    @JoinColumn(name = "Consumos_IdConsumo", referencedColumnName = "idConsumo")
    private Consumo Consumos_IdConsumo;

    @ManyToOne
    @JoinColumn(name = "Platos_nombre", referencedColumnName = "nombre")
    private Plato Platos_nombre;

    public PlatosConsumidosPK(Consumo Consumos_IdConsumo, Plato Platos_nombre) {
        super();
        this.Consumos_IdConsumo = Consumos_IdConsumo;
        this.Platos_nombre = Platos_nombre;
    }

    public Consumo getConsumos_IdConsumo() {
        return Consumos_IdConsumo;
    }

    public void setConsumos_IdConsumo(Consumo consumos_IdConsumo) {
        Consumos_IdConsumo = consumos_IdConsumo;
    }

    public Plato getPlatos_nombre() {
        return Platos_nombre;
    }

    public void setPlatos_nombre(Plato platos_nombre) {
        Platos_nombre = platos_nombre;
    }

    
}
