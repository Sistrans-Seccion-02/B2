package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "productosrest")
public class ProductoRestaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "platosbebidasid", referencedColumnName = "id")
    private PlatoBebida platoBebidaId;

    @ManyToOne
    @JoinColumn(name = "restauranteid", referencedColumnName = "id")
    private Restaurante restauranteId;
  
    public ProductoRestaurante(PlatoBebida platoBebidaId, Restaurante restauranteId) {
        
        this.platoBebidaId = platoBebidaId;
        this.restauranteId = restauranteId;
        
    }

    public ProductoRestaurante() {;}
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public PlatoBebida getPlatoBebidaId() {
        return platoBebidaId;
    }

    public void setPlatoBebidaId(PlatoBebida platoBebidaId) {
        this.platoBebidaId = platoBebidaId;
    }

    public Restaurante getRestauranteId() {
        return restauranteId;
    }

    public void setRestauranteId(Restaurante restauranteId) {
        this.restauranteId = restauranteId;
    }

}
