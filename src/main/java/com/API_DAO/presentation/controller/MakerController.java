package com.API_DAO.presentation.controller;

import com.API_DAO.presentation.dto.MakerDTO;
import com.API_DAO.service.interfaces.IMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maker")
public class MakerController {

    @Autowired
    private IMakerService makerService;

    @PostMapping("/create")
    public ResponseEntity<MakerDTO> createMaker(@RequestBody MakerDTO makerDTO){

        return new ResponseEntity<>(this.makerService.createMaker(makerDTO), HttpStatus.CREATED);

    }

    @GetMapping("/find")
    public ResponseEntity<List<MakerDTO>> findAll(){

        return new ResponseEntity<>(this.makerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<MakerDTO> findById(@PathVariable Long id){

        return new ResponseEntity<>(this.makerService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MakerDTO> updateMaker(@RequestBody MakerDTO makerDTO, @PathVariable Long id){

        return new ResponseEntity<>(this.makerService.updateUser(makerDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMaker(@PathVariable Long id){

        return new ResponseEntity<>(this.makerService.deleteUser(id), HttpStatus.NO_CONTENT);
    }
}
