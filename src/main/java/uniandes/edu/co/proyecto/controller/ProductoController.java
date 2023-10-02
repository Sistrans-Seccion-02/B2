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
import uniandes.edu.co.proyecto.Modelo.Producto;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;

/*@Controller*/
@RestController
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/productos")
    public String productos(Model model) {
        model.addAttribute("productos", productoRepository.darProductos());
        return model.toString();
    }
    
    @GetMapping("/productos/new")
    public String productoForm(Model model) {
        model.addAttribute("producto", new Producto());
        return "productoNuevo";
    }

    @PostMapping("/productos/new/save")
    public String productoGuardar(@ModelAttribute Producto producto) {
        productoRepository.insertarProducto(producto.getNombre(), producto.getPrecio(), producto.getsMercado().getNombre(), producto.getTienda().getNombre());
        return "redirect:/productos";
    }

    @GetMapping("/productos/{nombre}/edit") 
    public String productoEditarForm(@PathVariable("nombre") String nombre, Model model) {
        Producto producto = productoRepository.darProducto(nombre);
        if (producto != null) {
            model.addAttribute("nombre", nombre);
            return "productoEditar";
        } else {
            return "redirect:/productos";
        }
    }

    @PostMapping("/productos/{nombre}/edit/save")
    public String productoEditarGuardar(@PathVariable("nombre") String nombre, @ModelAttribute Producto producto) {
        productoRepository.actualizarProducto(nombre, producto.getPrecio(), producto.getsMercado().getNombre(), producto.getTienda().getNombre());
        return "redirect:/productos";
    }

    @GetMapping("/productos/{nombre}/delete")
    public String productoEliminar(@PathVariable("nombre") String nombre) {
        productoRepository.eliminarProducto(nombre);
        return "redirect:/productos";
    }
}



