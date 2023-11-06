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
    "    INNER JOIN CONSUMODER C ON C.CONSUMOID = R.ID " + 
    "    INNER JOIN SERVICIO S ON S.CONSUMOID = C.CONSUMOID " +
    "WHERE  " + 
    "      R.FECHAENTRADA >= TRUNC(SYSDATE) - INTERVAL '1' YEAR   " + 
    "GROUP BY  " + 
    "    H.ID, S.DESCRIPCION " +
    "ORDER BY H.ID", nativeQuery = true)


   Collection<rtareq1> req1();

    //RFC5 - MOSTRAR EL CONSUMO EN HOTELANDES POR UN USUARIO DADO, EN UN RANGO DE FECHAS INDICADO.
        //Recuerde que un cliente puede alojarse en el hotel cuantas veces quiera.
   // @Query(value="SELECT  FROM ")
      //  double req5(@Param("usuario")Integer usuario, @Param("fechaInicio")String fechaInicio, @Param("fechaFin")String fechaFin);

    // RFC9 - CONSULTAR CONSUMO EN HOTELANDES
        //Se quiere conocer la información de los clientes que consumieron al menos una vez un determinado servicio
        //del hotel, en un rango de fechas. Los resultados deben ser clasificados según un criterio deseado por quien
        //realiza la consulta. En la clasificación debe ofrecerse la posibilidad de agrupamiento y ordenamiento de las
        //respuestas según los intereses del usuario que consulta como, por ejemplo, por los datos del cliente, por fecha
        //y número de veces que se utilizó el servicio. Esta operación está disponible para el recepcionista y el gerente
        //del hotel.
            
    
}
