package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "Lavanderias")
public  class Lavanderia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idLavanderia;
    private Integer numPrendas;
    private Integer numZapatos;
    private String tipoLavado;
    private double costo;
    @ManyToOne
    @JoinColumn(name = "Comsumos_idConsumo", referencedColumnName = "idConsumo")
    private Consumo Comsumos_idConsumo;
    

    public Lavanderia(Integer numPrendas, Integer numZapatos, String tipoLavado, double costo, Consumo Comsumos_idConsumo) {
        this.numPrendas = numPrendas;
        this.numZapatos = numZapatos;
        this.tipoLavado = tipoLavado;
        this.costo = costo;
        this.Comsumos_idConsumo = Comsumos_idConsumo;
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

    public Consumo getComsumos_idConsumo() {
        return Comsumos_idConsumo;
    }

    public void setComsumos_idConsumo(Consumo Comsumos_idConsumo) {
        this.Comsumos_idConsumo = Comsumos_idConsumo;
    }
    
}
