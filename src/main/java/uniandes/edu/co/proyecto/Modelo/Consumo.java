package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Consumos")
public class Consumo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idconsumo;
  
    public Consumo(Integer idconsumo) {
        this.idconsumo = idconsumo;
        
    }
    public Consumo() {;}


    public int getIdConsumo() {
        return idconsumo;
    }

    public void setIdConsumo(int idConsumo) {
        this.idconsumo = idConsumo;
    }
    
}
