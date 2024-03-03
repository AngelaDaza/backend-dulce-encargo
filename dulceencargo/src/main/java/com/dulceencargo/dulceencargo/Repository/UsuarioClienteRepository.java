package com.dulceencargo.dulceencargo.Repository;

import com.dulceencargo.dulceencargo.Entity.UsuarioCliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioClienteRepository extends JpaRepository<UsuarioCliente, Long> {
    Optional<UsuarioCliente> findByUsernameAndPassword(String username, String password);
}
