package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.Modelo.Habitacion;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;

/*@Controller*/
@RestController

public class HabitacionController {

    @Autowired
    private HabitacionRepository habitacionRepository;

    @GetMapping("/habitaciones")
    public String habitaciones(Model model) {
        model.addAttribute("habitaciones", habitacionRepository.darHabitaciones());
        /*return "habitaciones";*/ 
        return model.toString();
    }

    @GetMapping("/habitaciones/new")
    public String habitacionForm(Model model){
        model.addAttribute("habitacion", new Habitacion());
        return"habitacionNuevo";       
    }

    @PostMapping("/habitaciones/new/save")
    public String habitacionGuardar(@ModelAttribute Habitacion habitacion){
        habitacionRepository.insertarHabitacion(habitacion.getCapacidad());
        return "redirect:/habitaciones";
    
    }

    @GetMapping("/habitaciones/{id/edit}")
    public String habitacionEditarForm(@PathVariable("id") int id, Model model){
        Habitacion habitacion= habitacionRepository.darHabitacion(id);
        if(habitacion != null){
            model.addAttribute("habitacion", habitacion);
            return "habitacionEditar";
        }
        else{
            return "redirect:/habitaciones";
        }
    }
    @PostMapping("/habitaciones/{id}/edit/save")
     public String habitacionEditarGuardar(@PathVariable("id") int id, @ModelAttribute Habitacion habitacion){
        habitacionRepository.actualizarHabitacion(id, habitacion.getCapacidad());
        return "redirect:/habitaciones";
    }

    @GetMapping("/habitaciones/{id}/delete")
    public String habitacionEliminar(@PathVariable("id") int id){
        habitacionRepository.eliminarHabitacion(id);
        return "redirect:/habitaciones";
    }

   




    
    
}