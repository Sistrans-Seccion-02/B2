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
    public String bares(Model model){
        model.addAttribute("bares", barRepository.darBares());
        return "Bar";
    }

    @GetMapping("/bares/new")
    public String barForm(Model model){
        model.addAttribute("bar", new Bar());
        return "barNuevo";       
    }
    
    @PostMapping("/bares/new/save")
    public String barGuardar(@ModelAttribute Bar bar){
        barRepository.insertarBar(bar.getNombre(),bar.getHorarioApertura(), bar.getHorarioCierre(), bar.getCapacidad());
        return "redirect:/bares";
    
    }

    @GetMapping("/bares/{nombre}/edit")
    public String barEditarForm(@PathVariable("id") String id, Model model){
        Bar bar= barRepository.darBar(id);
        if(bar != null){
            model.addAttribute("bar", bar);
            return "barEditar";
        }
        else{
            return "redirect:/bares";
        }
    }

    @PostMapping("/bares/{nombre}/edit/save")
     public String barEditarGuardar(@PathVariable("id") String id, @ModelAttribute Bar bar){
        barRepository.actualizarBar(id,bar.getHorarioApertura(), bar.getHorarioCierre(), bar.getCapacidad());
        return "redirect:/bares";
    }

    @GetMapping("/bares/{nombre}/delete")
    public String barEliminar(@PathVariable("nombre") String nombre){
        barRepository.eleminarBar(nombre);
        return "redirect:/bares";
    }
    
}
