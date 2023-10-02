package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.Modelo.Plato;

public interface PlatoRepository extends JpaRepository<Plato, String>{
    
    @Query(value = "SELECT * FROM Platos", nativeQuery = true)
    Collection<Plato> darPlatos();

    @Query(value = "SELECT * FROM Platos WHERE nombre = :nombre", nativeQuery = true)
    Plato darPlato(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Platos (nombre, precio, todoIncluido) VALUES (:nombre, :precio, :todoIncluido", nativeQuery = true)
    void insertarPlato(@Param("nombre") String nombre, @Param("precio") double precio, @Param("todoIncluido") Boolean todoIncluido);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Platos SET precio = :precio, todoIncluido = :todoIncluido", nativeQuery = true)
    void actualizarPlato(@Param("nombre") String nombre, @Param("precio") double precio, @Param("todoIncluido") Boolean todoIncluido);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Platos WHERE nombre = :nombre", nativeQuery = true)
    void eleminarPlato(@Param("nombre") String nombre);

}
