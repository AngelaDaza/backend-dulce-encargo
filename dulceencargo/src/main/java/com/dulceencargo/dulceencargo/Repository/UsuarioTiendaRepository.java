package com.dulceencargo.dulceencargo.Repository;

import com.dulceencargo.dulceencargo.Entity.UsuarioCliente;
import com.dulceencargo.dulceencargo.Entity.UsuarioTienda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioTiendaRepository extends JpaRepository<UsuarioTienda, Long> {
    Optional<UsuarioTienda> findByUsernameAndPassword(String username, String password);
}
