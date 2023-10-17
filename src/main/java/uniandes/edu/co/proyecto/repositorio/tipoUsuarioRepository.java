package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.TipoUsuario;

public interface tipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer>{
    
    @Query(value = "SELECT * FROM tiposUsuario", nativeQuery = true)

    Collection<TipoUsuario> dartiposUsuarios();
    

    @Query(value = "SELECT * FROM tiposUsuario WHERE id = :id", nativeQuery = true)
    TipoUsuario darTipoUsuario(@Param("id") Integer id);

    @Modifying
    @Transactional


    @Query (value = "INSERT INTO tiposUsuario (id, tipo, descripcion) VALUES ( B2.nextval, :tipo, :descripcion)" , nativeQuery = true)
    void insertarTipoUsuario(@Param("tipo") String tipo,@Param("descripcion") String descripcion);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE tiposUsuario SET  tipo = :tipo, descripcion = :descripcion  WHERE id = :id", nativeQuery = true)
    void actualizarTipoUsuario(@Param ("id") Integer id, @Param("tipo") String tipo,@Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tiposUsuario WHERE id = :id", nativeQuery = true)
    void eliminarTipoUsuario(@Param("id")Integer id);
    

    
}
