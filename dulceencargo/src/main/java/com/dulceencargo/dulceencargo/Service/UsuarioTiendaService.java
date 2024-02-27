package com.dulceencargo.dulceencargo.Service;

import com.dulceencargo.dulceencargo.Entity.UsuarioCliente;
import com.dulceencargo.dulceencargo.Entity.UsuarioTienda;

import java.util.List;

public interface UsuarioTiendaService {
    // Obtener todos los usuarios
    public List<UsuarioTienda> obtenerTodosLosUsuariosTienda();

    // Obtener usuario por ID
    public UsuarioTienda obtenerUsuarioTiendaPorId(Long id);

    // Crear un Nuevo usuario
    public UsuarioTienda crearUsuarioTienda(UsuarioTienda usuarioTienda);

    // Modificar usuario
    public UsuarioTienda modificarUsuarioTienda(Long id, UsuarioTienda nuevoUsuarioTienda);

    //Eliminar usuario
    public void eliminarUsuarioTienda (Long id);
}
