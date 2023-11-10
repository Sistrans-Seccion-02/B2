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
        return "Consumos";
    }
    
    @GetMapping("/consumos/req6")
    public String req6(Model model) {
        model.addAttribute("consumos", consumoRepository.req6());
        return "Consumosreq6";
    }

    @GetMapping("/consumos/new")
    public String consumoForm(Model model) {
        model.addAttribute("consumo", new Consumo());
        return "consumosNuevo";
    }

    @PostMapping("/consumos/new/save")
    public String consumoGuardar(@ModelAttribute Consumo consumo) {
        consumoRepository.insertarConsumo(consumo.getFecha());
        return "redirect:/Consumos";
        
    }

     @GetMapping("/consumos/{id}/edit")
        public String consumoEditarForm(@PathVariable("id") Integer id, Model model) {
            Consumo consumo = consumoRepository.darConsumo(id);
            if (consumo != null) {
                model.addAttribute("consumos", consumo);
                return "consumosEditar";
            } else {
                return "redirect:/consumos";
            }
        }

        @PostMapping("/consumos/{id}/edit/save")
        public String consumoEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Consumo consumo) {
            System.out.println(id);
            consumoRepository.actualizarConsumo(((Integer) id), consumo.getFecha());
                    
            return "redirect:/Consumos";
        }


    @GetMapping("/consumos/{id}/delete")
    public String consumoEliminar(@PathVariable("id") Integer id) {
        consumoRepository.eliminarConsumo(id);
        return "redirect:/Consumos";
    }
}




