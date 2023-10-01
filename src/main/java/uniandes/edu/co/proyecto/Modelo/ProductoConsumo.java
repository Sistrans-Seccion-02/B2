package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="productosConsumos")
public class ProductoConsumo {
    @EmbeddedId
    private ProductoConsumoPK pk;

    public ProductoConsumo(Consumo idConsumo, Producto nombre) {
        this.pk=new ProductoConsumoPK(idConsumo, nombre);
    }

    public ProductoConsumo() {;}

    public ProductoConsumoPK getPk() {
        return pk;
    }

    public void setPk(ProductoConsumoPK pk) {
        this.pk = pk;
    }
    
}
