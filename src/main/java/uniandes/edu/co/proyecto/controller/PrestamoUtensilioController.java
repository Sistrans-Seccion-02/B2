package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.PrestamoUtensilio;
import uniandes.edu.co.proyecto.repositorio.PrestamoUtensilioRepository;

@Controller
public class PrestamoUtensilioController {
    @Autowired
    private PrestamoUtensilioRepository prestamoUtensilioRepository;

    @GetMapping("/PrestamosUt")
    public String PrestamosUt(Model model){
        model.addAttribute("PrestamosUt", prestamoUtensilioRepository.darPrestamoUtensilios());
        return "PrestamosUt";
    }

    @GetMapping("/PrestamosUt/new")
    public String PrestamoUtensilioForm(Model model){
        model.addAttribute("PrestamoUtensilio", new PrestamoUtensilio());
        return "PrestamoUtensilioNuevo";       
    }

    @PostMapping("/PrestamosUt/new/save")
    public String PrestamoUtensilioGuardar(@ModelAttribute PrestamoUtensilio PrestamoUtensilio){
        prestamoUtensilioRepository.insertarPrestamoUtensilio(PrestamoUtensilio.getCantidad(),PrestamoUtensilio.getPrecio(), PrestamoUtensilio.getTipo(), PrestamoUtensilio.getEstado(), PrestamoUtensilio.getComsumos_idConsumo().getIdConsumo());
        return "redirect:/PrestamosUt";
    
    }

    @GetMapping("/PrestamosUt/{idutensilio}/edit")
    public String PrestamoUtensilioEditarForm(@PathVariable("idutensilio") Integer idutensilio, Model model){
        PrestamoUtensilio PrestamoUtensilio= prestamoUtensilioRepository.darPrestamoUtensilio(idutensilio);
        if(PrestamoUtensilio != null){
            model.addAttribute("PrestamoUtensilio", PrestamoUtensilio);
            return "PrestamoUtensilioEditar";
        }
        else{
            return "redirect:/PrestamosUt";
        }
    }

    @PostMapping("/PrestamosUt/{idutensilio}/edit/save")
     public String PrestamoUtensilioEditarGuardar(@PathVariable("idutensilio") Integer idutensilio, @ModelAttribute PrestamoUtensilio PrestamoUtensilio){
        prestamoUtensilioRepository.actualizarPrestamoUtensilio(idutensilio,PrestamoUtensilio.getCantidad(),PrestamoUtensilio.getPrecio(), PrestamoUtensilio.getTipo(), PrestamoUtensilio.getEstado(), PrestamoUtensilio.getComsumos_idConsumo().getIdConsumo());
        return "redirect:/PrestamosUt";
    }

    @GetMapping("/PrestamosUt/{idutensilio}/delete")
    public String PrestamoUtensilioEliminar(@PathVariable("idutensilio") Integer idutensilio){
        prestamoUtensilioRepository.eleminarPrestamoUtensilio(idutensilio);
        return "redirect:/PrestamosUt";
    }
    

}
