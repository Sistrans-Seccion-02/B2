package uniandes.edu.co.proyecto.Modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="reservas")


public abstract class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private Date FechaEntrada;
    private Date FechaSalida;
    private Integer numPersonas;
    private boolean estado;

    public Reserva(Date FechaEntrada, Date FechaSalida, Integer numPersonas, boolean estado) {
        this.FechaEntrada = FechaEntrada;
        this.FechaSalida = FechaSalida;
        this.numPersonas = numPersonas;
        this.estado = estado;
    }

    public Reserva() 
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaEntrada() {
        return FechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        FechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return FechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        FechaSalida = fechaSalida;
    }

    public Integer getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(Integer numPersonas) {
        this.numPersonas = numPersonas;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


    
    
}
