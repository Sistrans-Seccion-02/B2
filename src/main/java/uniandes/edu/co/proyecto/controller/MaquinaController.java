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
import uniandes.edu.co.proyecto.Modelo.Maquina;
import uniandes.edu.co.proyecto.repositorio.GimnasioRepository;
import uniandes.edu.co.proyecto.repositorio.MaquinaRepository;

/*@Controller*/
@RestController
public class MaquinaController {
    @Autowired
    private MaquinaRepository maquinaRepository;

    @Autowired
    private GimnasioRepository gimnasioRepository;

    @GetMapping("/maquinas")
    public String maquinas(Model model) {
        model.addAttribute("maquinas", maquinaRepository.darMaquinas());
        return model.toString();
    }
    
    @GetMapping("/maquinas/new")
    public String maquinaForm(Model model) {
        model.addAttribute("maquina", new Maquina());
        //model.addAttribute("gimnasios", gimnasioRepository.darGimnasios());
        return "maquinaNuevo";
    }

    @PostMapping("/maquinas/new/save")
    public String maquinaGuardar(@ModelAttribute Maquina maquina) {
        maquinaRepository.insertarMaquina(maquina.getNombre(), maquina.getGimnasios_nombre().getNombre());
        return "redirect:/maquinas";
    }

    @GetMapping("/maquinas/{idMaquina}/edit") 
    public String maquinaEditarForm(@PathVariable("idMaquina") int idMaquina, Model model) {
        Maquina maquina = maquinaRepository.darMaquina(idMaquina);
        if (maquina != null) {
            model.addAttribute("idMaquina", idMaquina);
            return "maquinaEditar";
        } else {
            return "redirect:/maquinas";
        }
    }

    @PostMapping("/maquinas/{idMaquina}/edit/save")
    public String maquinaEditarGuardar(@PathVariable("idMaquina") int idMaquina, @ModelAttribute Maquina maquina) {
        maquinaRepository.actualizarMaquina(idMaquina, maquina.getNombre(), maquina.getGimnasios_nombre().getNombre());
        return "redirect:/maquinas";
    }

    @GetMapping("/maquinas/{idMaquina}/delete")
    public String maquinaEliminar(@PathVariable("idMaquina") int idMaquina) {
        maquinaRepository.eliminarMaquina(idMaquina);
        return "redirect:/maquinas";
    }
}


