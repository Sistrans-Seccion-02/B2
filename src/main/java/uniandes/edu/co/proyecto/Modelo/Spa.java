package uniandes.edu.co.proyecto.Modelo;

import java.time.LocalTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Spas")
public class Spa  {
    @Id
    private String nombre;
    private LocalTime horarioapertura;
    private LocalTime horariocierre;
    private int capacidad;

    public Spa(String nombre, LocalTime horarioapertura, LocalTime horariocierre, int capacidad) {
        this.nombre = nombre;
        this.horarioapertura = horarioapertura;
        this.horariocierre = horariocierre;
        this.capacidad = capacidad;
    }

    public Spa() {;}

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

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
}
