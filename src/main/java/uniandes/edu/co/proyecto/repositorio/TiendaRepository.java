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
    @Query(value = "INSERT INTO Tiendas (nombre, horarioapertura, horariocierre, capacidad) VALUES (:nombre, :horarioapertura, :horariocierre, :capacidad)", nativeQuery = true)
    void insertarTienda(@Param("nombre") String nombre, @Param("horarioapertura") LocalTime horarioapertura, @Param("horariocierre") LocalTime horariocierre, @Param("capacidad") int capacidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Tiendas SET nombre=:nombre, horarioapertura=:horarioapertura, horariocierre=:horariocierre, capacidad=:capacidad WHERE nombre=:nombre", nativeQuery = true)
    void actualizarTienda(@Param("nombre") String nombre, @Param("horarioapertura") LocalTime horarioapertura, @Param("horariocierre") LocalTime horariocierre, @Param("capacidad") int capacidad);
   
    @Modifying
    @Transactional
    @Query(value= "DELETE FROM Tiendas WHERE nombre=:nombre", nativeQuery = true)
    void eliminarTienda(@Param("nombre") String nombre);
}


