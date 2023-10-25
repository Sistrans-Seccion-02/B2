package uniandes.edu.co.proyecto.Modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "consumos")
public class Consumo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idconsumo;
    private Date fecha;
  
    public Consumo(Integer idconsumo, Date fecha) {
        this.idconsumo = idconsumo;
        this.fecha = fecha;
        
    }
    public Consumo() {;}


    public Integer getIdConsumo() {
        return idconsumo;
    }

    public void setIdConsumo(int idConsumo) {
        this.idconsumo = idConsumo;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
