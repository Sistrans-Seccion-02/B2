package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "platosbebidas")
public class PlatoBebida {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nombre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Consumo getConsumoId() {
        return consumoId;
    }

    public void setConsumoId(Consumo consumoId) {
        this.consumoId = consumoId;
    }

    private double precio;

    @ManyToOne
    @JoinColumn(name = "consumoid", referencedColumnName = "id")
    private Consumo consumoId;

    public PlatoBebida(String nombre, double precio, Consumo consumoId) {
        this.nombre = nombre;
        this.precio = precio;
        this.consumoId = consumoId;
    }

    public PlatoBebida() {;}
     
}
