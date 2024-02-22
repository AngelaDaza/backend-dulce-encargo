package com.dulceencargo.dulceencargo.Controller;

import com.dulceencargo.dulceencargo.Entity.UsuarioTienda;
import com.dulceencargo.dulceencargo.Repository.UsuarioTiendaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/usuariotienda")
public class UsuarioTiendaController {
    private final UsuarioTiendaRepository usuarioTiendaRepository;
    // Constructor
    public UsuarioTiendaController(UsuarioTiendaRepository usuarioTiendaRepository) {
        this.usuarioTiendaRepository = usuarioTiendaRepository;
    }

    // Obtener todos las tiendas
    @GetMapping
    public List<UsuarioTienda> obtenerTodasLasTiendas(){
        return usuarioTiendaRepository.findAll();
    }

    // Obtener tienda por ID
    @GetMapping("/{id}")
    public UsuarioTienda obtenerTiendaPorId(@PathVariable Long id){
        return usuarioTiendaRepository.findById(id).orElse(null);
    }

    // Crear un Nueva Tienda
    @PostMapping
    public UsuarioTienda crearUsuarioTienda(@RequestBody UsuarioTienda usuarioTienda){
        return usuarioTiendaRepository.save(usuarioTienda);
    }

    // Modificar Tienda
    @PutMapping
    public UsuarioTienda modificarUsuarioTienda(@PathVariable Long id, UsuarioTienda nuevoUsuarioTienda){
        return usuarioTiendaRepository.findById(id).map(usuarioTienda-> {
            usuarioTienda.setName(nuevoUsuarioTienda.getName());
            usuarioTienda.setTypeBussines(nuevoUsuarioTienda.getTypeBussines());
            usuarioTienda.setTypeDocument(nuevoUsuarioTienda.getTypeDocument());
            usuarioTienda.setNumberDocument(nuevoUsuarioTienda.getNumberDocument());
            usuarioTienda.setLocality(nuevoUsuarioTienda.getLocality());
            usuarioTienda.setAddress(nuevoUsuarioTienda.getAddress());
            usuarioTienda.setEmail(nuevoUsuarioTienda.getEmail());
            usuarioTienda.setPhone(nuevoUsuarioTienda.getPhone());
            usuarioTienda.setUsername(nuevoUsuarioTienda.getUsername());
            usuarioTienda.setPassword(nuevoUsuarioTienda.getPassword());
            return usuarioTiendaRepository.save(usuarioTienda);
        }).orElse((null));
    }

    // Eliminar Tienda
    @DeleteMapping("/{id}")
    public void eliminarUsuarioTienda(@PathVariable Long id){
        usuarioTiendaRepository.deleteById(id);
    }
}

