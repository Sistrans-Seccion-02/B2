package uniandes.edu.co.proyecto.Modelo;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "reservas")

public  class Reserva {
    @Id
   
    private String id;
    @Field("fechaEntrada")
    private Date fechaentrada;
     @Field("fechaSalida")
    private Date fechasalida;
     @Field("numPersonas")
    private Integer numpersonas;
     @Field("estado")
    private boolean estado;
     @Field("precioReserva")
    private double precioreserva;
    @Field ("docUsuario")
    private String docusuario;
    @Field("habitaciones")
    private List<HabitacionEmbedded> habitaciones;
 
   

    public Reserva(Date fechaentrada, Date fechasalida, Integer numpersonas, boolean estado, double precioreserva,
            String docusuario, List<HabitacionEmbedded> habitaciones) {
        this.fechaentrada = fechaentrada;
        this.fechasalida = fechasalida;
        this.numpersonas = numpersonas;
        this.estado = estado;
        this.precioreserva = precioreserva;
        this.docusuario = docusuario;
        this.habitaciones = habitaciones;
     
    }
    public Reserva(){}

   

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getdocusuario() {
        return docusuario;
    }

    public void setUsuarioId(String docusuario) {
        this.docusuario = docusuario;
    }
    public List<HabitacionEmbedded> getHabitaciones() {
        return habitaciones;
    }
    public void setHabitaciones(List<HabitacionEmbedded> habitaciones) {
        this.habitaciones = habitaciones;
    }

    

   

    
    
}
