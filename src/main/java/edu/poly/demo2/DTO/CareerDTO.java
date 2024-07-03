package edu.poly.demo2.DTO;

import edu.poly.demo2.entity.Career;
import lombok.Data;


@Data
public class CareerDTO extends Career {
    private int id;
    private String name;
    private String education_required;
    private double average_salary;
    private String description;
}