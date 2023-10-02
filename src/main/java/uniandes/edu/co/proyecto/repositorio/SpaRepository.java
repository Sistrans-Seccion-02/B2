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
    @Query(value = "INSERT INTO Spas (nombre, horarioApertura, horarioCierre, capacidad, precio) VALUES (:nombre, :horarioApertura, :horarioCierre, :capacidad, :precio)", nativeQuery = true)
    void insertarSpa(@Param("nombre") String nombre, @Param("horarioApertura") LocalTime horarioApertura, @Param("horarioCierre") LocalTime horarioCierre, @Param("capacidad") int capacidad, @Param("precio") double precio);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Spas SET nombre=:nombre, horarioApertura=:horarioApertura, horarioCierre=:horarioCierre, capacidad=:capacidad, precio=:precio WHERE nombre=:nombre", nativeQuery = true)
    void actualizarSpa(@Param("nombre") String nombre, @Param("horarioApertura") LocalTime horarioApertura, @Param("horarioCierre") LocalTime horarioCierre, @Param("capacidad") int capacidad, @Param("precio") double precio);
   
    @Modifying
    @Transactional
    @Query(value= "DELETE FROM Spas WHERE nombre=:nombre", nativeQuery = true)
    void eliminarSpa(@Param("nombre") String nombre);
}


