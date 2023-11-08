package uniandes.edu.co.proyecto.repositorio;

import java.time.LocalDate;
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

        public interface rtareq43{
                int getIDSER();
                String getNOMBRESER();
                double getPRECIOSER();
        }

        public interface rtareq12{
                String getNOMBREUSUARIO();
                int getIDUSUARIO();
                String getCEDULAUSUARIO();
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

    @Query(value = "SELECT s.descripcion AS SERVICIODESCRIPCION, COUNT(c.id) AS CANTIDADCONSUMO\r\n" + //
            "FROM servicio s\r\n" + //
            "LEFT JOIN consumos c ON s.consumoid = c.id\r\n" + //
            "WHERE c.fecha BETWEEN TO_DATE(:fechainicial, 'yyyy-mm-dd') AND TO_DATE(:fechafinal, 'yyyy-mm-dd')\r\n" + //
            "GROUP BY  s.descripcion\r\n" + //
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

    @Query(value="SELECT u.id AS IDUSUARIO, u.nombre AS NOMBREUSUARIO, rs.descripcion AS DESCRIPCIONSERVICIO, rs.precio AS PRECIOSERVICIO\r\n" + //
                    "FROM tiposusuario tu\r\n" + //
                    "JOIN usuarios u ON tu.id = u.tipoid\r\n" + //
                    "JOIN reservas r ON u.id = r.usuariosid\r\n" + //
                    "JOIN consumoder cr ON r.id = cr.reservasid\r\n" + //
                    "JOIN consumos c ON cr.consumoid = c.id\r\n" + //
                    "JOIN reservasservicio rs ON c.id = rs.consumoid\r\n" + //
                    "WHERE tu.tipo = 'empleado' u.id = :identifier;", nativeQuery = true)
    Collection<rtareq43> darServicioPorEmpleado(@Param("identifier") Integer identifier);

    @Query(value="SELECT DISTINCT u.id AS IDUSUARIO, u.nombre AS NOMBREUSUARIO, u.cedula AS CEDULAUSUARIO\r\n" + //
                    "FROM usuarios u \r\n" + //
                    "JOIN reservas r ON u.id = r.usuariosid\r\n" + //
                    "JOIN consumoder cd ON r.id = cd.reservasid \r\n" + //
                    "JOIN consumos c ON cd.reservasid = c.id\r\n" + //
                    "JOIN reservasservicio rs ON c.id = rs.consumoid\r\n" + //
                    "JOIN tiposusuario tu ON u.tipoid = tu.id\r\n" + //
                    "WHERE tu.tipo='cliente' AND (\r\n" + //
                    "    (r.fechaentrada >= TRUNC(SYSDATE, 'Q') AND r.fechaentrada <= SYSDATE)\r\n" + //
                    "    OR EXISTS (\r\n" + //
                    "        SELECT 1\r\n" + //
                    "        FROM reservasservicio rss\r\n" + //
                    "        WHERE c.id = rss.consumoid AND rss.precio > 300000\r\n" + //
                    "    )\r\n" + //
                    "    OR (\r\n" + //
                    "        rs.descripcion IN ('SPA', 'Salones de reuniones')\r\n" + //
                    "        AND (rs.fechayhoraf - rs.fechayhorai) > 4/24\r\n" + //
                    "    )\r\n" + //
                    ")\r\n" + //
                    "OR EXISTS (\r\n" + //
                    "        SELECT 1\r\n" + //
                    "        FROM reservas r2\r\n" + //
                    "        WHERE u.id = r2.usuariosid\r\n" + //
                    "        AND MONTHS_BETWEEN(TRUNC(SYSDATE), TRUNC(r2.fechaentrada)) <= 12\r\n" + //
                    "        AND (r2.fechasalida - r2.fechaentrada) <= 90\r\n" + //
                    "    )\r\n" + //
                    "\r\n" + //
                    "GROUP BY u.nombre, u.id, u.cedula",nativeQuery = true)
    Collection<rtareq12> darClientesEstrella();
}



