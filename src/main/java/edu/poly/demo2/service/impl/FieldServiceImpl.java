package edu.poly.demo2.service.impl;

import edu.poly.demo2.DTO.CareerDTO;
import edu.poly.demo2.DTO.FieldDTO;
import edu.poly.demo2.DTO.ProFieldDTO;
import edu.poly.demo2.entity.Career;
import edu.poly.demo2.entity.Field;
import edu.poly.demo2.entity.ProField;
import edu.poly.demo2.mappers.CareerMapper;
import edu.poly.demo2.mappers.FieldMapper;
import edu.poly.demo2.mappers.ProFieldMapper;
import edu.poly.demo2.repository.CareerRepository;
import edu.poly.demo2.repository.FieldRepository;
import edu.poly.demo2.service.FieldService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FieldServiceImpl implements FieldService {
    @Autowired
    private FieldRepository fieldRepository;
    private CareerRepository careerRepository;


    @Override
    public List<FieldDTO> getAll() {
        List<Field> field = fieldRepository.findAll();
        List<FieldDTO> FieldDTOs = FieldMapper.INSTANCE.toFieldDTOs(field);

        return FieldDTOs;
    }
    @Override
    public FieldDTO insert(FieldDTO fieldDTO) {
        try {
            Field field = FieldMapper.INSTANCE.toField(fieldDTO);

            ProFieldDTO proFieldDTO = fieldDTO.getProField();
            ProField proField = ProFieldMapper.INSTANCE.toProField(proFieldDTO);
            field.setProField(proField);

            fieldRepository.save(field);

            List<Career> careerDTOs = fieldDTO.getCareers();
            for (Career careerDTO : careerDTOs) {
                Career career = CareerMapper.INSTANCE.toCareer((CareerDTO) careerDTO);
                career.getFields().add(field);
            }

            return fieldDTO;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public FieldDTO update(String id, FieldDTO fieldDTO) {
        try {
            Optional<Field> existingFieldOptional = fieldRepository.findById(id);

            if (existingFieldOptional.isPresent()) {
                Field existingField = existingFieldOptional.get();
                Field updatedField = FieldMapper.INSTANCE.toField(fieldDTO);

                existingField.setName(updatedField.getName());
                existingField.setCareers(updatedField.getCareers());
                existingField.setProField(updatedField.getProField());

                Field savedField = fieldRepository.save(existingField);
                return FieldMapper.INSTANCE.toFieldDTO(savedField);
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
            fieldRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
