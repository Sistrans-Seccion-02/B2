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

    @GetMapping("/SMercados")
    public String SMercados(Model model) {
        model.addAttribute("SMercados", SMercadoRepository.darSMercados());
        model.addAttribute("consumos", consumoRepository.darConsumos());
        return "SMercado";
    }
    
    @GetMapping("/SMercados/new")
    public String SMercadoForm(Model model) {
        model.addAttribute("SMercado", new SMercado());
        return "SMercadoNuevo";
    }

    @PostMapping("/SMercados/new/save")
    public String SMercadoGuardar(@ModelAttribute SMercado SMercado) {
        SMercadoRepository.insertarSMercado(SMercado.getNombre(), SMercado.getHorarioapertura(), SMercado.getHorariocierre(), SMercado.getCapacidad());
        return "redirect:/SMercados";
    }

    @GetMapping("/SMercados/{id}/edit") 
    public String SMercadoEditarForm(@PathVariable("id") Integer id, Model model) {
        SMercado SMercado = SMercadoRepository.darSMercado(id);
        if (SMercado != null) {
            model.addAttribute("SMercado", SMercado);
            return "SMercadoEditar";
        } else {
            return "redirect:/SMercados";
        }
    }

    @PostMapping("/SMercados/{id}/edit/save")
    public String SMercadoEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute SMercado SMercado) {
        SMercadoRepository.actualizarSMercado(id, SMercado.getNombre(),SMercado.getHorarioapertura(), SMercado.getHorariocierre(), SMercado.getCapacidad());
        return "redirect:/SMercados";
    }

    @GetMapping("/SMercados/{id}/delete")
    public String SMercadoEliminar(@PathVariable("id") Integer id) {
        SMercadoRepository.eliminarSMercado(id);
        return "redirect:/SMercados";
    }
}


