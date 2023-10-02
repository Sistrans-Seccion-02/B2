package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Bar;
import uniandes.edu.co.proyecto.Modelo.BarBebida;
import uniandes.edu.co.proyecto.Modelo.BarBebidaPK;
import uniandes.edu.co.proyecto.Modelo.Bebida;
import uniandes.edu.co.proyecto.Modelo.ConsumoBebidas;
import uniandes.edu.co.proyecto.Modelo.ConsumoBebidasPK;
import uniandes.edu.co.proyecto.repositorio.BebidaRepository;
import uniandes.edu.co.proyecto.repositorio.ConsumoBebidasRepository;
import uniandes.edu.co.proyecto.repositorio.ConsumoRepository;


@Controller
public class ConsumoBebidasController {
    @Autowired
    private ConsumoBebidasRepository consumoBebidasRepository;

    @Autowired
    private ConsumoRepository consumoRepository;

    @Autowired
    private BebidaRepository bebidaRepository;

    // @GetMapping("/consumoBebida")
    // public String consumoBebidas(Model model){
    //     model.addAttribute("consumoBebidas", consumoBebidasRepository.darConsumoBebidas());
    //     return "consumoBebidas";
    // }

    // @GetMapping("/consumoBebida/new")
    // public String consumoBebidaForm(Model model){
    //     model.addAttribute("consumoBebida", new ConsumoBebidas());
    //     return "consumoBebidaNuevo";       
    // }

    // @PostMapping("/consumoBebida/new/save")
    // public String consumoBebidaGuardar(@ModelAttribute ConsumoBebidas consumoBebida){
    //     consumoBebidasRepository.insertarConsumoBebida(consumoBebida.getPk().getConsumos_IdConsumo().getIdConsumo(), consumoBebida.getPk().getBebidas_nombre().getNombre());
    //     return "redirect:/consumoBebida";
    
    // }

    // @GetMapping("/consumoBebida/{idConsumo}/{Bebidas_nombre}/edit")
    // public String consumoBebidaEditarForm(@PathVariable("idConsumo") Integer idConsumo, @PathVariable("Bebidas_nombre") String Bebidas_nombre, Model model){
    //     ConsumoBebidas consumoBebida= consumoBebidasRepository.darConsumoBebida(idConsumo, Bebidas_nombre);
    //     if(consumoBebida != null){
    //         model.addAttribute("consumoBebida", consumoBebida);
    //         return "consumoBebidaEditar";
    //     }
    //     else{
    //         return "redirect:/consumoBebida";
    //     }
    // }

    // @PostMapping("/consumoBebida/{idConsumo}/{Bebidas_nombre}/edit/save")
    //  public String consumoBebidaEditarGuardar(@PathVariable("idConsumo") Integer idConsumo, @PathVariable("Bebidas_nombre") String Bebidas_nombre, @ModelAttribute ConsumoBebidas consumoBebida){
    //     consumoBebidasRepository.actualizarConsumoBebida(consumoBebida.getPk().getConsumos_IdConsumo().getIdConsumo(), consumoBebida.getPk().getBebidas_nombre().getNombre());
    //     return "redirect:/consumoBebida";
    // }

    // @GetMapping("/consumoBebida/{idConsumo}/{Bebidas_nombre}/delete")
    // public String consumoBebidaEliminar(@PathVariable("idConsumo") Integer idConsumo, @PathVariable("Bebidas_nombre") String Bebidas_nombre){
    //     consumoBebidasRepository.eleminarConsumoBebida(idConsumo, Bebidas_nombre);
    //     return "redirect:/consumoBebida";
    // }

    @GetMapping("/consumoBebida/new")
    public String consumoBebidaForm(Model model){
        model.addAttribute("consumoBebida", new ConsumoBebidas());
        model.addAttribute("consumos", consumoRepository.darConsumos());
        model.addAttribute("bebidas", bebidaRepository.darBebidas());
        return "consumoBebidaNuevo";       
    }

    @PostMapping("/consumoBebida/new/save")
    public String consumoBebidaGuardar(@ModelAttribute("idConsumo") Integer idConsumo, @ModelAttribute("nombre_bebida") String nombreBebida) {
        ConsumoBebidas consumoBebida = new ConsumoBebidas();
        ConsumoBebidasPK pk = new ConsumoBebidasPK(consumoRepository.darConsumo(idConsumo), bebidaRepository.darBebida(nombreBebida));
        consumoBebida.setPk(pk);
        consumoBebidasRepository.insertarConsumoBebida(consumoBebida.getPk().getConsumos_IdConsumo().getIdConsumo(), consumoBebida.getPk().getBebidas_nombre().getNombre());
        return "redirect:/consumoBebida";
    }


}
