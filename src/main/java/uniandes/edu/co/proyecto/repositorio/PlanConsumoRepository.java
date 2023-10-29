package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.PlanConsumo;





public interface PlanConsumoRepository extends JpaRepository<PlanConsumo, Integer>{
    
    @Query(value = "SELECT * FROM planesconsumo", nativeQuery = true)
    Collection<PlanConsumo> darplanesConsumo();
    

    @Query(value = "SELECT * FROM planesconsumo WHERE id = :id", nativeQuery = true)
    PlanConsumo darPlanConsumo(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query (value = "INSERT INTO planesconsumo (id, tipo, dtonoche, descripcion, descuentobar,descuentorest,descuentospa,limitebebidas, descuentolavado) VALUES (B2.nextval,:tipo, :dtonoche, :descripcion, :descuentobar, :descuentorest, :descuentospa, :limitebebidas, :descuentolavado)" , nativeQuery = true)
    void insertarPlanConsumo(@Param("tipo") String tipo, @Param("dtonoche") double dtonoche, @Param("descripcion") String descripcion, @Param("descuentobar") double descuentobar, @Param("descuentorest") double descuentorest, @Param("descuentospa") double descuentospa, @Param("limitebebidas") Integer limitebebidas, @Param("descuentolavado") double descuentolavado);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE planesconsumo SET  tipo = :tipo, dtonoche = :dtonoche, descripcion = :descripcion, descuentobar = :descuentobar, descuentorest= :descuentorest, descuentospa= :descuentospa, limitebebidas= :limitebebidas, descuentolavado =:descuentolavado WHERE id = :id", nativeQuery = true)
    void actualizarPlanConsumo (@Param("id") Integer id, @Param("tipo") String tipo, @Param("dtonoche") double dtonoche, @Param("descripcion") String descripcion, @Param("descuentobar") double descuentobar, @Param("descuentorest") double descuentorest, @Param("descuentospa") double descuentospa, @Param("limitebebidas") Integer limitebebidas, @Param("descuentolavado") double descuentolavado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM planesconsumo WHERE id = :id", nativeQuery = true)
    void eliminarPlanConsumo(@Param("id")Integer id);
    

    
}
