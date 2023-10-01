package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.LocalDateTime;


@Entity
@Table(name = "ReservaServicio")
public abstract class ReservaServicio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idReserva;
    private Integer duracion;
    private LocalDateTime fecha;

    public ReservaServicio(Integer duracion, LocalDateTime fecha) {
        this.duracion = duracion;
        this.fecha = fecha;
    }       

    public ReservaServicio() 
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
    
}
