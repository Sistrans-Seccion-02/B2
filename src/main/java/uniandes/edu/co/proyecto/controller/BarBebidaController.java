package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.BarBebida;
import uniandes.edu.co.proyecto.repositorio.BarBebidaRepository;


@Controller
public class BarBebidaController {
    @Autowired
    private BarBebidaRepository barBebidaRepository;

    @GetMapping("/barBebidas")
    public String barBebidas(Model model){
        model.addAttribute("barBebidas", barBebidaRepository.darBarBebidas());
        return "barBebidas";
    }

    @GetMapping("/barBebidas/new")
    public String barBebidaForm(Model model){
        model.addAttribute("barBebida", new BarBebida());
        return "barBebidaNuevo";       
    }

    @GetMapping("/barBebidas/new/save")
    public String barBebidaGuardar(@ModelAttribute BarBebida barBebida){
        barBebidaRepository.insertarBarBebida( barBebida.getPk().getNombreBar().getNombre(), barBebida.getPk().getNombreBebida().getNombre());
        return "redirect:/barBebidas";
    
    }

    @GetMapping("/barBebidas/{nombreBar}/{nombreBebida}/edit")
    public String barBebidaEditarForm(@PathVariable("nombreBar") String nombreBar, @PathVariable("nombreBebida") String nombreBebida, Model model){
        BarBebida barBebida= barBebidaRepository.darBarBebida(nombreBar, nombreBebida);
        if(barBebida != null){
            model.addAttribute("barBebida", barBebida);
            return "barBebidaEditar";
        }
        else{
            return "redirect:/barBebidas";
        }
    }

    @PostMapping("/barBebidas/{nombreBar}/{nombreBebida}/edit/save")
     public String barBebidaEditarGuardar(@PathVariable("nombreBar") String nombreBar, @PathVariable("nombreBebida") String nombreBebida, @ModelAttribute BarBebida barBebida){
        barBebidaRepository.actualizarBarBebida(nombreBar, nombreBebida);
        return "redirect:/barBebidas";
    }

    @GetMapping("/barBebidas/{nombreBar}/{nombreBebida}/delete")
    public String barBebidaEliminar(@PathVariable("nombreBar") String nombreBar, @PathVariable("nombreBebida") String nombreBebida){
        barBebidaRepository.eleminarBarBebida(nombreBar, nombreBebida);
        return "redirect:/barBebidas";
    }
    

}
