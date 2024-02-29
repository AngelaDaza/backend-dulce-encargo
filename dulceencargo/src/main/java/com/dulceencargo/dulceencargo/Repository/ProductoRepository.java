package com.dulceencargo.dulceencargo.Repository;

import com.dulceencargo.dulceencargo.Entity.Compras;
import com.dulceencargo.dulceencargo.Entity.Producto;
import com.dulceencargo.dulceencargo.Entity.UsuarioTienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Obtener producto por nombre
    List<Producto> findByName(String name);

    //Obtener producto por categoria
    List<Producto> findByCategory(String category);

    //Ordenar precio final por mayor precio
    List<Producto> findAllByOrderByFinalPriceDesc();

    //Ordenar precio final por menor precio
    List<Producto> findAllByOrderByFinalPriceAsc();

    List<Producto> findByIdTienda(UsuarioTienda idTienda);
}
