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
    @Query(value = "INSERT INTO Internets (capacidad, precio) VALUES (B2_sequence.nextval, :capacidad, :precio)")
    void insertarInternet(@Param("capacidad") int capacidad, @Param("precio") float precio);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Internets SET capacidad=:capacidad, precio =:precio WHERE capacidad=:capacidad", nativeQuery = true)
    void actualizarInternet(@Param("capacidad") int capacidad, @Param("precio") float precio);
   
    @Modifying
    @Transactional
    @Query(value= "DELETE FROM Internets WHERE capacidad=:capacidad", nativeQuery = true)
    void eliminarInternet(@Param("capacidad") int capacidad);
}
