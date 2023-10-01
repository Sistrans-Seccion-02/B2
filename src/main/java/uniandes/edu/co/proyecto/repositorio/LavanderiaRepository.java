package uniandes.edu.co.proyecto.repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.Modelo.Lavanderia;

public interface LavanderiaRepository extends JpaRepository<Lavanderia, Integer>{
    
    @Query(value = "SELECT * FROM Lavanderias", nativeQuery = true)
    Collection<Lavanderia> darLavanderias();

    @Query(value = "SELECT * FROM Lavanderias WHERE idLavanderia = :idLavanderia", nativeQuery = true)
    Lavanderia darLavanderia(@Param("idLavanderia") Integer idLavanderia);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO lavanderias (B2_sequence.nextval, numPrendas, numZapatos, tipoLavado, costo) VALUES (:numPrendas, :numZapatos, :tipoLavado, :costo)", nativeQuery = true)
    void insertarLavanderia(@Param("numPrendas") Integer numPrendas, @Param("numZapatos") Integer numZapatos, @Param("tipoLavado") String tipoLavado, @Param("costo") Integer costo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Lavanderias SET numPrendas = :numPrendas, numZapatos = :numZapatos, tipoLavado = :tipoLavado, costo = :costo WHERE idLavanderia = :idLavanderia", nativeQuery = true)
    void actualizarLavanderia(@Param("idLavanderia") Integer idLavanderia, @Param("numPrendas") Integer numPrendas, @Param("numZapatos") Integer numZapatos, @Param("tipoLavado") String tipoLavado, @Param("costo") Integer costo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Lavanderias WHERE idLavanderia = :idLavanderia", nativeQuery = true)
    void eleminarLavanderia(@Param("idLavanderia") Integer idLavanderia);
}
