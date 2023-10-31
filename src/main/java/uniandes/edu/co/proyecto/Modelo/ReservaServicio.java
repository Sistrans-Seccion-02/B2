package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.LocalDateTime;

@Entity
@Table(name = "ReservasServicio")
public  class ReservaServicio {
    private LocalDateTime fechayhorai;
    private LocalDateTime fechayhoraf;
    @ManyToOne
    @JoinColumn(name="consumoid", referencedColumnName = "id")
    private Consumo consumoid;
    private double precio;
    private String descripcion;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    
    public ReservaServicio(LocalDateTime fechayhorai, LocalDateTime fechayhoraf, String descripcion, double precio) {
        this.fechayhorai = fechayhorai;
        this.fechayhoraf = fechayhoraf;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public ReservaServicio() 
    {;}

    public LocalDateTime getFechayhorai() {
        return fechayhorai;
    }

    public void setFechayhorai(LocalDateTime fechayhorai) {
        this.fechayhorai = fechayhorai;
    }

    public LocalDateTime getFechayhoraf() {
        return fechayhoraf;
    }

    public void setFechayhoraf(LocalDateTime fechayhoraf) {
        this.fechayhoraf = fechayhoraf;
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

    

}
