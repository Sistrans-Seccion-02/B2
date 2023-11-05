package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.ProductoBar;

import uniandes.edu.co.proyecto.repositorio.ProductoBarRepository;
import uniandes.edu.co.proyecto.repositorio.BarRepository;
import uniandes.edu.co.proyecto.repositorio.PlatoBebidaRepository;

@Controller
public class ProductoBarController {
    @Autowired
    private ProductoBarRepository productoBarRepository;
    @Autowired
    private BarRepository barRepository;
    @Autowired
    private PlatoBebidaRepository platoBebidaRepositoryRepository;

    @GetMapping("/productosbares")
    public String productosbares(Model model) {
        model.addAttribute("productosbares", productoBarRepository.darProductosBar());
        return "Productosbares";
    }
    
    @GetMapping("/productosbares/new")
    public String productobarForm(Model model) {
        model.addAttribute("productobar", new ProductoBar());
        model.addAttribute("platosbebidas", platoBebidaRepositoryRepository.darPlatosBebidas());
        model.addAttribute("bares", barRepository.darBares());
        return "ProductoBarNuevo";
    }

    @PostMapping("/productosbares/new/save")
    public String productobarGuardar(@ModelAttribute ProductoBar productoBar) {
        productoBarRepository.insertarProductoBar(productoBar.getPlatoBebidaId().getId(), productoBar.getBarId().getId());
        return "redirect:/productosbares";
    }

    @GetMapping("/productosbares/{id}/edit") 
    public String productobarEditarForm(@PathVariable("id") Integer id, Model model) {
        ProductoBar productoBar = productoBarRepository.darProductoBar(id);
        if (productoBar != null) {
            model.addAttribute("productobar", productoBar);
            return "ProductoBarEditar";
        } else {
            return "redirect:/productosbares";
        }
    }

    @PostMapping("/productosbares/{id}/edit/save")
    public String productobarEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute ProductoBar productoBar) {
        productoBarRepository.actualizarProductoBar(id, productoBar.getPlatoBebidaId().getId(), productoBar.getBarId().getId());
        return "redirect:/productosbares";
    }

    @GetMapping("/productosbares/{id}/delete")
    public String productobarEliminar(@PathVariable("id") Integer id) {
        productoBarRepository.eliminarProductoBar(id);
        return "redirect:/productosbares";
    }
}
