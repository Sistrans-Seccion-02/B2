package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;


import uniandes.edu.co.proyecto.repositorio.ReservaRepository;


@Controller

public class ReservaControllerIO {

    @Autowired
    private ReservaRepository reservaRepository;
 

    @GetMapping("/reservasIO")
    public String reservas(Model model) {
        model.addAttribute("reservas", reservaRepository.darReservas());
        return "reservaIO";
    }


    @GetMapping("/reservasIO/{id}/checkIn")
    public String checkIn(@PathVariable("id") int id){
        reservaRepository.checkIn(id);
        return "redirect:/reservasIO";
    }


    @GetMapping("/reservasIO/{id}/checkOut")
    public String checkOut(@PathVariable("id") int id){
        reservaRepository.checkOut(id);
        return "redirect:/reservasIO";
    }

   




    
    
}
