package edu.poly.demo2.service;

import edu.poly.demo2.DTO.ProFieldDTO;

import java.util.List;

public interface ProFieldService {
    List<ProFieldDTO> getAll();

    ProFieldDTO insert(ProFieldDTO proFieldDTO);

    ProFieldDTO update(String id, ProFieldDTO proFieldDTO);

    Boolean deleteById(String id);

}