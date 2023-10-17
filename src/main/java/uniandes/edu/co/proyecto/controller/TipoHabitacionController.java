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
        model.addAttribute("tiposhab", new TipoHabitacion()); // Cambiar "tiposHab" a "tiposhab"
        return "TipoHabitacionNuevo";       
    }
    
    @PostMapping("/tiposHab/new/save")
    public String tipoHabitacionGuardar(@ModelAttribute TipoHabitacion tipoHabitacion){
        String tipo=tipoHabitacion.getTipo();
        System.out.println(tipo );
        tipoHabitacionRepository.insertarTipoHabitacion(tipoHabitacion.getTipo(), tipoHabitacion.getDescripcion() );
        return "redirect:/tiposHab";
    
    }

    @GetMapping("/tiposHab/{id}/edit")
    public String tipoHabitacionEditarForm(@PathVariable("id") Integer id, Model model){
        TipoHabitacion tipoHabitacion= tipoHabitacionRepository.darTipoHabitacion(id);
        if(tipoHabitacion != null){
            model.addAttribute("TipoHabitacion", tipoHabitacion);
            return "TipoHabitacionEditar";
        }
        else{
            return "redirect:/tiposHab";
        }
    }
    @PostMapping("/tiposHab/{id}/edit/save")
     public String tipoHabitacionEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute TipoHabitacion TipoHabitacion){
        tipoHabitacionRepository.actualizarTipoHabitacion( ((Integer) id), TipoHabitacion.getTipo(), TipoHabitacion.getDescripcion());
        return "redirect:/tiposHab";
    }

    @GetMapping("/tiposHab/{tipo}/delete")
    public String tipoHabitacionEliminar(@PathVariable("id") Integer id){
        tipoHabitacionRepository.eliminarTipoHabitacion(id);
        return "redirect:/tiposHab";
    }

   




    
    
}
