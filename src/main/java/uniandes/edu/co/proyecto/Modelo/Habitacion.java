package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="habitacion")
public  class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String capacidad;

    @ManyToOne
    @JoinColumn(name = "tipoid", referencedColumnName = "id")
    private TipoHabitacion tipoId;

    public Habitacion(String capacidad, TipoHabitacion tipoId) {
        this.capacidad = capacidad;
        this.tipoId = tipoId;
    }

    public Habitacion() 
    {;}

    public TipoHabitacion getTipoId() {
        return tipoId;
    }
    public void setTipoId(TipoHabitacion tipoId) {
        this.tipoId = tipoId;
    }
    
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
