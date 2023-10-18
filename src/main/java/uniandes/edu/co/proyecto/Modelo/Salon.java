package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

import java.time.LocalTime;

@Entity
@Table(name = "Salones")
public class Salon {
    
    @Id
    private String nombre;
    private LocalTime horarioapertura;
    private LocalTime horariocierre;
    private String tipoSalon;
    private Integer capacidad;

    public Salon(String nombre, double precio, LocalTime horarioapertura, LocalTime horariocierre, String tipoSalon, int capacidad) {
        this.nombre = nombre;
        this.horarioapertura = horarioapertura;
        this.horariocierre = horariocierre;
        this.tipoSalon = tipoSalon;
        this.capacidad = capacidad;
    }

    public Salon() 
    {;}

    
    
    public String getNombre() {
        return nombre;
    }

    public LocalTime getHorarioApertura() {
        return horarioapertura;
    }

    public LocalTime getHorarioCierre() {
        return horariocierre;
    }

    public String getTipoSalon() {
        return tipoSalon;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHorarioApertura(LocalTime horarioapertura) {
        this.horarioapertura = horarioapertura;
    }

    public void setHorarioCierre(LocalTime horariocierre) {
        this.horariocierre = horariocierre;
    }

    public void setTipoSalon(String tipoSalon) {
        this.tipoSalon = tipoSalon;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

}
