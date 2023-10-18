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
    private Integer idlavanderia;
    private Integer numprendas;
    private Integer numzapatos;
    private String tipolavado;
    private double costo;
    @ManyToOne
    @JoinColumn(name = "Comsumos_idConsumo", referencedColumnName = "idConsumo")
    private Consumo Comsumos_idConsumo;
    private double preciofinal;

    public Lavanderia(Integer numprendas, Integer numzapatos, String tipolavado, double costo, Consumo Comsumos_idConsumo, double preciofinal) {
        this.numprendas = numprendas;
        this.numzapatos = numzapatos;
        this.tipolavado = tipolavado;
        this.costo = costo;
        this.Comsumos_idConsumo = Comsumos_idConsumo;
        this.preciofinal = preciofinal;
    }

    public Lavanderia() 
    {;}

    public Integer getIdLavanderia() {
        return idlavanderia;
    }

    public void setIdLavanderia(Integer idlavanderia) {
        this.idlavanderia = idlavanderia;
    }

    public Integer getNumPrendas() {
        return numprendas;
    }

    public void setNumPrendas(Integer numprendas) {
        this.numprendas = numprendas;
    }

    public Integer getNumZapatos() {
        return numzapatos;
    }

    public void setNumZapatos(Integer numzapatos) {
        this.numzapatos = numzapatos;
    }

    public String getTipoLavado() {
        return tipolavado;
    }

    public void setTipoLavado(String tipolavado) {
        this.tipolavado = tipolavado;
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

    public double getPreciofinal() {
        return preciofinal;
    }

    public void setPreciofinal(double preciofinal) {
        this.preciofinal = preciofinal;
    }
    
}
