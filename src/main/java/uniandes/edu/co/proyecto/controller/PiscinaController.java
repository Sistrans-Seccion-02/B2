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
import uniandes.edu.co.proyecto.Modelo.Piscina;
import uniandes.edu.co.proyecto.repositorio.PiscinaRepository;

/*@Controller*/
@RestController
public class PiscinaController {
    @Autowired
    private PiscinaRepository piscinaRepository;

    @GetMapping("/piscinas")
    public String piscinas(Model model) {
        model.addAttribute("piscinas", piscinaRepository.darPiscinas());
        return model.toString();
    }
    
    @GetMapping("/piscinas/new")
    public String piscinaForm(Model model) {
        model.addAttribute("piscina", new Piscina());
        return "piscinaNuevo";
    }

    @PostMapping("/piscinas/new/save")
    public String piscinaGuardar(@ModelAttribute Piscina piscina) {
        piscinaRepository.insertarPiscina(piscina.getNombre(), piscina.getHorarioApertura(), piscina.getHorarioCierre(), piscina.getProfundidad());
        return "redirect:/piscinas";
    }

    @GetMapping("/piscinas/{nombre}/edit") 
    public String piscinaEditarForm(@PathVariable("nombre") String nombre, Model model) {
        Piscina piscina = piscinaRepository.darPiscina(nombre);
        if (piscina != null) {
            model.addAttribute("nombre", nombre);
            return "piscinaEditar";
        } else {
            return "redirect:/piscinas";
        }
    }

    @PostMapping("/piscinas/{nombre}/edit/save")
    public String piscinaEditarGuardar(@PathVariable("nombre") String nombre, @ModelAttribute Piscina piscina) {
        piscinaRepository.actualizarPiscina(nombre, piscina.getHorarioApertura(), piscina.getHorarioCierre(), piscina.getProfundidad());
        return "redirect:/piscinas";
    }

    @GetMapping("/piscinas/{nombre}/delete")
    public String piscinaEliminar(@PathVariable("nombre") String nombre) {
        piscinaRepository.eliminarPiscina(nombre);
        return "redirect:/piscinas";
    }
}


