
package uniandes.edu.co.proyecto.repositorio;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.ReservaServicio;

public interface ReservaServicioRepository extends JpaRepository<ReservaServicio, Integer>{
    
    @Query(value = "SELECT * FROM ReservasServicio", nativeQuery = true)
    Collection<ReservaServicio> darReservasServicio();

    @Query(value = "SELECT * FROM ReservasServicio WHERE id = :id", nativeQuery = true)
    ReservaServicio darReservaServicio(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ReservasServicio (fechayhorai, fechayhoraf, consumoid, precio, descripcion, id) VALUES (:fechayhorai, :fechayhoraf, :consumoid, :precio, :descripcion, B2_sequence.nextval)", nativeQuery = true)
    void insertarReservaServicio(@Param("fechayhorai") LocalDateTime fechayhorai, @Param("fechayhoraf") LocalDateTime fechayhoraf, @Param("consumoid") Integer consumoid, @Param("precio") double precio, @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ReservasServicio SET fechayhorai = :fechayhorai, fechayhoraf = :fechayhoraf, consumoid=:consumoid, precio=:precio, descripcion=:descripcion  WHERE id = :id", nativeQuery = true)
    void actualizarReservaServicio(@Param("id") Integer id, @Param("fechayhorai") LocalDateTime fechayhorai, @Param("fechayhoraf") LocalDateTime fechayhoraf, @Param("consumoid") Integer consumoid, @Param("precio") double precio, @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ReservasServicio WHERE id = :id", nativeQuery = true)
    void eleminarReservaServicio(@Param("id") Integer id);
}
