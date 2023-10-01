package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;


@Entity
@Table(name = "Bebida")
public abstract class Bebida {
    
    @Id
    private String nombre;
    private double precio;
    private Boolean todoIncluido;

    public Bebida(String nombre, double precio, Boolean todoIncluido) {
        this.nombre = nombre;
        this.precio = precio;
        this.todoIncluido = todoIncluido;
    }

    public Bebida() 
    {;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Boolean getTodoIncluido() {
        return todoIncluido;
    }

    public void setTodoIncluido(Boolean todoIncluido) {
        this.todoIncluido = todoIncluido;
    }
    
}
