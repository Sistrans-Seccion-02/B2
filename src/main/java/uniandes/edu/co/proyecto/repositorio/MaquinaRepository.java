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
    @Query(value = "INSERT INTO Maquinas (nombre, Gimnasios_nombre) VALUES (B2_sequence.nextval, :nombre, :Gimnasios_nombre)", nativeQuery = true)
    void insertarMaquina(@Param("nombre") String nombre, @Param("Gimnasios_nombre") String Gimnasios_nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Maquinas SET nombre = :nombre, Gimnasios_nombre = :Gimnasios_nombre WHERE idMaquina = :idMaquina", nativeQuery = true)
    void actualizarMaquina(@Param("idMaquina") Integer idMaquina, @Param("nombre") String nombre, @Param("Gimnasios_nombre") String Gimnasios_nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Maquinas WHERE idMaquina = :idMaquina", nativeQuery = true)
    void eliminarMaquina(@Param("idMaquina") Integer idMaquina);
}
