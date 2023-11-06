package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import uniandes.edu.co.proyecto.Modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;
import uniandes.edu.co.proyecto.repositorio.tipoUsuarioRepository;

@Controller

public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private tipoUsuarioRepository tipoUsuarioRepository;

    @GetMapping("/usuarios")
    public String usuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepository.darUsuarios());
        return "usuario";
    }
    @GetMapping("/usuarios/req5")
    public String req5(Model model, Integer id, String fecha1, String fecha2) {
        model.addAttribute("usuarios", usuarioRepository.req5(id, fecha1, fecha2));
        
        return "usuarioreq5";
    }

    @GetMapping("/usuarios/new")
    public String usuarioForm(Model model){
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("tipos", tipoUsuarioRepository.dartiposUsuarios());
        return"UsuarioNuevo";       
    }

    @PostMapping("/usuarios/new/save")
    public String usuarioGuardar(@ModelAttribute Usuario usuario){
        System.out.println(usuario.getNombre());
        usuarioRepository.insertarUsuario(usuario.getNombre(), usuario.getCedula(), usuario.getTipoId().getId());
        return "redirect:/usuarios";
    
    }
    @GetMapping("/usuarios/{id}/edit")
        public String usuarioEditarForm(@PathVariable("id") int id, Model model) {
            Usuario usuario = usuarioRepository.darUsuario(id);
            System.out.println(usuario);
            if (usuario != null) {
                model.addAttribute("usuario", usuario);
                model.addAttribute("tipos", tipoUsuarioRepository.dartiposUsuarios());
                return "UsuarioEditar";
            } else {
                return "redirect:/usuarios";
            }
        }

        @PostMapping("/usuarios/{id}/edit/save")
        public String usuarioEditarGuardar(@PathVariable("id") int id, @ModelAttribute Usuario usuario) {
            usuarioRepository.actualizarUsuario(((Integer) id), usuario.getNombre(), usuario.getCedula(), usuario.getTipoId().getId());
                    
            return "redirect:/usuarios";
        }
    

    @GetMapping("/usuarios/{id}/delete")
    public String usuarioEliminar(@PathVariable("id") int id){
        usuarioRepository.eliminarUsuario(id);
        return "redirect:/usuarios";
    }

   




    
    
}
