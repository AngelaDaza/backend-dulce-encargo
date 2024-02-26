package com.dulceencargo.dulceencargo.Service;

import com.dulceencargo.dulceencargo.Entity.Compras;
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
        Compras compra = comprasRepository.findByStatusShopping(statusShopping);
        if(compra != null){
            return (List<Compras>) compra;
        }  else{
            throw new RuntimeException("No se encontro compras con este estatus.");
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
