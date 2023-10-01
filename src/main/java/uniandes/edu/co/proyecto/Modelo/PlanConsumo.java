package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="planesConsumo")


public  class PlanConsumo {
    
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String tipo;
    private double descuento;
    private String descripcion;
    private boolean descuentoBar;
    private boolean descuentoRestaurante;
    private boolean descuentoSpa;
    private int limiteBebidas;
    private boolean descuentoLavado;

    public PlanConsumo(String tipo, double descuento,String descripcion , boolean descuentoBar, boolean descuentoRestaurante, boolean descuentoSpa, int limiteBebidas, boolean descuentoLavado) {
        this.tipo = tipo;

        this.descuento = descuento;
        this.descripcion = descripcion;
        this.descuentoBar = descuentoBar;
        this.descuentoRestaurante = descuentoRestaurante;
        this.descuentoSpa = descuentoSpa;
        this.limiteBebidas = limiteBebidas;
        this.descuentoLavado = descuentoLavado;
    }

    public PlanConsumo() 
    {;}

   

    public String getTipo() {
        return tipo;
    }

    public double getDescuento() {
        return descuento;
    }

    public boolean isDescuentoBar() {
        return descuentoBar;
    }

    public boolean isDescuentoRestaurante() {
        return descuentoRestaurante;
    }

    public boolean isDescuentoSpa() {
        return descuentoSpa;
    }

    public int getLimiteBebidas() {
        return limiteBebidas;
    }

    public boolean isDescuentoLavado() {
        return descuentoLavado;
    }

    

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public void setDescuentoBar(boolean descuentoBar) {
        this.descuentoBar = descuentoBar;
    }

    public void setDescuentoRestaurante(boolean descuentoRestaurante) {
        this.descuentoRestaurante = descuentoRestaurante;
    }

    public void setDescuentoSpa(boolean descuentoSpa) {
        this.descuentoSpa = descuentoSpa;
    }

    public void setLimiteBebidas(int limiteBebidas) {
        this.limiteBebidas = limiteBebidas;
    }

    public void setDescuentoLavado(boolean descuentoLavado) {
        this.descuentoLavado = descuentoLavado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    } 
    
}
