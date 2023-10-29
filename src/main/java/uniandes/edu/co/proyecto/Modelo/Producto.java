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
<<<<<<< HEAD
    @JoinColumn(name = "tiendaid", referencedColumnName = "id")
    private Tienda tienda;

    @ManyToOne
    @JoinColumn(name = "smercadoid", referencedColumnName = "id")
    private SMercado smercado_nombre;

    @ManyToOne
    @JoinColumn(name = "consumoid", referencedColumnName = "id")
    private Consumo Consumos_idconsumo;
=======
    @JoinColumn(name = "tiendas_nombre", referencedColumnName = "nombre")
    public Tienda tiendas_nombre;

    @ManyToOne
    @JoinColumn(name = "smercados_nombre", referencedColumnName = "nombre")
    private SMercado smercados_nombre;

    @ManyToOne
    @JoinColumn(name = "Consumos_idconsumo", referencedColumnName = "idConsumo")
    public Consumo Consumos_idconsumo;
>>>>>>> bf9f5b61143cf465a60316e6edc06db4975209a6


    public Producto(String nombre, double precio, Tienda tiendas_nombre, SMercado smercados_nombre, Consumo Consumos_idconsumo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tiendas_nombre = tiendas_nombre;
        this.smercados_nombre = smercados_nombre;
        this.Consumos_idconsumo = Consumos_idconsumo;
    }

    public Tienda getTienda() {
        return tiendas_nombre;
    }

    public void setTienda(Tienda tienda) {
        this.tiendas_nombre = tienda;
    }

    public SMercado getsMercado() {
        return smercados_nombre;
    }

    public void setsMercado(SMercado smercados_nombre) {
        this.smercados_nombre = smercados_nombre;
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

    public Consumo getConsumos_idConsumo() {
        return Consumos_idconsumo;
    }

    public void setConsumos_idconsumo(Consumo consumos_idconsumo) {
        Consumos_idconsumo = consumos_idconsumo;
    }
    
}
