package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Utensilios")
public class Utensilio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "PrestamosUt_idUtensilio", referencedColumnName = "idutensilio")
    private Utensilio PrestamosUt_idUtensilio;

    public Utensilio(String nombre, Utensilio PrestamosUt_idUtensilio) {
        this.nombre = nombre;
        this.PrestamosUt_idUtensilio = PrestamosUt_idUtensilio;
    }

    Utensilio() {;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Utensilio getPrestamosUt_idUtensilio() {
        return PrestamosUt_idUtensilio;
    }

    public void setPrestamosUt_idUtensilio(Utensilio PrestamosUt_idUtensilio) {
        this.PrestamosUt_idUtensilio = PrestamosUt_idUtensilio;
    }


}

