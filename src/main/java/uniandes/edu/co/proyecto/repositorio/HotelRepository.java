package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Hotel;




public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    
    @Query(value = "SELECT * FROM hoteles", nativeQuery = true)

    Collection<Hotel> darHoteles();
    

    @Query(value = "SELECT * FROM hoteles WHERE id = :id", nativeQuery = true)
    Hotel darHotel(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query (value = "INSERT INTO hoteles (nombre) VALUES (B2_sequence.nextval, :nombre)" , nativeQuery = true)
    void insertarHotel(@Param("nombre") String nombre);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE hoteles SET nombre = :nombre WHERE id = :id", nativeQuery = true)
    void actualizarHotel(@Param ("id") Integer id, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM hoteles WHERE id = :id", nativeQuery = true)
    void eliminarHotel(@Param("id")Integer id);
    
}
