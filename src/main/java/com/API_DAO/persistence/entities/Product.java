package com.API_DAO.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "producto")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "nombre")
    private String name;

    @JoinColumn(name = "precio")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "id_fabricante", nullable = false)
    private Maker maker;
}
