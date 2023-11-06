package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import uniandes.edu.co.proyecto.Modelo.Reserva;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;
import uniandes.edu.co.proyecto.repositorio.PlanConsumoRepository;
import uniandes.edu.co.proyecto.repositorio.ReservaRepository;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

@Controller

public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private UsuarioRepository  usuarioRepository;
    @Autowired
    private PlanConsumoRepository  planConsumoRepository;
    @Autowired
    private HabitacionRepository  habitacionRepository;

    @GetMapping("/reservas")
    public String reservas(Model model) {
        model.addAttribute("reservas", reservaRepository.darReservas());
        return "reserva";
    }

    @GetMapping("/reservas/new")
    public String reservaForm(Model model){
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("usuarios", usuarioRepository.darUsuarios());
        model.addAttribute("planes", planConsumoRepository.darplanesConsumo());
        model.addAttribute("habitaciones", habitacionRepository.darHabitaciones());

        return"reservaNueva";       
    }

    @PostMapping("/reservas/new/save")
    public String reservaGuardar(@ModelAttribute Reserva reserva){
        reservaRepository.insertarReserva(reserva.getFechaentrada(), reserva.getFechasalida(), reserva.getNumpersonas(), reserva.isEstado(), reserva.getPrecioreserva(), reserva.getUsuarioId().getId(), reserva.getPlanid().getId(), reserva.getHabitacionId().getId());
        return "redirect:/reservas";
    
    }

    @GetMapping("/reservas/{id}/edit")
    public String reservaEditarForm(@PathVariable("id") int id, Model model){
        Reserva reserva= reservaRepository.darReserva(id);
        if(reserva != null){
            model.addAttribute("reserva", reserva);
            model.addAttribute("usuarios", usuarioRepository.darUsuarios());
            model.addAttribute("planes", planConsumoRepository.darplanesConsumo());
            model.addAttribute("habitaciones", habitacionRepository.darHabitaciones());
            return "ReservaEditar";
        }
        else{
            return "redirect:/reservas";
        }
    }
    @PostMapping("/reservas/{id}/edit/save")
     public String reservaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Reserva reserva){
        reservaRepository.actualizarReserva(id, reserva.getFechaentrada(), reserva.getFechasalida(), reserva.getNumpersonas(), reserva.isEstado(), reserva.getPrecioreserva(), reserva.getUsuarioId().getId(), reserva.getPlanid().getId(), reserva.getHabitacionId().getId());
        return "redirect:/reservas";
    }

    @GetMapping("/reservas/{id}/delete")
    public String reservaEliminar(@PathVariable("id") int id){
        reservaRepository.eliminarReserva(id);
        return "redirect:/reservas";
    }


    @GetMapping("/reservas/{id}/checkIn")
    public String checkIn(@PathVariable("id") int id){
        reservaRepository.checkIn(id);
        return "redirect:/reservas";
    }


    @GetMapping("/reservas/{id}/checkOut")
    public String checkOut(@PathVariable("id") int id){
        reservaRepository.checkOut(id);
        return "redirect:/reservas";
    }

   




    
    
}
