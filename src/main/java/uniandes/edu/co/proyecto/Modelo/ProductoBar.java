package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "productosbares")
public class ProductoBar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "platosbebidasid", referencedColumnName = "id")
    private PlatoBebida platoBebidaId;

    @ManyToOne
    @JoinColumn(name = "barid", referencedColumnName = "id")
    private Bar barId;
  
    public ProductoBar(PlatoBebida platoBebidaId, Bar barId) {
        
        this.platoBebidaId = platoBebidaId;
        this.barId = barId;
        
    }

    public ProductoBar() {;}
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public PlatoBebida getPlatoBebidaId() {
        return platoBebidaId;
    }

    public void setPlatoBebidaId(PlatoBebida platoBebidaId) {
        this.platoBebidaId = platoBebidaId;
    }

    public Bar getBarId() {
        return barId;
    }

    public void setBarId(Bar barId) {
        this.barId = barId;
    }
    
}
