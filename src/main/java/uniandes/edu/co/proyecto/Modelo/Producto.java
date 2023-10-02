package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Productos")
public class Producto  {
    @Id
    private String nombre;
    private double precio;

    @ManyToOne
    @JoinColumn(name = "tienda", referencedColumnName = "nombre")
    private Tienda tienda;

    @ManyToOne
    @JoinColumn(name = "sMercado", referencedColumnName = "nombre")
    private SMercado sMercado;


    public Producto(String nombre, double precio, Tienda tienda, SMercado sMercado) {
        this.nombre = nombre;
        this.precio = precio;
        this.tienda = tienda;
        this.sMercado = sMercado;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public SMercado getsMercado() {
        return sMercado;
    }

    public void setsMercado(SMercado sMercado) {
        this.sMercado = sMercado;
    }

    public Producto() {;}

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
    
}
