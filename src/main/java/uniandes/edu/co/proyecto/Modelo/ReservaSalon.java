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
@Table(name = "ReservasSalon")
public  class ReservaSalon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idReserva;
    private Integer duracion;
    private LocalDateTime fecha;
    @ManyToOne
    @JoinColumn(name = "SalonesNombre", referencedColumnName = "nombre")
    private Salon SalonesNombre;


    public ReservaSalon(Integer duracion, LocalDateTime fecha, Salon SalonesNombre) {
        this.duracion = duracion;
        this.fecha = fecha;
        this.SalonesNombre = SalonesNombre;
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
    
    public Salon getNombreSalon() {
        return SalonesNombre;
    }

    public void setNombreSalon(Salon nombreSpa) {
        this.SalonesNombre = nombreSpa;
    }
}
