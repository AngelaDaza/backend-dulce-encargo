package com.dulceencargo.dulceencargo.Controller;

import com.dulceencargo.dulceencargo.Entity.UsuarioCliente;
import com.dulceencargo.dulceencargo.Entity.UsuarioTienda;
import com.dulceencargo.dulceencargo.Repository.UsuarioClienteRepository;
import com.dulceencargo.dulceencargo.Service.UsuarioClienteServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/usuariocliente")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UsuarioClienteController<LoginRequest> {
    @Autowired
    private final UsuarioClienteServiceIMPL usuarioClienteServiceIMPL;

    public UsuarioClienteController(UsuarioClienteServiceIMPL usuarioClienteServiceIMPL) {
        this.usuarioClienteServiceIMPL = usuarioClienteServiceIMPL;
    }

    // Obtener todos los usuarios cliente
    @GetMapping
    @RequestMapping(value = "obtenerTodosLosUsuariosCliente", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerTodosLosUsuariosCliente(){
        List<UsuarioCliente> usuariosClienteList = this.usuarioClienteServiceIMPL.obtenerTodosLosUsuariosCliente();
        return ResponseEntity.ok(usuariosClienteList);
    }
    // Obtener cliente por ID
    @GetMapping("/{id}")
    @RequestMapping(value = "obtenerUsuarioClientePorId/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerUsuarioClientePorId(@PathVariable Long id){
        UsuarioCliente usuarioCliente = this.usuarioClienteServiceIMPL.obtenerUsuarioClientePorId(id);
        return ResponseEntity.ok(usuarioCliente);
    }

    // Crear un Nuevo Cliente
    @PostMapping
    @RequestMapping(value = "crearUsuarioCliente", method = RequestMethod.POST)
    public ResponseEntity<?> crearUsuarioCliente(@RequestBody UsuarioCliente usuarioCliente){
        return ResponseEntity.ok(usuarioClienteServiceIMPL.crearUsuarioCliente(usuarioCliente));
    }

    /*@PostMapping
    @RequestMapping(value="validarCredenciales", method = RequestMethod.POST)
    public ResponseEntity<?> validarCredenciales(@RequestBody String username, @RequestBody String password){
        this.usuarioClienteServiceIMPL.findByUsernameAndPassword(username, password);
        return ResponseEntity.ok().build();
    }*/
    @PostMapping
    @RequestMapping(value="validarCredenciales", method = RequestMethod.POST)
    public ResponseEntity<?> validarCredenciales(@RequestBody UsuarioCliente usuarioCliente){
        Optional<UsuarioCliente> usuarioValidado = usuarioClienteServiceIMPL.findByUsernameAndPassword(usuarioCliente.getUsername(), usuarioCliente.getPassword());
        if (usuarioValidado.isPresent()) {
            return ResponseEntity.ok().body("Credenciales válidas");
        } else {
            return ResponseEntity.badRequest().body("Credenciales inválidas");
        }
    }

    // Modificar Cliente
    @PutMapping
    @RequestMapping(value = "modificarUsuarioCliente/{id}",method = RequestMethod.PUT)
    public ResponseEntity<?> modificarUsuarioCliente(@PathVariable Long id, @RequestBody UsuarioCliente usuarioCliente){
        UsuarioCliente nuevoUsuarioCliente=this.usuarioClienteServiceIMPL.modificarUsuarioCliente(id, usuarioCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuarioCliente);
    }

    // Eliminar Cliente
    @DeleteMapping
    @RequestMapping(value = "eliminarUsuarioCliente/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminarUsuarioCliente(@PathVariable Long id){
        this.usuarioClienteServiceIMPL.eliminarUsuarioCliente(id);
        return ResponseEntity.ok().build();
    }
}