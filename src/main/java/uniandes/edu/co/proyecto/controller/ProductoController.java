package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Producto;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;
import org.springframework.stereotype.Controller;


@Controller
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/productos")
    public String productos(Model model) {
        model.addAttribute("productos", productoRepository.darProductos());
        return "Productos";
    }
    
    @GetMapping("/productos/new")
    public String productoForm(Model model) {
        model.addAttribute("producto", new Producto());
        return "ProductoNuevo";
    }

    @PostMapping("/productos/new/save")
    public String productoGuardar(@ModelAttribute Producto producto) {
        productoRepository.insertarProducto(producto.getNombre(), producto.getConsumoid().getId(), producto.getTiendaid().getId(), producto.getSmercadoid().getId(), producto.getPreciofinal());
        return "redirect:/productos";
    }

    @GetMapping("/productos/{id}/edit") 
    public String productoEditarForm(@PathVariable("id") Integer id, Model model) {
        Producto producto = productoRepository.darProducto(id);
        if (producto != null) {
            model.addAttribute("producto", producto);
            return "productoEditar";
        } else {
            return "redirect:/productos";
        }
    }

    @PostMapping("/productos/{id}/edit/save")
    public String productoEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Producto producto) {
        productoRepository.actualizarProducto(id,producto.getNombre(),producto.getConsumoid().getId(), producto.getTiendaid().getId(), producto.getSmercadoid().getId(), producto.getPreciofinal());
        return "redirect:/productos";
    }

    @GetMapping("/productos/{id}/delete")
    public String productoEliminar(@PathVariable("id") Integer id) {
        productoRepository.eliminarProducto(id);
        return "redirect:/productos";
    }
}




