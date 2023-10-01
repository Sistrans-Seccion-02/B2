package uniandes.edu.co.proyecto.repositorio;

import java.time.LocalTime;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Piscina;

public interface PiscinaRepository extends JpaRepository<Piscina, String> {
    @Query(value = "SELECT * FROM  Piscinas", nativeQuery = true )
    Collection<Piscina> darPiscinas();
    
    @Query(value = "SELECT * FROM Piscinas WHERE nombre = :nombre", nativeQuery = true)
    Piscina darPiscina(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Piscinas (nombre, horarioApertura, horarioCierre, profundidad) VALUES (B2_sequence.nextval, :nombre, :horarioApertura, :horarioCierre, :profundidad)")
    void insertarPiscina(@Param("nombre") String nombre, @Param("horarioApertura") LocalTime horarioApertura, @Param("horarioCierre") LocalTime horarioCierre, @Param("profundidad") int profundidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Piscinas SET nombre=:nombre, horarioApertura=:horarioApertura, horarioCierre=:horarioCierre, profundidad=:profundidad WHERE nombre=:nombre", nativeQuery = true)
    void actualizarPiscina(@Param("nombre") String nombre, @Param("horarioApertura") LocalTime horarioApertura, @Param("horarioCierre") LocalTime horarioCierre, @Param("profundidad") int profundidad);
   
    @Modifying
    @Transactional
    @Query(value= "DELETE FROM Piscinas WHERE nombre=:nombre", nativeQuery = true)
    void eliminarPiscina(@Param("nombre") String nombre);
}

