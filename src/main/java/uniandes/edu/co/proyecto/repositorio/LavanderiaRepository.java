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

    @Query(value = "SELECT * FROM Lavanderias WHERE idlavanderia = :idlavanderia", nativeQuery = true)
    Lavanderia darLavanderia(@Param("idlavanderia") Integer idlavanderia);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO lavanderias (numprendas, numzapatos, tipolavado, costo, Comsumos_idConsumo, preciofinal) VALUES (B2_sequence.nextval, :numprendas, :numzapatos, :tipolavado, :costo, :Comsumos_idConsumo, :preciofinal)", nativeQuery = true)
    void insertarLavanderia(@Param("numprendas") Integer numprendas, @Param("numzapatos") Integer numzapatos, @Param("tipolavado") String tipolavado, @Param("costo") double costo, @Param("Comsumos_idConsumo") Integer Comsumos_idConsumo, @Param("preciofinal") double preciofinal);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Lavanderias SET numprendas = :numprendas, numzapatos = :numzapatos, tipolavado = :tipolavado, costo = :costo, Comsumos_idConsumo = :Comsumos_idConsumo, preciofinal = :preciofinal WHERE idlavanderia = :idlavanderia", nativeQuery = true)
    void actualizarLavanderia(@Param("idlavanderia") Integer idlavanderia, @Param("numprendas") Integer numprendas, @Param("numzapatos") Integer numzapatos, @Param("tipolavado") String tipolavado, @Param("costo") double costo, @Param("Comsumos_idConsumo") Integer Comsumos_idConsumo, @Param("preciofinal") double preciofinal);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Lavanderias WHERE idlavanderia = :idlavanderia", nativeQuery = true)
    void eleminarLavanderia(@Param("idlavanderia") Integer idlavanderia);
}
