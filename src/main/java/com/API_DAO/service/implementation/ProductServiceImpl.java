package com.API_DAO.service.implementation;

import com.API_DAO.persistence.dao.interfaces.IProductDAO;
import com.API_DAO.persistence.entities.Product;
import com.API_DAO.presentation.dto.MakerDTO;
import com.API_DAO.presentation.dto.ProductDTO;
import com.API_DAO.service.interfaces.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDAO productDAO;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        try{
            ModelMapper modelMapper = new ModelMapper();
            Product product = modelMapper.map(productDTO, Product.class);

            this.productDAO.saveProduct(product);

            return productDTO;
        }catch (Exception e){
            throw new UnsupportedOperationException("Error al guardar el producto");
        }
    }

    @Override
    public List<ProductDTO> findAll() {

        ModelMapper modelMapper = new ModelMapper();

        return this.productDAO.findAll()
                .stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO findById(Long id) {

        Optional<Product> product = this.productDAO.findById(id);

        if(product.isPresent()){
            ModelMapper modelMapper = new ModelMapper();
            Product currentProduct = product.get();

            return modelMapper.map(currentProduct, ProductDTO.class);
        }else {

            return new ProductDTO();
        }

    }

    @Override
    public ProductDTO updateUser(ProductDTO productDTO, Long id) {

        Optional<Product> product = this.productDAO.findById(id);

        if(product.isPresent()){
            Product currentProduct = product.get();
            currentProduct.setName(productDTO.getName());
            currentProduct.setPrice(productDTO.getPrice());
            currentProduct.setMaker(productDTO.getMaker());

            this.productDAO.updateProduct(currentProduct);

            ModelMapper modelMapper = new ModelMapper();

            return modelMapper.map(currentProduct, ProductDTO.class);
        }else {
            throw new IllegalArgumentException("El producto no existe");
        }
    }

    @Override
    public String deleteUser(Long id) {

        Optional<Product> product = this.productDAO.findById(id);

        if(product.isPresent()){
            Product currentProduct = product.get();
            this.productDAO.deleteProduct(currentProduct);

            return "Producto eliminado";
        }else {

            return "El producto no existe";
        }
    }
}
