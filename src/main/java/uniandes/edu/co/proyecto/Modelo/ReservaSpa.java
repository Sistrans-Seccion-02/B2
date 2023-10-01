package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.LocalDateTime;

@Entity
@Table(name = "ReservasSpa")
public abstract class ReservaSpa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idReserva;
    private Integer duracion;
    private LocalDateTime fecha;
    private String nombreSpa;

    public ReservaSpa(Integer duracion, LocalDateTime fecha, String nombreSpa) {
        this.duracion = duracion;
        this.fecha = fecha;
        this.nombreSpa = nombreSpa;
    }       

    public ReservaSpa() 
    {;}

    public Integer getIdReserva() {
        return idReserva;
    }
    
    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    
    public String getNombreSpa() {
        return nombreSpa;
    }

    public void setNombreSpa(String nombreSpa) {
        this.nombreSpa = nombreSpa;
    }
}
