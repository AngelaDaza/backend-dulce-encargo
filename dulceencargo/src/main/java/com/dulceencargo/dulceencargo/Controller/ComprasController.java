package com.dulceencargo.dulceencargo.Controller;

import com.dulceencargo.dulceencargo.Entity.Compras;
import com.dulceencargo.dulceencargo.Repository.ComprasRepository;
import com.dulceencargo.dulceencargo.Service.ComprasServiceIMPL;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/compras")
public class ComprasController {
    @Autowired
    private final ComprasServiceIMPL comprasServiceIMPL;

    // Constructor
    public ComprasController(ComprasServiceIMPL comprasServiceIMPL) {
        this.comprasServiceIMPL = comprasServiceIMPL;
    }

    // Obtener todas las compras
    @GetMapping
    @RequestMapping(value = "obtenerTodasLasCompras", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerTodasLasCompras(){
        List<Compras> comprasList = this.comprasServiceIMPL.obtenerTodasLasCompras();
        return ResponseEntity.ok(comprasList);
    }

    // Obtener compra por ID
    @GetMapping
    @RequestMapping(value = "obtenerComprasPorId/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerComprasPorId(@PathVariable Long id){
        Compras compra = this.comprasServiceIMPL.obtenerComprasPorId(id);
        return ResponseEntity.ok(compra);
    }
    // Obtener compras por status
    @GetMapping
    @RequestMapping(value = "obtenerComprasPorStatus/{statusShopping}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerComprasPorStatus(@PathVariable String statusShopping){
        List<Compras> compra = this.comprasServiceIMPL.obtenerComprasPorStatus(statusShopping);
        return ResponseEntity.ok(compra);
    }

    // Crear una Nueva Compra
    @PostMapping
    @RequestMapping(value = "crearCompra", method = RequestMethod.POST)
    public ResponseEntity<?> crearCompra(@PathVariable String statusShopping){
        List<Compras> compra = this.comprasServiceIMPL.obtenerComprasPorStatus(statusShopping);
        return ResponseEntity.ok(compra);
    }
/*
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
    }*/
}
