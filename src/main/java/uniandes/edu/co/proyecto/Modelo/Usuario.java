package uniandes.edu.co.proyecto.Modelo;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")

public  class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private String cedula;
    @OneToOne
    @JoinColumn(name = "tipoid", referencedColumnName = "id")
    private TipoUsuario tipoid;
    
    public Usuario(String nombre, String cedula, TipoUsuario tipoid) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.tipoid = tipoid;
    }
    public Usuario() 
    {;}

    public Integer getId() {
        return id;
    }   
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public TipoUsuario getTipo() {
        return tipoid;
    }
    public void setTipo(TipoUsuario tipoid) {
        this.tipoid = tipoid;
    }
    
}
