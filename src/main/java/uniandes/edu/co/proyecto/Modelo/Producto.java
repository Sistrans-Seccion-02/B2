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

    @JoinColumn(name = "tiendaid", referencedColumnName = "id")
    private Tienda tienda;

    @ManyToOne
    @JoinColumn(name = "smercadoid", referencedColumnName = "id")
    private SMercado smercado;

    @ManyToOne
    @JoinColumn(name = "consumoid", referencedColumnName = "id")
    private Consumo conusmoid;



    public Producto(String nombre, double precio, Tienda tiendas_nombre, SMercado smercados_nombre, Consumo Consumos_idconsumo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tienda = tiendas_nombre;
        this.smercado = smercados_nombre;
        this.conusmoid = Consumos_idconsumo;
    }

    public Producto() {;
    }

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

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public SMercado getSmercado() {
        return smercado;
    }

    public void setSmercado(SMercado smercado) {
        this.smercado = smercado;
    }

    public Consumo getConusmoid() {
        return conusmoid;
    }

    public void setConusmoid(Consumo conusmoid) {
        this.conusmoid = conusmoid;
    }   
    
}
