package uniandes.edu.co.proyecto.repositorio;

import java.time.LocalTime;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Gimnasio;

public interface GimnasioRepository extends JpaRepository<Gimnasio, String> {
    @Query(value = "SELECT * FROM  Gimnasios", nativeQuery = true )
    Collection<Gimnasio> darGimnasios();
    
    @Query(value = "SELECT * FROM Gimnasios WHERE nombre = :nombre", nativeQuery = true)
    Gimnasio darGimnasio(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Gimnasios (nombre, horarioApertura, horarioCierre, capacidad) VALUES (B2_sequence.nextval, :nombre, :horarioApertura, :horarioCierre, :capacidad)")
    void insertarGimnasio(@Param("nombre") String nombre, @Param("horarioApertura") LocalTime horarioApertura, @Param("horarioCierre") LocalTime horarioCierre, @Param("capacidad") int capacidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Gimnasios SET nombre=:nombre, horarioApertura=:horarioApertura, horarioCierre=:horarioCierre, capacidad=:capacidad WHERE nombre=:nombre", nativeQuery = true)
    void actualizarGimnasio(@Param("nombre") String nombre, @Param("horarioApertura") LocalTime horarioApertura, @Param("horarioCierre") LocalTime horarioCierre, @Param("capacidad") int capacidad);
   
    @Modifying
    @Transactional
    @Query(value= "DELETE FROM Gimnasios WHERE nombre=:nombre", nativeQuery = true)
    void eliminarGimnasio(@Param("nombre") String nombre);
}


