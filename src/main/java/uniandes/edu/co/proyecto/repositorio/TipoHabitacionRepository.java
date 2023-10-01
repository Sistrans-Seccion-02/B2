package uniandes.edu.co.proyecto.repositorio;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.TipoHabitacion;

public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion, Integer>{
    
    @Query(value = "SELECT * FROM tiposDeHabitacion", nativeQuery = true)

    Collection<TipoHabitacion> dartiposDeHabitacion();
    

    @Query(value = "SELECT * FROM tiposDeHabitacion WHERE id = :id", nativeQuery = true)
    TipoHabitacion darTipoHabitacion(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query (value = "INSERT INTO tiposDeHabitacion (tipo, descripcion) VALUES (B2_sequence.nextval, :tipo, :descripcion)" , nativeQuery = true)
    void insertarTipoHabitacion(@Param("tipo") String tipo,@Param("descripcion") String descripcion);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE tiposDeHabitacion SET tipo = :tipo, descripcion = :descripcion WHERE id = :id", nativeQuery = true)
    void actualizarTipoHabitacion(@Param ("id") Integer id, @Param("tipo") String tipo,@Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tiposDeHabitacion WHERE id = :id", nativeQuery = true)
    void eliminarTipoHabitacion(@Param("id")Integer id);
    

    
}
