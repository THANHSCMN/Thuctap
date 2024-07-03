package edu.poly.demo2.DTO;

import edu.poly.demo2.entity.Field;
import lombok.Data;

import java.util.List;

@Data
public class FieldDTO extends Field {
    private int id;
    private String name;
    private ProFieldDTO proField;
}