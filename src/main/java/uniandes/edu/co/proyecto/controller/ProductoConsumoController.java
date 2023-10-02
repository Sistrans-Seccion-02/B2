package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import oracle.jdbc.proxy.annotation.Post;
import uniandes.edu.co.proyecto.Modelo.Consumo;
import uniandes.edu.co.proyecto.Modelo.Producto;
import uniandes.edu.co.proyecto.Modelo.ProductoConsumo;
import uniandes.edu.co.proyecto.Modelo.ProductoConsumoPK;
import uniandes.edu.co.proyecto.repositorio.ConsumoRepository;
import uniandes.edu.co.proyecto.repositorio.ProductoConsumoRepository;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;

/*@Controller*/
@RestController
public class ProductoConsumoController {
    @Autowired
    private ProductoConsumoRepository productoConsumoRepository;

    @Autowired
    private ProductoRepository productoRepository;
    
    @Autowired
    private ConsumoRepository consumoRepository;
    

    /*
    @GetMapping("/productos")
    public String productos(Model model) {
        model.addAttribute("productos", productoRepository.darProductoConsumos());
        return model.toString();
    }
    */

    @GetMapping("/productos/new")
    public String productoForm(Model model) {
        model.addAttribute("productos", productoRepository.darProductos());
        model.addAttribute("consumos", consumoRepository.darConsumos());
        return "productoConsumoNuevo";
    }

    /* 
    @PostMapping("/productos/new/save")
    public String productoConsumoGuardar(@ModelAttribute("idConsumo") int idConsumo, @ModelAttribute("nombre") String nombre) {
        Consumo consumo = consumoRepository.darConsumo(idConsumo);
        Producto producto = productoRepository.darProducto(nombre);
        ProductoConsumoPK pk = new ProductoConsumoPK(consumo.getIdConsumo(), producto.getNombre());
        ProductoConsumo productoConsumo = new ProductoConsumo();

        productoRepository.insertarProductoConsumo(producto.getPk().getIdConsumo().getIdConsumo(), producto.getPk().getNombre().getNombre());
        return "redirect:/productos";
    }
    */
    /*
    @GetMapping("/productos/{nombre}/edit") 
    public String productoEditarForm(@PathVariable("nombre") String nombre, Model model) {
        ProductoConsumo producto = productoRepository.darProductoConsumo(nombre);
        if (producto != null) {
            model.addAttribute("nombre", nombre);
            return "productoEditar";
        } else {
            return "redirect:/productos";
        }
    }

    @PostMapping("/productos/{nombre}/edit/save")
    public String productoEditarGuardar(@PathVariable("nombre") String nombre, @ModelAttribute ProductoConsumo producto) {
        productoRepository.actualizarProductoConsumo(nombre, producto.getPrecio(), producto.getsMercado().getNombre(), producto.getTienda().getNombre());
        return "redirect:/productos";
    }

    @GetMapping("/productos/{nombre}/delete")
    public String productoEliminar(@PathVariable("nombre") String nombre) {
        productoRepository.eliminarProductoConsumo(nombre);
        return "redirect:/productos";
    }
    */
}





