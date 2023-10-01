package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="habitaciones")
public abstract class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private String capacidad;

    public Habitacion(String capacidad) {
        this.capacidad = capacidad;
    }

    public Habitacion() 
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }
    

    
}
