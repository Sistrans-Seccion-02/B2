package uniandes.edu.co.proyecto.repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.PlatosConsumidos;

public interface PlatosConsumidosRepository extends JpaRepository<PlatosConsumidos, Integer>{
    
    @Query(value = "SELECT * FROM PlatosConsumidos", nativeQuery = true)
    Collection<PlatosConsumidos> darPlatosConsumidos();

    @Query(value = "SELECT * FROM PlatosConsumidos WHERE Consumos_IdConsumo = :Consumos_IdConsumo AND Platos_nombre = :Platos_nombre", nativeQuery = true)
    PlatosConsumidos darPlatoConsumido(@Param("Consumos_IdConsumo") Integer Consumos_IdConsumo, @Param("Platos_nombre") String Platos_nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PlatosConsumidos (Consumos_IdConsumo, Platos_nombre) VALUES (:Consumos_IdConsumo, :Platos_nombre)", nativeQuery = true)
    void insertarPlatoConsumido(@Param("Consumos_IdConsumo") Integer Consumos_IdConsumo, @Param("Platos_nombre") String Platos_nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PlatosConsumidos SET Consumos_IdConsumo = :Consumos_IdConsumo, Platos_nombre = :Platos_nombre WHERE Consumos_IdConsumo = :Consumos_IdConsumo AND Platos_nombre = :Platos_nombre", nativeQuery = true)
    void actualizarPlatoConsumido(@Param("Consumos_IdConsumo") Integer Consumos_IdConsumo, @Param("Platos_nombre") String Platos_nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PlatosConsumidos WHERE Consumos_IdConsumo = :Consumos_IdConsumo AND Platos_nombre = :Platos_nombre", nativeQuery = true)
    void eleminarPlatoConsumido(@Param("Consumos_IdConsumo") Integer Consumos_IdConsumo, @Param("Platos_nombre") String Platos_nombre);
}
