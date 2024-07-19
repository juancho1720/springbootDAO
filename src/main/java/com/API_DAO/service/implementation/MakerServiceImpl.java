package com.API_DAO.service.implementation;

import com.API_DAO.persistence.dao.interfaces.IMakerDAO;
import com.API_DAO.persistence.entities.Maker;
import com.API_DAO.presentation.dto.MakerDTO;
import com.API_DAO.service.interfaces.IMakerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MakerServiceImpl implements IMakerService {

    @Autowired
    IMakerDAO makerDAO;

    @Override
    public MakerDTO createMaker(MakerDTO makerDTO) {

        try{
            ModelMapper modelMapper = new ModelMapper();
            Maker maker = modelMapper.map(makerDTO, Maker.class);
            this.makerDAO.saveMaker(maker);
            return makerDTO;

        }catch(Exception e) {
            throw new UnsupportedOperationException("Error al guardar el fabricante");
        }

    }

    @Override
    public List<MakerDTO> findAll() {

        ModelMapper modelMapper = new ModelMapper();

        return this.makerDAO.findAll()
                .stream()
                .map(maker -> modelMapper.map(maker, MakerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public MakerDTO findById(Long id) {

        Optional<Maker> maker = this.makerDAO.findByID(id);

        if(maker.isPresent()){
            ModelMapper modelMapper = new ModelMapper();
            Maker currentMaker = maker.get();

            return modelMapper.map(currentMaker, MakerDTO.class);
        }else {
            return new MakerDTO();
        }
    }

    @Override
    public MakerDTO updateUser(MakerDTO makerDTO, Long id) {

        Optional<Maker> maker = this.makerDAO.findByID(id);

        if(maker.isPresent()){
            Maker currentMaker = maker.get();
            currentMaker.setName(makerDTO.getName());

            this.makerDAO.updateMaker(currentMaker);

            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(currentMaker, MakerDTO.class);
        }else{
            throw new IllegalArgumentException("El usuario no existe");
        }
    }

    @Override
    public String deleteUser(Long id) {

        Optional<Maker> maker = this.makerDAO.findByID(id);

        if(maker.isPresent()){
            Maker currentMaker = maker.get();

            this.makerDAO.deleteMaker(currentMaker);

            return "Usuario eliminado";
        }

        return "El usuario no existe";
    }
}
