package uniandes.edu.co.proyecto.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.repositorio.PlatosConsumidosRepository;


@Controller
public class PlatosConsumidosController {
    @Autowired
    private PlatosConsumidosRepository platosConsumidosRepository;

    @GetMapping("/platosConsumidos")
    public String platosConsumidos(Model model){
        model.addAttribute("platosConsumidos", platosConsumidosRepository.darPlatosConsumidos());
        return "platosConsumidos";
    }

    @GetMapping("/platosConsumidos/new")
    public String platosConsumidosForm(Model model){
        model.addAttribute("platosConsumidos", new uniandes.edu.co.proyecto.Modelo.PlatosConsumidos());
        return "platosConsumidosNuevo";       
    }



}
