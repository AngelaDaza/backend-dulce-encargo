package com.dulceencargo.dulceencargo.Controller;

import com.dulceencargo.dulceencargo.Entity.Compras;
import com.dulceencargo.dulceencargo.Entity.Producto;
import com.dulceencargo.dulceencargo.Entity.UsuarioTienda;
import com.dulceencargo.dulceencargo.Repository.ProductoRepository;
import com.dulceencargo.dulceencargo.Service.ProductoServiceIMPL;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/productos")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ProductoController {
    @Autowired
    private final ProductoServiceIMPL productoServiceIMPL;

    // Constructor
    public ProductoController(ProductoServiceIMPL productoServiceIMPL) {
        this.productoServiceIMPL = productoServiceIMPL;
    }

    // Obtener todos los productos
    @GetMapping
    @RequestMapping(value = "obtenerTodosLosProductos", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerTodosLosProductos(){
        List<Producto> productosList = this.productoServiceIMPL.obtenerTodosLosProductos();
        return ResponseEntity.ok(productosList);
    }

    // Obtener producto por ID
    @GetMapping("/{id}")
    @RequestMapping(value = "obtenerProductoPorId/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerProductoPorId(@PathVariable Long id){
        Producto producto = this.productoServiceIMPL.obtenerProductoPorId(id);
        return ResponseEntity.ok(producto);
    }

    // Crear un Nuevo Producto
    @PostMapping
    @RequestMapping(value = "crearProducto", method = RequestMethod.POST)
    public ResponseEntity<?> crearProducto(@RequestBody Producto producto){
        return ResponseEntity.ok(productoServiceIMPL.crearProducto(producto));
    }

    // Modificar producto
    @PutMapping
    @RequestMapping(value = "modificarProducto/{id}",method = RequestMethod.PUT)
    public ResponseEntity<?> modificarProducto(@PathVariable Long id, @RequestBody Producto producto){
        Producto nuevoProducto=this.productoServiceIMPL.modificarProducto(id, producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }

    //Eliminar producto
    @DeleteMapping
    @RequestMapping(value = "eliminarProducto/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminarProducto(@PathVariable Long id){
        this.productoServiceIMPL.eliminarProducto(id);
        return ResponseEntity.ok().build();
    }

    // Obtener productos por nombre
    @GetMapping
    @RequestMapping(value = "obtenerProductoPorName/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerProductoPorName(@PathVariable String name){
        List<Producto> productos = this.productoServiceIMPL.findByName(name);
        return ResponseEntity.ok(productos);
    }
    // Obtener productos por nombre
    @GetMapping
    @RequestMapping(value = "obtenerProductoPorCategoria/{category}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerProductoPorCategoria(@PathVariable String category){
        List<Producto> productos = this.productoServiceIMPL.findByCategory(category);
        return ResponseEntity.ok(productos);
    }
    // Obtener productos por tienda
    @GetMapping
    @RequestMapping(value = "obtenerProductoPorIdTienda/{idTienda}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerProductoPorIdTienda(@PathVariable UsuarioTienda idTienda){
        List<Producto> productos = this.productoServiceIMPL.findByIdTienda(idTienda);
        return ResponseEntity.ok(productos);
    }
    // Obtener productos ordenados de mayor a menor
    @GetMapping
    @RequestMapping(value = "obtenerProductoDeMayorAMenor", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerProductoDeMayorAMenor(){
        List<Producto> productos = this.productoServiceIMPL.findAllByOrderByFinalPriceDesc();
        return ResponseEntity.ok(productos);
    }
    // Obtener productos ordenados de menor a mayor
    @GetMapping
    @RequestMapping(value = "obtenerProductoDeMenorAMayor", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerProductoDeMenorAMayor(){
        List<Producto> productos = this.productoServiceIMPL.findAllByOrderByFinalPriceAsc();
        return ResponseEntity.ok(productos);
    }

}
