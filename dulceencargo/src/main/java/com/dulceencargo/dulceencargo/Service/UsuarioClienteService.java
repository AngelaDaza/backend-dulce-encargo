package com.dulceencargo.dulceencargo.Service;

import com.dulceencargo.dulceencargo.Entity.UsuarioCliente;

import java.util.List;
import java.util.Optional;

public interface UsuarioClienteService {
    // Obtener todos los usuarios
    public List<UsuarioCliente> obtenerTodosLosUsuariosCliente();

    // Obtener usuario por ID
    public UsuarioCliente obtenerUsuarioClientePorId(Long id);

    // Crear un Nuevo usuario
    public UsuarioCliente crearUsuarioCliente(UsuarioCliente usuarioCliente);

    // Modificar usuario
    public UsuarioCliente modificarUsuarioCliente(Long id, UsuarioCliente nuevoUsuarioCliente);

    //Eliminar usuario
    public void eliminarUsuarioCliente (Long id);

    public Optional<UsuarioCliente> findByUsernameAndPassword(String username, String password);
}
