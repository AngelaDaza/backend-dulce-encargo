package com.dulceencargo.dulceencargo.Service;

import com.dulceencargo.dulceencargo.Entity.Producto;

import java.util.List;

public interface ProductoService {
    // Obtener todas las compras
    public List<Producto> obtenerTodosLosProductos();

    // Obtener producto por ID
    public Producto obtenerProductoPorId(Long id);


    // Crear un Nuevo producto
    public Producto crearProducto(Producto producto);

    // Modificar producto
    public Producto modificarProducto(Long id, Producto nuevoProducto);

    //Eliminar Producto
    public void eliminarProducto (Long id);

    //Calcular descuento de Producto
    public void calculateDiscount(Producto producto);

    // Obtener producto por nombre
     public List<Producto> findByName(String name);

    //Obtener producto por categoria
    public List<Producto> findByCategory(String category);

    //Ordenar precio final por mayor precio
    public List<Producto> findAllByOrderByFinalPriceDesc();

    //Ordenar precio final por menor precio
    public List<Producto> findAllByOrderByFinalPriceAsc();
}
