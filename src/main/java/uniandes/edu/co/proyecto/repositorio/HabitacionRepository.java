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

   
    
}
