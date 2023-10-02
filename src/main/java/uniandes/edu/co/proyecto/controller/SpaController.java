package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import oracle.jdbc.proxy.annotation.Post;
import uniandes.edu.co.proyecto.Modelo.Spa;
import uniandes.edu.co.proyecto.repositorio.SpaRepository;

/*@Controller*/
@RestController
public class SpaController {
    @Autowired
    private SpaRepository spaRepository;

    @GetMapping("/spas")
    public String spas(Model model) {
        model.addAttribute("spas", spaRepository.darSpas());
        return model.toString();
    }
    
    @GetMapping("/spas/new")
    public String spaForm(Model model) {
        model.addAttribute("spa", new Spa());
        return "spaNuevo";
    }

    @PostMapping("/spas/new/save")
    public String spaGuardar(@ModelAttribute Spa spa) {
        spaRepository.insertarSpa(spa.getNombre(), spa.getHorarioApertura(), spa.getHorarioCierre(), spa.getCapacidad(), spa.getPrecio());
        return "redirect:/spas";
    }

    @GetMapping("/spas/{nombre}/edit") 
    public String spaEditarForm(@PathVariable("nombre") String nombre, Model model) {
        Spa spa = spaRepository.darSpa(nombre);
        if (spa != null) {
            model.addAttribute("nombre", nombre);
            return "spaEditar";
        } else {
            return "redirect:/spas";
        }
    }

    @PostMapping("/spas/{nombre}/edit/save")
    public String spaEditarGuardar(@PathVariable("nombre") String nombre, @ModelAttribute Spa spa) {
        spaRepository.actualizarSpa(nombre, spa.getHorarioApertura(), spa.getHorarioCierre(), spa.getCapacidad(), spa.getPrecio());
        return "redirect:/spas";
    }

    @GetMapping("/spas/{nombre}/delete")
    public String spaEliminar(@PathVariable("nombre") String nombre) {
        spaRepository.eliminarSpa(nombre);
        return "redirect:/spas";
    }
}


