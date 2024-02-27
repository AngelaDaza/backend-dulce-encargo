package com.dulceencargo.dulceencargo.Service;

import com.dulceencargo.dulceencargo.Entity.UsuarioCliente;
import com.dulceencargo.dulceencargo.Entity.UsuarioTienda;
import com.dulceencargo.dulceencargo.Repository.UsuarioClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioClienteServiceIMPL implements UsuarioClienteService {
    @Autowired
    private UsuarioClienteRepository usuarioClienteRepository;
    @Override
    public List<UsuarioCliente> obtenerTodosLosUsuariosCliente() {
        List<UsuarioCliente> usuarios = usuarioClienteRepository.findAll();
        return usuarios;
    }

    @Override
    public UsuarioCliente obtenerUsuarioClientePorId(Long id) {
        Optional<UsuarioCliente> optionalUsuario = usuarioClienteRepository.findById(id);
        if (((Optional<?>) optionalUsuario).isPresent()) {
            UsuarioCliente usuarioCliente = optionalUsuario.get();
            return usuarioCliente;
        } else {
            return null;
        }
    }

    @Override
    public UsuarioCliente crearUsuarioCliente(UsuarioCliente usuarioCliente) {
        return usuarioClienteRepository.save(usuarioCliente);
    }

    @Override
    public UsuarioCliente modificarUsuarioCliente(Long id, UsuarioCliente nuevoUsuarioCliente) {
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

    @Override
    public void eliminarUsuarioCliente(Long id) {
        usuarioClienteRepository.deleteById(id);
    }
}
