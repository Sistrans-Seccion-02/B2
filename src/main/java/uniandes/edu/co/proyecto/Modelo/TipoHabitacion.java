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


public abstract class TipoHabitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    
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

    public Integer getId() {
        return id;
    }
    public String getTipo() {
        return tipo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
