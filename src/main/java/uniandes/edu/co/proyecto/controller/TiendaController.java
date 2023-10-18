package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.Modelo.Tienda;
import uniandes.edu.co.proyecto.repositorio.TiendaRepository;

/*@Controller*/
@Controller
public class TiendaController {
    @Autowired
    private TiendaRepository tiendaRepository;

    @GetMapping("/tiendas")
    public String tiendas(Model model) {
        model.addAttribute("tiendas", tiendaRepository.darTiendas());
        return model.toString();
    }
    
    @GetMapping("/tiendas/new")
    public String tiendaForm(Model model) {
        model.addAttribute("tienda", new Tienda());
        return "tiendaNuevo";
    }

    @PostMapping("/tiendas/new/save")
    public String tiendaGuardar(@ModelAttribute Tienda tienda) {
        tiendaRepository.insertarTienda(tienda.getNombre(), tienda.getHorarioApertura(), tienda.getHorarioCierre(), tienda.getCapacidad());
        return "redirect:/tiendas";
    }

    @GetMapping("/tiendas/{nombre}/edit") 
    public String tiendaEditarForm(@PathVariable("nombre") String nombre, Model model) {
        Tienda tienda = tiendaRepository.darTienda(nombre);
        if (tienda != null) {
            model.addAttribute("nombre", nombre);
            return "tiendaEditar";
        } else {
            return "redirect:/tiendas";
        }
    }

    @PostMapping("/tiendas/{nombre}/edit/save")
    public String tiendaEditarGuardar(@PathVariable("nombre") String nombre, @ModelAttribute Tienda tienda) {
        tiendaRepository.actualizarTienda(nombre, tienda.getHorarioApertura(), tienda.getHorarioCierre(), tienda.getCapacidad());
        return "redirect:/tiendas";
    }

    @GetMapping("/tiendas/{nombre}/delete")
    public String tiendaEliminar(@PathVariable("nombre") String nombre) {
        tiendaRepository.eliminarTienda(nombre);
        return "redirect:/tiendas";
    }
}


