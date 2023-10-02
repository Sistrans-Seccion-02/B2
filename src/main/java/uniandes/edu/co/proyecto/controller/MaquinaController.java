package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.repositorio.MaquinaRepository;


@Controller
public class MaquinaController {
    @Autowired
    private MaquinaRepository maquinaRepository;

    @GetMapping("/maquinas")
    public String maquinas(Model model){
        model.addAttribute("maquinas", maquinaRepository.darMaquinas());
        return "maquinas";
    }

    @GetMapping("/maquinas/new")
    public String maquinaForm(Model model){
        model.addAttribute("maquina", new uniandes.edu.co.proyecto.Modelo.Maquina());
        return "maquinaNuevo";       
    }

    @PostMapping("/maquinas/new/save")
    public String maquinaGuardar(@ModelAttribute uniandes.edu.co.proyecto.Modelo.Maquina maquina){
        maquinaRepository.insertarMaquina(maquina.getNombre(),maquina.getGimnasios_nombre().getNombre());
        return "redirect:/maquinas";
    
    }

    @GetMapping("/maquinas/{idMaquina}/edit")
    public String maquinaEditarForm(@PathVariable("idMaquina") Integer idMaquina, Model model){
        uniandes.edu.co.proyecto.Modelo.Maquina maquina= maquinaRepository.darMaquina(idMaquina);
        if(maquina != null){
            model.addAttribute("maquina", maquina);
            return "maquinaEditar";
        }
        else{
            return "redirect:/maquinas";
        }
    }

    @PostMapping("/maquinas/{idMaquina}/edit/save")
     public String maquinaEditarGuardar(@PathVariable("idMaquina") Integer idMaquina, @ModelAttribute uniandes.edu.co.proyecto.Modelo.Maquina maquina){
        maquinaRepository.actualizarMaquina(idMaquina,maquina.getNombre(),maquina.getGimnasios_nombre().getNombre());
        return "redirect:/maquinas";
    }

    @GetMapping("/maquinas/{idMaquina}/delete")
    public String maquinaEliminar(@PathVariable("idMaquina") Integer idMaquina){
        maquinaRepository.eleminarMaquina(idMaquina);
        return "redirect:/maquinas";
    }



}
