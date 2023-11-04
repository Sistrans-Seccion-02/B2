package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.Modelo.SMercado;
import uniandes.edu.co.proyecto.repositorio.ConsumoRepository;
import uniandes.edu.co.proyecto.repositorio.SMercadoRepository;

@Controller
public class SMercadoController {
    @Autowired
    private SMercadoRepository SMercadoRepository;
    @Autowired
    private ConsumoRepository consumoRepository;

    @GetMapping("/mercados")
    public String mercados(Model model) {
        model.addAttribute("mercados", SMercadoRepository.darSMercados());
        model.addAttribute("consumos", consumoRepository.darConsumos());
        return "Mercados";
    }
    
    @GetMapping("/mercados/new")
    public String mercadoForm(Model model) {
        model.addAttribute("mercado", new SMercado());
        return "MercadoNuevo";
    }

    @PostMapping("/mercados/new/save")
    public String mercadoGuardar(@ModelAttribute SMercado SMercado) {
        SMercadoRepository.insertarSMercado(SMercado.getNombre(), SMercado.getHorarioapertura(), SMercado.getHorariocierre(), SMercado.getCapacidad());
        return "redirect:/mercados";
    }

    @GetMapping("/mercados/{id}/edit") 
    public String mercadoEditarForm(@PathVariable("id") Integer id, Model model) {
        SMercado mercado = SMercadoRepository.darSMercado(id);
        if (mercado != null) {
            model.addAttribute("mercado", mercado);
            return "MercadoEditar";
        } else {
            return "redirect:/mercados";
        }
    }

    @PostMapping("/mercados/{id}/edit/save")
    public String mercadoEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute SMercado SMercado) {
        SMercadoRepository.actualizarSMercado(id, SMercado.getNombre(),SMercado.getHorarioapertura(), SMercado.getHorariocierre(), SMercado.getCapacidad());
        return "redirect:/mercados";
    }

    @GetMapping("/mercados/{id}/delete")
    public String mercadoEliminar(@PathVariable("id") Integer id) {
        SMercadoRepository.eliminarSMercado(id);
        return "redirect:/mercados";
    }
}


