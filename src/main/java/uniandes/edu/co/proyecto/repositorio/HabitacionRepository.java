package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Habitacion;




public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {
    
    @Query(value = "SELECT * FROM habitacion", nativeQuery = true)

    Collection<Habitacion> darHabitaciones();
    

    @Query(value = "SELECT * FROM habitacion WHERE id = :id", nativeQuery = true)
    Habitacion darHabitacion(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query (value = "INSERT INTO habitacion (id, capacidad, tipoid) VALUES (B2.nextval, :capacidad, :tipoid)" , nativeQuery = true)
    void insertarHabitacion(@Param("capacidad") String capacidad, @Param("tipoid") Integer tipoid);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE habitacion SET capacidad = :capacidad, tipoid = :tipoid WHERE id = :id", nativeQuery = true)
    void actualizarHabitacion(@Param ("id") Integer id, @Param("capacidad") String capacidad, @Param("tipoid") Integer tipoid);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitacion WHERE id = :id", nativeQuery = true)
    void eliminarHabitacion(@Param("id")Integer id);
    
}
