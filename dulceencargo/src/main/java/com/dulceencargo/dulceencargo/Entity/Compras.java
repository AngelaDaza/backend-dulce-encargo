package com.dulceencargo.dulceencargo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Compras {
    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    private Integer amount;
    @Column(columnDefinition = "TIME")
    private LocalTime hour;
    private String statusShopping;
}
