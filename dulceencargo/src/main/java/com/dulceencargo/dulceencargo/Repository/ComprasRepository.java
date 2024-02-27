package com.dulceencargo.dulceencargo.Repository;

import com.dulceencargo.dulceencargo.Entity.Compras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalTime;
import java.util.List;

public interface ComprasRepository extends JpaRepository<Compras, Long> {
    // Obtener compra por estado

    List<Compras> findByStatusShopping(String statusShopping);
/*
    @Query("SELECT * FROM compras WHERE compras.hour = +get")
    Compras findByHour(LocalTime hour);*/
}
