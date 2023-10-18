package uniandes.edu.co.proyecto.Modelo;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")

public  class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private String cedula;
   @ManyToOne
    @JoinColumn(name = "tiposusuario_id", referencedColumnName = "id")
    private TipoUsuario tiposusuario_id;
    
    public Usuario(String nombre, String cedula, TipoUsuario tiposusuario_id) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.tiposusuario_id = tiposusuario_id;
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
        return tiposusuario_id;
    }
    public void setTipo(TipoUsuario tiposusuario_id) {
        this.tiposusuario_id = tiposusuario_id;
    }
    
}
