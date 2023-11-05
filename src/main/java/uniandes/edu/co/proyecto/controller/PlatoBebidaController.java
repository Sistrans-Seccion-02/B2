package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.PlatoBebida;

import uniandes.edu.co.proyecto.repositorio.PlatoBebidaRepository;
import uniandes.edu.co.proyecto.repositorio.ConsumoRepository;
import org.springframework.stereotype.Controller;


@Controller
public class PlatoBebidaController {
    @Autowired
    private PlatoBebidaRepository platoBebidaRepository;
    @Autowired
    private ConsumoRepository consumoRepository;

    @GetMapping("/platosbebidas")
    public String platosbebidas(Model model) {
        model.addAttribute("platosbebidas", platoBebidaRepository.darPlatosBebidas());
        return "Platosbebidas";
    }
    
    @GetMapping("/platosbebidas/new")
    public String platobebidaForm(Model model) {
        model.addAttribute("platobebida", new PlatoBebida());
        model.addAttribute("consumos", consumoRepository.darConsumos());
        return "PlatoBebidaNuevo";
    }

    @PostMapping("/platosbebidas/new/save")
    public String platobebidaGuardar(@ModelAttribute PlatoBebida platoBebida) {
        platoBebidaRepository.insertarPlatoBebida(platoBebida.getNombre(), platoBebida.getPrecio(), platoBebida.getConsumoId().getId());
        return "redirect:/platosbebidas";
    }

    @GetMapping("/platosbebidas/{id}/edit") 
    public String platobebidaEditarForm(@PathVariable("id") Integer id, Model model) {
        PlatoBebida platoBebida = platoBebidaRepository.darPlatoBebida(id);
        if (platoBebida != null) {
            model.addAttribute("platobebida", platoBebida);
            return "platobebidaEditar";
        } else {
            return "redirect:/platosbebidas";
        }
    }

    @PostMapping("/platosbebidas/{id}/edit/save")
    public String platobebidaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute PlatoBebida platoBebida) {
        platoBebidaRepository.actualizarPlatoBebida(id, platoBebida.getNombre(), platoBebida.getPrecio(), platoBebida.getConsumoId().getId());
        return "redirect:/platosbebidas";
    }

    @GetMapping("/platosbebidas/{id}/delete")
    public String platobebidaEliminar(@PathVariable("id") Integer id) {
        platoBebidaRepository.eliminarPlatoBebida(id);
        return "redirect:/platosbebidas";
    }
}





