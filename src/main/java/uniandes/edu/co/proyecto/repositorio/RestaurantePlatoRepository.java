package uniandes.edu.co.proyecto.repositorio;
    
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.RestaurantePlato;

public interface RestaurantePlatoRepository extends JpaRepository<RestaurantePlato, String>{
    
    @Query (value = "SELECT * FROM RestaurantesPlatos", nativeQuery = true)
    Collection<RestaurantePlato> darRestaurantePlatos();

    @Query(value = "SELECT * FROM RestaurantesPlatos WHERE nombreRestaurante = :nombreRestaurante AND nombrePlato = :nombrePlato", nativeQuery = true)
    RestaurantePlato darRestaurantePlato(@Param("nombreRestaurante") String nombreRestaurante, @Param("nombrePlato") String nombrePlato);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO RestaurantesPlatos (nombreRestaurante, nombrePlato) VALUES (:nombreRestaurante, :nombrePlato)", nativeQuery = true)
    void insertarRestaurantePlato(@Param("nombreRestaurante") String nombreRestaurante, @Param("nombrePlato") String nombrePlato);

    @Modifying
    @Transactional
    @Query(value = "UPDATE RestaurantesPlatos SET nombreRestaurante = :nombreRestaurante, nombrePlato = :nombrePlato WHERE nombreRestaurante = :nombreRestaurante AND nombrePlato = :nombrePlato", nativeQuery = true)
    void actualizarRestaurantePlato(@Param("nombreRestaurante") String nombreRestaurante, @Param("nombrePlato") String nombrePlato);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM RestaurantesPlatos WHERE nombreRestaurante = :nombreRestaurante AND nombrePlato = :nombrePlato", nativeQuery = true)
    void eleminarRestaurantePlato(@Param("nombreRestaurante") String nombreRestaurante, @Param("nombrePlato") String nombrePlato);
} 
    

