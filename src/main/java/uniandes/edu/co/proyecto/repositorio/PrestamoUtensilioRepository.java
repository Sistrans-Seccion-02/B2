package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.PrestamoUtensilio;

public interface PrestamoUtensilioRepository extends JpaRepository<PrestamoUtensilio, Integer>{
    
    @Query(value = "SELECT * FROM PrestamosUt", nativeQuery = true)
    Collection<PrestamoUtensilio> darPrestamoUtensilios();

    @Query(value = "SELECT * FROM PrestamosUt WHERE idutensilio = :idutensilio", nativeQuery = true)
    PrestamoUtensilio darPrestamoUtensilio(@Param("idutensilio") Integer idutensilio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PrestamosUt (cantidad, precio, tipo, estado, Comsumos_idConsumo) VALUES (B2_sequence.nextval, :cantidad, :precio, :tipo, :estado, :Comsumos_idConsumo)", nativeQuery = true)
    void insertarPrestamoUtensilio(@Param("cantidad") Integer cantidad, @Param("precio") double precio, @Param("tipo") String tipo, @Param("estado") Boolean estado, @Param("Comsumos_idConsumo") Integer Comsumos_idConsumo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PrestamosUt SET cantidad = :cantidad, precio = :precio, tipo = :tipo, estado = :estado, Comsumos_idConsumo = :Comsumos_idConsumo WHERE idutensilio =:idutensilio", nativeQuery = true)
    void actualizarPrestamoUtensilio(@Param("idutensilio") Integer idutensilio, @Param("cantidad") Integer cantidad, @Param("precio") double precio, @Param("tipo") String tipo, @Param("estado") Boolean estado, @Param("Comsumos_idConsumo") Integer Comsumos_idConsumo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PrestamosUt WHERE idutensilio = :idutensilio", nativeQuery = true)
    void eleminarPrestamoUtensilio(@Param("idutensilio") Integer idutensilio);

}
