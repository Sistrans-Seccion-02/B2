package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.Modelo.PlanConsumo;
import uniandes.edu.co.proyecto.repositorio.PlanConsumoRepository;

@Controller

public class PlanConsumoController {

    @Autowired
    private PlanConsumoRepository planConsumoRepository;

    @GetMapping("/planesConsumo")
    public String planesConsumo(Model model) {
        model.addAttribute("planesConsumo", planConsumoRepository.darplanesConsumo());
        return "planesConsumo";
    }

    @GetMapping("/planesConsumo/new")
    public String planConsumoForm(Model model){
        model.addAttribute("PlanConsumo", new PlanConsumo());
        return"PlanConsumoNuevo";       
    }

    @PostMapping("/planesConsumo/new/save")
    public String planConsumoGuardar(@ModelAttribute PlanConsumo planConsumo){
        planConsumoRepository.insertarPlanConsumo(planConsumo.getTipo(), planConsumo.getDescripcion(),planConsumo.getDescuento(),  planConsumo.isDescuentoBar(), planConsumo.isDescuentoRestaurante(), planConsumo.isDescuentoSpa(), planConsumo.getLimiteBebidas(), planConsumo.isDescuentoLavado() );
        return "redirect:/planesConsumo";
    
    }

    @GetMapping("/planesConsumo/{id/edit}")
    public String PlanConsumoEditarForm(@PathVariable("id") String id, Model model){
        PlanConsumo planConsumo= planConsumoRepository.darPlanConsumo(id);
        if(planConsumo != null){
            model.addAttribute("PlanConsumo", planConsumo);
            return "PlanConsumoEditar";
        }
        else{
            return "redirect:/planesConsumo";
        }
    }
    @PostMapping("/planesConsumo/{id}/edit/save")
     public String PlanConsumoEditarGuardar(@PathVariable("id") String id, @ModelAttribute PlanConsumo planConsumo){
        planConsumoRepository.actualizarPlanConsumo( planConsumo.getTipo(), planConsumo.getDescripcion(),planConsumo.getDescuento(),  planConsumo.isDescuentoBar(), planConsumo.isDescuentoRestaurante(), planConsumo.isDescuentoSpa(), planConsumo.getLimiteBebidas(), planConsumo.isDescuentoLavado());
        return "redirect:/planesConsumo";
    }

    @GetMapping("/planesConsumo/{id}/delete")
    public String PlanConsumoEliminar(@PathVariable("id") String  id){
        planConsumoRepository.eliminarPlanConsumo(id);
        return "redirect:/planesConsumo";
    }

   




    
    
}
