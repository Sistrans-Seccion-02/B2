package uniandes.edu.co.proyecto.repositorio;

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

        public interface ratareq4{
                int getid();
                String getnombre();
                double getpreciofinal();
        }

        public interface rtareq41{
                int getIDSERVICIO();
                String getDESCRIPCIONSERVICIO();
                String getFECHA();
        }

        public interface rtareq42{
                int getIDSER();
                String getNOMBRESER();
                double getPRECIOSER();
        }

        public interface rtareq12{

        }
        
    @Query(value = "SELECT * FROM  servicio", nativeQuery = true )
    Collection<Utensilio> darUtensilios();
    
    @Query(value = "SELECT * FROM servicio WHERE id = :id", nativeQuery = true)
    Utensilio darUtensilio(@Param("id") Integer id);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO servicio (id, descripcion, precio, consumoid) VALUES (B2.nextval, :descripcion, :precio, :consumoid)", nativeQuery = true)
    void insertarUtensilio(@Param("descripcion") String descripcion, @Param("precio") double precio, @Param("consumoid") Integer consumoid);

    @Modifying
    @Transactional
    @Query(value = "UPDATE servicio SET descripcion=:descripcion, precio=:precio, consumoid=:consumoid WHERE id=:id", nativeQuery = true)
    void actualizarUtensilio(@Param("id") Integer id, @Param("descripcion") String descripcion, @Param("precio") double precio, @Param("consumoid") Integer consumoid);
   
    @Modifying
    @Transactional
    @Query(value= "DELETE FROM servicio WHERE id=:id", nativeQuery = true)
    void eliminarUtensilio(@Param("id") Integer id);

//Consultas avanzadas

    @Query(value = "SELECT s.id AS SERVICIOID, s.descripcion AS SERVICIODESCRIPCION, COUNT(c.id) AS CANTIDADCONSUMO\r\n" + //
            "FROM servicio s\r\n" + //
            "LEFT JOIN consumos c ON s.consumoid = c.id\r\n" + //
            "WHERE c.fecha BETWEEN TO_DATE(:fechainicial, 'yyyy-mm-dd') AND TO_DATE(:fechafinal, 'yyyy-mm-dd')\r\n" + //
            "GROUP BY s.id, s.descripcion\r\n" + //
            "ORDER BY COUNT(c.id) DESC\r\n" + //
            "FETCH FIRST 20 ROWS ONLY", nativeQuery = true)    
    Collection<rtareq2> darServiciosPoplares(@Param("fechainicial") String fechainicial, @Param("fechafinal") String fechafinal);

    @Query(value = "SELECT s.id AS SERVICIOID, s.descripcion AS SERVICIODESCRIPCION, COUNT(c.id) AS CANTIDADCONSUMO\r\n" + //
            "FROM servicio s\r\n" + //
            "LEFT JOIN consumos c ON s.consumoid = c.id\r\n" + //
            "WHERE c.fecha BETWEEN SYSDATE - 365 AND SYSDATE\r\n" + //
            "GROUP BY s.id, s.descripcion\r\n" + //
            "HAVING COUNT(c.id) < 3\r\n" + //
            "ORDER BY s.id, s.descripcion", nativeQuery = true)
    Collection<rtareq8> darServiciosMenosConsumidos();

    @Query(value = "SELECT id, nombre, preciofinal FROM SERVICIO\r\n" + //
            "WHERE precio BETWEEN :precioinicial AND :preciofinal", nativeQuery = true)
    Collection<ratareq4> darServicioPorRangoPrecio(@Param("precioinicial") double precioinicial, @Param("preciofinal") double preciofinal);

    @Query(value = "SELECT s.id AS IDSERVICIO, s.descripcion AS DESCRIPCIONSERVICIO, c.fecha AS FECHA\r\n" + //
            "FROM SERVICIO s\r\n" + //
            "INNER JOIN CONSUMOS c ON s.consumoid = c.id\r\n" + //
            "WHERE c.fecha BETWEEN TO_DATE(:fechainicial, 'yyyy-mm-dd') AND TO_DATE(:fechafinal, 'yyyy-mm-dd')", nativeQuery = true)
    Collection<rtareq41> darServicioPorRangoFecha(@Param("fechainicial") String fechainicial, @Param("fechafinal") String fechafinal);

    @Query(value = "SELECT s.id AS IDSER, s.descripcion AS NOMBRESER, s.precio AS PRECIOSER FROM SERVICIO s\r\n"+ //
            "WHERE descripcion = :tipo", nativeQuery = true)
    Collection<rtareq42> darServicioPorTipo(@Param("tipo") String tipo);

//     @Query()
//     Collection<rtareq12> darClientesEstrella();

}



