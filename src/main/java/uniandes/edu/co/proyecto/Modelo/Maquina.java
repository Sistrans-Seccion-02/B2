package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "Maquinas")
public  class Maquina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idMaquina;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "Gimnasios_nombre", referencedColumnName = "nombre")
    private Gimnasio Gimnasios_nombre;
    

    public Maquina(String nombre, Gimnasio Gimnasios_nombre) {
        this.nombre = nombre;
        this.Gimnasios_nombre = Gimnasios_nombre;
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

    public Gimnasio getGimnasios_nombre() {
        return Gimnasios_nombre;
    }

    public void setGimnasios_nombre(Gimnasio Gimnasios_nombre) {
        this.Gimnasios_nombre = Gimnasios_nombre;
    }
}
