package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.LocalDateTime;

@Entity
@Table(name = "ReservaSalon")
public abstract class ReservaSalon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idReserva;
    private Integer duracion;
    private LocalDateTime fecha;
    private String nombreSalon;

    public ReservaSalon(Integer duracion, LocalDateTime fecha, String nombreSalon) {
        this.duracion = duracion;
        this.fecha = fecha;
        this.nombreSalon = nombreSalon;
    }       

    public ReservaSalon() 
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
    
    public String getNombreSalon() {
        return nombreSalon;
    }

    public void setNombreSalon(String nombreSpa) {
        this.nombreSalon = nombreSpa;
    }
}
