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
    

    @Query(value = "SELECT * FROM planesConsumo WHERE id = :id", nativeQuery = true)
    PlanConsumo darPlanConsumo(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query (value = "INSERT INTO planesConsumo (tipo, descripcion, descuento, descuentoBar, descuentoRestaurante, descuentoSpa, limiteBebidas, descuentoLavado) VALUES (B2_sequence.nextval, :tipo, :descripcion, :descuento, :descuentoBar, :descuentoRestaurante, :descuentoSpa, :limiteBebidas, :descuentoLavado)" , nativeQuery = true)
    void insertarPlanConsumo(@Param("tipo") String tipo,@Param("descripcion") String descripcion, @Param("descuento") double descuento, @Param("descuentoBar") boolean descuentoBar, @Param("descuentoRestaurante") boolean descuentoRestaurante, @Param("descuentoSpa") boolean descuentoSpa, @Param("limiteBebidas") int limiteBebidas, @Param("descuentoLavado") boolean descuentoLavado);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE planesConsumo SET tipo = :tipo, descripcion = :descripcion, descuento = :descuento, descuentoBar = :descuentoBar, descuentoRestaurante = :descuentoRestaurante, descuentoSpa= :descuentoSpa, limiteBebidas= :limiteBebidas, descuentoLavado= :descuentoLavado WHERE id = :id", nativeQuery = true)
    void actualizarPlanConsumo(@Param ("id") Integer id, @Param("tipo") String tipo,@Param("descripcion") String descripcion, @Param("descuento") double descuento, @Param("descuentoBar") boolean descuentoBar, @Param("descuentoRestaurante") boolean descuentoRestaurante, @Param("descuentoSpa") boolean descuentoSpa, @Param("limiteBebidas") int limiteBebidas, @Param("descuentoLavado") boolean descuentoLavado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM planesConsumo WHERE id = :id", nativeQuery = true)
    void eliminarPlanConsumo(@Param("id")Integer id);
    

    
}
