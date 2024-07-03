package edu.poly.demo2.mappers;

import edu.poly.demo2.entity.ProField;
import edu.poly.demo2.DTO.ProFieldDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProFieldMapper {
    ProFieldMapper INSTANCE = Mappers.getMapper(ProFieldMapper.class);

    ProFieldDTO toProFieldDTO(ProField proField);

    ProField toProField(ProFieldDTO fieldDTO);

    List<ProFieldDTO> toProFieldDTOs(List<ProField> proFields);
}
