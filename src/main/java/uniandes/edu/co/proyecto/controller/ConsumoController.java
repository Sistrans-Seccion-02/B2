package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import oracle.jdbc.proxy.annotation.Post;
import uniandes.edu.co.proyecto.Modelo.Consumo;
import uniandes.edu.co.proyecto.repositorio.ConsumoRepository;

/*@Controller*/
@RestController
public class ConsumoController {
    @Autowired
    private ConsumoRepository consumoRepository;

    @GetMapping("/consumos")
    public String consumos(Model model) {
        model.addAttribute("consumos", consumoRepository.darConsumos());
        return model.toString();
    }
    
    @GetMapping("/consumos/new")
    public String consumoForm(Model model) {
        model.addAttribute("consumo", new Consumo());
        return "consumoNuevo";
    }

    @PostMapping("/consumos/new/save")
    public String consumoGuardar(@ModelAttribute Consumo consumo) {
        consumoRepository.insertarConsumo(consumo.getIdConsumo(), consumo.getPrecioTotal(), consumo.getPazYSalvo());
        return "redirect:/consumos";
    }

    @GetMapping("/consumos/{idConsumo}/edit") 
    public String consumoEditarForm(@PathVariable("idConsumo") int id, Model model) {
        Consumo consumo = consumoRepository.darConsumo(id);
        if (consumo != null) {
            model.addAttribute("idConsumo", id);
            return "consumoEditar";
        } else {
            return "redirect:/consumos";
        }
    }

    @PostMapping("/consumos/{idConsumo}/edit/save")
    public String consumoEditarGuardar(@PathVariable("idConsumo") int id, @ModelAttribute Consumo consumo) {
        consumoRepository.actualizarConsumo(id, consumo.getPrecioTotal(), consumo.getPazYSalvo());
        return "redirect:/consumos";
    }

    @GetMapping("/consumos/{idConsumo}/delete")
    public String consumoEliminar(@PathVariable("idConsumo") int id) {
        consumoRepository.eliminarConsumo(id);
        return "redirect:/consumos";
    }
}




