package com.dulceencargo.dulceencargo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String urlImage;
    private String description;
    private Integer stock;
    private Double regularPrice;
    private Double finalPrice;
    private String category;
    private Double discount;

}
