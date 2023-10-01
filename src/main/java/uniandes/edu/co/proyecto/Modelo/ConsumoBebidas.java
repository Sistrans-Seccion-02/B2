package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "consumoBebida")
public class ConsumoBebidas {
    @EmbeddedId
    private ConsumoBebidasPK pk;

    public ConsumoBebidas(Consumo consumo, Bebida bebida) {
        this.pk = new ConsumoBebidasPK(consumo, bebida);
    }

    public ConsumoBebidas() 
    {;}

    public ConsumoBebidasPK getPk() {
        return pk;
    }

    public void setPk(ConsumoBebidasPK pk) {
        this.pk = pk;
    }
}
