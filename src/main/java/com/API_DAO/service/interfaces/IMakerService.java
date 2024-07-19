package com.API_DAO.service.interfaces;

import com.API_DAO.persistence.entities.Maker;
import com.API_DAO.presentation.dto.MakerDTO;

import java.util.List;

public interface IMakerService {

    MakerDTO createMaker(MakerDTO makerDTO);
    List<MakerDTO> findAll();
    MakerDTO findById(Long id);
    MakerDTO updateUser(MakerDTO makerDTO, Long id);
    String deleteUser(Long id);
}
