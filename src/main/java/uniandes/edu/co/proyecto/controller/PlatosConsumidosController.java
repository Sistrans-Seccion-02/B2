package uniandes.edu.co.proyecto.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Consumo;
import uniandes.edu.co.proyecto.Modelo.ConsumoBebidas;
import uniandes.edu.co.proyecto.Modelo.ConsumoBebidasPK;
import uniandes.edu.co.proyecto.Modelo.PlatosConsumidos;
import uniandes.edu.co.proyecto.Modelo.PlatosConsumidosPK;
import uniandes.edu.co.proyecto.repositorio.ConsumoRepository;
import uniandes.edu.co.proyecto.repositorio.PlatoRepository;
import uniandes.edu.co.proyecto.repositorio.PlatosConsumidosRepository;


@Controller
public class PlatosConsumidosController {
    @Autowired
    private PlatosConsumidosRepository platosConsumidosRepository;

    @Autowired
    private ConsumoRepository consumoRepository;

    @Autowired
    private PlatoRepository platoRepository;

    // @GetMapping("/platosConsumidos")
    // public String platosConsumidos(Model model){
    //     model.addAttribute("platosConsumidos", platosConsumidosRepository.darPlatosConsumidos());
    //     return "platosConsumidos";
    // }

    // @GetMapping("/platosConsumidos/new")
    // public String platosConsumidosForm(Model model){
    //     model.addAttribute("platosConsumidos", new uniandes.edu.co.proyecto.Modelo.PlatosConsumidos());
    //     return "platosConsumidosNuevo";       
    // }

    @GetMapping("/platosConsumidos/new")
    public String platosConsumidosForm(Model model){
        model.addAttribute("platosConsumidos", new uniandes.edu.co.proyecto.Modelo.PlatosConsumidos());
        model.addAttribute("consumos", consumoRepository.darConsumos());
        model.addAttribute("platos", platoRepository.darPlatos());
        return "platosConsumidosNuevo";       
    }

    @PostMapping("/platosConsumidos/new/save")
    public String platosConsumidosGuardar(@ModelAttribute("idConsumo")Integer idConsumo, @ModelAttribute("nombrePlato") String nombrePlato){
        PlatosConsumidos platosConsumidos = new PlatosConsumidos();
        PlatosConsumidosPK pk = new PlatosConsumidosPK(consumoRepository.darConsumo(idConsumo), platoRepository.darPlato(nombrePlato));
        platosConsumidos.setPk(pk);
        platosConsumidosRepository.insertarPlatoConsumido(platosConsumidos.getPk().getConsumos_IdConsumo().getIdConsumo(), platosConsumidos.getPk().getPlatos_nombre().getNombre());
        return "redirect:/platosConsumidos";
    }

}
