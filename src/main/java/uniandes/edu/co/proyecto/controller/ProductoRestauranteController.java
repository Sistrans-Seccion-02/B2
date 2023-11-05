package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.ProductoRestaurante;

import uniandes.edu.co.proyecto.repositorio.ProductoRestauranteRepository;
import uniandes.edu.co.proyecto.repositorio.RestauranteRepository;
import uniandes.edu.co.proyecto.repositorio.PlatoBebidaRepository;

@Controller
public class ProductoRestauranteController {
    @Autowired
    private ProductoRestauranteRepository productoRestauranteRepository;
    @Autowired
    private RestauranteRepository restauranteRepository;
    @Autowired
    private PlatoBebidaRepository platoBebidaRepositoryRepository;

    @GetMapping("/productosrestaurantes")
    public String productosrestaurantes(Model model) {
        model.addAttribute("productosrestaurantes", productoRestauranteRepository.darProductosRestaurante());
        return "Productosrestaurantes";
    }
    
    @GetMapping("/productosrestaurantes/new")
    public String productorestauranteForm(Model model) {
        model.addAttribute("productorestaurante", new ProductoRestaurante());
        model.addAttribute("platosbebidas", platoBebidaRepositoryRepository.darPlatosBebidas());
        model.addAttribute("rests", restauranteRepository.darRestaurantes());
        return "ProductoRestauranteNuevo";
    }

    @PostMapping("/productosrestaurantes/new/save")
    public String productorestauranteGuardar(@ModelAttribute ProductoRestaurante productoRestaurante) {
        productoRestauranteRepository.insertarProductoRestaurante(productoRestaurante.getPlatoBebidaId().getId(), productoRestaurante.getRestauranteId().getId());
        return "redirect:/productosrestaurantes";
    }

    @GetMapping("/productosrestaurantes/{id}/edit") 
    public String productorestauranteEditarForm(@PathVariable("id") Integer id, Model model) {
        ProductoRestaurante productoRestaurante = productoRestauranteRepository.darProductoRestaurante(id);
        if (productoRestaurante != null) {
            model.addAttribute("productorestaurante", productoRestaurante);
            return "ProductoRestauranteEditar";
        } else {
            return "redirect:/productosrestaurantes";
        }
    }

    @PostMapping("/productosrestaurantes/{id}/edit/save")
    public String productorestauranteEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute ProductoRestaurante productoRestaurante) {
        productoRestauranteRepository.actualizarProductoRestaurante(id, productoRestaurante.getPlatoBebidaId().getId(), productoRestaurante.getRestauranteId().getId());
        return "redirect:/productosrestaurantes";
    }

    @GetMapping("/productosrestaurantes/{id}/delete")
    public String productorestauranteEliminar(@PathVariable("id") Integer id) {
        productoRestauranteRepository.eliminarProductoRestaurante(id);
        return "redirect:/productosrestaurantes";
    }
}