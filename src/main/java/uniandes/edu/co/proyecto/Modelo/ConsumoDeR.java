package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "consumosDeR")
public class ConsumoDeR {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "reservasid", referencedColumnName = "id")
    private Reserva reservaId;

    @ManyToOne
    @JoinColumn(name = "consumoid", referencedColumnName = "id")
    private Consumo consumoId;
  
    public ConsumoDeR(Reserva reservaId, Consumo consumoId) {
        
        this.reservaId = reservaId;
        this.consumoId = consumoId;
        
    }

    public ConsumoDeR() {;}
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Reserva getReservaId() {
        return reservaId;
    }
    public void setReservaId(Reserva reservaId) {
        this.reservaId = reservaId;
    }

    public Consumo getConsumoId() {
        return consumoId;
    }
    public void setConsumoId(Consumo consumoId) {
        this.consumoId = consumoId;
    }
}

