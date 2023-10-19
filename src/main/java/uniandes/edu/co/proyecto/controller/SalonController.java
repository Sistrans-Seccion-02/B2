package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Salon;
import uniandes.edu.co.proyecto.repositorio.SalonRepository;

@Controller
public class SalonController {
    @Autowired
    private SalonRepository salonRepository;

    @GetMapping("/salones")
    public String salones(Model model){
        model.addAttribute("salones", salonRepository.darSalones());
        return "salon";
    }

    @GetMapping("/salones/new")
    public String salonForm(Model model){
        model.addAttribute("salon", new Salon());
        return "salonNuevo";
    }

    @PostMapping("/salones/new/save")
    public String salonGuardar(@ModelAttribute Salon salon){
        salonRepository.insertarSalon(salon.getNombre(), salon.getHorarioApertura(), salon.getHorarioCierre(), salon.getTipoSalon(), salon.getCapacidad());
        return "redirect:/salones";
    }

    @GetMapping("/salones/{nombre}/edit")
    public String salonEditarForm(@PathVariable("nombre") String nombre, Model model){
        Salon salon = salonRepository.darSalon(nombre);
        if(salon != null){
            model.addAttribute("salon", salon);
            return "salonEditar";
        }
        else{
            return "redirect:/salones";
        }
    }

    @PostMapping("/salones/{nombre}/edit/save")
    public String salonEditarGuardar(@PathVariable("nombre") String nombre, @ModelAttribute Salon salon){
        salonRepository.actualizarSalon(nombre, salon.getHorarioApertura(), salon.getHorarioCierre(), salon.getTipoSalon(), salon.getCapacidad());
        return "redirect:/salones";
    }

    @GetMapping("/salones/{nombre}/delete")
    public String salonEliminar(@PathVariable("nombre") String nombre){
        salonRepository.eleminarSalon(nombre);
        return "redirect:/salones";
    }

}
