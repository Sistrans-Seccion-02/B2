package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Reserva;





public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
    
    @Query(value = "SELECT * FROM reservas", nativeQuery = true)

    Collection<Reserva> darreservas();
    

    @Query(value = "SELECT * FROM reservas WHERE id = :id", nativeQuery = true)
    Reserva darReserva(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query (value = "INSERT INTO reservas (fechaEntrada, fechaSalida, numPersonas,estado) VALUES (B2_sequence.nextval, :fechaEntrada, :fechaSalida, :numPersonas, :estado)" , nativeQuery = true)
    void insertarReserva(@Param("fechaEntrada") String fechaEntrada,@Param("fechaSalida") String fechaSalida,@Param("numPersonas") String numPersonas,@Param("estado") String estado);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE reservas SET fechaEntrada = :fechaEntrada, fechaSalida = :fechaSalida, numPersonas = :numPersonas, estado = :estado WHERE id = :id", nativeQuery = true)
    void actualizarReserva(@Param ("id") Integer id, @Param("fechaEntrada") String fechaEntrada,@Param("fechaSalida") String fechaSalida,@Param("numPersonas") String numPersonas,@Param("estado") String estado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservas WHERE id = :id", nativeQuery = true)
    void eliminarReserva(@Param("id")Integer id);
    

    
}
