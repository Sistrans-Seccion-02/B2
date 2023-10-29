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
    private Integer id;
    private Date fechaentrada;
    private Date fechasalida;
    private Integer numpersonas;
    private boolean estado;
    private double precioreserva;
    @ManyToOne
    @JoinColumn(name = "usuariosid", referencedColumnName = "id")
    private Usuario usuarioId;

    @ManyToOne
    @JoinColumn(name = "planid", referencedColumnName = "id")
    private PlanConsumo planId;

    @ManyToOne
    @JoinColumn(name = "habitacionid", referencedColumnName = "id")
    private Habitacion habitacionId;
   

    public Reserva(Date fechaentrada, Date fechasalida, Integer numpersonas, boolean estado, double precioreserva,
            Usuario usuarioid, PlanConsumo planId, Habitacion habitacionId ) {
        this.fechaentrada = fechaentrada;
        this.fechasalida = fechasalida;
        this.numpersonas = numpersonas;
        this.estado = estado;
        this.precioreserva = precioreserva;
        this.usuarioId = usuarioid;
        this.planId = planId;
        this.habitacionId = habitacionId;
    }

    public Reserva() 
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaentrada() {
        return fechaentrada;
    }

    public void setFechaentrada(Date fechaentrada) {
        this.fechaentrada = fechaentrada;
    }

    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public Integer getNumpersonas() {
        return numpersonas;
    }

    public void setNumpersonas(Integer numpersonas) {
        this.numpersonas = numpersonas;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getPrecioreserva() {
        return precioreserva;
    }

    public void setPrecioreserva(double precioreserva) {
        this.precioreserva = precioreserva;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Habitacion getHabitacionId() {
        return habitacionId;
    }
    public void setHabitacionId(Habitacion habitacionId) {
        this.habitacionId = habitacionId;
    }

    public PlanConsumo getPlanid() {
        return planId;
    }
    public void setPlanId(PlanConsumo planId) {
        this.planId = planId;
    }

    

   

    
    
}
