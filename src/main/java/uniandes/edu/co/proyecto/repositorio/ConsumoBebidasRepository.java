package uniandes.edu.co.proyecto.repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.ConsumoBebidas;

public interface ConsumoBebidasRepository extends JpaRepository<ConsumoBebidas, Integer>{
    
    @Query(value = "SELECT * FROM ConsumosBebidas", nativeQuery = true)
    Collection<ConsumoBebidas> darConsumoBebidas();

    @Query(value = "SELECT * FROM ConsumosBebidas WHERE Consumos_IdConsumo = :Consumos_IdConsumo AND Bebidas_nombre = :Bebidas_nombre", nativeQuery = true)
    ConsumoBebidas darConsumoBebida(@Param("Consumos_IdConsumo") Integer Consumos_IdConsumo, @Param("Bebidas_nombre") String Bebidas_nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ConsumosBebidas (Consumos_IdConsumo, Bebidas_nombre) VALUES (:Consumos_IdConsumo, :Bebidas_nombre)", nativeQuery = true)
    void insertarConsumoBebida(@Param("Consumos_IdConsumo") Integer Consumos_IdConsumo, @Param("Bebidas_nombre") String Bebidas_nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ConsumosBebidas SET Consumos_IdConsumo = :Consumos_IdConsumo, Bebidas_nombre = :Bebidas_nombre WHERE Consumos_IdConsumo = :Consumos_IdConsumo AND Bebidas_nombre = :Bebidas_nombre", nativeQuery = true)
    void actualizarConsumoBebida(@Param("Consumos_IdConsumo") Integer Consumos_IdConsumo, @Param("Bebidas_nombre") String Bebidas_nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ConsumosBebidas WHERE Consumos_IdConsumo = :Consumos_IdConsumo AND Bebidas_nombre = :Bebidas_nombre", nativeQuery = true)
    void eleminarConsumoBebida(@Param("Consumos_IdConsumo") Integer Consumos_IdConsumo, @Param("Bebidas_nombre") String Bebidas_nombre);
}
