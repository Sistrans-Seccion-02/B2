package uniandes.edu.co.proyecto.repositorio;

import java.time.LocalTime;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Bar;

public interface BarRepository extends JpaRepository<Bar, String>{
    
    @Query(value = "SELECT * FROM Bar", nativeQuery = true)
    Collection<Bar> darBares();

    @Query(value = "SELECT * FROM Bar WHERE nombre = :nombre", nativeQuery = true)
    Bar darBar(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Bar (nombre, horaApertura, horaCierre, capacidad) VALUES (:nombre, :horaApertura, :horaCierre, :capacidad)", nativeQuery = true)
    void insertarBar(@Param("nombre") String nombre, @Param("horaApertura") LocalTime horaApertura, @Param("horaCierre") LocalTime horaCierre, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Bar SET horaApertura = :horaApertura, horaCierre = :horaCierre, capacidad = :capacidad WHERE nombre = :nombre", nativeQuery = true)      
    void actualizarBar(@Param("nombre") String nombre, @Param("horaApertura") LocalTime horaApertura, @Param("horaCierre") LocalTime horaCierre, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Bar WHERE nombre = :nombre", nativeQuery = true)
    void eleminarBar(@Param("nombre") String nombre);
}
