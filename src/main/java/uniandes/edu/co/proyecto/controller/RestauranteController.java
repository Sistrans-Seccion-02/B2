package uniandes.edu.co.proyecto.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Restaurante;
import uniandes.edu.co.proyecto.repositorio.RestauranteRepository;



@Controller
public class RestauranteController {
    @Autowired
    private RestauranteRepository restauranteRepository;

    @GetMapping("/Rests")
    public String Rests(Model model){
        model.addAttribute("Rests", restauranteRepository.darRestaurantes());
        return "Rests";
    }

    @GetMapping("/Rests/new")
    public String RestForm(Model model){
        model.addAttribute("Rest", new Restaurante());
        return "RestNuevo";       
    }

    @PostMapping("/Rests/new/save")
    public String RestGuardar(@ModelAttribute Restaurante Rest){
        restauranteRepository.insertarRestaurante(Rest.getNombre(),Rest.getHorarioApertura(), Rest.getHorarioCierre(), Rest.getCapacidad());
        return "redirect:/Rests";
    
    }

    @GetMapping("/Rests/{nombre}/edit")
    public String RestEditarForm(@PathVariable("id") String id, Model model){
        Restaurante Rest= restauranteRepository.darRestaurante(id);
        if(Rest != null){
            model.addAttribute("Rest", Rest);
            return "RestEditar";
        }
        else{
            return "redirect:/Rests";
        }
    }

    @PostMapping("/Rests/{nombre}/edit/save")
     public String RestEditarGuardar(@PathVariable("id") String id, @ModelAttribute Restaurante Rest){
        restauranteRepository.actualizarRestaurante(id,Rest.getHorarioApertura(), Rest.getHorarioCierre(), Rest.getCapacidad());
        return "redirect:/Rests";
    }

    @GetMapping("/Rests/{nombre}/delete")
    public String RestEliminar(@PathVariable("nombre") String nombre){
        restauranteRepository.eleminarRestaurante(nombre);
        return "redirect:/Rests";
    }
}
