package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Bebida;
import uniandes.edu.co.proyecto.repositorio.BebidaRepository;


@Controller
public class BebidaController {
    
    @Autowired
    private BebidaRepository bebidaRepository;

    @GetMapping("/bebidas")
    public String bebidas(Model model){
        model.addAttribute("bebidas", bebidaRepository.darBebidas());
        return "bebidas";
    }

    @GetMapping("/bebidas/new")
    public String bebidaForm(Model model){
        model.addAttribute("bebida", new Bebida());
        return "bebidaNuevo";       
    }

    @PostMapping("/bebidas/new/save")
    public String bebidaGuardar(@ModelAttribute Bebida bebida){
        bebidaRepository.insertarBebida(bebida.getNombre(),bebida.getPrecio(), bebida.getTodoIncluido());
        return "redirect:/bebidas";
    
    }

    @GetMapping("/bebidas/{nombre}/edit")
    public String bebidaEditarForm(@PathVariable("nombre") String nombre, Model model){
        Bebida bebida= bebidaRepository.darBebida(nombre);
        if(bebida != null){
            model.addAttribute("bebida", bebida);
            return "bebidaEditar";
        }
        else{
            return "redirect:/bebidas";
        }
    }

    @PostMapping("/bebidas/{nombre}/edit/save")
     public String bebidaEditarGuardar(@PathVariable("nombre") String nombre, @ModelAttribute Bebida bebida){
        bebidaRepository.actualizarBebida(nombre,bebida.getPrecio(), bebida.getTodoIncluido());
        return "redirect:/bebidas";
    }

    @GetMapping("/bebidas/{nombre}/delete")
    public String bebidaEliminar(@PathVariable("nombre") String nombre){
        bebidaRepository.eleminarBebida(nombre);
        return "redirect:/bebidas";
    }
}
