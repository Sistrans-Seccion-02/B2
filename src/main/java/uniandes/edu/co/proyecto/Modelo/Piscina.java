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
    @JoinColumn(name = "Consumos_idconsumo", referencedColumnName = "idConsumo")
    private Consumo Consumos_idconsumo;
    private double preciofinal;

    

    public Piscina(String nombre, LocalTime horarioapertura, LocalTime horariocierre, Integer profundidad, Consumo Consumos_idconsumo, double preciofinal) {
        this.nombre = nombre;
        this.horarioapertura = horarioapertura;
        this.horariocierre = horariocierre;
        this.profundidad = profundidad;
        this.Consumos_idconsumo = Consumos_idconsumo;
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

    public Consumo getConsumos_idConsumo() {
        return Consumos_idconsumo;
    }

    public void setConsumos_idConsumo(Consumo Consumos_idconsumo) {
        this.Consumos_idconsumo = Consumos_idconsumo;
    }
    
    public double getPreciofinal() {
        return preciofinal;
    }

    public void setPreciofinal(double preciofinal) {
        this.preciofinal = preciofinal;
    }
}
