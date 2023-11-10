package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Consumo;
import uniandes.edu.co.proyecto.Modelo.Habitacion;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository.rtareq3;

public interface ConsumoRepository extends JpaRepository<Consumo, Integer> {

    public interface rtareq6{
        String getFECHA();
        int getTotal_del_dia();
        int getOCUPACION();
    }

    @Query(value = "SELECT * FROM  Consumos", nativeQuery = true )
    Collection<Consumo> darConsumos();
    
    @Query(value = "SELECT * FROM Consumos WHERE id = :id", nativeQuery = true)
    Consumo darConsumo(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Consumos (id,fecha) VALUES (B2.nextval, :fecha)", nativeQuery = true)
    void insertarConsumo(@Param("fecha") Date fecha);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Consumos SET fecha = :fecha WHERE id = :id", nativeQuery = true)
    void actualizarConsumo(@Param ("id") Integer id, @Param ("fecha") Date fecha);

    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Consumos WHERE id = :id", nativeQuery = true)
    void eliminarConsumo(@Param("id")Integer id);

    @Query(value = "SELECT TRUNC(CONSUMOS.FECHA) AS FECHA, SUM(S.PRECIO) AS Total_del_dia  , COUNT(DISTINCT R.ID ) AS OCUPACION\r\n" + //
            " FROM RESERVAS R \r\n" + //
            " INNER JOIN CONSUMODER C ON R.ID = C.RESERVASID\r\n" + //
            " INNER JOIN CONSUMOS ON CONSUMOS.ID= C.CONSUMOID\r\n" + //
            " INNER JOIN SERVICIO S ON S.CONSUMOID = CONSUMOS.ID \r\n" + //
            " GROUP BY TRUNC(CONSUMOS.FECHA)\r\n" + //
            " ORDER BY OCUPACION desc", nativeQuery=true)
    Collection<rtareq6> req6();
}



