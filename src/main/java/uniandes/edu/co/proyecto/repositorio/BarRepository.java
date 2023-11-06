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
    
    @Query(value = "SELECT * FROM Bares", nativeQuery = true)
    Collection<Bar> darBares();

    @Query(value = "SELECT * FROM Bares WHERE id = :id", nativeQuery = true)
    Bar darBar(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Bares (id, nombre, horaApertura, horaCierre, capacidad) VALUES (B2.nextval, :nombre, :horaApertura, :horaCierre, :capacidad)", nativeQuery = true)
    void insertarBar(@Param("nombre") String nombre, @Param("horaApertura") LocalTime horaApertura, @Param("horaCierre") LocalTime horaCierre, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Bares SET nombre=:nombre, horaApertura = :horaApertura, horaCierre = :horaCierre, capacidad = :capacidad WHERE id = :id", nativeQuery = true)      
    void actualizarBar(@Param("id") Integer id, @Param("nombre") String nombre, @Param("horaApertura") LocalTime horaApertura, @Param("horaCierre") LocalTime horaCierre, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Bares WHERE id = :id", nativeQuery = true)
    void eliminarBar(@Param("id") Integer id);
}
