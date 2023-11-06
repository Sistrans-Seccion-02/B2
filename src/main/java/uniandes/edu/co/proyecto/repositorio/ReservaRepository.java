package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Reserva;


public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
    
    @Query(value = "SELECT * FROM reservas", nativeQuery = true)

    Collection<Reserva> darReservas();
    

    @Query(value = "SELECT * FROM reservas WHERE id = :id", nativeQuery = true)
    Reserva darReserva(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query (value = "INSERT INTO reservas (id, fechaentrada, fechasalida, numpersonas, estado, precioreserva, usuariosId, planId, habitacionid) VALUES (B2.nextval, :fechaentrada, :fechasalida, :numpersonas, :estado, :precioreserva, :usuariosId, :planId, :habitacionid)" , nativeQuery = true)
    void insertarReserva(@Param("fechaentrada") Date fechaentrada,@Param("fechasalida") Date fechasalida,@Param("numpersonas") int numpersonas,@Param("estado") boolean estado, @Param("precioreserva") double precioreserva, @Param("usuariosId") Integer usuariosId, @Param("planId") Integer planId, @Param("habitacionid") Integer habitacionid);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE reservas SET fechaentrada = :fechaentrada, fechasalida = :fechasalida, numpersonas = :numpersonas, estado = :estado, precioreserva = :precioreserva, usuariosId = :usuariosId, planId = :planId, habitacionid = :habitacionid WHERE id = :id", nativeQuery = true)
    void actualizarReserva(@Param ("id") Integer id, @Param("fechaentrada") Date fechaentrada,@Param("fechasalida") Date fechasalida,@Param("numpersonas") Integer numpersonas,@Param("estado") boolean estado, @Param("precioreserva") double precioreserva, @Param("usuariosId") Integer usuariosId, @Param("planId") Integer planId, @Param("habitacionid") Integer habitacionid);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservas WHERE id = :id", nativeQuery = true)
    void eliminarReserva(@Param("id")Integer id);


    @Modifying
    @Transactional
    @Query(value = "UPDATE reservas SET estado = 1 WHERE id = :id", nativeQuery = true)
    void checkIn(@Param("id")Integer id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservas SET estado = 0 WHERE id = :id", nativeQuery = true)
    void checkOut(@Param("id")Integer id);








    
}
