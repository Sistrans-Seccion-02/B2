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
    public String reservasSalon(Model model){
        model.addAttribute("reservasServicio",reservaServicioRepository.darReservasServicio());
        return "reservasServicio";
    }

    @GetMapping("/reservasServicio/new")
    public String reservaSalonForm(Model model){
        model.addAttribute("reservaSalon", new ReservaServicio());
        return "reservaServicioNuevo";       
    }

    @PostMapping("/reservasServicio/new/save")
    public String reservaSalonGuardar(@ModelAttribute ReservaServicio reservaServicio){
        reservaServicioRepository.insertarReservaServicio(reservaServicio.getFechayhorai(), reservaServicio.getFechayhoraf(), 
        reservaServicio.getSpas_nombre().getNombre(), reservaServicio.getSalones_nombre().getNombre(),
        reservaServicio.getComsumos_idConsumo().getIdConsumo(), reservaServicio.getUtensilios_id().getId(), 
        reservaServicio.getPreciofinal());
        return "redirect:/reservasServicio";
    }

    @GetMapping("/reservasServicio/{idreservas}/edit")
    public String reservaSalonEditarForm(@PathVariable("idreservas") Integer idreservas, Model model){
        ReservaServicio reservaServicio = reservaServicioRepository.darReservaServicio(idreservas);
        if(reservaServicio != null){
            model.addAttribute("idreservas", idreservas);
            return "reservaServicioEditar";
        }else{
            return "redirect:/reservasServicio";
        }
    }

    @PostMapping("/reservasServicio/{idreservas}/edit/save")    
    public String reservaSalonEditarGuardar(@PathVariable("idreservas") Integer idreservas, @ModelAttribute ReservaServicio reservaServicio){
        reservaServicioRepository.actualizarReservaServicio(idreservas, reservaServicio.getFechayhorai(), reservaServicio.getFechayhoraf(), 
        reservaServicio.getSpas_nombre().getNombre(), reservaServicio.getSalones_nombre().getNombre(),
        reservaServicio.getComsumos_idConsumo().getIdConsumo(), reservaServicio.getUtensilios_id().getId(), 
        reservaServicio.getPreciofinal());
        return "redirect:/reservasServicio";
    }   

    @GetMapping("/reservasServicio/{idreservas}/delete")
    public String reservaSalonEliminar(@PathVariable("idreservas") Integer idreservas){
        reservaServicioRepository.eleminarReservaServicio(idreservas);
        return "redirect:/reservasServicio";
    }

}
