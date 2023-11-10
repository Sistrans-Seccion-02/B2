package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.Modelo.Habitacion;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;
import uniandes.edu.co.proyecto.repositorio.TipoHabitacionRepository;

@Controller

public class HabitacionController {

    @Autowired
    private HabitacionRepository habitacionRepository;
    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;
    

    @GetMapping("/habitaciones")
    public String habitaciones(Model model) {
        model.addAttribute("habitaciones", habitacionRepository.darHabitaciones());
        return "Habitacion";
    }
    @GetMapping("/habitaciones/req1")
    public String req1(Model model){
        model.addAttribute("habitaciones", habitacionRepository.req1());
        return"Habitacionreq1";       
    }

    @GetMapping("/habitaciones/req3")
    public String req3(Model model) {
        model.addAttribute("habitaciones", habitacionRepository.req3());
        return "Habitacionreq3";
    }
    @GetMapping("/habitaciones/req11")
    public String req11(Model model) {
        model.addAttribute("habitaciones", habitacionRepository.req11());
        return "Habitacionreq11";
    }

    @GetMapping("/habitaciones/new")
    public String habitacionForm(Model model){
        model.addAttribute("habitaciones", new Habitacion());
        model.addAttribute("tipos", tipoHabitacionRepository.darTiposDeHabitacion());
        return"HabitacionNuevo";       
    }

    @PostMapping("/habitaciones/new/save")
    public String habitacionGuardar(@ModelAttribute Habitacion habitacion){
        habitacionRepository.insertarHabitacion(habitacion.getCapacidad(), habitacion.getTipoId().getId());
        return "redirect:/habitaciones";
    
    }

    @GetMapping("/habitaciones/{id}/edit")
    public String habitacionEditarForm(@PathVariable("id") int id, Model model){
        Habitacion habitacion= habitacionRepository.darHabitacion(id);
        if(habitacion != null){
            model.addAttribute("habitaciones", habitacion);
            model.addAttribute("tipos", tipoHabitacionRepository.darTiposDeHabitacion());
            return "habitacionEditar";
        }
        else{
            return "redirect:/habitaciones";
        }
    }
    @PostMapping("/habitaciones/{id}/edit/save")
     public String habitacionEditarGuardar(@PathVariable("id") int id, @ModelAttribute Habitacion habitacion){
        habitacionRepository.actualizarHabitacion(id, habitacion.getCapacidad(),habitacion.getTipoId().getId());
        return "redirect:/habitaciones";
    }

    @GetMapping("/habitaciones/{id}/delete")
    public String habitacionEliminar(@PathVariable("id") int id){
        habitacionRepository.eliminarHabitacion(id);
        return "redirect:/habitaciones";
    }

   




    
    
}
