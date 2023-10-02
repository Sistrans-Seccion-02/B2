package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Internet;

public interface InternetRepository extends JpaRepository<Internet, Integer> {
    @Query(value = "SELECT * FROM  Internets", nativeQuery = true )
    Collection<Internet> darInternets();
    
    @Query(value = "SELECT * FROM Internets WHERE id = :capacidad", nativeQuery = true)
    Internet darInternet(@Param("capacidad") int capacidad);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Internets (capacidad, precio, Comsumos_idConsumo) VALUES (:capacidad, :precio, :Comsumos_idConsumo)", nativeQuery = true)
    void insertarInternet(@Param("capacidad") Integer capacidad, @Param("precio") double precio, @Param("Comsumos_idConsumo") Integer Comsumos_idConsumo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Internets SET precio = :precio, Comsumos_idConsumo = :Comsumos_idConsumo WHERE capacidad = :capacidad", nativeQuery = true)
    void actualizarInternet(@Param("capacidad") Integer capacidad, @Param("precio") double precio, @Param("Comsumos_idConsumo") Integer Comsumos_idConsumo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Internets WHERE capacidad = :capacidad", nativeQuery = true)
    void eliminarInternet(@Param("capacidad") Integer capacidad);



}
