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
                String getdescripcion();
                double getprecio();
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
                int getUSUARIOID();
                String getNOMBRECLIENTE();
                String getCEDULACLIENTE();
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

    @Query(value = "SELECT id, descripcion, precio FROM SERVICIO\r\n" + //
            "WHERE precio BETWEEN :precioinicial AND :preciofinal", nativeQuery = true)
    Collection<ratareq4> darServicioPorRangoPrecio(@Param("precioinicial") Double precioinicial, @Param("preciofinal") Double preciofinal);

    @Query(value = "SELECT s.id AS IDSERVICIO, s.descripcion AS DESCRIPCIONSERVICIO, c.fecha AS FECHA\r\n" + //
            "FROM SERVICIO s\r\n" + //
            "INNER JOIN CONSUMOS c ON s.consumoid = c.id\r\n" + //
            "WHERE c.fecha BETWEEN TO_DATE(:fechainicial, 'yyyy-mm-dd') AND TO_DATE(:fechafinal, 'yyyy-mm-dd')", nativeQuery = true)
    Collection<rtareq41> darServicioPorRangoFecha(@Param("fechainicial") String fechainicial, @Param("fechafinal") String fechafinal);

    @Query(value = "SELECT s.id AS IDSER, s.descripcion AS NOMBRESER, s.precio AS PRECIOSER FROM SERVICIO s\r\n"+ //
            "WHERE descripcion = :tipo", nativeQuery = true)
    Collection<rtareq42> darServicioPorTipo(@Param("tipo") String tipo);

//     @Query(value="SELECT u.id AS usuario_id, u.nombre AS nombre_cliente, u.cedula AS cedula_cliente,\r\n" + //
//                     "       t.tipo AS tipo_usuario, t.descripcion AS descripcion_tipo_usuario,\r\n" + //
//                     "       r.id AS reserva_id, r.fechaentrada, r.fechasalida, r.numpersonas, r.estado, r.precioreserva,\r\n" + //
//                     "       rs.fechayhorai AS fecha_inicio_servicio, rs.fechayhoraf AS fecha_fin_servicio,\r\n" + //
//                     "       rs.precio AS precio_servicio, rs.descripcion AS descripcion_servicio\r\n" + //
//                     "FROM usuarios u\r\n" + //
//                     "JOIN tiposusuario t ON u.tipoid = t.id\r\n" + //
//                     "JOIN reservas r ON u.id = r.usuariosid\r\n" + //
//                     "LEFT JOIN reservasservicio rs ON r.id = rs.reservaid\r\n" + //
//                     "WHERE t.tipo = 'cliente'\r\n" + //
//                     "AND (\r\n" + //
//                     "    (SELECT COUNT(*) FROM reservas r2\r\n" + //
//                     "     WHERE r2.usuariosid = u.id\r\n" + //
//                     "     AND DATE_PART('quarter', r2.fechaentrada) = DATE_PART('quarter', CURRENT_DATE) - 1) > 0\r\n" + //
//                     "    OR\r\n" + //
//                     "    (SELECT COUNT(*) FROM reservasservicio rs2\r\n" + //
//                     "     WHERE r.id = rs2.reservaid AND rs2.precio > 300000) > 0\r\n" + //
//                     "    OR\r\n" + //
//                     "    (SELECT COUNT(*) FROM reservasservicio rs3\r\n" + //
//                     "     WHERE r.id = rs3.reservaid AND (rs3.descripcion = 'SPA' OR rs3.descripcion = 'Salon de reuniones')\r\n" + //
//                     "     AND EXTRACT(HOUR FROM (rs3.fechayhoraf - rs3.fechayhorai)) > 4) > 0\r\n" + //
//                     ")\r\n" + //
//                     "ORDER BY u.id, r.id, rs.fechayhorai;")
//     Collection<rtareq12> darClientesEstrella();

}



