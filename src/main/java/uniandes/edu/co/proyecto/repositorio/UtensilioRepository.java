package uniandes.edu.co.proyecto.repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Utensilio;

public interface UtensilioRepository extends JpaRepository<Utensilio, Integer>{
    
    @Query(value = "SELECT * FROM Utensilios", nativeQuery = true)
    Collection<Utensilio> darUtensilios();

    @Query(value = "SELECT * FROM Utensilios WHERE idUtensilio = :idUtensilio", nativeQuery = true)
    Utensilio darUtensilio(@Param("idUtensilio") Integer idUtensilio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Utensilios (id, nombre, PrestamosUt_idUtensilio) VALUES (B2_sequence.nextval, :nombre, :PrestamosUt_idUtensilio)", nativeQuery = true)
    void insertarUtensilio(@Param("nombre") String nombre, @Param("PrestamosUt_idUtensilio") Integer PrestamosUt_idUtensilio);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Utensilios SET nombre = :nombre, PrestamosUt_idUtensilio = :PrestamosUt_idUtensilio WHERE id = :id", nativeQuery = true)
    void actualizarUtensilio(@Param("id") Integer id, @Param("nombre") String nombre, @Param("PrestamosUt_idUtensilio") Integer PrestamosUt_idUtensilio);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Utensilios WHERE id = :id", nativeQuery = true)
    void eleminarUtensilio(@Param("id") Integer id);
}
