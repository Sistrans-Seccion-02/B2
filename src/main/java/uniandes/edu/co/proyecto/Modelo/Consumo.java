package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Consumos")
public class Consumo {
    @Id
    private int idConsumo;
    private double precioTotal;
    private boolean pazYSalvo;

    public Consumo() {;}

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public boolean isPazYSalvo() {
        return pazYSalvo;
    }

    public void setPazYSalvo(boolean pazYSalvo) {
        this.pazYSalvo = pazYSalvo;
    }

    public int getIdConsumo() {
        return idConsumo;
    }

    public void setIdConsumo(int idConsumo) {
        this.idConsumo = idConsumo;
    }
    
}
