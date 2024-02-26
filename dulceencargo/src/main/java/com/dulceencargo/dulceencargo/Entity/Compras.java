package com.dulceencargo.dulceencargo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Compras {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate date;
    private Integer amount;
    @Column(columnDefinition = "TIME")
    private LocalTime hour;
    @Column(name = "status_shopping")
    private String statusShopping;
}
