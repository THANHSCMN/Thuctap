package edu.poly.demo2.mappers;

import java.util.List;

import edu.poly.demo2.entity.Career;
import edu.poly.demo2.DTO.CareerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CareerMapper {
    CareerMapper INSTANCE = Mappers.getMapper(CareerMapper.class);

    CareerDTO toCareerDTO (Career career);

    Career toCareer (CareerDTO careerDTO);

    List<CareerDTO> toCareerDTOs(List<Career> careers);
}
