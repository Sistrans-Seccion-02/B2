package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "internets")
public class Internet {


    @EmbeddedId
    private internetPK pk;
    private double precio;
    
    public Internet() {;    }
    public Internet(Consumo consumos_idconsumo, Integer capacidad, double precio) {
        this.pk=new internetPK(consumos_idconsumo, capacidad);
        this.precio=precio;
    }

    public internetPK getPk() {
        return pk;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPk(internetPK pk) {
        this.pk = pk;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
