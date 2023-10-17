package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.TipoUsuario;
import uniandes.edu.co.proyecto.repositorio.tipoUsuarioRepository;


@Controller
public class tipoUsuarioController {

    @Autowired
    private tipoUsuarioRepository tipousuarioRepository;

    @GetMapping("/tiposUsuario")
    public String tiposUsuario(Model model) {
        model.addAttribute("tiposUsuario", tipousuarioRepository.dartiposUsuarios());
        return "tiposUsuario";
        
    }

    @GetMapping("/tiposUsuario/new")
    public String tiposUsuarioForm(Model model){
        model.addAttribute("tiposUsuario", new TipoUsuario());
        return"tiposUsuarioNuevo";       
    }

    @PostMapping("/tiposUsuario/new/save")
    public String tiposUsuarioGuardar(@ModelAttribute TipoUsuario tipoUsuario){
        tipousuarioRepository.insertarTipoUsuario(tipoUsuario.getTipo(), tipoUsuario.getDescripcion());
        return "redirect:/tiposUsuario";
    
    }
    @GetMapping("/tiposUsuario/{id}/edit")
        public String tiposUsuarioEditarForm(@PathVariable("id") int id, Model model) {
            TipoUsuario usuario = tipousuarioRepository.darTipoUsuario(id);
            if (usuario != null) {
                model.addAttribute("tiposUsuario", usuario);
                return "tiposUsuarioEditar";
            } else {
                return "redirect:/tiposUsuario";
            }
        }

        @PostMapping("/tiposUsuario/{id}/edit/save")
        public String tiposUsuarioEditarGuardar(@PathVariable("id") int id, @ModelAttribute TipoUsuario usuario) {
            tipousuarioRepository.actualizarTipoUsuario(((Integer) id), usuario.getTipo(), usuario.getDescripcion());
                    
            return "redirect:/tiposUsuario";
        }
    

    @GetMapping("/tiposUsuario/{id}/delete")
    public String tiposUsuarioEliminar(@PathVariable("id") int id){
        tipousuarioRepository.eliminarTipoUsuario(id);
        return "redirect:/tiposUsuario";
    }

   




    
    
}
