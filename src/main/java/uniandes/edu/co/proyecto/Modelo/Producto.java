package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Productos")
public class Producto  {
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "consumoid", referencedColumnName = "id")
    private Consumo consumoid;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "tiendaid", referencedColumnName = "id")
    private Tienda tiendaid;
    @ManyToOne
    @JoinColumn(name = "smercadoid", referencedColumnName = "id")
    private SMercado smercadoid;
    private double preciofinal;

    public Producto(String nombre, Consumo consumoid, Tienda tiendaid, SMercado smercadoid, double preciofinal) {
        this.nombre = nombre;
        this.consumoid = consumoid;
        this.tiendaid = tiendaid;
        this.smercadoid = smercadoid;
        this.preciofinal = preciofinal;
        
    }

    public Producto() {;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Consumo getConsumoid() {
        return consumoid;
    }

    public void setConsumoid(Consumo consumoid) {
        this.consumoid = consumoid;
    }

    public Tienda getTiendaid() {
        return tiendaid;
    }

    public void setTiendaid(Tienda tiendaid) {
        this.tiendaid = tiendaid;
    }

    public SMercado getSmercadoid() {
        return smercadoid;
    }

    public void setSmercadoid(SMercado smercadoid) {
        this.smercadoid = smercadoid;
    }

    public double getPreciofinal() {
        return preciofinal;
    }

    public void setPreciofinal(double preciofinal) {
        this.preciofinal = preciofinal;
    }
    
}
