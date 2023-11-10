package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Habitacion;




public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {
    public interface rtareq1{
        int getHABITACION_ID();
        String getDESCRIPCION();
        double getTotal_Precio();

    }
    
    public interface rtareq3{
        int getID_HABITACION();
        double getOCCUPANCY_PERCENTAGE();
    }
    
    public interface rtareq11{
        String getYearWeek();
        int gethabitacionid();
        int getRoomBookings();
    }

    @Query(value = "SELECT * FROM habitacion", nativeQuery = true)

    Collection<Habitacion> darHabitaciones();
    

    @Query(value = "SELECT * FROM habitacion WHERE id = :id", nativeQuery = true)
    Habitacion darHabitacion(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query (value = "INSERT INTO habitacion (id, capacidad, tipoid) VALUES (B2.nextval, :capacidad, :tipoid)" , nativeQuery = true)
    void insertarHabitacion(@Param("capacidad") String capacidad, @Param("tipoid") Integer tipoid);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE habitacion SET capacidad = :capacidad, tipoid = :tipoid WHERE id = :id", nativeQuery = true)
    void actualizarHabitacion(@Param ("id") Integer id, @Param("capacidad") String capacidad, @Param("tipoid") Integer tipoid);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitacion WHERE id = :id", nativeQuery = true)
    void eliminarHabitacion(@Param("id")Integer id);



    @Query(value = "SELECT H.ID AS Habitacion_ID, S.DESCRIPCION, SUM(S.PRECIO) AS Total_Precio " + 
    "FROM " + 
    "    HABITACION H " + 
    "    INNER JOIN RESERVAS R ON R.HABITACIONID = H.ID " + 
    "    INNER JOIN CONSUMODER C ON C.RESERVASID = R.ID " + 
    "    INNER JOIN SERVICIO S ON S.CONSUMOID = C.CONSUMOID " +
    "WHERE  " + 
    "      R.FECHAENTRADA >= TRUNC(SYSDATE) - INTERVAL '1' YEAR   " + 
    "GROUP BY  " + 
    "    H.ID, S.DESCRIPCION " +
    "ORDER BY H.ID", nativeQuery = true)


   Collection<rtareq1> req1();

   @Query(value = "SELECT habitacion.id AS ID_HABITACION,\r\n" + //
           "    ROUND(COALESCE(\r\n" + //
           "    (SUM(\r\n" + //
           "      CASE\r\n" + //
           "        WHEN reservas.fechaentrada = reservas.fechasalida THEN 1\r\n" + //
           "        WHEN reservas.fechaentrada < (TRUNC(SYSDATE) - 365) THEN (reservas.fechasalida - (TRUNC(SYSDATE) - 365)) + 1\r\n" + //
           "        ELSE (reservas.fechasalida - reservas.fechaentrada) + 1\r\n" + //
           "      END\r\n" + //
           "    ) / 365.0) * 100,\r\n" + //
           "    0\r\n" + //
           "    ), 2) AS OCCUPANCY_PERCENTAGE\r\n" + //
           "    FROM\r\n" + //
           "      habitacion\r\n" + //
           "    LEFT JOIN\r\n" + //
           "      reservas\r\n" + //
           "      ON habitacion.id = reservas.habitacionid\r\n" + //
           "      AND reservas.fechaentrada >= TRUNC(SYSDATE) - 365\r\n" + //
           "    GROUP BY\r\n" + //
           "      habitacion.id", nativeQuery=true)
    Collection<rtareq3> req3();
    

    
    @Query(value = "SELECT \r\n" + //
            "    YearWeek,\r\n" + //
            "    habitacionid,\r\n" + //
            "    RoomBookings\r\n" + //
            "FROM (\r\n" + //
            "    SELECT \r\n" + //
            "        TO_CHAR(TRUNC(reservas.fechaentrada, 'IW'), 'IYYY-IW') AS YearWeek, \r\n" + //
            "        reservas.habitacionid,\r\n" + //
            "        COUNT(*) AS RoomBookings,\r\n" + //
            "        RANK() OVER (PARTITION BY TO_CHAR(TRUNC(reservas.fechaentrada, 'IW'), 'IYYY-IW') ORDER BY COUNT(*) DESC) as rnk\r\n" + //
            "    FROM \r\n" + //
            "        reservas \r\n" + //
            "    WHERE \r\n" + //
            "        reservas.fechaentrada >= ADD_MONTHS(TRUNC(SYSDATE, 'YY'), -12)\r\n" + //
            "        AND reservas.fechaentrada < TRUNC(SYSDATE, 'YY')\r\n" + //
            "    GROUP BY \r\n" + //
            "        TO_CHAR(TRUNC(reservas.fechaentrada, 'IW'), 'IYYY-IW'), \r\n" + //
            "        reservas.habitacionid\r\n" + //
            ") \r\n" + //
            "WHERE \r\n" + //
            "    rnk = 1\r\n" + //
            "ORDER BY \r\n" + //
            "    YearWeek", nativeQuery=true)
    Collection<rtareq11> req11();
}
