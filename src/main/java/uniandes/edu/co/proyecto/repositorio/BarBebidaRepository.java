package uniandes.edu.co.proyecto.repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.BarBebida;

public interface BarBebidaRepository extends JpaRepository<BarBebida, String>{
    
    @Query(value = "SELECT * FROM BaresBebidas", nativeQuery = true)
    Collection<BarBebida> darBarBebidas();

    @Query(value = "SELECT * FROM BaresBebidas WHERE nombreBar = :nombreBar AND nombreBebida = :nombreBebida", nativeQuery = true)
    BarBebida darBarBebida(@Param("nombreBar") String nombreBar, @Param("nombreBebida") String nombreBebida);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO BaresBebidas (nombreBar, nombreBebida) VALUES (:nombreBar, :nombreBebida)", nativeQuery = true)
    void insertarBarBebida(@Param("nombreBar") String nombreBar, @Param("nombreBebida") String nombreBebida);

    @Modifying
    @Transactional
    @Query(value = "UPDATE BaresBebidas SET nombreBar = :nombreBar, nombreBebida = :nombreBebida WHERE nombreBar = :nombreBar AND nombreBebida = :nombreBebida", nativeQuery = true)
    void actualizarBarBebida(@Param("nombreBar") String nombreBar, @Param("nombreBebida") String nombreBebida);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM BaresBebidas WHERE nombreBar = :nombreBar AND nombreBebida = :nombreBebida", nativeQuery = true)
    void eleminarBarBebida(@Param("nombreBar") String nombreBar, @Param("nombreBebida") String nombreBebida);
}
