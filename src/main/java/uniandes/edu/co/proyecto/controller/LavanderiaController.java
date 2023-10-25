package uniandes.edu.co.proyecto.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Lavanderia;
import uniandes.edu.co.proyecto.repositorio.LavanderiaRepository;

@Controller
public class LavanderiaController {
    @Autowired
    private LavanderiaRepository lavanderiaRepository;

    @GetMapping("/lavanderias")
    public String lavanderias(Model model){
        model.addAttribute("lavanderias", lavanderiaRepository.darLavanderias());
        return "Lavanderias";
    }   

    @GetMapping("/lavanderias/new")
    public String lavanderiaForm(Model model){
        model.addAttribute("lavanderia", new Lavanderia());
        return "LavanderiaNuevo";       
    }

    @PostMapping("/lavanderias/new/save")
    public String lavanderiaGuardar(@ModelAttribute Lavanderia lavanderia){
        lavanderiaRepository.insertarLavanderia(lavanderia.getNumprendas(), lavanderia.getNumzapatos(), lavanderia.getTipolavado(), lavanderia.getCosto(), lavanderia.getConsumos_idConsumo().getIdConsumo(), lavanderia.getPreciofinal());
        return "redirect:/lavanderias";
    
    }

    @GetMapping("/lavanderias/{idlavanderia}/edit")
    public String lavanderiaEditarForm(@PathVariable("idlavanderia") Integer idlavanderia, Model model){
        Lavanderia lavanderia= lavanderiaRepository.darLavanderia(idlavanderia);
        if(lavanderia != null){
            model.addAttribute("lavanderia", lavanderia);
            return "LavanderiaEditar";
        }
        else{
            return "redirect:/lavanderias";
        }
    }

    @PostMapping("/lavanderias/{idlavanderia}/edit/save")
     public String lavanderiaEditarGuardar(@PathVariable("idlavanderia") Integer idlavanderia, @ModelAttribute Lavanderia lavanderia){
        lavanderiaRepository.actualizarLavanderia(idlavanderia, lavanderia.getNumprendas(), lavanderia.getNumzapatos(), lavanderia.getTipolavado(), lavanderia.getCosto(), lavanderia.getConsumos_idConsumo().getIdConsumo(), lavanderia.getPreciofinal());
        return "redirect:/lavanderias";
    }

    @GetMapping("/lavanderias/{idlavanderia}/delete")
    public String lavanderiaEliminar(@PathVariable("idlavanderia") Integer idlavanderia){
        lavanderiaRepository.eleminarLavanderia(idlavanderia);
        return "redirect:/lavanderias";
    }
    
}
