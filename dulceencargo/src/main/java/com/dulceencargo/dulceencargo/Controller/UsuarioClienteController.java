package com.dulceencargo.dulceencargo.Controller;

import com.dulceencargo.dulceencargo.Entity.UsuarioCliente;
import com.dulceencargo.dulceencargo.Repository.UsuarioClienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/usuariocliente")
public class UsuarioClienteController {
    private final UsuarioClienteRepository usuarioClienteRepository;
    // Constructor
    public UsuarioClienteController(UsuarioClienteRepository usuarioClienteRepository) {
        this.usuarioClienteRepository = usuarioClienteRepository;
    }

    // Obtener todos los clientes
    @GetMapping
    public List<UsuarioCliente> obtenerTodosLosClientes(){
        return usuarioClienteRepository.findAll();
    }

    // Obtener cliente por ID
    @GetMapping("/{id}")
    public UsuarioCliente obtenerClientePorId(@PathVariable Long id){
        return usuarioClienteRepository.findById(id).orElse(null);
    }

    // Crear un Nuevo Cliente
    @PostMapping
    public UsuarioCliente crearUsuarioCliente(@RequestBody UsuarioCliente usuarioCliente){
        return usuarioClienteRepository.save(usuarioCliente);
    }

    // Modificar Cliente
    @PutMapping
    public UsuarioCliente modificarUsuarioCliente(@PathVariable Long id, UsuarioCliente nuevoUsuarioCliente){
        return usuarioClienteRepository.findById(id).map(usuarioCliente-> {
            usuarioCliente.setName(nuevoUsuarioCliente.getName());
            usuarioCliente.setSurname(nuevoUsuarioCliente.getSurname());
            usuarioCliente.setTypeDocument(nuevoUsuarioCliente.getTypeDocument());
            usuarioCliente.setNumberDocument(nuevoUsuarioCliente.getNumberDocument());
            usuarioCliente.setLocality(nuevoUsuarioCliente.getLocality());
            usuarioCliente.setAddress(nuevoUsuarioCliente.getAddress());
            usuarioCliente.setEmail(nuevoUsuarioCliente.getEmail());
            usuarioCliente.setPhone(nuevoUsuarioCliente.getPhone());
            usuarioCliente.setUsername(nuevoUsuarioCliente.getUsername());
            usuarioCliente.setPassword(nuevoUsuarioCliente.getPassword());
            return usuarioClienteRepository.save(usuarioCliente);
        }).orElse((null));
    }

    // Eliminar Cliente
    @DeleteMapping("/{id}")
    public void eliminarUsuarioCliente(@PathVariable Long id){
        usuarioClienteRepository.deleteById(id);
    }
}