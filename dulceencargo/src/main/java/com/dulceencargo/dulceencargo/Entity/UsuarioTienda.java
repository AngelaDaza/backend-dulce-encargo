package com.dulceencargo.dulceencargo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioTienda {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String typeDocument;
    private Long numberDocument;
    private String locality;
    private String address;
    private String typeBussines;
    private String email;
    private String phone;
    private String username;
    private String password;
}
