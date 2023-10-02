package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.PlanConsumo;





public interface PlanConsumoRepository extends JpaRepository<PlanConsumo, Integer>{
    
    @Query(value = "SELECT * FROM planesConsumo", nativeQuery = true)
    Collection<PlanConsumo> darplanesConsumo();
    

    @Query(value = "SELECT * FROM planesConsumo WHERE tipo = :id", nativeQuery = true)
    PlanConsumo darPlanConsumo(@Param("id") String id);

    @Modifying
    @Transactional
    @Query (value = "INSERT INTO planesConsumo (tipo, descripcion, descuento, descuentoBar, descuentoRestaurante, descuentoSpa, limiteBebidas, descuentoLavado, Comsumos_idConsumo, Reservas_idReservas) VALUES (B2_sequence.nextval, :descripcion, :descuento, :descuentoBar, :descuentoRestaurante, :descuentoSpa, :limiteBebidas, :descuentoLavado, :Comsumos_idConsumo, :Reservas_idReservas)" , nativeQuery = true)
    void insertarPlanConsumo(@Param("descripcion") String descripcion, @Param("descuento") double descuento, @Param("descuentoBar") boolean descuentoBar, @Param("descuentoRestaurante") boolean descuentoRestaurante, @Param("descuentoSpa") boolean descuentoSpa, @Param("limiteBebidas") int limiteBebidas, @Param("descuentoLavado") boolean descuentoLavado, @Param("Comsumos_idConsumo") Integer Comsumos_idConsumo, @Param("Reservas_idReservas") Integer Reservas_idReservas);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE planesConsumo SET  descripcion = :descripcion, descuento = :descuento, descuentoBar = :descuentoBar, descuentoRestaurante = :descuentoRestaurante, descuentoSpa= :descuentoSpa, limiteBebidas= :limiteBebidas, descuentoLavado= :descuentoLavado, Comsumos_idConsumo =:Comsumos_idConsumo, Reservas_idReservas=:Reservas_idReservas WHERE id = :tipo", nativeQuery = true)
    void actualizarPlanConsumo(@Param("tipo") String tipo,@Param("descripcion") String descripcion, @Param("descuento") double descuento, @Param("descuentoBar") boolean descuentoBar, @Param("descuentoRestaurante") boolean descuentoRestaurante, @Param("descuentoSpa") boolean descuentoSpa, @Param("limiteBebidas") int limiteBebidas, @Param("descuentoLavado") boolean descuentoLavado, @Param("Comsumos_idConsumo") Integer Comsumos_idConsumo, @Param("Reservas_idReservas") Integer Reservas_idReservas);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM planesConsumo WHERE tipo = :id", nativeQuery = true)
    void eliminarPlanConsumo(@Param("id")String id);
    

    
}
