package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.ConsumoDeR;

import uniandes.edu.co.proyecto.repositorio.ConsumoDeRRepository;
import uniandes.edu.co.proyecto.repositorio.ConsumoRepository;
import uniandes.edu.co.proyecto.repositorio.ReservaRepository;

@Controller
public class ConsumoDeRController {
/*
    @Autowired
    private ConsumoDeRRepository consumoDeRRepository;
    @Autowired
    private ConsumoRepository consumoRepository;
    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping("/consumosDeR")
    public String consumosDeR(Model model) {
        model.addAttribute("consumosDeR", consumoDeRRepository.darConsumosDeR());
        return "consumosDeR";
    }
    
    @GetMapping("/consumosDeR/new")
    public String consumoDeRForm(Model model) {
        model.addAttribute("consumoDeR", new ConsumoDeR());
        model.addAttribute("reservas", reservaRepository.darReservas());
        model.addAttribute("usuarios", consumoRepository.darConsumos());
        return "consumosDeRNuevo";
    }

    @PostMapping("/consumosDeR/new/save")
    public String consumoDeRGuardar(@ModelAttribute ConsumoDeR consumoDeR) {
        consumoDeRRepository.insertarConsumoDeR(consumoDeR.getReservaId().getId(), consumoDeR.getConsumoId().getId());
        return "redirect:/consumosDeR";
        
    }

    @GetMapping("/consumosDeR/{id}/edit")
    public String consumoDeREditarForm(@PathVariable("id") Integer id, Model model) {
        ConsumoDeR consumoDeR = consumoDeRRepository.darConsumoDeR(id);
        if (consumoDeR != null) {
            model.addAttribute("consumosDeR", consumoDeR);
            return "consumosDeREditar";
        } else {
            return "redirect:/consumosDeR";
        }
    }

    @PostMapping("/consumosDeR/{id}/edit/save")
    public String consumoDeREditarGuardar(@PathVariable("id") Integer id, @ModelAttribute ConsumoDeR consumoDeR) {
        consumoDeRRepository.actualizarConsumoDeR(id, consumoDeR.getReservaId().getId(), consumoDeR.getConsumoId().getId());      
        return "redirect:/consumosDeR";
    }

    @GetMapping("/consumosDeR/{id}/delete")
    public String consumoDeREliminar(@PathVariable("id") Integer id) {
        consumoDeRRepository.eliminarConsumoDeR(id);
        return "redirect:/consumosDeR";
    }
     */
}




