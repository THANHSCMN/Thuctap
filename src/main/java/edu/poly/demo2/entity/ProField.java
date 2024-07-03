package edu.poly.demo2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pro_field")
@Data
public class ProField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String color;
    @Column
    private String description;
    @Column
    private String representative_image;
}
