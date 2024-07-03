package edu.poly.demo2.service;

import edu.poly.demo2.DTO.FieldDTO;

import java.util.List;

public interface FieldService {
    List<FieldDTO> getAll();

    FieldDTO update(String id, FieldDTO fieldDTO);

    FieldDTO insert(FieldDTO fieldDTO);

    Boolean deleteById(String id);

}