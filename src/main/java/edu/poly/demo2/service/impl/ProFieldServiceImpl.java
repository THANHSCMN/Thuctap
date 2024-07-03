package edu.poly.demo2.service.impl;


import edu.poly.demo2.DTO.ProFieldDTO;
import edu.poly.demo2.entity.ProField;
import edu.poly.demo2.mappers.ProFieldMapper;
import edu.poly.demo2.repository.ProFieldRepository;
import edu.poly.demo2.service.ProFieldService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProFieldServiceImpl implements ProFieldService {
    @Autowired
    private ProFieldRepository proFieldRepository;


    @Override
    public List<ProFieldDTO> getAll() {
        List<ProField> proField = proFieldRepository.findAll();
        List<ProFieldDTO> ProFieldDTOs = ProFieldMapper.INSTANCE.toProFieldDTOs(proField);

        return ProFieldDTOs;
    }
    @Override
    public ProFieldDTO insert(ProFieldDTO proFieldDTO){
        try {
            ProField proField = ProFieldMapper.INSTANCE.toProField(proFieldDTO);

            proFieldRepository.save(proField);

            return proFieldDTO;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public ProFieldDTO update(String id, ProFieldDTO proFieldDTO) {
        try {
            Optional<ProField> existingProFieldOptional = proFieldRepository.findById(id);
            if (existingProFieldOptional.isPresent()) {
                ProField existingProField = existingProFieldOptional.get();
                ProField updatedProField = ProFieldMapper.INSTANCE.toProField(proFieldDTO);

                existingProField.setColor(updatedProField.getColor());
                existingProField.setDescription(updatedProField.getDescription());
                existingProField.setName(updatedProField.getName());
                existingProField.setRepresentative_image(updatedProField.getRepresentative_image());

                ProField savedProField = proFieldRepository.save(existingProField);
                return ProFieldMapper.INSTANCE.toProFieldDTO(savedProField);
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    @Transactional
    public Boolean deleteById(String id) {
        try {
            proFieldRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
