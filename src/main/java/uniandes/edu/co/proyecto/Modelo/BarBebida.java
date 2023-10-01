package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "BaresBebidas")
public class BarBebida {
    @EmbeddedId
    private BarBebidaPK pk;

    public BarBebida(Bar nombreBar, Bebida nombreBebida) {
        this.pk = new BarBebidaPK(nombreBar, nombreBebida);
    }

    public BarBebida() 
    {;}

    public BarBebidaPK getPk() {
        return pk;
    }

    public void setPk(BarBebidaPK pk) {
        this.pk = pk;
    }

    
}
