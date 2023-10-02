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
import uniandes.edu.co.proyecto.Modelo.Gimnasio;
import uniandes.edu.co.proyecto.repositorio.GimnasioRepository;

/*@Controller*/
@RestController
public class GimnasioController {
    @Autowired
    private GimnasioRepository gimnasioRepository;

    @GetMapping("/gimnasios")
    public String gimnasios(Model model) {
        model.addAttribute("gimnasios", gimnasioRepository.darGimnasios());
        return model.toString();
    }
    
    @GetMapping("/gimnasios/new")
    public String gimnasioForm(Model model) {
        model.addAttribute("gimnasio", new Gimnasio());
        return "gimnasioNuevo";
    }

    @PostMapping("/gimnasios/new/save")
    public String gimnasioGuardar(@ModelAttribute Gimnasio gimnasio) {
        gimnasioRepository.insertarGimnasio(gimnasio.getNombre(), gimnasio.getHorarioApertura(), gimnasio.getHorarioCierre(), gimnasio.getCapacidad());
        return "redirect:/gimnasios";
    }

    @GetMapping("/gimnasios/{nombre}/edit") 
    public String gimnasioEditarForm(@PathVariable("nombre") String nombre, Model model) {
        Gimnasio gimnasio = gimnasioRepository.darGimnasio(nombre);
        if (gimnasio != null) {
            model.addAttribute("nombre", nombre);
            return "gimnasioEditar";
        } else {
            return "redirect:/gimnasios";
        }
    }

    @PostMapping("/gimnasios/{nombre}/edit/save")
    public String gimnasioEditarGuardar(@PathVariable("nombre") String nombre, @ModelAttribute Gimnasio gimnasio) {
        gimnasioRepository.actualizarGimnasio(nombre, gimnasio.getHorarioApertura(), gimnasio.getHorarioCierre(), gimnasio.getCapacidad());
        return "redirect:/gimnasios";
    }

    @GetMapping("/gimnasios/{nombre}/delete")
    public String gimnasioEliminar(@PathVariable("nombre") String nombre) {
        gimnasioRepository.eliminarGimnasio(nombre);
        return "redirect:/gimnasios";
    }
}

