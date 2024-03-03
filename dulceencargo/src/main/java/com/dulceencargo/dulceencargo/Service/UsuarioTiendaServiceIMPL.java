package com.dulceencargo.dulceencargo.Service;

import com.dulceencargo.dulceencargo.Entity.Producto;
import com.dulceencargo.dulceencargo.Entity.UsuarioCliente;
import com.dulceencargo.dulceencargo.Entity.UsuarioTienda;
import com.dulceencargo.dulceencargo.Repository.UsuarioTiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioTiendaServiceIMPL implements UsuarioTiendaService {
    @Autowired
    private UsuarioTiendaRepository usuarioTiendaRepository;
    @Override
    public List<UsuarioTienda> obtenerTodosLosUsuariosTienda() {
        List<UsuarioTienda> usuarios = usuarioTiendaRepository.findAll();
        return usuarios;
    }

    @Override
    public UsuarioTienda obtenerUsuarioTiendaPorId(Long id) {
        Optional<UsuarioTienda> optionalUsuario = usuarioTiendaRepository.findById(id);
        if (((Optional<?>) optionalUsuario).isPresent()) {
            UsuarioTienda usuarioTienda = optionalUsuario.get();
            return usuarioTienda;
        } else {
            return null;
        }
    }

    @Override
    public UsuarioTienda crearUsuarioTienda(UsuarioTienda usuarioTienda) {
        return usuarioTiendaRepository.save(usuarioTienda);
    }

    @Override
    public UsuarioTienda modificarUsuarioTienda(Long id, UsuarioTienda nuevoUsuarioTienda) {
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

    @Override
    public void eliminarUsuarioTienda(Long id) {
        usuarioTiendaRepository.deleteById(id);
    }

    @Override
    public Optional<UsuarioTienda> findByUsernameAndPassword(String username, String password) {
        return usuarioTiendaRepository.findByUsernameAndPassword(username, password);
    }
}
