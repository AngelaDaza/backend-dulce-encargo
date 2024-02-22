package com.dulceencargo.dulceencargo.Controller;

import com.dulceencargo.dulceencargo.Entity.Producto;
import com.dulceencargo.dulceencargo.Repository.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/productos")
public class ProductoController {
    private final ProductoRepository productoRepository;

    // Constructor
    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Obtener todos los productos
    @GetMapping
    public List<Producto> obtenerTodosLosProductos(){
        List<Producto> productos = productoRepository.findAll();
        for(Producto producto: productos){
            calculateDiscount(producto);
        }
        return productos;
    }

    // Obtener producto por ID
    @GetMapping("/productos/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id) {
        Optional<Producto> optionalProducto = productoRepository.findById(id);
        if (((Optional<?>) optionalProducto).isPresent()) {
            Producto producto = optionalProducto.get();
            calculateDiscount(producto); // Calcular el descuento para el producto
            return producto;
        } else {
            return null;
        }
    }
    
    private void calculateDiscount(Producto producto) {
        producto.setDiscount(producto.getRegularPrice() - producto.getFinalPrice());
    }

    // Crear un Nuevo Producto
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto){
        return productoRepository.save(producto);
    }

    // Modificar producto
    @PutMapping("/{id}")
    public Producto modificarProducto(@PathVariable Long id, Producto nuevoProducto){
        return productoRepository.findById(id).map(producto -> {
            producto.setName(nuevoProducto.getName());
            producto.setUrlImage(nuevoProducto.getUrlImage());
            producto.setDescription(nuevoProducto.getDescription());
            producto.setStock(nuevoProducto.getStock());
            producto.setRegularPrice(nuevoProducto.getRegularPrice());
            producto.setFinalPrice(nuevoProducto.getFinalPrice());
            producto.setCategory(nuevoProducto.getCategory());
            return productoRepository.save(producto);
        }).orElse((null));
    }

    // Eliminar Producto
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id){
        productoRepository.deleteById(id);
    }
}
