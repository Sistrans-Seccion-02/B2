package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Habitacion;




public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {
    
    @Query(value = "SELECT * FROM habitaciones", nativeQuery = true)

    Collection<Habitacion> darhabitaciones();
    

    @Query(value = "SELECT * FROM habitaciones WHERE id = :id", nativeQuery = true)
    Habitacion darHabitacion(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query (value = "INSERT INTO habitaciones (capacidad) VALUES (B2_sequence.nextval, :capacidad)" , nativeQuery = true)
    void insertarHabitacion(@Param("capacidad") String capacidad);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE habitaciones SET capacidad = :capacidad WHERE id = :id", nativeQuery = true)
    void actualizarHabitacion(@Param ("id") Integer id, @Param("capacidad") String capacidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitaciones WHERE id = :id", nativeQuery = true)
    void eliminarHabitacion(@Param("id")Integer id);
    
}
