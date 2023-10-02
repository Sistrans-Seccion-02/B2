package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.Modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

@Controller

public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public String usuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepository.darUsuarios());
        return "Usuario";
        
    }

    @GetMapping("/usuarios/new")
    public String usuarioForm(Model model){
        model.addAttribute("usuario", new Usuario());
        return"UsuarioNuevo";       
    }

    @PostMapping("/usuarios/new/save")
    public String usuarioGuardar(@ModelAttribute Usuario usuario){
        usuarioRepository.insertarUsuario(usuario.getNombre(), usuario.getCedula(), usuario.getTipo());
        return "redirect:/usuarios";
    
    }

    @GetMapping("/usuarios/{id}/editar")
    public String usuarioEditarForm(@PathVariable("id") int id, Model model){
        Usuario usuario= usuarioRepository.darUsuario(id);
        if(usuario != null){
            model.addAttribute("usuario", usuario);
            return "UsuarioEditar";
        }
        else{
            return "redirect:/usuarios";
        }
    }
    @PostMapping("/usuarios/{id}/editar/save")
     public String usuarioEditarGuardar(@PathVariable("id") int id, @ModelAttribute Usuario usuario){
        usuarioRepository.actualizarUsuario(id, usuario.getNombre(), usuario.getCedula(), usuario.getTipo());
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{id}/delete")
    public String usuarioEliminar(@PathVariable("id") int id){
        usuarioRepository.eliminarUsuario(id);
        return "redirect:/usuarios";
    }

   




    
    
}
