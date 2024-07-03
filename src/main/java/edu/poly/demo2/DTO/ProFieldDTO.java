package edu.poly.demo2.DTO;

import edu.poly.demo2.entity.ProField;
import lombok.Data;

@Data
public class ProFieldDTO extends ProField {
    private int id;
    private String name;
    private String color;
    private String description;
    private String representative_image;
}
