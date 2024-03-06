package com.dulceencargo.dulceencargo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class UsuarioTienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    /*@OneToMany(cascade = CascadeType.ALL , mappedBy = "idTienda")
    @JsonManagedReference
    private List<Producto> productos;*/
}
