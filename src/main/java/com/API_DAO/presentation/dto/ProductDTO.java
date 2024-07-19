package com.API_DAO.presentation.dto;

import com.API_DAO.persistence.entities.Maker;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private BigDecimal price;
    private Maker maker;
}
