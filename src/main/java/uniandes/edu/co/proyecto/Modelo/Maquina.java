package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "Maquinas")
public abstract class Maquina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idMaquina;
    private String nombre;

    public Maquina(String nombre) {
        this.nombre = nombre;
    }

    public Maquina() 
    {;}

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
