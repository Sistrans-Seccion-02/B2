
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

    @Query(value = "SELECT * FROM ReservasServicio WHERE idreservas = :idreservas", nativeQuery = true)
    ReservaServicio darReservaServicio(@Param("idreservas") Integer idreservas);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ReservasSalon (idreservas, fechayhorai, fechayhoraf, Spas_nombre, Salones_nombre, Comsumos_idConsumo, Utensilios_id, preciofinal) VALUES (B2_sequence.nextval, :fechayhorai, :fechayhoraf, :Spas_nombre, :Salones_nombre, :Comsumos_idConsumo, :Utensilios_id, :preciofinal)", nativeQuery = true)
    void insertarReservaServicio(@Param("fechayhorai") LocalDateTime fechayhorai, @Param("fechayhoraf") LocalDateTime fechayhoraf, @Param("Spas_nombre") String Spas_nombre, @Param("Salones_nombre") String Salones_nombre, @Param("Comsumos_idConsumo") Integer Comsumos_idConsumo, @Param("Utensilios_id") Integer Utensilios_id, @Param("preciofinal") double preciofinal);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ReservasSalon SET fechayhorai = :fechayhorai, fechayhoraf = :fechayhoraf, Spas_nombre = :Spas_nombre, Salones_nombre =:Salones_nombre, Comsumos_idConsumo=:Comsumos_idConsumo, Utensilios_id=:Utensilios_id, preciofinal =:preciofinal WHERE idreservas = :idreservas", nativeQuery = true)
    void actualizarReservaServicio(@Param("idreservas") Integer idreservas, @Param("fechayhorai") LocalDateTime fechayhorai, @Param("fechayhoraf") LocalDateTime fechayhoraf, @Param("Spas_nombre") String Spas_nombre, @Param("Salones_nombre") String Salones_nombre, @Param("Comsumos_idConsumo") Integer Comsumos_idConsumo, @Param("Utensilios_id") Integer Utensilios_id, @Param("preciofinal") double preciofinal);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ReservasSalon WHERE idreservas = :idreservas", nativeQuery = true)
    void eleminarReservaServicio(@Param("idreservas") Integer idreservas);
}
