package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.Modelo.Bebida;

public interface BebidaRepository extends JpaRepository<Bebida, String> {
    
    @Query(value = "SELECT * FROM Bebidas", nativeQuery = true)
    Collection<Bebida> darBebidas();

    @Query(value = "SELECT * FROM Bebidas WHERE nombre = :nombre", nativeQuery = true)
    Bebida darBebida(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Bebidas (nombre, precio, todoIncluido) VALUES (:nombre, :precio, :todoIncluido)", nativeQuery = true)
    void insertarBebida(@Param("nombre") String nombre, @Param("precio") double precio, @Param("todoIncluido") Boolean todoIncluido);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Bebidas SET precio = :precio, todoIncluido = :todoIncluido WHERE nombre = :nombre", nativeQuery = true)
    void actualizarBebida(@Param("nombre") String nombre, @Param("precio") double precio, @Param("todoIncluido") Boolean todoIncluido);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Bebidas WHERE nombre = :nombre", nativeQuery = true)
    void eleminarBebida(@Param("nombre") String nombre);
}
