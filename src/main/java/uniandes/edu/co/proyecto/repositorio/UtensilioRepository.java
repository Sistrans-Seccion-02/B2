package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Utensilio;

public interface UtensilioRepository extends JpaRepository<Utensilio, Integer> {
    @Query(value = "SELECT * FROM  servicio", nativeQuery = true )
    Collection<Utensilio> darUtensilios();
    
    @Query(value = "SELECT * FROM servicio WHERE id = :id", nativeQuery = true)
    Utensilio darUtensilio(@Param("id") Integer id);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO servicio (id, descripcion, precio, consumoid) VALUES (B2.nextval, :descripcion, :precio, :consumoid)", nativeQuery = true)
    void insertarUtensilio(@Param("descripcion") String descripcion, @Param("precio") double precio, @Param("consumoid") Integer consumoid);

    @Modifying
    @Transactional
    @Query(value = "UPDATE servicio SET descripcion=:descripcion, precio=:precio, consumoid=:consumoid WHERE id=:id", nativeQuery = true)
    void actualizarUtensilio(@Param("id") Integer id, @Param("descripcion") String descripcion, @Param("precio") double precio, @Param("consumoid") Integer consumoid);
   
    @Modifying
    @Transactional
    @Query(value= "DELETE FROM servicio WHERE id=:id", nativeQuery = true)
    void eliminarUtensilio(@Param("id") Integer id);
}



