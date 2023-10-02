package uniandes.edu.co.proyecto.repositorio;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.ReservaSpa;

public interface ReservaSpaRepository extends JpaRepository<ReservaSpa, Integer>{
    
    @Query(value = "SELECT * FROM ReservasSpa", nativeQuery = true)
    Collection<ReservaSpa> darReservasSpa();

    @Query(value = "SELECT * FROM ReservasSpa WHERE idReserva = :idReserva", nativeQuery = true)
    ReservaSpa darReservaSpa(@Param("idReserva") Integer idReserva);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ReservasSpa (idReserva, duracion, fecha, SpasNombre) VALUES (B2_sequence.nextval, :duracion, :fecha, :SpasNombre)", nativeQuery = true)
    void insertarReservaSpa(@Param("duracion") Integer duracion, @Param("fecha") LocalDateTime fecha, @Param("SpasNombre") String SpasNombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ReservasSpa SET duracion = :duracion, fecha = :fecha, SpasNombre = :SpasNombre WHERE idReserva = :idReserva", nativeQuery = true)
    void actualizarReservaSpa(@Param("idReserva") Integer idReserva, @Param("duracion") Integer duracion, @Param("fecha") LocalDateTime fecha, @Param("SpasNombre") String SpasNombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ReservasSpa WHERE idReserva = :idReserva", nativeQuery = true)
    void eleminarReservaSpa(@Param("idReserva") Integer idReserva);
}
