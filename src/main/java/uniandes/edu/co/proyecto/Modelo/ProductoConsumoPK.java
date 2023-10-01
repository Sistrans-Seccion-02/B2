package uniandes.edu.co.proyecto.Modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ProductoConsumoPK implements Serializable {
    @ManyToOne
    @JoinColumn(name="idConsumo", referencedColumnName = "idConsumo")
    private Consumo idConsumo;

    @ManyToOne
    @JoinColumn(name="nombre", referencedColumnName = "nombre")
    private Producto nombre;

    public ProductoConsumoPK(Consumo idConsumo, Producto nombre) {
        super();
        this.idConsumo = idConsumo;
        this.nombre = nombre;
    }

    public Consumo getIdConsumo() {
        return idConsumo;
    }

    public void setIdConsumo(Consumo idConsumo) {
        this.idConsumo = idConsumo;
    }

    public Producto getNombre() {
        return nombre;
    }

    public void setNombre(Producto nombre) {
        this.nombre = nombre;
    }
    
}
