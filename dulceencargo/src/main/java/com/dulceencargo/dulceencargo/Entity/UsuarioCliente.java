package com.dulceencargo.dulceencargo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String typeDocument;
    private Long numberDocument;
    private String locality;
    private String address;
    private String email;
    private String phone;
    private String username;
    private String password;
}