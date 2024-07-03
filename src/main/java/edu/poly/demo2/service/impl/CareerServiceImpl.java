package edu.poly.demo2.service.impl;

import edu.poly.demo2.DTO.CareerDTO;
import edu.poly.demo2.entity.Career;
import edu.poly.demo2.entity.Field;
import edu.poly.demo2.mappers.CareerMapper;
import edu.poly.demo2.repository.CareerRepository;
import edu.poly.demo2.service.CareerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CareerServiceImpl implements CareerService {
    @Autowired
    private CareerRepository careerRepository;


    @Override
    public List<CareerDTO> getAll() {
        List<Career> career = careerRepository.findAll();
        List<CareerDTO> CareerDTOs = CareerMapper.INSTANCE.toCareerDTOs(career);

        return CareerDTOs;
    }
    @Override
    public CareerDTO insert(CareerDTO careerDTO) {
        try {
            Career career = CareerMapper.INSTANCE.toCareer(careerDTO);

            careerRepository.save(career);

            List<Field> fields = career.getFields();
            for (Field field : fields) {
                field.getCareers().add(career);
            }

            return careerDTO;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public CareerDTO update(String id, CareerDTO careerDTO) {
        try {
            Optional<Career> existingCareerOptional = careerRepository.findById(id);

            if (existingCareerOptional.isPresent()) {
                Career existingCareer = existingCareerOptional.get();
                Career updatedCareer = CareerMapper.INSTANCE.toCareer(careerDTO);

                existingCareer.setName(updatedCareer.getName());
                existingCareer.setEducation_required(updatedCareer.getEducation_required());
                existingCareer.setAverage_salary(updatedCareer.getAverage_salary());
                existingCareer.setDescription(updatedCareer.getDescription());

                Career savedCareer = careerRepository.save(existingCareer);
                return CareerMapper.INSTANCE.toCareerDTO(savedCareer);
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
            careerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
