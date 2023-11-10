package uniandes.edu.co.proyecto.repositorio;


import java.util.Collection;

import org.antlr.v4.runtime.atn.SemanticContext.AND;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Usuario;






public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
    public interface rtareq5{
        int getUSUARIO_ID();
        String getTIPO_CONSUMO();
        double getCOSTO();

    }
    public interface rtareq7 {
        int getID();
        String getNOMBRE();
        int getJustificacion();
    }
    public interface rtareq9_10_NOMBRE_ID{
         int getID();
        String getNOMBRE();
        String getTIPO();

    }
    public interface rtareq9_10_FECHA{
        String getFECHA();
        String getSERVICIO();
        int getNUMERO_VECES_UTILIZADO();

    }


    @Query(value = "SELECT * FROM usuarios", nativeQuery = true)
    Collection<Usuario> darUsuarios();

    
    @Query(value = "SELECT * FROM usuarios WHERE id = :id", nativeQuery = true)
    Usuario darUsuario(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query (value = "INSERT INTO usuarios (id, nombre, cedula, tipoid) VALUES ( B2.nextval, :nombre, :cedula, :tipoid)" , nativeQuery = true)
    void insertarUsuario(@Param("nombre") String nombre,@Param("cedula") String cedula, @Param("tipoid") Integer tipoid );
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE usuarios SET nombre = :nombre, cedula = :cedula , tipoid = :tipoid WHERE id = :id", nativeQuery = true)
    void actualizarUsuario(@Param ("id") Integer id, @Param("nombre") String nombre,@Param("cedula") String cedula, @Param("tipoid") Integer tipoid );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios WHERE id = :id", nativeQuery = true)
    void eliminarUsuario(@Param("id")Integer id);


     //RFC5 - MOSTRAR EL CONSUMO EN HOTELANDES POR UN USUARIO DADO, EN UN RANGO DE FECHAS INDICADO.

     @Query(value = "SELECT R.USUARIOSID AS USUARIO_ID, S.DESCRIPCION AS TIPO_CONSUMO, S.PRECIO AS COSTO " +
     "FROM CONSUMOS C " +
     "INNER JOIN SERVICIO S ON S.CONSUMOID = C.ID " +
     "INNER JOIN CONSUMODER CR ON CR.CONSUMOID = C.ID " +
     "INNER JOIN RESERVAS R ON CR.RESERVASID = R.ID " +
     "WHERE R.USUARIOSID = :id AND C.FECHA BETWEEN TO_DATE(:fecha1, 'yyyy-mm-dd') AND TO_DATE(:fecha2, 'yyyy-mm-dd')", nativeQuery = true)
    Collection<rtareq5> req5(@Param("id") Integer id, @Param("fecha1") String fecha1, @Param("fecha2") String fecha2);

    
    //RFC7 - ENCONTRAR LOS BUENOS CLIENTES
    @Query(value = "SELECT U.id as ID, U.nombre as NOMBRE, SUM(S.PRECIO) AS Justificacion\r\n" + //
            "FROM USUARIOS U\r\n" + //
            "INNER JOIN Reservas R ON U.id = R.usuariosid\r\n" + //
            "INNER JOIN consumoder CR ON R.id = CR.reservasid\r\n" + //
            "INNER JOIN consumos C ON C.id = CR.consumoid\r\n" + //
            "INNER JOIN servicio S ON S.consumoid = C.id\r\n" + //
            "WHERE U.TIPOID = 2 AND R.fechaentrada >= trunc(sysdate) - 365\r\n" + //
            "GROUP BY U.id, U.nombre\r\n" + //
            "HAVING Sum(s.precio) > 1000000\r\n" + //
            "UNION\r\n" + //
            "SELECT id, nombre, duracion_total_estadia\r\n" + //
            "FROM (\r\n" + //
            "    SELECT usuarios.id, usuarios.nombre, SUM(reservas.fechasalida - reservas.fechaentrada) AS duracion_total_estadia\r\n" + //
            "    FROM usuarios JOIN reservas ON usuarios.id = reservas.usuariosid WHERE usuarios.tipoid= 2 AND reservas.fechaentrada >= trunc(sysdate) - 365\r\n" + //
            "    GROUP BY usuarios.id, usuarios.nombre\r\n" + //
            "    )\r\n" + //
            "    WHERE duracion_total_estadia >= 14", nativeQuery = true)
    Collection<rtareq7> req7();

    //RFC9
    @Query(value = "SELECT DISTINCT U.ID, U.NOMBRE, S.DESCRIPCION AS TIPO " + 
    "FROM SERVICIO S " +
    "JOIN CONSUMOS C ON C.ID = S.CONSUMOID " +
    "JOIN CONSUMODER CR ON CR.CONSUMOID = C.ID " +
    "JOIN RESERVAS R ON R.ID = CR.RESERVASID " +
    "JOIN USUARIOS U ON U.ID = R.USUARIOSID " +
    "WHERE S.DESCRIPCION = :servicio AND C.FECHA BETWEEN TO_DATE(:fecha1, 'yyyy-mm-dd') AND TO_DATE(:fecha2, 'yyyy-mm-dd') " +
    "ORDER BY U.NOMBRE", nativeQuery = true)
    Collection<rtareq9_10_NOMBRE_ID> req9_NOMBRE(@Param("servicio") String servicio, @Param("fecha1") String fecha1, @Param("fecha2") String fecha2);

    @Query(value = "SELECT DISTINCT U.ID, U.NOMBRE, S.DESCRIPCION AS TIPO " + 
    "FROM SERVICIO S " +
    "JOIN CONSUMOS C ON C.ID = S.CONSUMOID " +
    "JOIN CONSUMODER CR ON CR.CONSUMOID = C.ID " +
    "JOIN RESERVAS R ON R.ID = CR.RESERVASID " +
    "JOIN USUARIOS U ON U.ID = R.USUARIOSID " +
    "WHERE S.DESCRIPCION = :servicio AND C.FECHA BETWEEN TO_DATE(:fecha1, 'yyyy-mm-dd') AND TO_DATE(:fecha2, 'yyyy-mm-dd') " +
    "ORDER BY U.ID", nativeQuery = true)
    Collection<rtareq9_10_NOMBRE_ID> req9_ID(@Param("servicio") String servicio, @Param("fecha1") String fecha1, @Param("fecha2") String fecha2);

    @Query(value ="SELECT C.FECHA, S.DESCRIPCION AS SERVICIO, COUNT(*) AS NUMERO_VECES_UTILIZADO "+
    "FROM SERVICIO S "+
    "JOIN CONSUMOS C ON C.ID = S.CONSUMOID "+
   "JOIN CONSUMODER CR ON CR.CONSUMOID = C.ID "+
    "JOIN RESERVAS R ON R.ID = CR.RESERVASID "+
   "JOIN USUARIOS U ON U.ID = R.USUARIOSID "+
     "WHERE S.DESCRIPCION = :servicio AND C.FECHA BETWEEN TO_DATE(:fecha1, 'yyyy-mm-dd') AND TO_DATE(:fecha2, 'yyyy-mm-dd') " +
    "GROUP BY C.FECHA, S.DESCRIPCION", nativeQuery = true)
    Collection<rtareq9_10_FECHA> req9_FECHA(@Param("servicio") String servicio, @Param("fecha1") String fecha1, @Param("fecha2") String fecha2);
    
    
    
    //RFC10
     @Query(value = "SELECT DISTINCT U.ID, U.NOMBRE, S.DESCRIPCION AS TIPO " + 
    "FROM SERVICIO S " +
    "JOIN CONSUMOS C ON C.ID = S.CONSUMOID " +
    "JOIN CONSUMODER CR ON CR.CONSUMOID = C.ID " +
    "JOIN RESERVAS R ON R.ID = CR.RESERVASID " +
    "JOIN USUARIOS U ON U.ID = R.USUARIOSID " +
    "WHERE S.DESCRIPCION != :servicio AND C.FECHA BETWEEN TO_DATE(:fecha1, 'yyyy-mm-dd') AND TO_DATE(:fecha2, 'yyyy-mm-dd') " +
    "ORDER BY U.NOMBRE", nativeQuery = true)
    Collection<rtareq9_10_NOMBRE_ID> req10_NOMBRE(@Param("servicio") String servicio, @Param("fecha1") String fecha1, @Param("fecha2") String fecha2);

    @Query(value = "SELECT DISTINCT U.ID, U.NOMBRE, S.DESCRIPCION  AS TIPO " + 
    "FROM SERVICIO S " +
    "JOIN CONSUMOS C ON C.ID = S.CONSUMOID " +
    "JOIN CONSUMODER CR ON CR.CONSUMOID = C.ID " +
    "JOIN RESERVAS R ON R.ID = CR.RESERVASID " +
    "JOIN USUARIOS U ON U.ID = R.USUARIOSID " +
    "WHERE S.DESCRIPCION != :servicio AND C.FECHA BETWEEN TO_DATE(:fecha1, 'yyyy-mm-dd') AND TO_DATE(:fecha2, 'yyyy-mm-dd') " +
    "ORDER BY U.ID", nativeQuery = true)
    Collection<rtareq9_10_NOMBRE_ID> req10_ID(@Param("servicio") String servicio, @Param("fecha1") String fecha1, @Param("fecha2") String fecha2);

    @Query(value ="SELECT C.FECHA, S.DESCRIPCION AS SERVICIO, COUNT(*) AS NUMERO_VECES_UTILIZADO "+
    "FROM SERVICIO S "+
    "JOIN CONSUMOS C ON C.ID = S.CONSUMOID "+
   "JOIN CONSUMODER CR ON CR.CONSUMOID = C.ID "+
    "JOIN RESERVAS R ON R.ID = CR.RESERVASID "+
   "JOIN USUARIOS U ON U.ID = R.USUARIOSID "+
     "WHERE S.DESCRIPCION != :servicio AND C.FECHA BETWEEN TO_DATE(:fecha1, 'yyyy-mm-dd') AND TO_DATE(:fecha2, 'yyyy-mm-dd') " +
    "GROUP BY C.FECHA, S.DESCRIPCION", nativeQuery = true)
    Collection<rtareq9_10_FECHA> req10_FECHA(@Param("servicio") String servicio, @Param("fecha1") String fecha1, @Param("fecha2") String fecha2);
    
    
    
}
