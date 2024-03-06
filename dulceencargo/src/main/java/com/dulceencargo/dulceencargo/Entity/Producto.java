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
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "producto_seq", sequenceName = "producto_seq")
    private Long id;
    private String name;
    @Column(length = 350)
    private String urlImage;
    private String description;
    private Integer stock;
    private Double regularPrice;
    private Double finalPrice;
    private String category;
    private Double discount;




    @ManyToOne
    @JoinColumn(name = "id_usuarioTienda", nullable = false)
    private UsuarioTienda idTienda;

}
