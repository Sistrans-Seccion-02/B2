package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Utensilio;
import uniandes.edu.co.proyecto.repositorio.UtensilioRepository;
import uniandes.edu.co.proyecto.repositorio.ConsumoRepository;

@Controller
public class UtensilioController{
    @Autowired
    private UtensilioRepository utensilioRepository;
    @Autowired
    private ConsumoRepository consumoRepository;

    @GetMapping("/utensilios")
    public String utensilios(Model model){
        model.addAttribute("utensilios", utensilioRepository.darUtensilios());
        model.addAttribute("consumos", consumoRepository.darConsumos());        
        return "Utensilios";
    }
 
    @GetMapping("/utensilios/new")
    public String utensilioForm(Model model){
        model.addAttribute("utensilio", new Utensilio());
        return "UtensilioNuevo";       
    }
    
    @PostMapping("/utensilios/new/save")
    public String utensilioGuardar(@ModelAttribute Utensilio utensilio){
        utensilioRepository.insertarUtensilio(utensilio.getDescripcion(), utensilio.getPrecio(), utensilio.getConsumoid().getId());
        return "redirect:/utensilios";
    
    }

    @GetMapping("/utensilios/{id}/edit")
    public String utensilioEditarForm(@PathVariable("id") Integer id, Model model){
        Utensilio utensilio= utensilioRepository.darUtensilio(id);
        if(utensilio != null){
            model.addAttribute("utensilio", utensilio);
            model.addAttribute("consumos", consumoRepository.darConsumos());
            return "UtensilioEditar";
        }
        else{
            return "redirect:/utensilios";
        }
    }

    @PostMapping("/utensilios/{id}/edit/save")
     public String utensilioEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Utensilio utensilio){
        utensilioRepository.actualizarUtensilio(id,utensilio.getDescripcion(), utensilio.getPrecio(), utensilio.getConsumoid().getId());
        return "redirect:/utensilios";
    }
    
    @GetMapping("/utensilios/{id}/delete")
    public String utensilioEliminar(@PathVariable("id") Integer id){
        utensilioRepository.eliminarUtensilio(id);
        return "redirect:/utensilios";
    }

    @GetMapping("/utensilios/req8")
    public String utensilioReq8(Model model){
        model.addAttribute("utensilios", utensilioRepository.darServiciosMenosConsumidos());
        return "ServicioReq8";
    }

    @GetMapping("/utensilios/req2")
    public String utensilioReq2(Model model, String fechainicial, String fechafinal){
        model.addAttribute("utensilios", utensilioRepository.darServiciosPoplares(fechainicial, fechafinal));
        return "ServicioReq2";
    }

    @GetMapping("/utensilios/req4")
    public String utensilioReq4(Model model, Double precioinicial, Double preciofinal){
        model.addAttribute("utensilios", utensilioRepository.darServicioPorRangoPrecio(precioinicial, preciofinal));
        return "ServicioReq4";
    }

    @GetMapping("/utensilios/req41")
    public String utensilioReq41(Model model, String fechainicial, String fechafinal){
        model.addAttribute("utensilios", utensilioRepository.darServicioPorRangoFecha(fechainicial, fechafinal));
        return "ServicioReq41";
    }

    @GetMapping("/utensilios/req42")
    public String utensilioReq42(Model model, String tipo){
        model.addAttribute("utensilios", utensilioRepository.darServicioPorTipo(tipo));
        return "ServicioReq42";
    }

    @GetMapping("/utensilios/req43")
    public String utensilioReq43(Model model, Integer identifier){
        model.addAttribute("utensilios", utensilioRepository.darServicioPorEmpleado(identifier));
        return "ServicioReq43";
    }

    @GetMapping("/utensilios/req12")
    public String utensilioReq12(Model model){
        model.addAttribute("utensilios", utensilioRepository.darClientesEstrella());
        return "ServicioReq12";
    }
}
