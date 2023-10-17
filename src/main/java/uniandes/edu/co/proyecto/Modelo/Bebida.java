package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;


@Entity
@Table(name = "Bebidas")
public class Bebida {
    
    @Id
    private String nombre;
    private double precio;
    
    @JoinColumn(name = "todoincluido")
    private Boolean todoincluido;

    public Bebida(String nombre, double precio, Boolean todoincluido) {
        this.nombre = nombre;
        this.precio = precio;
        this.todoincluido = todoincluido;
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
        return todoincluido;
    }

    public void setTodoIncluido(Boolean todoincluido) {
        this.todoincluido = todoincluido;
    }
    
}
