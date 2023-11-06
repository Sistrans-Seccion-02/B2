package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.ProductoBar;

public interface ProductoBarRepository extends JpaRepository<ProductoBar, Integer> {

    @Query(value = "SELECT * FROM  productosbares", nativeQuery = true )
    Collection<ProductoBar> darProductosBar();
    
    @Query(value = "SELECT * FROM productosbares WHERE id = :id", nativeQuery = true)
    ProductoBar darProductoBar(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productosbares (id, platosbebidasid, barid) VALUES (B2.nextval, :platosbebidasid, :barid)", nativeQuery = true)
    void insertarProductoBar(@Param("platosbebidasid") Integer platosbebidasId, @Param("barid") Integer barId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE productosbares SET platosbebidasid=:platosbebidasid, barid=:barid WHERE id=:id", nativeQuery = true)
    void actualizarProductoBar(@Param("id") Integer id, @Param("platosbebidasid") Integer platosbebidasId, @Param("barid") Integer barId);
   
    @Modifying
    @Transactional
    @Query(value= "DELETE FROM productosbares WHERE id=:id", nativeQuery = true)
    void eliminarProductoBar(@Param("id") Integer id);
}
