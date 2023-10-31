package uniandes.edu.co.proyecto.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.repositorio.ConsumoRepository;
import uniandes.edu.co.proyecto.repositorio.ReservaServicioRepository;
import uniandes.edu.co.proyecto.Modelo.ReservaServicio;


@Controller
public class ReservaServicioController {
    @Autowired
    private ReservaServicioRepository reservaServicioRepository;
    @Autowired
    private ConsumoRepository consumoRepository;

    @GetMapping("/reservasServicio")
    public String reservasServicio(Model model){
        model.addAttribute("reservasServicio",reservaServicioRepository.darReservasServicio());
        model.addAttribute("consumos", consumoRepository.darConsumos());
        return "ReservasServicio";
    }

    @GetMapping("/reservasServicio/new")
    public String reservaServicioForm(Model model){
        model.addAttribute("reservaServicio", new ReservaServicio());
        return "ReservaServicioNuevo";       
    }

    @PostMapping("/reservasServicio/new/save")
    public String reservaServicioGuardar(@ModelAttribute ReservaServicio reservaServicio){
        reservaServicioRepository.insertarReservaServicio(reservaServicio.getFechayhorai(), reservaServicio.getFechayhoraf(), 
        reservaServicio.getConsumoid().getId(), reservaServicio.getPrecio(), reservaServicio.getDescripcion());
        return "redirect:/reservasServicio";
    }

    @GetMapping("/reservasServicio/{id}/edit")
    public String reservaServicioEditarForm(@PathVariable("id") Integer id, Model model){
        ReservaServicio reservaServicio = reservaServicioRepository.darReservaServicio(id);
        if(reservaServicio != null){
            model.addAttribute("reservaServicio", reservaServicio);
            return "ReservaServicioEditar";
        }else{
            return "redirect:/reservasServicio";
        }
    }

    @PostMapping("/reservasServicio/{id}/edit/save")    
    public String reservaServicioEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute ReservaServicio reservaServicio){
        reservaServicioRepository.actualizarReservaServicio(id, reservaServicio.getFechayhorai(), reservaServicio.getFechayhoraf(), 
        reservaServicio.getConsumoid().getId(), reservaServicio.getPrecio(), reservaServicio.getDescripcion());
        return "redirect:/reservasServicio";
    }   
 
    @GetMapping("/reservasServicio/{id}/delete")
    public String reservaServicioEliminar(@PathVariable("id") Integer id){
        reservaServicioRepository.eleminarReservaServicio(id);
        return "redirect:/reservasServicio";
    }

}
