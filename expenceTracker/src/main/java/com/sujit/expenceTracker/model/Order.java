package com.sujit.expenceTracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    private LocalDate Date;
    private LocalTime Time;
    @ManyToOne
    @JoinColumn()
    private User user;

    @ManyToOne
    @JoinColumn(name = "fk_product_id")
    private Product product;
}
