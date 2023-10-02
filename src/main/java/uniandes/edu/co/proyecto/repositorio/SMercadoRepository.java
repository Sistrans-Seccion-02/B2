package uniandes.edu.co.proyecto.repositorio;

import java.time.LocalTime;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.SMercado;

public interface SMercadoRepository extends JpaRepository<SMercado, String> {
    @Query(value = "SELECT * FROM  SMercados", nativeQuery = true )
    Collection<SMercado> darSMercados();
    
    @Query(value = "SELECT * FROM SMercados WHERE nombre = :nombre", nativeQuery = true)
    SMercado darSMercado(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO SMercados (nombre, horarioApertura, horarioCierre, capacidad) VALUES (:nombre, :horarioApertura, :horarioCierre, :capacidad)", nativeQuery = true)
    void insertarSMercado(@Param("nombre") String nombre, @Param("horarioApertura") LocalTime horarioApertura, @Param("horarioCierre") LocalTime horarioCierre, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE SMercados SET nombre=:nombre, horarioApertura=:horarioApertura, horarioCierre=:horarioCierre, capacidad=:capacidad WHERE nombre=:nombre", nativeQuery = true)
    void actualizarSMercado(@Param("nombre") String nombre, @Param("horarioApertura") LocalTime horarioApertura, @Param("horarioCierre") LocalTime horarioCierre, @Param("capacidad") Integer capacidad);
   
    @Modifying
    @Transactional
    @Query(value= "DELETE FROM SMercados WHERE nombre=:nombre", nativeQuery = true)
    void eliminarSMercado(@Param("nombre") String nombre);
}



