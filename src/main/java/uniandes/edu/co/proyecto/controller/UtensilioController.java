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
import uniandes.edu.co.proyecto.Modelo.Utensilio;
import uniandes.edu.co.proyecto.repositorio.UtensilioRepository;

/*@Controller*/
@RestController
public class UtensilioController {
    @Autowired
    private UtensilioRepository utensilioRepository;

    @GetMapping("/utensilios")
    public String utensilios(Model model) {
        model.addAttribute("utensilios", utensilioRepository.darUtensilios());
        return model.toString();
    }
    
    @GetMapping("/utensilios/new")
    public String utensilioForm(Model model) {
        model.addAttribute("utensilio", new Utensilio());
        return "utensilioNuevo";
    }

    @PostMapping("/utensilios/new/save")
    public String utensilioGuardar(@ModelAttribute Utensilio utensilio) {
        utensilioRepository.insertarUtensilio(utensilio.getNombre(), utensilio.getPrestamosUt_idUtensilio().getIdutensilio());
        return "redirect:/utensilios";
    }

    @GetMapping("/utensilios/{id}/edit") 
    public String utensilioEditarForm(@PathVariable("id") int id, Model model) {
        Utensilio utensilio = utensilioRepository.darUtensilio(id);
        if (utensilio != null) {
            model.addAttribute("id", id);
            return "utensilioEditar";
        } else {
            return "redirect:/utensilios";
        }
    }

    @PostMapping("/utensilios/{id}/edit/save")
    public String utensilioEditarGuardar(@PathVariable("id") int id, @ModelAttribute Utensilio utensilio) {
        utensilioRepository.actualizarUtensilio(id, utensilio.getNombre(), utensilio.getPrestamosUt_idUtensilio().getIdutensilio());
        return "redirect:/utensilios";
    }

    @GetMapping("/utensilios/{id}/delete")
    public String utensilioEliminar(@PathVariable("id") int id) {
        utensilioRepository.eliminarUtensilio(id);
        return "redirect:/utensilios";
    }
}



