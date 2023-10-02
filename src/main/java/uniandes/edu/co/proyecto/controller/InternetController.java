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
import uniandes.edu.co.proyecto.Modelo.Internet;
import uniandes.edu.co.proyecto.repositorio.InternetRepository;

/*@Controller*/
@RestController
public class InternetController {
    @Autowired
    private InternetRepository internetRepository;

    @GetMapping("/internets")
    public String internets(Model model) {
        model.addAttribute("internets", internetRepository.darInternets());
        return model.toString();
    }
    
    @GetMapping("/internets/new")
    public String internetForm(Model model) {
        model.addAttribute("internet", new Internet());
        return "internetNuevo";
    }

    @PostMapping("/internets/new/save")
    public String internetGuardar(@ModelAttribute Internet internet) {
        internetRepository.insertarInternet(internet.getCapacidad(), internet.getPrecio(), internet.getComsumos_idConsumo().getIdConsumo());
        return "redirect:/internets";
    }

    @GetMapping("/internets/{capacidad}/edit") 
    public String internetEditarForm(@PathVariable("capacidad") int capacidad, Model model) {
        Internet internet = internetRepository.darInternet(capacidad);
        if (internet != null) {
            model.addAttribute("capacidad", capacidad);
            return "internetEditar";
        } else {
            return "redirect:/internets";
        }
    }

    @PostMapping("/internets/{capacidad}/edit/save")
    public String internetEditarGuardar(@PathVariable("capacidad") int capacidad, @ModelAttribute Internet internet) {
        internetRepository.actualizarInternet(capacidad, internet.getPrecio(), internet.getComsumos_idConsumo().getIdConsumo());
        return "redirect:/internets";
    }

    @GetMapping("/internets/{capacidad}/delete")
    public String internetEliminar(@PathVariable("capacidad") int capacidad) {
        internetRepository.eliminarInternet(capacidad);
        return "redirect:/internets";
    }
}
