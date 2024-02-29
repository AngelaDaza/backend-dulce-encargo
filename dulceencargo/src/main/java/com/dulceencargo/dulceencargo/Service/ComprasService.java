package com.dulceencargo.dulceencargo.Service;

import com.dulceencargo.dulceencargo.Entity.Compras;
import com.dulceencargo.dulceencargo.Entity.UsuarioCliente;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface ComprasService {

    // Obtener todas las compras
    public List<Compras> obtenerTodasLasCompras();

    // Obtener compra por ID
    public Compras obtenerComprasPorId(Long id);


    // Crear una Nueva Compra
    public Compras crearCompra(Compras compra);

    // Modificar compra por estado
    public Compras modificarEstadoCompra(Long id, Compras nuevaCompra);

    // Obtener compra por estado
    public List<Compras> obtenerComprasPorStatus(String statusShopping);

    //Obtener compra por hora
    public List<Compras> findByHour(String hour);

    //Obtener compras por usuario cliente
    //public List<Compras> findByUsuarioCliente(UsuarioCliente usuarioCliente);
}
