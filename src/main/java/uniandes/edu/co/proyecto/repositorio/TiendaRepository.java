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
    
    @Query(value = "SELECT * FROM Tiendas WHERE id = :id", nativeQuery = true)
    Tienda darTienda(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Tiendas (nombre, horarioapertura, horariocierre, capacidad, id) VALUES (:nombre, :horarioapertura, :horariocierre, :capacidad, B2.nextval)", nativeQuery = true)
    void insertarTienda(@Param("nombre") String nombre, @Param("horarioapertura") LocalTime horarioapertura, @Param("horariocierre") LocalTime horariocierre, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Tiendas SET nombre=:nombre, horarioapertura=:horarioapertura, horariocierre=:horariocierre, capacidad=:capacidad WHERE id=:id", nativeQuery = true)
    void actualizarTienda(@Param("id") Integer id, @Param("nombre") String nombre, @Param("horarioapertura") LocalTime horarioapertura, @Param("horariocierre") LocalTime horariocierre, @Param("capacidad") Integer capacidad);
   
    @Modifying
    @Transactional
    @Query(value= "DELETE FROM Tiendas WHERE id=:id", nativeQuery = true)
    void eliminarTienda(@Param("id") Integer id);
}


