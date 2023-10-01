package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import java.time.LocalTime;

@Entity
@Table(name = "Rest")
public abstract class Restaurante {
    
    @Id
    private String nombre;
    private String tipo;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private Integer capacidad;

    public Restaurante(String nombre, String tipo, LocalTime horarioApertura, LocalTime horarioCierre, Integer capacidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
        this.capacidad = capacidad;
    }       

    public Restaurante() 
    {;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalTime getHorarioApertura() {
        return horarioApertura;
    }

    public void setHorarioApertura(LocalTime horarioApertura) {
        this.horarioApertura = horarioApertura;
    }

    public LocalTime getHorarioCierre() {
        return horarioCierre;
    }

    public void setHorarioCierre(LocalTime horarioCierre) {
        this.horarioCierre = horarioCierre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    
}
