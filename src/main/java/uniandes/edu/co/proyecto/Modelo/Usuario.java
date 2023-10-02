package uniandes.edu.co.proyecto.Modelo;

import org.hibernate.annotations.Check;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")

public  class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private String cedula;
    private String tipo;
    
    public Usuario(String nombre, String cedula, String tipo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.tipo = tipo;
    }
    public Usuario() 
    {;}

    public Integer getId() {
        return id;
    }   
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
