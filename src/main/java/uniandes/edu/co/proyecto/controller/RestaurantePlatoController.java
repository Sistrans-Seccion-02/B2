package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Plato;
import uniandes.edu.co.proyecto.Modelo.Restaurante;
import uniandes.edu.co.proyecto.Modelo.RestaurantePlato;
import uniandes.edu.co.proyecto.Modelo.RestaurantePlatoPK;
import uniandes.edu.co.proyecto.repositorio.PlatoRepository;
import uniandes.edu.co.proyecto.repositorio.RestaurantePlatoRepository;
import uniandes.edu.co.proyecto.repositorio.RestauranteRepository;

@Controller
public class RestaurantePlatoController {
    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private PlatoRepository platoRepository;

    @Autowired
    private RestaurantePlatoRepository restaurantePlatoRepository;

    @GetMapping("/RestaurantesPlatos/new")
    public String restaurantesPlatosForm(Model model) {
        model.addAttribute("Platos", platoRepository.darPlatos());
        model.addAttribute("Restaurantes", restauranteRepository.darRestaurantes());

        return "RestaurantesPlatosNuevo";        
    }

    @PostMapping("/RestaurantesPlatos/new/save")
    public String restaurantesPlatosGuardar(@ModelAttribute("nombreRestaurante") String nombreRestaurante, @ModelAttribute("nombrePlato") String nombrePlato) {
        Restaurante restaurante = restauranteRepository.darRestaurante(nombreRestaurante);
        Plato plato = platoRepository.darPlato(nombrePlato);
        
        RestaurantePlatoPK pk = new RestaurantePlatoPK(restaurante, plato);
        RestaurantePlato restaurantePlato  = new RestaurantePlato();
        restaurantePlato.setPk(pk);
        restaurantePlatoRepository.insertarRestaurantePlato(restaurantePlato.getPk().getNombreRestaurante().getNombre(), restaurantePlato.getPk().getNombrePlato().getNombre());
        return "redirect:/Platos";
    }
}

