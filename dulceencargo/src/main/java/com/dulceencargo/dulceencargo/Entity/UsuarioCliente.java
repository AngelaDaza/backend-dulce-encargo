package com.dulceencargo.dulceencargo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "idUsuarioCliente")
    @JsonIgnore
    private List<Compras> compras;
}