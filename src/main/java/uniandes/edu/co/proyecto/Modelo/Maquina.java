package uniandes.edu.co.proyecto.Modelo;

public abstract class Maquina {

    private String nombre;

    public Maquina(String nombre) {
        this.nombre = nombre;
    }

    public Maquina() 
    {;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
