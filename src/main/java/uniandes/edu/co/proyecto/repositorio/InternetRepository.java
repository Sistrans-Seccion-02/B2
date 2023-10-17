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
    
    @Query(value = "SELECT * FROM Internets WHERE consumos_idconsumo = :consumos_idconsumo AND capacidad=:capacidad", nativeQuery = true)
    Internet darInternet(@Param("consumos_idconsumo")Integer consumos_idconsumo,@Param("capacidad") int capacidad);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Internets (capacidad, precio, consumos_idconsumo) VALUES (:capacidad, :precio, :consumos_idconsumo)", nativeQuery = true)
    void insertarInternet(@Param("capacidad") Integer capacidad, @Param("precio") double precio, @Param("consumos_idconsumo") Integer consumos_idconsumo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Internets SET precio = :precio, consumos_idconsumo = :consumos_idconsumo WHERE capacidad = :capacidad", nativeQuery = true)
    void actualizarInternet(@Param("capacidad") Integer capacidad, @Param("precio") double precio, @Param("consumos_idconsumo") Integer consumos_idconsumo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Internets WHERE capacidad = :capacidad", nativeQuery = true)
    void eliminarInternet(@Param("capacidad") Integer capacidad);



}
