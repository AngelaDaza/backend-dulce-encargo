package com.dulceencargo.dulceencargo.Service;

import com.dulceencargo.dulceencargo.Entity.Compras;
import com.dulceencargo.dulceencargo.Entity.UsuarioCliente;
import com.dulceencargo.dulceencargo.Repository.ComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class ComprasServiceIMPL implements ComprasService{
    @Autowired
    private ComprasRepository comprasRepository;

    @Override
    public List<Compras> obtenerTodasLasCompras() {
        return comprasRepository.findAll();
    }

    @Override
    public Compras obtenerComprasPorId(Long id) {
        return comprasRepository.findById(id).orElse(null);
    }

    @Override
    public List<Compras> obtenerComprasPorStatus(String statusShopping) {
        List<Compras> compras = comprasRepository.findByStatusShopping(statusShopping);
        if(compras != null){
            return compras;
        }  else{
            throw new RuntimeException("No se encontro compras con este estatus.");
        }
    }

    @Override
    public List<Compras> findByHour(String hour) {
        List<Compras> compras = comprasRepository.findByHour(hour);
        if(compras != null){
            return compras;
        }  else{
            throw new RuntimeException("No se encontro compras con este horario.");
        }
    }
/*
    @Override
    public List<Compras> findByUsuarioCliente(UsuarioCliente usuarioCliente) {
        List<Compras> compras = comprasRepository.findByUsuarioCliente(usuarioCliente);
        if(compras != null){
            return compras;
        }  else{
            throw new RuntimeException("No se encontro compras con este usuario cliente.");
        }
    }
    /*
    @Override
    public Compras obtenerComprasPorHora(LocalTime hour) {
        Compras compra = comprasRepository.findByHour(hour);
        if(compra != null){
            return compra;
        }  else{
            throw new RuntimeException("No se encontro compras con este estatus.");
        }
    }*/

    @Override
    public Compras crearCompra(Compras compra) {
        return comprasRepository.save(compra);
    }

    @Override
    public Compras modificarEstadoCompra(Long id, Compras nuevaCompra) {
        return comprasRepository.findById(id).map(compra -> {
            compra.setStatusShopping(nuevaCompra.getStatusShopping());
            return comprasRepository.save(compra);
        }).orElse((null));
    }


}
