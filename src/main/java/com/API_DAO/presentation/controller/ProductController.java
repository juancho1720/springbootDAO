package com.API_DAO.presentation.controller;

import com.API_DAO.presentation.dto.ProductDTO;
import com.API_DAO.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/find")
    public ResponseEntity<List<ProductDTO>> findAll(){

        return new ResponseEntity<>(this.productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){

        return new ResponseEntity<>(this.productService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){

        return new ResponseEntity<>(this.productService.createProduct(productDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO, @PathVariable Long id){

        return new ResponseEntity<>(this.productService.updateUser(productDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){

        return new ResponseEntity<>(this.productService.deleteUser(id), HttpStatus.NO_CONTENT);
    }
}
