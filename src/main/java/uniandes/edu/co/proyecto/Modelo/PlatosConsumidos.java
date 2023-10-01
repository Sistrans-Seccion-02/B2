package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "platosConsumidos")
public class PlatosConsumidos {
    @EmbeddedId
    private PlatosConsumidosPK pk;

    public PlatosConsumidos(Consumo consumo, Plato plato) {
        this.pk = new PlatosConsumidosPK(consumo, plato);
    }

    public PlatosConsumidos() 
    {;}

    public PlatosConsumidosPK getPk() {
        return pk;
    }

    public void setPk(PlatosConsumidosPK pk) {
        this.pk = pk;
    }
    
}
