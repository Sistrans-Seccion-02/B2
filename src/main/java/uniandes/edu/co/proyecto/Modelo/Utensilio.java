package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicio")
public class Utensilio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String descripcion;
    private double precio;
    @ManyToOne
    @JoinColumn(name="consumoid", referencedColumnName = "id")
    private Consumo consumoid;
    private Integer duracion;
    

    public Utensilio(String descripcion, double precio, Consumo consumoid, Integer duracion) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.consumoid = consumoid;
        this.duracion = duracion;
    }

    public Utensilio() {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Consumo getConsumoid() {
        return consumoid;
    }

    public void setConsumoid(Consumo consumoid) {
        this.consumoid = consumoid;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    
}

