package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.TipoHabitacion;
import uniandes.edu.co.proyecto.repositorio.TipoHabitacionRepository;

@Controller

public class TipoHabitacionController {

    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @GetMapping("/tiposHab")
    public String tiposHabitacion(Model model) {
        model.addAttribute("tiposHab", tipoHabitacionRepository.darTiposDeHabitacion());
        return "TipoHabitacion";
    }

    @GetMapping("/tiposHab/new")
    public String TipoHabitacionForm(Model model){
        model.addAttribute("tiposHab", new TipoHabitacion());
        return"TipoHabitacionNuevo";       
    }

    @PostMapping("/tiposHabitacion/new/save")
    public String tipoHabitacionGuardar(@ModelAttribute TipoHabitacion TipoHabitacion){
        tipoHabitacionRepository.insertarTipoHabitacion(TipoHabitacion.getTipo(), TipoHabitacion.getDescripcion() );
        return "redirect:/TipoHabitacion";
    
    }

    @GetMapping("/tiposHabitacion/{id}/edit")
    public String tipoHabitacionEditarForm(@PathVariable("id") String id, Model model){
        TipoHabitacion tipoHabitacion= tipoHabitacionRepository.darTipoHabitacion(id);
        if(tipoHabitacion != null){
            model.addAttribute("TipoHabitacion", tipoHabitacion);
            return "TipoHabitacionEditar";
        }
        else{
            return "redirect:/tiposHabitacion";
        }
    }
    @PostMapping("/tiposHabitacion/{id}/edit/save")
     public String tipoHabitacionEditarGuardar(@PathVariable("id") int id, @ModelAttribute TipoHabitacion TipoHabitacion){
        tipoHabitacionRepository.actualizarTipoHabitacion( TipoHabitacion.getTipo(), TipoHabitacion.getDescripcion());
        return "redirect:/tiposHabitacion";
    }

    @GetMapping("/tiposHabitacion/{id}/delete")
    public String tipoHabitacionEliminar(@PathVariable("id") String id){
        tipoHabitacionRepository.eliminarTipoHabitacion(id);
        return "redirect:/tiposHabitacion";
    }

   




    
    
}
