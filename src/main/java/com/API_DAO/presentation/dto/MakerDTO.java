package com.API_DAO.presentation.dto;

import com.API_DAO.persistence.entities.Product;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MakerDTO {

    private Long id;
    private String name;
    private List<Product> products = new ArrayList<>();
}
