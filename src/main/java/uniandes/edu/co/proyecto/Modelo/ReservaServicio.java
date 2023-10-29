package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.LocalDateTime;

@Entity
@Table(name = "ReservasServicio")
public  class ReservaServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer idreservas;
    private LocalDateTime fechayhorai;
    private LocalDateTime fechayhoraf;
    
    @ManyToOne
    @JoinColumn(name = "Spas_nombre", referencedColumnName = "nombre")
    Spa Spas_nombre;
    @ManyToOne
    @JoinColumn(name = "Salones_nombre", referencedColumnName = "nombre")
    Salon Salones_nombre;
    @ManyToOne
    @JoinColumn(name = "Consumos_idconsumo", referencedColumnName = "idConsumo")
    Consumo Consumos_idconsumo;
    @ManyToOne
    @JoinColumn(name = "Utensilios_id", referencedColumnName = "id")
    Utensilio Utensilios_id;
    double preciofinal;

    public ReservaServicio(LocalDateTime fechayhorai, LocalDateTime fechayhoraf,  Consumo Consumos_idconsumo , double preciofinal) {
        this.fechayhorai = fechayhorai;
        this.fechayhoraf = fechayhoraf;
        
        this.Consumos_idconsumo = Consumos_idconsumo;
    
        this.preciofinal = preciofinal;
    }

    public ReservaServicio() 
    {;}

    public LocalDateTime getFechayhorai() {
        return fechayhorai;
    }

    public void setFechayhorai(LocalDateTime fechayhorai) {
        this.fechayhorai = fechayhorai;
    }

    public LocalDateTime getFechayhoraf() {
        return fechayhoraf;
    }

    public void setFechayhoraf(LocalDateTime fechayhoraf) {
        this.fechayhoraf = fechayhoraf;
    }

    


    public Consumo getConsumos_idConsumo() {
        return Consumos_idconsumo;
    }

    public void setConsumos_idConsumo(Consumo consumos_idconsumo) {
        Consumos_idconsumo = consumos_idconsumo;
    }



    public double getPreciofinal() {
        return preciofinal;
    }

    public void setPreciofinal(double preciofinal) {
        this.preciofinal = preciofinal;
    }

    

}
