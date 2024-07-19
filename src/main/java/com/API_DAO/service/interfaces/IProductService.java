package com.API_DAO.service.interfaces;

import com.API_DAO.presentation.dto.MakerDTO;
import com.API_DAO.presentation.dto.ProductDTO;

import java.util.List;

public interface IProductService {

    ProductDTO createProduct(ProductDTO productDTO);
    List<ProductDTO> findAll();
    ProductDTO findById(Long id);
    ProductDTO updateUser(ProductDTO productDTO, Long id);
    String deleteUser(Long id);
}
