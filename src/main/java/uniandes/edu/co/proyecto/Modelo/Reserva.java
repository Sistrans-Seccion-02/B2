package uniandes.edu.co.proyecto.Modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="reservas")


public  class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private Date FechaEntrada;
    private Date FechaSalida;
    private Integer numPersonas;
    private boolean estado;
    private double precioReserva;
    @JoinColumn(name = "tipoPlanConsumo", referencedColumnName = "tipo")
    private PlanConsumo tipo;
    @JoinColumn(name = "usuarioID", referencedColumnName = "id")
    private Usuario idUsuario;

    public Reserva(Date FechaEntrada, Date FechaSalida, Integer numPersonas, boolean estado, double precioReserva, PlanConsumo tipo, Usuario idUsuario) {
        this.FechaEntrada = FechaEntrada;
        this.FechaSalida = FechaSalida;
        this.numPersonas = numPersonas;
        this.estado = estado;
        this.tipo = tipo;
        this.precioReserva = precioReserva;
        this.idUsuario = idUsuario;
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
    public boolean getEstado() {
        return estado;
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

    public double getPrecioReserva() {
        return precioReserva;
    }

    public void setPrecioReserva(double precioReserva) {
        this.precioReserva = precioReserva;
    }

    public PlanConsumo getTipo() {
        return tipo;
    }

    public void setTipo(PlanConsumo tipo) {
        this.tipo = tipo;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }


    
    
}
