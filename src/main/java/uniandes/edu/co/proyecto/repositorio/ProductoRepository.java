package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, String> {
    @Query(value = "SELECT * FROM  Productos", nativeQuery = true )
    Collection<Producto> darProductos();
    
    @Query(value = "SELECT * FROM Productos WHERE nombre = :nombre", nativeQuery = true)
    Producto darProducto(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Productos (nombre, precio) VALUES (B2_sequence.nextval, :nombre, :precio)")
    void insertarProducto(@Param("nombre") String nombre, @Param("precio") double precio);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Productos SET nombre=:nombre, precio=:precio, pazYSalvo=:pazYSalvo WHERE nombre=:nombre", nativeQuery = true)
    void actualizarProducto(@Param("nombre") String nombre, @Param("precio") double precio);
   
    @Modifying
    @Transactional
    @Query(value= "DELETE FROM Productos WHERE nombre=:nombre", nativeQuery = true)
    void eliminarProducto(@Param("nombre") String nombre);
}




