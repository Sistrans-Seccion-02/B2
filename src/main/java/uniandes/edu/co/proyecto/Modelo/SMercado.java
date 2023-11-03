package uniandes.edu.co.proyecto.Modelo;

import java.time.LocalTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SMercados")
public class SMercado  {
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private LocalTime horarioapertura;
    private LocalTime horariocierre;
    private Integer capacidad;

    public SMercado(String nombre, LocalTime horarioapertura, LocalTime horariocierre, Integer capacidad) {
        this.nombre = nombre;
        this.horarioapertura = horarioapertura;
        this.horariocierre = horariocierre;
        this.capacidad = capacidad;
    }

    public SMercado() {;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalTime getHorarioapertura() {
        return horarioapertura;
    }

    public void setHorarioapertura(LocalTime horarioapertura) {
        this.horarioapertura = horarioapertura;
    }

    public LocalTime getHorariocierre() {
        return horariocierre;
    }

    public void setHorariocierre(LocalTime horariocierre) {
        this.horariocierre = horariocierre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

}

