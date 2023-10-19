package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.Modelo.SMercado;
import uniandes.edu.co.proyecto.repositorio.SMercadoRepository;

/*@Controller*/
@Controller
public class SMercadoController {
    @Autowired
    private SMercadoRepository SMercadoRepository;

    @GetMapping("/SMercados")
    public String SMercados(Model model) {
        model.addAttribute("SMercados", SMercadoRepository.darSMercados());
        return "SMercado";
    }
    
    @GetMapping("/SMercados/new")
    public String SMercadoForm(Model model) {
        model.addAttribute("SMercado", new SMercado());
        return "SMercadoNuevo";
    }

    @PostMapping("/SMercados/new/save")
    public String SMercadoGuardar(@ModelAttribute SMercado SMercado) {
        SMercadoRepository.insertarSMercado(SMercado.getNombre(), SMercado.getHorarioApertura(), SMercado.getHorarioCierre(), SMercado.getCapacidad());
        return "redirect:/SMercados";
    }

    @GetMapping("/SMercados/{nombre}/edit") 
    public String SMercadoEditarForm(@PathVariable("nombre") String nombre, Model model) {
        SMercado SMercado = SMercadoRepository.darSMercado(nombre);
        if (SMercado != null) {
            model.addAttribute("nombre", nombre);
            return "SMercadoEditar";
        } else {
            return "redirect:/SMercados";
        }
    }

    @PostMapping("/SMercados/{nombre}/edit/save")
    public String SMercadoEditarGuardar(@PathVariable("nombre") String nombre, @ModelAttribute SMercado SMercado) {
        SMercadoRepository.actualizarSMercado(nombre, SMercado.getHorarioApertura(), SMercado.getHorarioCierre(), SMercado.getCapacidad());
        return "redirect:/SMercados";
    }

    @GetMapping("/SMercados/{nombre}/delete")
    public String SMercadoEliminar(@PathVariable("nombre") String nombre) {
        SMercadoRepository.eliminarSMercado(nombre);
        return "redirect:/SMercados";
    }
}


