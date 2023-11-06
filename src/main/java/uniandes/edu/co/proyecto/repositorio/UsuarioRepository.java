package uniandes.edu.co.proyecto.repositorio;


import java.util.Collection;

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


    
}
