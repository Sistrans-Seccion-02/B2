package uniandes.edu.co.proyecto.repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Maquina;

public interface MaquinaRepository extends JpaRepository<Maquina, Integer>{
    @Query(value = "SELECT * FROM Maquinas", nativeQuery = true)
    Collection<Maquina> darMaquinas();

    @Query(value = "SELECT * FROM Maquinas WHERE idMaquina = :idMaquina", nativeQuery = true)
    Maquina darMaquina(@Param("idMaquina") Integer idMaquina);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Maquinas (nombre, capacidad, tipo) VALUES (B2_sequence.nextval, :nombre, :capacidad, :tipo)", nativeQuery = true)
    void insertarMaquina(@Param("nombre") String nombre, @Param("capacidad") Integer capacidad, @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Maquinas SET nombre = :nombre, capacidad = :capacidad, tipo = :tipo WHERE idMaquina = :idMaquina", nativeQuery = true)
    void actualizarMaquina(@Param("idMaquina") Integer idMaquina, @Param("nombre") String nombre, @Param("capacidad") Integer capacidad, @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Maquinas WHERE idMaquina = :idMaquina", nativeQuery = true)
    void eleminarMaquina(@Param("idMaquina") Integer idMaquina);
}
