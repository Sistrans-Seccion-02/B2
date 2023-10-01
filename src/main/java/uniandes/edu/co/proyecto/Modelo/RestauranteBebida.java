package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "RestaurantesBebidas")
public class RestauranteBebida {
    @EmbeddedId
    private RestauranteBebidaPK pk;

    public RestauranteBebida(Restaurante nombreRestaurante, Bebida nombreBebida) {
        this.pk = new RestauranteBebidaPK(nombreRestaurante, nombreBebida);
    }

    public RestauranteBebida() 
    {;}

    public RestauranteBebidaPK getPk() {
        return pk;
    }

    public void setPk(RestauranteBebidaPK pk) {
        this.pk = pk;
    }

}
