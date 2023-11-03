package uniandes.edu.co.proyecto.repositorio;

import java.time.LocalTime;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.SMercado;

public interface SMercadoRepository extends JpaRepository<SMercado, Integer> {
    @Query(value = "SELECT * FROM  SMercados", nativeQuery = true )
    Collection<SMercado> darSMercados();
    
    @Query(value = "SELECT * FROM SMercados WHERE id = :id", nativeQuery = true)
    SMercado darSMercado(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO SMercados (nombre, horarioapertura, horariocierre, capacidad, id) VALUES (:nombre, :horarioapertura, :horariocierre, :capacidad, B2.nextval)", nativeQuery = true)
    void insertarSMercado(@Param("nombre") String nombre, @Param("horarioapertura") LocalTime horarioapertura, @Param("horariocierre") LocalTime horariocierre, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE SMercados SET nombre=:nombre, horarioapertura=:horarioapertura, horariocierre=:horariocierre, capacidad=:capacidad WHERE id=:id", nativeQuery = true)
    void actualizarSMercado(@Param("id") Integer id, @Param("nombre") String nombre, @Param("horarioapertura") LocalTime horarioapertura, @Param("horariocierre") LocalTime horariocierre, @Param("capacidad") Integer capacidad);
   
    @Modifying
    @Transactional
    @Query(value= "DELETE FROM SMercados WHERE id=:id", nativeQuery = true)
    void eliminarSMercado(@Param("id") Integer id);
}



