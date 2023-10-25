package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Consumo;

public interface ConsumoRepository extends JpaRepository<Consumo, Integer> {
    @Query(value = "SELECT * FROM  Consumos", nativeQuery = true )
    Collection<Consumo> darConsumos();
    
    @Query(value = "SELECT * FROM Consumos WHERE idConsumo = :idConsumo", nativeQuery = true)
    Consumo darConsumo(@Param("idConsumo") Integer idConsumo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Consumos (idConsumo,fecha) VALUES (B2.nextval, :fecha)", nativeQuery = true)
    void insertarConsumo(@Param("fecha") Date fecha);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Consumos SET fecha = :fecha WHERE idConsumo = :idConsumo", nativeQuery = true)
    void actualizarConsumo(@Param ("idConsumo") Integer idConsumo, @Param ("fecha") Date fecha);

    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Consumos WHERE idConsumo = :idConsumo", nativeQuery = true)
    void eliminarConsumo(@Param("idConsumo")Integer idConsumo);
}



