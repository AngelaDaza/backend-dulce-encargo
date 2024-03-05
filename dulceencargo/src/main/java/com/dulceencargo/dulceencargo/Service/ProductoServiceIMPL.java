package com.dulceencargo.dulceencargo.Service;

import com.dulceencargo.dulceencargo.Entity.Compras;
import com.dulceencargo.dulceencargo.Entity.Producto;
import com.dulceencargo.dulceencargo.Entity.UsuarioTienda;
import com.dulceencargo.dulceencargo.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductoServiceIMPL implements ProductoService{
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        List<Producto> productos = productoRepository.findAll();
        return productos;
    }

    @Override
    public Producto obtenerProductoPorId(Long id) {
        Optional<Producto> optionalProducto = productoRepository.findById(id);
        if (((Optional<?>) optionalProducto).isPresent()) {
            Producto producto = optionalProducto.get();
            return producto;
        } else {
            return null;
        }
    }

    @Override
    public Producto crearProducto(Producto producto) {
        calculateDiscount(producto); // Calcular el descuento para el producto
        return productoRepository.save(producto);
    }

    @Override
    public Producto modificarProducto(Long id, Producto nuevoProducto) {
        return productoRepository.findById(id).map(producto -> {
            producto.setName(nuevoProducto.getName());
            producto.setUrlImage(nuevoProducto.getUrlImage());
            producto.setDescription(nuevoProducto.getDescription());
            producto.setStock(nuevoProducto.getStock());
            producto.setRegularPrice(nuevoProducto.getRegularPrice());
            producto.setFinalPrice(nuevoProducto.getFinalPrice());
            producto.setCategory(nuevoProducto.getCategory());

            if (Objects.nonNull(nuevoProducto.getIdTienda())){
                producto.setIdTienda(nuevoProducto.getIdTienda());
            }

            return productoRepository.save(producto);
        }).orElse((null));
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public void calculateDiscount(Producto producto) {
        producto.setDiscount(producto.getRegularPrice() - producto.getFinalPrice());
    }

    @Override
    public List<Producto> findByName(String name) {
        List<Producto> productos = productoRepository.findByName(name);
        if(productos != null){
            return productos;
        }  else{
            throw new RuntimeException("No se encontro productos con este nombre.");
        }
    }

    @Override
    public List<Producto> findByCategory(String category) {
        List<Producto> productos = productoRepository.findByCategory(category);
        if(productos != null){
            return productos;
        }  else{
            throw new RuntimeException("No se encontro productos con esta categoria.");
        }
    }

    @Override
    public List<Producto> findByIdTienda(UsuarioTienda idTienda) {
        List<Producto> productos = productoRepository.findByIdTienda(idTienda);
        return productos;
    }

    @Override
    public List<Producto> findAllByOrderByFinalPriceDesc() {
        return productoRepository.findAllByOrderByFinalPriceDesc();
    }

    @Override
    public List<Producto> findAllByOrderByFinalPriceAsc(){
        return productoRepository.findAllByOrderByFinalPriceAsc();
    }
}
