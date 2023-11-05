package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.ProductoRestaurante;

public interface ProductoRestauranteRepository extends JpaRepository<ProductoRestaurante, Integer> {

    @Query(value = "SELECT * FROM  productosrest", nativeQuery = true )
    Collection<ProductoRestaurante> darConsumosDeR();
    
    @Query(value = "SELECT * FROM productosrest WHERE id = :id", nativeQuery = true)
    ProductoRestaurante darProductoRestaurante(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productosrest (id, platosbebidasid, restid) VALUES (B2.nextval, :platosbebidasid, :restid)", nativeQuery = true)
    void insertarProductoRestaurante(@Param("platosbebidasid") Integer platosbebidasId, @Param("restid") Integer restId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE productosrest SET platosbebidasid=:platosbebidasid, restid=:restid WHERE id=:id", nativeQuery = true)
    void actualizarProductoRestaurante(@Param("id") Integer id, @Param("platosbebidasid") Integer platosbebidasId, @Param("restid") Integer restId);
   
    @Modifying
    @Transactional
    @Query(value= "DELETE FROM productosrest WHERE id=:id", nativeQuery = true)
    void eliminarProductoRestaurante(@Param("id") Integer id);
}

