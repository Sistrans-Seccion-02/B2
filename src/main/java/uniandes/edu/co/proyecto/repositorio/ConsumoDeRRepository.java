package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.ConsumoDeR;

public interface ConsumoDeRRepository extends JpaRepository<ConsumoDeR, Integer> {

    @Query(value = "SELECT * FROM  consumosDeR", nativeQuery = true )
    Collection<ConsumoDeR> darConsumosDeR();
    
    @Query(value = "SELECT * FROM consumosDeR WHERE id = :id", nativeQuery = true)
    ConsumoDeR darConsumoDeR(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO consumosDeR (id, reservasid, consumoid) VALUES (B2.nextval, :reservasid, :consumoid)", nativeQuery = true)
    void insertarConsumoDeR(@Param("reservasid") Integer reservasId, @Param("consumoid") Integer consumoId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE consumosDeR SET reservasid=:reservasid, consumoid=:consumoid WHERE id=:id", nativeQuery = true)
    void actualizarConsumoDeR(@Param("id") Integer id, @Param("reservasid") Integer reservasId, @Param("consumoid") Integer consumoId);
   
    @Modifying
    @Transactional
    @Query(value= "DELETE FROM consumosDeR WHERE id=:id", nativeQuery = true)
    void eliminarConsumoDeR(@Param("id") Integer id);
}
