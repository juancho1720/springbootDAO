package com.API_DAO.persistence.dao.interfaces;

import com.API_DAO.persistence.entities.Maker;

import java.util.List;
import java.util.Optional;

public interface IMakerDAO {

    List<Maker> findAll();
    Optional<Maker> findByID(Long id);
    void saveMaker(Maker maker);
    void updateMaker(Maker maker);
    void deleteMaker(Maker maker);
}
