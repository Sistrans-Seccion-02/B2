package uniandes.edu.co.proyecto.repositorio;

import java.time.LocalTime;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Spa;

public interface SpaRepository extends JpaRepository<Spa, String> {
    @Query(value = "SELECT * FROM  Spas", nativeQuery = true )
    Collection<Spa> darSpas();
    
    @Query(value = "SELECT * FROM Spas WHERE nombre = :nombre", nativeQuery = true)
    Spa darSpa(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Spas (nombre, horarioapertura, horariocierre, capacidad) VALUES (:nombre, :horarioapertura, :horariocierre, :capacidad)", nativeQuery = true)
    void insertarSpa(@Param("nombre") String nombre, @Param("horarioapertura") LocalTime horarioapertura, @Param("horariocierre") LocalTime horariocierre, @Param("capacidad") int capacidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Spas SET nombre=:nombre, horarioapertura=:horarioapertura, horarioCierre=:horariocierre, capacidad=:capacidad WHERE nombre=:nombre", nativeQuery = true)
    void actualizarSpa(@Param("nombre") String nombre, @Param("horarioapertura") LocalTime horarioapertura, @Param("horariocierre") LocalTime horariocierre, @Param("capacidad") int capacidad);
   
    @Modifying
    @Transactional
    @Query(value= "DELETE FROM Spas WHERE nombre=:nombre", nativeQuery = true)
    void eliminarSpa(@Param("nombre") String nombre);
}


