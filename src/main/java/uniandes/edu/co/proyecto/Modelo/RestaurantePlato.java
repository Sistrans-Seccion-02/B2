package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "RestPlato")
public class RestaurantePlato {
    @EmbeddedId
    private RestaurantePlatoPK pk;

    public RestaurantePlato(Restaurante nombreRestaurante, Plato nombrePlato) {
        this.pk = new RestaurantePlatoPK(nombreRestaurante, nombrePlato);
    }

    public RestaurantePlato() 
    {;}

    public RestaurantePlatoPK getPk() {
        return pk;
    }

    public void setPk(RestaurantePlatoPK pk) {
        this.pk = pk;
    }
}
