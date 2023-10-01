package uniandes.edu.co.proyecto.repositorio;

import java.time.LocalTime;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Tienda;

public interface TiendaRepository extends JpaRepository<Tienda, String> {
    @Query(value = "SELECT * FROM  Tiendas", nativeQuery = true )
    Collection<Tienda> darTiendas();
    
    @Query(value = "SELECT * FROM Tiendas WHERE nombre = :nombre", nativeQuery = true)
    Tienda darTienda(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Tiendas (nombre, horarioApertura, horarioCierre, capacidad) VALUES (B2_sequence.nextval, :nombre, :horarioApertura, :horarioCierre, :capacidad)")
    void insertarTienda(@Param("nombre") String nombre, @Param("horarioApertura") LocalTime horarioApertura, @Param("horarioCierre") LocalTime horarioCierre, @Param("capacidad") int capacidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Tiendas SET nombre=:nombre, horarioApertura=:horarioApertura, horarioCierre=:horarioCierre, capacidad=:capacidad WHERE nombre=:nombre", nativeQuery = true)
    void actualizarTienda(@Param("nombre") String nombre, @Param("horarioApertura") LocalTime horarioApertura, @Param("horarioCierre") LocalTime horarioCierre, @Param("capacidad") int capacidad);
   
    @Modifying
    @Transactional
    @Query(value= "DELETE FROM Tiendas WHERE nombre=:nombre", nativeQuery = true)
    void eliminarTienda(@Param("nombre") String nombre);
}


