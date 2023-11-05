package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.PlatoBebida;

public interface PlatoBebidaRepository extends JpaRepository<PlatoBebida, Integer> {

    @Query(value = "SELECT * FROM  platosbebidas", nativeQuery = true)
    Collection<PlatoBebida> darPlatosBebidas();
    
    @Query(value = "SELECT * FROM platosbebidas WHERE id = :id", nativeQuery = true)
    PlatoBebida darPlatoBebida(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO platosbebidas (id, nombre, precio, consumoid) VALUES (B2.nextval, :nombre, :precio, :consumoid)", nativeQuery = true)
    void insertarPlatoBebida(@Param("nombre") String nombre, @Param("precio") double precio, @Param("consumoid") Integer consumoId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE platosbebidas SET nombre=:nombre, precio=:precio, consumoid=:consumoid WHERE id=:id", nativeQuery = true)
    void actualizarPlatoBebida(@Param("id") Integer id, @Param("nombre") String nombre, @Param("precio") double precio, @Param("consumoid") Integer consumoId);
   
    @Modifying
    @Transactional
    @Query(value= "DELETE FROM platosbebidas WHERE id=:id", nativeQuery = true)
    void eliminarPlatoBebida(@Param("id") Integer id);
}
