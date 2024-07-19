package com.API_DAO.persistence.dao.interfaces;

import com.API_DAO.persistence.entities.Product;

import java.util.List;
import java.util.Optional;

public interface IProductDAO {

    List<Product> findAll();
    Optional<Product> findById(Long id);
    void saveProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Product product);
}
