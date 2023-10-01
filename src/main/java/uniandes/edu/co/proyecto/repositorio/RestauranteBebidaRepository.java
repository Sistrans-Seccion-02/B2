package uniandes.edu.co.proyecto.repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.RestauranteBebida;

public interface RestauranteBebidaRepository extends JpaRepository<RestauranteBebida, String>{
    
    @Query (value = "SELECT * FROM RestaurantesBebidas", nativeQuery = true)
    Collection<RestauranteBebida> darRestauranteBebidas();

    @Query(value = "SELECT * FROM RestaurantesBebidas WHERE nombreRestaurante = :nombreRestaurante AND nombreBebida = :nombreBebida", nativeQuery = true)
    RestauranteBebida darRestauranteBebida(@Param("nombreRestaurante") String nombreRestaurante, @Param("nombreBebida") String nombreBebida);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO RestaurantesBebidas (nombreRestaurante, nombreBebida) VALUES (:nombreRestaurante, :nombreBebida)", nativeQuery = true)
    void insertarRestauranteBebida(@Param("nombreRestaurante") String nombreRestaurante, @Param("nombreBebida") String nombreBebida);

    @Modifying
    @Transactional
    @Query(value = "UPDATE RestaurantesBebidas SET nombreRestaurante = :nombreRestaurante, nombreBebida = :nombreBebida WHERE nombreRestaurante = :nombreRestaurante AND nombreBebida = :nombreBebida", nativeQuery = true)
    void actualizarRestauranteBebida(@Param("nombreRestaurante") String nombreRestaurante, @Param("nombreBebida") String nombreBebida);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM RestaurantesBebidas WHERE nombreRestaurante = :nombreRestaurante AND nombreBebida = :nombreBebida", nativeQuery = true)
    void eleminarRestauranteBebida(@Param("nombreRestaurante") String nombreRestaurante, @Param("nombreBebida") String nombreBebida);
}
