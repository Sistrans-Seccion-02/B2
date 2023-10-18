package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalTime;

@Entity
@Table(name = "Piscinas")
public class Piscina {
    @Id
    private String nombre;
    private LocalTime horarioapertura;
    private LocalTime horariocierre;
    private Integer profundidad;
    @ManyToOne
    @JoinColumn(name = "Comsumos_idConsumo", referencedColumnName = "idConsumo")
    private Consumo Comsumos_idConsumo;
    private double preciofinal;

    

    public Piscina(String nombre, LocalTime horarioapertura, LocalTime horariocierre, Integer profundidad, Consumo Comsumos_idConsumo, double preciofinal) {
        this.nombre = nombre;
        this.horarioapertura = horarioapertura;
        this.horariocierre = horariocierre;
        this.profundidad = profundidad;
        this.Comsumos_idConsumo = Comsumos_idConsumo;
        this.preciofinal = preciofinal;
    }

    public Piscina() {;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalTime getHorarioApertura() {
        return horarioapertura;
    }

    public void setHorarioApertura(LocalTime horarioapertura) {
        this.horarioapertura = horarioapertura;
    }

    public LocalTime getHorarioCierre() {
        return horariocierre;
    }

    public void setHorarioCierre(LocalTime horariocierre) {
        this.horariocierre = horariocierre;
    }

    public Integer getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(Integer profundidad) {
        this.profundidad = profundidad;
    }

    public Consumo getComsumos_idConsumo() {
        return Comsumos_idConsumo;
    }

    public void setComsumos_idConsumo(Consumo Comsumos_idConsumo) {
        this.Comsumos_idConsumo = Comsumos_idConsumo;
    }
    
    public double getPreciofinal() {
        return preciofinal;
    }

    public void setPreciofinal(double preciofinal) {
        this.preciofinal = preciofinal;
    }
}
