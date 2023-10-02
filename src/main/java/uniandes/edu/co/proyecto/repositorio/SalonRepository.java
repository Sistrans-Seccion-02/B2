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
    @Query(value = "INSERT INTO Salones (nombre, precio, horaApertura, horaCierre, ocupado, tipoSalon, capacidad, Comsumos_idConsumo) VALUES (:nombre, :precio, :horaApertura, :horaCierre, :ocupado, :tipoSalon, :capacidad, :Comsumos_idConsumo)", nativeQuery = true)
    void insertarSalon(@Param("nombre") String nombre, @Param("precio") double precio, @Param("horaApertura") LocalTime horaApertura, @Param("horaCierre") LocalTime horaCierre,@Param("ocupado") Boolean ocupado,@Param("tipoSalon") String tipoSalon, @Param("capacidad") Integer capacidad, @Param("Comsumos_idConsumo") Integer Comsumos_idConsumo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Salones SET precio = :precio, horaApertura = :horaApertura, horaCierre = :horaCierre, ocupado = :ocupado, tipoSalon = :tipoSalon, capacidad = :capacidad, Comsumos_idConsumo = :Comsumos_idConsumo WHERE nombre = :nombre", nativeQuery = true)
    void actualizarSalon(@Param("nombre") String nombre, @Param("precio") double precio, @Param("horaApertura") LocalTime horaApertura, @Param("horaCierre") LocalTime horaCierre,@Param("ocupado") Boolean ocupado,@Param("tipoSalon") String tipoSalon, @Param("capacidad") Integer capacidad, @Param("Comsumos_idConsumo") Integer Comsumos_idConsumo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Salones WHERE nombre = :nombre", nativeQuery = true)
    void eleminarSalon(@Param("nombre") String nombre);
}
