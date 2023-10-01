package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "Lavanderias")
public abstract class Lavanderia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idLavanderia;
    private Integer numPrendas;
    private Integer numZapatos;
    private String tipoLavado;
    private double costo;

    public Lavanderia(Integer numPrendas, Integer numZapatos, String tipoLavado, double costo) {
        this.numPrendas = numPrendas;
        this.numZapatos = numZapatos;
        this.tipoLavado = tipoLavado;
        this.costo = costo;
    }

    public Lavanderia() 
    {;}

    public Integer getIdLavanderia() {
        return idLavanderia;
    }

    public void setIdLavanderia(Integer idLavanderia) {
        this.idLavanderia = idLavanderia;
    }

    public Integer getNumPrendas() {
        return numPrendas;
    }

    public void setNumPrendas(Integer numPrendas) {
        this.numPrendas = numPrendas;
    }

    public Integer getNumZapatos() {
        return numZapatos;
    }

    public void setNumZapatos(Integer numZapatos) {
        this.numZapatos = numZapatos;
    }

    public String getTipoLavado() {
        return tipoLavado;
    }

    public void setTipoLavado(String tipoLavado) {
        this.tipoLavado = tipoLavado;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    
}
