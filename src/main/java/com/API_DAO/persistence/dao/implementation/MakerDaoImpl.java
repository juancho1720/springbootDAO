package com.API_DAO.persistence.dao.implementation;

import com.API_DAO.persistence.dao.interfaces.IMakerDAO;
import com.API_DAO.persistence.entities.Maker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class MakerDaoImpl implements IMakerDAO {

    @PersistenceContext
    private EntityManager em;
    @Override
    @Transactional(readOnly = true)
    public List<Maker> findAll() {
        return this.em.createQuery("SELECT u FROM Maker u").getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Maker> findByID(Long id) {
        return Optional.ofNullable(this.em.find(Maker.class, id));
    }

    @Override
    @Transactional
    public void saveMaker(Maker maker) {
         this.em.persist(maker);
         this.em.flush();
    }

    @Override
    @Transactional
    public void updateMaker(Maker maker) {
        this.em.merge(maker);
    }

    @Override
    @Transactional
    public void deleteMaker(Maker maker) {
        this.em.remove(maker);
    }
}
