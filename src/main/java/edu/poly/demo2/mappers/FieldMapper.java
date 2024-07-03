package edu.poly.demo2.mappers;

import edu.poly.demo2.DTO.FieldDTO;
import edu.poly.demo2.entity.Field;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FieldMapper {
    FieldMapper INSTANCE = Mappers.getMapper(FieldMapper.class);

    FieldDTO toFieldDTO(Field field);

    Field toField(FieldDTO fieldDTO);

    List<FieldDTO> toFieldDTOs(List<Field> fields);
}
