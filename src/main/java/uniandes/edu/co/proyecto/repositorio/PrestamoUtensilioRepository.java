package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.PrestamoUtensilio;

public interface PrestamoUtensilioRepository extends JpaRepository<PrestamoUtensilio, Integer>{
    
    @Query(value = "SELECT * FROM PrestamosUtensilios", nativeQuery = true)
    Collection<PrestamoUtensilio> darPrestamoUtensilios();

    @Query(value = "SELECT * FROM PrestamosUtensilios WHERE idutensilio = :idutensilio", nativeQuery = true)
    PrestamoUtensilio darPrestamoUtensilio(@Param("idutensilio") Integer idutensilio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PrestamosUtensilios (cantidad, precio, tipo, estado) VALUES (B2_sequence.nextval, :cantidad, :precio, :tipo, :estado)", nativeQuery = true)
    void insertarPrestamoUtensilio(@Param("cantidad") Integer cantidad, @Param("precio") double precio, @Param("tipo") String tipo, @Param("estado") Boolean estado);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PrestamosUtensilios SET cantidad = :cantidad, precio = :precio, tipo = :tipo, estado =: estado WHERE idutensilio =: idutensilio", nativeQuery = true)
    void actualizarPrestamoUtensilio(@Param("idutensilio") Integer idutensilio, @Param("cantidad") Integer cantidad, @Param("precio") double precio, @Param("tipo") String tipo, @Param("estado") Boolean estado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PrestamosUtensilios WHERE idutensilio = :idutensilio", nativeQuery = true)
    void eleminarPrestamoUtensilio(@Param("idutensilio") Integer idutensilio);

}
