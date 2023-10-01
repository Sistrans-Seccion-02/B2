package uniandes.edu.co.proyecto.repositorio;
    
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.ProductoConsumo;

public interface ProductoConsumoRepository extends JpaRepository<ProductoConsumo, String>{
    
    @Query (value = "SELECT * FROM productosConsumos", nativeQuery = true)
    Collection<ProductoConsumo> darProductoConsumos();

    @Query(value = "SELECT * FROM productosConsumos WHERE idConsumo = :idConsumo AND nombre = :nombre", nativeQuery = true)
    ProductoConsumo darProductoConsumo(@Param("idConsumo") int idConsumo, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productosConsumos (idConsumo, nombre) VALUES (:idConsumo, :nombre)", nativeQuery = true)
    void insertarProductoConsumo(@Param("idConsumo") int idConsumo, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE productosConsumos SET idConsumo = :idConsumo, nombre = :nombre WHERE idConsumo = :idConsumo AND nombre = :nombre", nativeQuery = true)
    void actualizarProductoConsumo(@Param("idConsumo") int idConsumo, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productosConsumos WHERE idConsumo = :idConsumo AND nombre = :nombre", nativeQuery = true)
    void eleminarProductoConsumo(@Param("idConsumo") int idConsumo, @Param("nombre") String nombre);
} 
