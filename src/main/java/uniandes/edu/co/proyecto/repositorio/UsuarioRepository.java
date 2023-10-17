package uniandes.edu.co.proyecto.repositorio;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Usuario;





public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
    @Query(value = "SELECT * FROM usuarios", nativeQuery = true)

    Collection<Usuario> darUsuarios();
    

    @Query(value = "SELECT * FROM usuarios WHERE id = :id", nativeQuery = true)
    Usuario darUsuario(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query (value = "INSERT INTO usuarios (id, nombre, cedula, tiposusuario_id) VALUES ( B2.nextval, :nombre, :cedula, :tiposusuario_id)" , nativeQuery = true)
    void insertarUsuario(@Param("nombre") String nombre,@Param("cedula") String cedula, @Param("tiposusuario_id") Integer tiposusuario_id );
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE usuarios SET nombre = :nombre, cedula = :cedula , tiposusuario_id = :tiposusuario_id WHERE id = :id", nativeQuery = true)
    void actualizarUsuario(@Param ("id") Integer id, @Param("nombre") String nombre,@Param("cedula") String cedula, @Param("tiposusuario_id") Integer tiposusuario_id );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios WHERE id = :id", nativeQuery = true)
    void eliminarUsuario(@Param("id")Integer id);
    

    
}
