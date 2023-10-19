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
        return "lavanderia";
    }   

    @GetMapping("/lavanderias/new")
    public String lavanderiaForm(Model model){
        model.addAttribute("lavanderia", new Lavanderia());
        return "lavanderiaNuevo";       
    }

    @PostMapping("/lavanderias/new/save")
    public String lavanderiaGuardar(@ModelAttribute Lavanderia lavanderia){
        lavanderiaRepository.insertarLavanderia(lavanderia.getNumPrendas(), lavanderia.getNumZapatos(), lavanderia.getTipoLavado(), lavanderia.getCosto(), lavanderia.getConsumos_idConsumo().getIdConsumo(), lavanderia.getPreciofinal());
        return "redirect:/lavanderias";
    
    }

    @GetMapping("/lavanderias/{idLavanderia}/edit")
    public String lavanderiaEditarForm(@PathVariable("idLavanderia") Integer idLavanderia, Model model){
        Lavanderia lavanderia= lavanderiaRepository.darLavanderia(idLavanderia);
        if(lavanderia != null){
            model.addAttribute("lavanderia", lavanderia);
            return "lavanderiaEditar";
        }
        else{
            return "redirect:/lavanderias";
        }
    }

    @PostMapping("/lavanderias/{idLavanderia}/edit/save")
     public String lavanderiaEditarGuardar(@PathVariable("idLavanderia") Integer idLavanderia, @ModelAttribute Lavanderia lavanderia){
        lavanderiaRepository.actualizarLavanderia(idLavanderia, lavanderia.getNumPrendas(), lavanderia.getNumZapatos(), lavanderia.getTipoLavado(), lavanderia.getCosto(), lavanderia.getConsumos_idConsumo().getIdConsumo(), lavanderia.getPreciofinal());
        return "redirect:/lavanderias";
    }

    @GetMapping("/lavanderias/{idLavanderia}/delete")
    public String lavanderiaEliminar(@PathVariable("idLavanderia") Integer idLavanderia){
        lavanderiaRepository.eleminarLavanderia(idLavanderia);
        return "redirect:/lavanderias";
    }
    
}
