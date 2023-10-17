package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Consumo;
import uniandes.edu.co.proyecto.Modelo.Internet;
import uniandes.edu.co.proyecto.Modelo.internetPK;
import uniandes.edu.co.proyecto.repositorio.ConsumoRepository;
import uniandes.edu.co.proyecto.repositorio.InternetRepository;

@Controller
public class InternetController {
    @Autowired
    private InternetRepository internetRepository;
    @Autowired
    private ConsumoRepository consumoRepository;

    @GetMapping("/internets")
    public String internets(Model model) {
        model.addAttribute("internets", internetRepository.darInternets());
        return "Internet";
    }
    
    @GetMapping("/internets/new")
    public String internetForm(Model model) {
        model.addAttribute("internets", new Internet());
        return "internetNuevo";
    }

    @PostMapping("/internets/new/save")
    public String internetGuardar(@ModelAttribute ("capacidad") Integer capacidad,@ModelAttribute ("precio") double precio,@ModelAttribute ("consumos_idconsumo") Integer consumos_idconsumo) {
        Consumo consumo =consumoRepository.darConsumo(consumos_idconsumo);
        internetPK pk= new internetPK(consumo, capacidad);
        Internet internet = new Internet();
        internet.setPk(pk);
        internetRepository.insertarInternet(internet.getPk().getCapacidad(), internet.getPrecio(), internet.getPk().getConsumos_idconsumo().getIdConsumo());
        return "redirect:/internets";
    }
/* 
    @GetMapping("/internets/{capacidad}/edit") 
    public String internetEditarForm(@PathVariable("capacidad") int capacidad, Model model) {
        Internet internet = internetRepository.darInternet(capacidad);
        if (internet != null) {
            model.addAttribute("capacidad", capacidad);
            return "internetEditar";
        } else {
            return "redirect:/internets";
        }
    }

    @PostMapping("/internets/{capacidad}/edit/save")
    public String internetEditarGuardar(@PathVariable("capacidad") int capacidad, @ModelAttribute Internet internet) {
        internetRepository.actualizarInternet(capacidad, internet.getPrecio(), internet.getComsumos_idConsumo().getIdConsumo());
        return "redirect:/internets";
    }

    @GetMapping("/internets/{capacidad}/delete")
    public String internetEliminar(@PathVariable("capacidad") int capacidad) {
        internetRepository.eliminarInternet(capacidad);
        return "redirect:/internets";
    }*/
}
