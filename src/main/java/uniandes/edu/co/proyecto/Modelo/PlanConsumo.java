package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "planesconsumo")

public class PlanConsumo {

    @Id
    private String tipo;

    private float dtonoche;
    private String descripcion;
    private double descuentobar;
    private double descuentorest;
    private double descuentospa;
    private int limitebebidas;
    private double descuentolavado;

    public PlanConsumo() {
        ;
    }

    public PlanConsumo(String tipo, float dtonoche, String descripcion, double descuentobar, double descuentorest,
            double descuentospa, int limitebebidas, double descuentolavado) {
        this.tipo = tipo;
        this.dtonoche = dtonoche;
        this.descripcion = descripcion;
        this.descuentobar = descuentobar;
        this.descuentorest = descuentorest;
        this.descuentospa = descuentospa;
        this.limitebebidas = limitebebidas;
        this.descuentolavado = descuentolavado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getDtonoche() {
        return dtonoche;
    }

    public void setDtonoche(float dtonoche) {
        this.dtonoche = dtonoche;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getDescuentobar() {
        return descuentobar;
    }

    public void setDescuentobar(double descuentobar) {
        this.descuentobar = descuentobar;
    }

    public double getDescuentorest() {
        return descuentorest;
    }

    public void setDescuentorest(double descuentorest) {
        this.descuentorest = descuentorest;
    }

    public double getDescuentoSpa() {
        return descuentospa;
    }

    public void setDescuentoSpa(double descuentospa) {
        this.descuentospa = descuentospa;
    }

    public int getLimitebebidas() {
        return limitebebidas;
    }

    public void setLimitebebidas(int limitebebidas) {
        this.limitebebidas = limitebebidas;
    }

    public double getDescuentolavado() {
        return descuentolavado;
    }

    public void setDescuentolavado(double descuentolavado) {
        this.descuentolavado = descuentolavado;
    }

}