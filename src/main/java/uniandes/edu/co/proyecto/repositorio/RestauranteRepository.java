package uniandes.edu.co.proyecto.repositorio;

import java.time.LocalTime;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Integer>{
    
    @Query(value = "SELECT * FROM Restaurantes", nativeQuery = true)
    Collection<Restaurante> darRestaurantes();

    @Query(value = "SELECT * FROM Restaurantes WHERE id = :id", nativeQuery = true)
    Restaurante darRestaurante(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Restaurantes (id, nombre, tipo, horaApertura, horaCierre, capacidad) VALUES (B2.nextval, :nombre, :tipo, :horaApertura, :horaCierre, :capacidad)", nativeQuery = true)
    void insertarRestaurante(@Param("nombre") String nombre, @Param("tipo") String tipo, @Param("horaApertura") LocalTime horaApertura, @Param("horaCierre") LocalTime horaCierre, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Restaurantes SET nombre=:nombre, tipo=:tipo, horaApertura = :horaApertura, horaCierre = :horaCierre, capacidad = :capacidad WHERE id = :id", nativeQuery = true)
    void actualizarRestaurante(@Param("id") Integer id, @Param("nombre") String nombre, @Param("tipo") String tipo, @Param("horaApertura") LocalTime horaApertura, @Param("horaCierre") LocalTime horaCierre, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Restaurantes WHERE id = :id", nativeQuery = true)
    void eliminarRestaurante(@Param("id") Integer id);
}
