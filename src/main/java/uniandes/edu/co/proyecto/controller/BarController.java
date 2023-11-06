package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.Modelo.Bar;
import uniandes.edu.co.proyecto.repositorio.BarRepository;


@Controller
public class BarController {
    @Autowired
    private BarRepository barRepository;

    @GetMapping("/bares")
    public String bares(Model model) {
        model.addAttribute("bares", barRepository.darBares());
        return "Bares";
    }
    
    @GetMapping("/bares/new")
    public String barForm(Model model) {
        model.addAttribute("bar", new Bar());
        return "BarNuevo";
    }

    @PostMapping("/bares/new/save")
    public String barGuardar(@ModelAttribute Bar bar) {
        barRepository.insertarBar(bar.getNombre(), bar.getHorarioApertura(), bar.getHorarioCierre(), bar.getCapacidad());
        return "redirect:/bares";
    }

    @GetMapping("/bares/{id}/edit") 
    public String barEditarForm(@PathVariable("id") Integer id, Model model) {
        Bar bar = barRepository.darBar(id);
        if (bar != null) {
            model.addAttribute("bar", bar);
            return "BarEditar";
        } else {
            return "redirect:/bares";
        }
    }

    @PostMapping("/bares/{id}/edit/save")
    public String barEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Bar bar) {
        barRepository.actualizarBar(id, bar.getNombre(),bar.getHorarioApertura(), bar.getHorarioCierre(), bar.getCapacidad());
        return "redirect:/bares";
    }

    @GetMapping("/bares/{id}/delete")
    public String barEliminar(@PathVariable("id") Integer id) {
        barRepository.eliminarBar(id);
        return "redirect:/bares";
    }
}