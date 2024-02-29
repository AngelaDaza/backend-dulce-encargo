package com.dulceencargo.dulceencargo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Compras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private Integer amount;
    @Column
    private String hour;
    @Column(name = "status_shopping")
    private String statusShopping;

    @ManyToOne
    @JoinColumn(name = "id_usuario_cliente")
    private UsuarioCliente usuarioCliente;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
    /*
    @ManyToOne
    @JoinColumn(name= "id_usuarioCliente", nullable = false)
    @JsonManagedReference
    private UsuarioCliente idUsuarioCliente;

    @ManyToOne
    @JoinColumn(name="id_producto", nullable = false)
    @JsonManagedReference
    private Producto idProducto;*/

}
