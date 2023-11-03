package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.Modelo.Tienda;
import uniandes.edu.co.proyecto.repositorio.ConsumoRepository;
import uniandes.edu.co.proyecto.repositorio.TiendaRepository;

/*@Controller*/
@Controller
public class TiendaController {
    @Autowired
    private TiendaRepository tiendaRepository;
    @Autowired
    private ConsumoRepository consumoRepository;

    @GetMapping("/tiendas")
    public String tiendas(Model model) {
        model.addAttribute("tiendas", tiendaRepository.darTiendas());
        model.addAttribute("consumos", consumoRepository.darConsumos());
        return "Tiendas";
    }
    
    @GetMapping("/tiendas/new")
    public String tiendaForm(Model model) {
        model.addAttribute("tienda", new Tienda());
        return "TiendaNuevo";
    }

    @PostMapping("/tiendas/new/save")
    public String tiendaGuardar(@ModelAttribute Tienda tienda) {
        tiendaRepository.insertarTienda(tienda.getNombre(), tienda.getHorarioapertura(), tienda.getHorariocierre(), tienda.getCapacidad());
        return "redirect:/tiendas";
    }

    @GetMapping("/tiendas/{id}/edit") 
    public String tiendaEditarForm(@PathVariable("id") Integer id, Model model) {
        Tienda tienda = tiendaRepository.darTienda(id);
        if (tienda != null) {
            model.addAttribute("tienda", tienda);
            return "TiendaEditar";
        } else {
            return "redirect:/tiendas";
        }
    }

    @PostMapping("/tiendas/{id}/edit/save")
    public String tiendaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Tienda tienda) {
        tiendaRepository.actualizarTienda(id, tienda.getNombre(),tienda.getHorarioapertura(), tienda.getHorariocierre(), tienda.getCapacidad());
        return "redirect:/tiendas";
    }

    @GetMapping("/tiendas/{id}/delete")
    public String tiendaEliminar(@PathVariable("id") Integer id) {
        tiendaRepository.eliminarTienda(id);
        return "redirect:/tiendas";
    }
}


