package uniandes.edu.co.proyecto.Modelo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.Check;


@Entity
@Table(name="tiposHabitacion")


public  class TipoHabitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    
    
    @Column(name = "tipo")
    @Check(constraints = "tipo IN ('PRESIDENCIAL', 'SUITE', 'FAMILIAR', 'DOBLE', 'SENCILLA')")
    private String tipo;
    private String descripcion;

    public TipoHabitacion(String tipo, String descripcion) {
        this.tipo = tipo;
        this.descripcion = descripcion;
    }
    public TipoHabitacion() 
    {;}

    
    public String getTipo() {
        return tipo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
