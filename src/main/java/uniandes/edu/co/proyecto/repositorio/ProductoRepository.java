package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    @Query(value = "SELECT * FROM  Productos", nativeQuery = true )
    Collection<Producto> darProductos();
    
    @Query(value = "SELECT * FROM Productos WHERE id = :id", nativeQuery = true)
    Producto darProducto(@Param("id") Integer id);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Productos (nombre, consumoid, id, tiendaid, smercadoid, preciofinal) VALUES (:nombre, :consumoid,  B2.nextval, :tiendaid, :smercadoid, :preciofinal)", nativeQuery = true)
    void insertarProducto(@Param("nombre") String nombre, @Param("consumoid") Integer consumoid, @Param("tiendaid") Integer tiendaid, @Param("smercadoid") Integer smercadoid, @Param("preciofinal") double preciofinal);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Productos SET nombre=:nombre, consumoid=:consumoid, tiendaid=:tiendaid, smercadoid=:smercadoid, preciofinal=:preciofinal WHERE id=:id", nativeQuery = true)
    void actualizarProducto(@Param("id") Integer id, @Param("nombre") String nombre, @Param("consumoid") Integer consumoid, @Param("tiendaid") Integer tiendaid, @Param("smercadoid") Integer smercadoid, @Param("preciofinal") double preciofinal);
   
    @Modifying
    @Transactional
    @Query(value= "DELETE FROM Productos WHERE id=:id", nativeQuery = true)
    void eliminarProducto(@Param("id") Integer id);
}




