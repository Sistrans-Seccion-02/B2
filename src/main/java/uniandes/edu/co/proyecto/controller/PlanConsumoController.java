package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.PlanConsumo;
import uniandes.edu.co.proyecto.repositorio.PlanConsumoRepository;

@Controller

public class PlanConsumoController {

    @Autowired
    private PlanConsumoRepository planConsumoRepository;

    @GetMapping("/planesconsumo")
    public String planesConsumo(Model model) {
        model.addAttribute("planesconsumo", planConsumoRepository.darplanesConsumo());
        return "PlanConsumo";
    }

    @GetMapping("/planesconsumo/new")
    public String planConsumoForm(Model model){
        model.addAttribute("planesconsumo", new PlanConsumo());
        return"PlanConsumoNuevo";       
    }

    @PostMapping("/planesconsumo/new/save")
    public String planConsumoGuardar(@ModelAttribute PlanConsumo planConsumo){
        planConsumoRepository.insertarPlanConsumo(planConsumo.getTipo(), planConsumo.getDtonoche(), planConsumo.getDescripcion(), planConsumo.getDescuentobar(), planConsumo.getDescuentorest(), planConsumo.getDescuentoSpa(), planConsumo.getLimitebebidas(), planConsumo.getDescuentolavado());
        System.out.println(planConsumo.getId());
        return "redirect:/planesconsumo";
    
    }

    @GetMapping("/planesconsumo/{id}/edit")
    public String PlanConsumoEditarForm(@PathVariable("id") Integer id, Model model){
        PlanConsumo planConsumo= planConsumoRepository.darPlanConsumo(id);
        if(planConsumo != null){
            model.addAttribute("planesconsumo", planConsumo);
            return "PlanConsumoEditar";
        }
        else{
            return "redirect:/planesconsumo";
        }
    }
    @PostMapping("/planesconsumo/{id}/edit/save")
     public String PlanConsumoEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute PlanConsumo planConsumo){
        planConsumoRepository.actualizarPlanConsumo(planConsumo.getId(),planConsumo.getTipo(), planConsumo.getDtonoche(), planConsumo.getDescripcion(), planConsumo.getDescuentobar(), planConsumo.getDescuentorest(), planConsumo.getDescuentoSpa(), planConsumo.getLimitebebidas(), planConsumo.getDescuentolavado());
        return "redirect:/planesconsumo";
    }

    @GetMapping("/planesconsumo/{id}/delete")
    public String PlanConsumoEliminar(@PathVariable("id") Integer  id){
        planConsumoRepository.eliminarPlanConsumo(id);
        return "redirect:/planesconsumo";
    }

   




    
    
}
