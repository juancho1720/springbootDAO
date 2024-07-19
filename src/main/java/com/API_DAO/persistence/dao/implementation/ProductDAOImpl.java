package com.API_DAO.persistence.dao.implementation;

import com.API_DAO.persistence.dao.interfaces.IProductDAO;
import com.API_DAO.persistence.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductDAOImpl implements IProductDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return this.em.createQuery("SELECT u FROM Product u").getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(this.em.find(Product.class, id));
    }

    @Override
    @Transactional
    public void saveProduct(Product product) {
        this.em.persist(product);
        this.em.flush();
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        this.em.merge(product);
    }

    @Override
    @Transactional
    public void deleteProduct(Product product) {
        this.em.remove(product);
    }
}
