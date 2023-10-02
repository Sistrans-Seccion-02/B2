package uniandes.edu.co.proyecto.Modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reservas")


public  class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer idReserva;
    private Date FechaEntrada;
    private Date FechaSalida;
    private Integer numPersonas;
    private boolean estado;
    private double precioReserva;
    @ManyToOne
    @JoinColumn(name = "tipoPlanConsumo", referencedColumnName = "tipo")
    private PlanConsumo tipoPlanConsumo;
    @ManyToOne
    @JoinColumn(name = "usuarioID", referencedColumnName = "id")
    private Usuario usuarioID;

    public Reserva(Date FechaEntrada, Date FechaSalida, Integer numPersonas, boolean estado, double precioReserva, PlanConsumo tipoPlanConsumo, Usuario usuarioID) {
        this.FechaEntrada = FechaEntrada;
        this.FechaSalida = FechaSalida;
        this.numPersonas = numPersonas;
        this.estado = estado;
        this.tipoPlanConsumo = tipoPlanConsumo;
        this.precioReserva = precioReserva;
        this.usuarioID = usuarioID;
    }

    public Reserva() 
    {;}

    public Integer getId() {
        return idReserva;
    }

    public void setId(Integer idReserva) {
        this.idReserva = idReserva;
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
        return tipoPlanConsumo;
    }

    public void setTipo(PlanConsumo tipoPlanConsumo) {
        this.tipoPlanConsumo = tipoPlanConsumo;
    }

    public Usuario getIdUsuario() {
        return usuarioID;
    }

    public void setIdUsuario(Usuario usuarioID) {
        this.usuarioID = usuarioID;
    }


    
    
}
