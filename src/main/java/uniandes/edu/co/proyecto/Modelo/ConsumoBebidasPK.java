package uniandes.edu.co.proyecto.Modelo;
import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ConsumoBebidasPK implements Serializable{
    @ManyToOne
    @JoinColumn(name = "Consumos_IdConsumo", referencedColumnName = "idConsumo")
    private Consumo Consumos_IdConsumo;

    @ManyToOne
    @JoinColumn(name = "Bebidas_nombre", referencedColumnName = "nombre")
    private Bebida Bebidas_nombre;

    public ConsumoBebidasPK(Consumo Consumos_IdConsumo, Bebida Bebidas_nombre) {
        super();
        this.Consumos_IdConsumo = Consumos_IdConsumo;
        this.Bebidas_nombre = Bebidas_nombre;
    }

    public Consumo getConsumos_IdConsumo() {
        return Consumos_IdConsumo;
    }

    public void setConsumos_IdConsumo(Consumo consumos_IdConsumo) {
        Consumos_IdConsumo = consumos_IdConsumo;
    }

    public Bebida getBebidas_nombre() {
        return Bebidas_nombre;
    }

    public void setBebidas_nombre(Bebida bebidas_nombre) {
        Bebidas_nombre = bebidas_nombre;
    }

    
}
