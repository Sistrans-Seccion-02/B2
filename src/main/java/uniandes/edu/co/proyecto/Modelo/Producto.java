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
    @JoinColumn(name = "smercado_nombre", referencedColumnName = "nombre")
    private SMercado smercado_nombre;

    @ManyToOne
    @JoinColumn(name = "Comsumos_idConsumo", referencedColumnName = "idConsumo")
    private Consumo Comsumos_idConsumo;


    public Producto(String nombre, double precio, Tienda tienda, SMercado smercado_nombre, Consumo Comsumos_idConsumo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tienda = tienda;
        this.smercado_nombre = smercado_nombre;
        this.Comsumos_idConsumo = Comsumos_idConsumo;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public SMercado getsMercado() {
        return smercado_nombre;
    }

    public void setsMercado(SMercado smercado_nombre) {
        this.smercado_nombre = smercado_nombre;
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

    public Consumo getComsumos_idConsumo() {
        return Comsumos_idConsumo;
    }

    public void setComsumos_idConsumo(Consumo comsumos_idConsumo) {
        Comsumos_idConsumo = comsumos_idConsumo;
    }
    
}
