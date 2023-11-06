package uniandes.edu.co.proyecto.repositorio;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Utensilio;

public interface UtensilioRepository extends JpaRepository<Utensilio, Integer> {

        public interface rtareq8{
                int getSERVICIOID();
                String getSERVICIODESCRIPCION();
                int getCANTIDADCONSUMO();
        }

        public interface rtareq2{
                int getSERVICIOID();
                String getSERVICIODESCRIPCION();
                int getCANTIDADCONSUMO();
        }
        
    @Query(value = "SELECT * FROM  servicio", nativeQuery = true )
    Collection<Utensilio> darUtensilios();
    
    @Query(value = "SELECT * FROM servicio WHERE id = :id", nativeQuery = true)
    Utensilio darUtensilio(@Param("id") Integer id);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO servicio (id, descripcion, precio, consumoid, duracion) VALUES (B2.nextval, :descripcion, :precio, :consumoid, :duracion)", nativeQuery = true)
    void insertarUtensilio(@Param("descripcion") String descripcion, @Param("precio") double precio, @Param("consumoid") Integer consumoid, @Param("duracion") Integer duracion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE servicio SET descripcion=:descripcion, precio=:precio, consumoid=:consumoid, duracion=:duracion WHERE id=:id", nativeQuery = true)
    void actualizarUtensilio(@Param("id") Integer id, @Param("descripcion") String descripcion, @Param("precio") double precio, @Param("consumoid") Integer consumoid, @Param("duracion") Integer duracion);
   
    @Modifying
    @Transactional
    @Query(value= "DELETE FROM servicio WHERE id=:id", nativeQuery = true)
    void eliminarUtensilio(@Param("id") Integer id);

//Consultas avanzadas

    @Query(value = "SELECT s.id AS SERVICIOID, s.descripcion AS SERVICIODESCRIPCION, COUNT(c.id) AS CANTIDADCONSUMO\r\n" + //
            "FROM servicio s\r\n" + //
            "LEFT JOIN consumos c ON s.consumoid = c.id\r\n" + //
            "WHERE c.fecha BETWEEN :fechainicial AND :fechafinal\r\n" + //
            "GROUP BY s.id, s.descripcion\r\n" + //
            "ORDER BY COUNT(c.id) DESC\r\n" + //
            "FETCH FIRST 20 ROWS ONLY", nativeQuery = true)    
    Collection<rtareq2> darServiciosPoplares(@Param("fechainicial") LocalDateTime fechainicial, @Param("fechafinal") LocalDateTime fechafinal);

    @Query(value = "SELECT s.id AS SERVICIOID, s.descripcion AS SERVICIODESCRIPCION, COUNT(c.id) AS CANTIDADCONSUMO\r\n" + //
            "FROM servicio s\r\n" + //
            "LEFT JOIN consumos c ON s.consumoid = c.id\r\n" + //
            "WHERE c.fecha BETWEEN SYSDATE - 365 AND SYSDATE\r\n" + //
            "GROUP BY s.id, s.descripcion\r\n" + //
            "HAVING COUNT(c.id) < 3\r\n" + //
            "ORDER BY s.id, s.descripcion", nativeQuery = true)
    Collection<rtareq8> darServiciosMenosConsumidos();

    @Query(value = "SELECT * FROM SERVICIO\r\n" + //
            "WHERE precio BETWEEN :precioinicial AND :preciofinal", nativeQuery = true)
    Collection<Utensilio> darServicioPorRangoPrecio(@Param("precioinicial") double precioinicial, @Param("preciofinal") double preciofinal);

    @Query(value = "SELECT * s.id, s.descripcion\r\n" + //
            "FROM SERVICIO s\r\n" + //
            "INNER JOIN CONSUMOS c ON s.consumoid = c.id\r\n" + //
            "WHERE c.fecha BETWEEN :fechai AND :fechaf", nativeQuery = true)
    Collection<Utensilio> darServicioPorRangoFecha(@Param("fechai") LocalDateTime fechai, @Param("fechaf") LocalDateTime fechaf);

    @Query(value = "SELECT * FROM SERVICIO\r\n"+ //
            "WHERE descripcion = :tipo", nativeQuery = true)
    Collection<Utensilio> darServicioPorTipo(@Param("tipo") String tipo);

}



