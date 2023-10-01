package uniandes.edu.co.proyecto.repositorio;

import java.time.LocalTime;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, String>{
    
    @Query(value = "SELECT * FROM Restaurantes", nativeQuery = true)
    Collection<Restaurante> darRestaurantes();

    @Query(value = "SELECT * FROM Restaurantes WHERE nombre = :nombre", nativeQuery = true)
    Restaurante darRestaurante(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Restaurantes (nombre, horaApertura, horaCierre, capacidad) VALUES (:nombre, :horaApertura, :horaCierre, :capacidad)", nativeQuery = true)
    void insertarRestaurante(@Param("nombre") String nombre, @Param("horaApertura") LocalTime horaApertura, @Param("horaCierre") LocalTime horaCierre, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Restaurantes SET horaApertura = :horaApertura, horaCierre = :horaCierre, capacidad = :capacidad WHERE nombre = :nombre", nativeQuery = true)
    void actualizarRestaurante(@Param("nombre") String nombre, @Param("horaApertura") LocalTime horaApertura, @Param("horaCierre") LocalTime horaCierre, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Restaurantes WHERE nombre = :nombre", nativeQuery = true)
    void eleminarRestaurante(@Param("nombre") String nombre);
}
