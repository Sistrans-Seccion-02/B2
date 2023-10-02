package uniandes.edu.co.proyecto.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.repositorio.ReservaSalonRepository;


@Controller
public class ReservaSalonController {
    @Autowired
    private ReservaSalonRepository reservaSalonRepository;

    @GetMapping("/reservasSalon")
    public String reservasSalon(Model model){
        model.addAttribute("reservasSalon", reservaSalonRepository.darReservasSalon());
        return "reservasSalon";
    }

    @GetMapping("/reservasSalon/new")
    public String reservaSalonForm(Model model){
        model.addAttribute("reservaSalon", new uniandes.edu.co.proyecto.Modelo.ReservaSalon());
        return "reservaSalonNuevo";       
    }

    @PostMapping("/reservasSalon/new/save")
    public String reservaSalonGuardar(@ModelAttribute uniandes.edu.co.proyecto.Modelo.ReservaSalon reservaSalon){
        reservaSalonRepository.insertarReservaSalon(reservaSalon.getDuracion(), reservaSalon.getFecha(), reservaSalon.getNombreSalon().getNombre());
        return "redirect:/reservasSalon";
    
    }

    @GetMapping("/reservasSalon/{idReservaSalon}/edit")
    public String reservaSalonEditarForm(@PathVariable("idReservaSalon") Integer idReservaSalon, Model model){
        uniandes.edu.co.proyecto.Modelo.ReservaSalon reservaSalon= reservaSalonRepository.darReservaSalon(idReservaSalon);
        if(reservaSalon != null){
            model.addAttribute("reservaSalon", reservaSalon);
            return "reservaSalonEditar";
        }
        else{
            return "redirect:/reservasSalon";
        }
    }

    @PostMapping("/reservasSalon/{idReservaSalon}/edit/save")
     public String reservaSalonEditarGuardar(@PathVariable("idReservaSalon") Integer idReservaSalon, @ModelAttribute uniandes.edu.co.proyecto.Modelo.ReservaSalon reservaSalon){
        reservaSalonRepository.actualizarReservaSalon(idReservaSalon, reservaSalon.getDuracion(), reservaSalon.getFecha(), reservaSalon.getNombreSalon().getNombre());
        return "redirect:/reservasSalon";
    }

    @GetMapping("/reservasSalon/{idReservaSalon}/delete")
    public String reservaSalonEliminar(@PathVariable("idReservaSalon") Integer idReservaSalon){
        reservaSalonRepository.eleminarReservaSalon(idReservaSalon);
        return "redirect:/reservasSalon";
    }

    

}
