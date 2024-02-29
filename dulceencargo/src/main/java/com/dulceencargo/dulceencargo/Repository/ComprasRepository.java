package com.dulceencargo.dulceencargo.Repository;

import com.dulceencargo.dulceencargo.Entity.Compras;
import com.dulceencargo.dulceencargo.Entity.UsuarioCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalTime;
import java.util.List;

public interface ComprasRepository extends JpaRepository<Compras, Long> {
    // Obtener compra por estado

    List<Compras> findByStatusShopping(String statusShopping);

    //Obtener compra por hora
    List<Compras> findByHour(String hour);

    //Obtener compras por usuario cliente
    //List<Compras> findByUsuarioCliente(UsuarioCliente usuarioCliente);

/*
    @Query("SELECT * FROM compras WHERE compras.hour = +get")
    Compras findByHour(LocalTime hour);*/
}
