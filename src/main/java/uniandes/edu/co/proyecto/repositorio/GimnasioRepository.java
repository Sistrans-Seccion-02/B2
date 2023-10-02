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
    @Query(value = "INSERT INTO Gimnasios (nombre, horaApertura, horaCierre, capacidad) VALUES (:nombre, :horaApertura, :horaCierre, :capacidad)", nativeQuery = true)
    void insertarGimnasio(@Param("nombre") String nombre, @Param("horaApertura") LocalTime horaApertura, @Param("horaCierre") LocalTime horaCierre, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Gimnasios SET horaApertura = :horaApertura, horaCierre = :horaCierre, capacidad = :capacidad WHERE nombre = :nombre", nativeQuery = true)
    void actualizarGimnasio(@Param("nombre") String nombre, @Param("horaApertura") LocalTime horaApertura, @Param("horaCierre") LocalTime horaCierre, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Gimnasios WHERE nombre = :nombre", nativeQuery = true)
    void eliminarGimnasio(@Param("nombre") String nombre);
}


