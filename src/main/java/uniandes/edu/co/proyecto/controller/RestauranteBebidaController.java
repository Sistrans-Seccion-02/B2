package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Bebida;
import uniandes.edu.co.proyecto.Modelo.Restaurante;
import uniandes.edu.co.proyecto.Modelo.RestauranteBebida;
import uniandes.edu.co.proyecto.Modelo.RestauranteBebidaPK;
import uniandes.edu.co.proyecto.repositorio.BebidaRepository;
import uniandes.edu.co.proyecto.repositorio.RestauranteBebidaRepository;
import uniandes.edu.co.proyecto.repositorio.RestauranteRepository;

@Controller
public class RestauranteBebidaController {
    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private BebidaRepository bebidaRepository;

    @Autowired
    private RestauranteBebidaRepository restauranteBebidaRepository;

    @GetMapping("/RestaurantesBebidas/new")
    public String restaurantesBebidasForm(Model model) {
        model.addAttribute("Bebidas", bebidaRepository.darBebidas());
        model.addAttribute("Restaurantes", restauranteRepository.darRestaurantes());

        return "RestaurantesBebidasNuevo";        
    }

    @PostMapping("/RestaurantesBebidas/new/save")
    public String restaurantesBebidasGuardar(@ModelAttribute("nombreRestaurante") String nombreRestaurante, @ModelAttribute("nombreBebida") String nombreBebida) {
        Restaurante restaurante = restauranteRepository.darRestaurante(nombreRestaurante);
        Bebida bebida = bebidaRepository.darBebida(nombreBebida);
        
        RestauranteBebidaPK pk = new RestauranteBebidaPK(restaurante, bebida);
        RestauranteBebida restauranteBebida  = new RestauranteBebida();
        restauranteBebida.setPk(pk);
        restauranteBebidaRepository.insertarRestauranteBebida(restauranteBebida.getPk().getNombreRestaurante().getNombre(), restauranteBebida.getPk().getNombreBebida().getNombre());
        return "redirect:/Bebidas";
    }
}
