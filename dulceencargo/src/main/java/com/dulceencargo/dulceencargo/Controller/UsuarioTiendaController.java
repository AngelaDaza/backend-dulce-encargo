package com.dulceencargo.dulceencargo.Controller;

import com.dulceencargo.dulceencargo.Entity.Producto;
import com.dulceencargo.dulceencargo.Entity.UsuarioTienda;
import com.dulceencargo.dulceencargo.Repository.UsuarioTiendaRepository;
import com.dulceencargo.dulceencargo.Service.UsuarioTiendaService;
import com.dulceencargo.dulceencargo.Service.UsuarioTiendaServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/usuariotienda")
public class UsuarioTiendaController {
    @Autowired
    private final UsuarioTiendaServiceIMPL usuarioTiendaServiceIMPL;

    public UsuarioTiendaController(UsuarioTiendaServiceIMPL usuarioTiendaServiceIMPL) {
        this.usuarioTiendaServiceIMPL = usuarioTiendaServiceIMPL;
    }

    // Obtener todos los usuarios tienda
    @GetMapping
    @RequestMapping(value = "obtenerTodosLosUsuariosTienda", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerTodosLosUsuariosTienda(){
        List<UsuarioTienda> usuariosTiendaList = this.usuarioTiendaServiceIMPL.obtenerTodosLosUsuariosTienda();
        return ResponseEntity.ok(usuariosTiendaList);
    }

    // Obtener tienda por ID
    @GetMapping("/{id}")
    @RequestMapping(value = "obtenerUsuarioTiendaPorId/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerUsuarioTiendaPorId(@PathVariable Long id){
        UsuarioTienda usuarioTienda = this.usuarioTiendaServiceIMPL.obtenerUsuarioTiendaPorId(id);
        return ResponseEntity.ok(usuarioTienda);
    }

    // Crear un Nueva Tienda
    @PostMapping
    @RequestMapping(value = "crearUsuarioTienda", method = RequestMethod.POST)
    public ResponseEntity<?> crearUsuarioTienda(@RequestBody UsuarioTienda usuarioTienda){
        return ResponseEntity.ok(usuarioTiendaServiceIMPL.crearUsuarioTienda(usuarioTienda));
    }

    // Modificar Tienda
    @PutMapping
    @RequestMapping(value = "modificarUsuarioTienda/{id}",method = RequestMethod.PUT)
    public ResponseEntity<?> modificarUsuarioTienda(@PathVariable Long id, @RequestBody UsuarioTienda usuarioTienda){
        UsuarioTienda nuevoUsuarioTienda=this.usuarioTiendaServiceIMPL.modificarUsuarioTienda(id, usuarioTienda);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuarioTienda);
    }

    // Eliminar Tienda
    @DeleteMapping
    @RequestMapping(value = "eliminarUsuarioTienda/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminarUsuarioTienda(@PathVariable Long id){
        this.usuarioTiendaServiceIMPL.eliminarUsuarioTienda(id);
        return ResponseEntity.ok().build();
    }
}

