package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Plato;
import uniandes.edu.co.proyecto.repositorio.PlatoRepository;


@Controller
public class PlatoController {
    @Autowired
    private PlatoRepository platoRepository;

    @GetMapping("/platos")
    public String platos(Model model){
        model.addAttribute("platos", platoRepository.darPlatos());
        return "platos";
    }

    @GetMapping("/platos/new")
    public String platoForm(Model model){
        model.addAttribute("plato", new Plato());
        return "platoNuevo";       
    }

    @PostMapping("/platos/new/save")
    public String platoGuardar(@ModelAttribute Plato plato){
        platoRepository.insertarPlato(plato.getNombre(),plato.getPrecio(), plato.getTodoIncluido());
        return "redirect:/platos";
    
    }

    @GetMapping("/platos/{nombre}/edit")
    public String platoEditarForm(@PathVariable("nombre") String nombre, Model model){
        Plato plato= platoRepository.darPlato(nombre);
        if(plato != null){
            model.addAttribute("plato", plato);
            return "platoEditar";
        }
        else{
            return "redirect:/platos";
        }
    }

    @PostMapping("/platos/{nombre}/edit/save")
     public String platoEditarGuardar(@PathVariable("nombre") String nombre, @ModelAttribute Plato plato){
        platoRepository.actualizarPlato(nombre,plato.getPrecio(), plato.getTodoIncluido());
        return "redirect:/platos";
    }

    @GetMapping("/platos/{nombre}/delete")
    public String platoEliminar(@PathVariable("nombre") String nombre){
        platoRepository.eleminarPlato(nombre);
        return "redirect:/platos";
    }


}
