package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import java.time.LocalTime;

@Entity
@Table(name = "Salones")
public abstract class Salon {
    
    @Id
    
    private String nombre;
    private double precio;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private Boolean ocupado;
    private String tipoSalon;
    private Integer capacidad;

    public Salon(String nombre, double precio, LocalTime horarioApertura, LocalTime horarioCierre, Boolean ocupado, String tipoSalon, int capacidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
        this.ocupado = ocupado;
        this.tipoSalon = tipoSalon;
        this.capacidad = capacidad;
    }

    public Salon() 
    {;}

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public LocalTime getHorarioApertura() {
        return horarioApertura;
    }

    public LocalTime getHorarioCierre() {
        return horarioCierre;
    }

    public Boolean getOcupado() {
        return ocupado;
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

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setHorarioApertura(LocalTime horarioApertura) {
        this.horarioApertura = horarioApertura;
    }

    public void setHorarioCierre(LocalTime horarioCierre) {
        this.horarioCierre = horarioCierre;
    }

    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }

    public void setTipoSalon(String tipoSalon) {
        this.tipoSalon = tipoSalon;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    

}
