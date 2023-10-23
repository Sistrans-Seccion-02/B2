package uniandes.edu.co.proyecto.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Utensilio;
import uniandes.edu.co.proyecto.repositorio.UtensilioRepository;

@Controller
public class UtensilioController{
    @Autowired
    private UtensilioRepository utensilioRepository;

    @GetMapping("/utensilios")
    public String utensilios(Model model){
        model.addAttribute("utensilios", utensilioRepository.darUtensilios());
        return "Utensilios";
    }

    @GetMapping("/utensilios/new")
    public String utensilioForm(Model model){
        model.addAttribute("utensilio", new Utensilio());
        return "UtensilioNuevo";       
    }
    
    @PostMapping("/utensilios/new/save")
    public String utensilioGuardar(@ModelAttribute Utensilio utensilio){
        utensilioRepository.insertarUtensilio(utensilio.getNombre());
        return "redirect:/utensilios";
    
    }

    @GetMapping("/utensilios/{id}/edit")
    public String utensilioEditarForm(@PathVariable("id") Integer id, Model model){
        Utensilio utensilio= utensilioRepository.darUtensilio(id);
        if(utensilio != null){
            model.addAttribute("utensilio", utensilio);
            return "UtensilioEditar";
        }
        else{
            return "redirect:/utensilios";
        }
    }

    @PostMapping("/utensilios/{id}/edit/save")
     public String utensilioEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Utensilio utensilio){
        utensilioRepository.actualizarUtensilio(id,utensilio.getNombre());
        return "redirect:/Utensilios";
    }
    
    @GetMapping("/utensilios/{id}/delete")
    public String utensilioEliminar(@PathVariable("id") Integer id){
        utensilioRepository.eliminarUtensilio(id);
        return "redirect:/Utensilios";
    }
}
