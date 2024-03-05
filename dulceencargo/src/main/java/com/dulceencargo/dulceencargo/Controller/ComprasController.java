package com.dulceencargo.dulceencargo.Controller;

import com.dulceencargo.dulceencargo.Entity.Compras;
import com.dulceencargo.dulceencargo.Entity.UsuarioCliente;
import com.dulceencargo.dulceencargo.Repository.ComprasRepository;
import com.dulceencargo.dulceencargo.Service.ComprasServiceIMPL;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/compras")
@CrossOrigin(origins = "http://127.0.0.1:5502")
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
    public ResponseEntity<?> crearCompra(@RequestBody Compras compra){
        return ResponseEntity.ok(comprasServiceIMPL.crearCompra(compra));
    }
    // Obtener compras por hora
    @GetMapping
    @RequestMapping(value = "obtenerComprasPorHora/{hour}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerComprasPorHora(@PathVariable String hour){
        List<Compras> compra = this.comprasServiceIMPL.findByHour(hour);
        return ResponseEntity.ok(compra);
    }
/*
    // Obtener compras por usuario cliente
    @GetMapping
    @RequestMapping(value = "obtenerComprasPorUsuarioCliente/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerComprasPorUsuarioCliente(@PathVariable UsuarioCliente usuarioCliente){
        List<Compras> compra = this.comprasServiceIMPL.findByUsuarioCliente(usuarioCliente);
        return ResponseEntity.ok(compra);
    }*/

    
}
