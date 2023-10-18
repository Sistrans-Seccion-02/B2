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
    private Integer idreservas;
    private LocalDateTime fechayhorai;
    private LocalDateTime fechayhoraf;
    @ManyToOne
    @JoinColumn(name = "Spas_nombre", referencedColumnName = "nombre")
    Spa Spas_nombre;
    @ManyToOne
    @JoinColumn(name = "Salones_nombre", referencedColumnName = "nombre")
    Salon Salones_nombre;
    @ManyToOne
    @JoinColumn(name = "Comsumos_idConsumo", referencedColumnName = "idConsumo")
    Consumo Comsumos_idConsumo;
    @ManyToOne
    @JoinColumn(name = "Utensilios_id", referencedColumnName = "id")
    Utensilio Utensilios_id;
    double preciofinal;

    public ReservaServicio(LocalDateTime fechayhorai, LocalDateTime fechayhoraf, Spa Spas_nombre, Salon Salones_nombre, Consumo Comsumos_idConsumo, Utensilio Utensilios_id, double preciofinal) {
        this.fechayhorai = fechayhorai;
        this.fechayhoraf = fechayhoraf;
        this.Spas_nombre = Spas_nombre;
        this.Salones_nombre = Salones_nombre;
        this.Comsumos_idConsumo = Comsumos_idConsumo;
        this.Utensilios_id = Utensilios_id;
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

    public Spa getSpas_nombre() {
        return Spas_nombre;
    }

    public void setSpas_nombre(Spa spas_nombre) {
        Spas_nombre = spas_nombre;
    }

    public Salon getSalones_nombre() {
        return Salones_nombre;
    }

    public void setSalones_nombre(Salon salones_nombre) {
        Salones_nombre = salones_nombre;
    }

    public Consumo getComsumos_idConsumo() {
        return Comsumos_idConsumo;
    }

    public void setComsumos_idConsumo(Consumo comsumos_idConsumo) {
        Comsumos_idConsumo = comsumos_idConsumo;
    }

    public Utensilio getUtensilios_id() {
        return Utensilios_id;
    }

    public void setUtensilios_id(Utensilio utensilios_id) {
        Utensilios_id = utensilios_id;
    }

    public double getPreciofinal() {
        return preciofinal;
    }

    public void setPreciofinal(double preciofinal) {
        this.preciofinal = preciofinal;
    }

}
