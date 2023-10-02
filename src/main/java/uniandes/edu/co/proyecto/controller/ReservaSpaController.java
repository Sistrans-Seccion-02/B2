package uniandes.edu.co.proyecto.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.repositorio.ReservaSpaRepository;

@Controller
public class ReservaSpaController {
    @Autowired
    private ReservaSpaRepository reservaSpaRepository;

    @GetMapping("/reservasSpa")
    public String reservasSpa(Model model){
        model.addAttribute("reservasSpa", reservaSpaRepository.darReservasSpa());
        return "reservasSpa";
    }

    @GetMapping("/reservasSpa/new")
    public String reservaSpaForm(Model model){
        model.addAttribute("reservaSpa", new uniandes.edu.co.proyecto.Modelo.ReservaSpa());
        return "reservaSpaNuevo";       
    }

    @PostMapping("/reservasSpa/new/save")
    public String reservaSpaGuardar(@ModelAttribute uniandes.edu.co.proyecto.Modelo.ReservaSpa reservaSpa){
        reservaSpaRepository.insertarReservaSpa(reservaSpa.getDuracion(), reservaSpa.getFecha(), reservaSpa.getNombreSpa().getNombre());
        return "redirect:/reservasSpa";
    
    }

    @GetMapping("/reservasSpa/{idReservaSpa}/edit")
    public String reservaSpaEditarForm(@PathVariable("idReservaSpa") Integer idReservaSpa, Model model){
        uniandes.edu.co.proyecto.Modelo.ReservaSpa reservaSpa= reservaSpaRepository.darReservaSpa(idReservaSpa);
        if(reservaSpa != null){
            model.addAttribute("reservaSpa", reservaSpa);
            return "reservaSpaEditar";
        }
        else{
            return "redirect:/reservasSpa";
        }
    }

    @PostMapping("/reservasSpa/{idReservaSpa}/edit/save")
     public String reservaSpaEditarGuardar(@PathVariable("idReservaSpa") Integer idReservaSpa, @ModelAttribute uniandes.edu.co.proyecto.Modelo.ReservaSpa reservaSpa){
        reservaSpaRepository.actualizarReservaSpa(idReservaSpa, reservaSpa.getDuracion(), reservaSpa.getFecha(), reservaSpa.getNombreSpa().getNombre());
        return "redirect:/reservasSpa";
    }

    @GetMapping("/reservasSpa/{idReservaSpa}/delete")
    public String reservaSpaEliminar(@PathVariable("idReservaSpa") Integer idReservaSpa){
        reservaSpaRepository.eleminarReservaSpa(idReservaSpa);
        return "redirect:/reservasSpa";
    }

}
