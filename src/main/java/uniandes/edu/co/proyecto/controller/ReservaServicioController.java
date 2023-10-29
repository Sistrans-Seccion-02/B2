package uniandes.edu.co.proyecto.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.repositorio.ReservaServicioRepository;
import uniandes.edu.co.proyecto.Modelo.ReservaServicio;


@Controller
public class ReservaServicioController {
    @Autowired
    private ReservaServicioRepository reservaServicioRepository;

    @GetMapping("/reservasServicio")
    public String reservasServicio(Model model){
        model.addAttribute("reservasServicio",reservaServicioRepository.darReservasServicio());
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
        reservaServicio.getSpas_nombre().getNombre(), reservaServicio.getSalones_nombre().getNombre(),
        reservaServicio.getConsumos_idConsumo().getIdConsumo(), reservaServicio.getUtensilios_id().getId(), 
        reservaServicio.getPreciofinal());
        return "redirect:/reservasServicio";
    }

    @GetMapping("/reservasServicio/{idreservas}/edit")
    public String reservaServicioEditarForm(@PathVariable("idreservas") Integer idreservas, Model model){
        ReservaServicio reservaServicio = reservaServicioRepository.darReservaServicio(idreservas);
        if(reservaServicio != null){
            model.addAttribute("reservaServicio", reservaServicio);
            return "ReservaServicioEditar";
        }else{
            return "redirect:/reservasServicio";
        }
    }

    @PostMapping("/reservasServicio/{idreservas}/edit/save")    
    public String reservaServicioEditarGuardar(@PathVariable("idreservas") Integer idreservas, @ModelAttribute ReservaServicio reservaServicio){
        reservaServicioRepository.actualizarReservaServicio(idreservas, reservaServicio.getFechayhorai(), reservaServicio.getFechayhoraf(), 
        reservaServicio.getSpas_nombre().getNombre(), reservaServicio.getSalones_nombre().getNombre(),
        reservaServicio.getConsumos_idConsumo().getIdConsumo(), reservaServicio.getUtensilios_id().getId(), 
        reservaServicio.getPreciofinal());
        return "redirect:/reservasServicio";
    }   

    @GetMapping("/reservasServicio/{idreservas}/delete")
    public String reservaServicioEliminar(@PathVariable("idreservas") Integer idreservas){
        reservaServicioRepository.eleminarReservaServicio(idreservas);
        return "redirect:/reservasServicio";
    }

}
