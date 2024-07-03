package edu.poly.demo2.service;

import edu.poly.demo2.DTO.CareerDTO;

import java.util.List;

public interface CareerService {
    List<CareerDTO> getAll();

    CareerDTO update(String id, CareerDTO careerDTO);

    CareerDTO insert(CareerDTO careerDTO);

    Boolean deleteById(String id);

}