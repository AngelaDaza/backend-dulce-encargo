package com.dulceencargo.dulceencargo.Controller;

import com.dulceencargo.dulceencargo.Entity.Compras;
import com.dulceencargo.dulceencargo.Repository.ComprasRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/compras")
public class ComprasController {
    private final ComprasRepository comprasRepository;

    // Constructor
    public ComprasController(ComprasRepository comprasRepository) {
        this.comprasRepository = comprasRepository;
    }

    // Obtener todas las compras
    @GetMapping
    public List<Compras> obtenerTodasLasCompras(){
        return comprasRepository.findAll();
    }

    // Obtener compra por ID
    @GetMapping("/{id}")
    public Compras obtenerComprasPorId(@PathVariable Long id){
        return comprasRepository.findById(id).orElse(null);
    }

    // Crear una Nueva Compra
    @PostMapping
    public Compras crearCompra(@RequestBody Compras compra){
        return comprasRepository.save(compra);
    }

    // Modificar compra por estado
    @PutMapping("/{id}")
    public Compras modificarEstadoCompra(@PathVariable Long id, @RequestBody Compras nuevaCompra){
        return comprasRepository.findById(id).map(compra -> {
            compra.setStatusShopping(nuevaCompra.getStatusShopping());
            return comprasRepository.save(compra);
        }).orElse((null));
    }
}
