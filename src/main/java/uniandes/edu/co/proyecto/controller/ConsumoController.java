package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.Modelo.Consumo;
import uniandes.edu.co.proyecto.repositorio.ConsumoRepository;

@Controller
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
        consumoRepository.insertarConsumo();
        return "redirect:/consumos";
    }


    @GetMapping("/consumos/{idConsumo}/delete")
    public String consumoEliminar(@PathVariable("idConsumo") Integer idConsumo) {
        consumoRepository.eliminarConsumo(idConsumo);
        return "redirect:/consumos";
    }
}




