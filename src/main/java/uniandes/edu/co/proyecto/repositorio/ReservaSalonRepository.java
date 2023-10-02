package uniandes.edu.co.proyecto.repositorio;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.ReservaSalon;

public interface ReservaSalonRepository extends JpaRepository<ReservaSalon, Integer>{
    
    @Query(value = "SELECT * FROM ReservasSalon", nativeQuery = true)
    Collection<ReservaSalon> darReservasSalon();

    @Query(value = "SELECT * FROM ReservasSalon WHERE idReserva = :idReserva", nativeQuery = true)
    ReservaSalon darReservaSalon(@Param("idReserva") Integer idReserva);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ReservasSalon (idReserva, duracion, fecha, SalonesNombre) VALUES (B2_sequence.nextval, :duracion, :fecha, :SalonesNombre)", nativeQuery = true)
    void insertarReservaSalon(@Param("duracion") Integer duracion, @Param("fecha") LocalDateTime fecha, @Param("SalonesNombre") String SalonesNombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ReservasSalon SET duracion = :duracion, fecha = :fecha, SalonesNombre = :SalonesNombre WHERE idReserva = :idReserva", nativeQuery = true)
    void actualizarReservaSalon(@Param("idReserva") Integer idReserva, @Param("duracion") Integer duracion, @Param("fecha") LocalDateTime fecha, @Param("SalonesNombre") String SalonesNombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ReservasSalon WHERE idReserva = :idReserva", nativeQuery = true)
    void eleminarReservaSalon(@Param("idReserva") Integer idReserva);
}
