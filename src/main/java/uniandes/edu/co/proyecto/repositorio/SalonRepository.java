package uniandes.edu.co.proyecto.repositorio;
import java.time.LocalTime;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Salon;

public interface SalonRepository extends JpaRepository<Salon, String>{
    
    @Query(value = "SELECT * FROM Salones", nativeQuery = true)
    Collection<Salon> darSalones();

    @Query(value = "SELECT * FROM Salones WHERE nombre = :nombre", nativeQuery = true)
    Salon darSalon(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Salones (nombre, horarioapertura, horariocierre, tipoSalon, capacidad) VALUES (:nombre, :horarioapertura, :horariocierre, :tipoSalon, :capacidad)", nativeQuery = true)
    void insertarSalon(@Param("nombre") String nombre, @Param("horarioapertura") LocalTime horarioapertura, @Param("horariocierre") LocalTime horariocierre,@Param("tipoSalon") String tipoSalon, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Salones SET horarioapertura = :horarioapertura, horariocierre = :horariocierre, tipoSalon = :tipoSalon, capacidad = :capacidad WHERE nombre = :nombre", nativeQuery = true)
    void actualizarSalon(@Param("nombre") String nombre, @Param("horarioapertura") LocalTime horarioapertura, @Param("horariocierre") LocalTime horariocierre,@Param("tipoSalon") String tipoSalon, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Salones WHERE nombre = :nombre", nativeQuery = true)
    void eleminarSalon(@Param("nombre") String nombre);
}
