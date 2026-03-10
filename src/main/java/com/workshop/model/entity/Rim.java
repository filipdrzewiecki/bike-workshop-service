package com.workshop.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Rim extends BicyclePart{


    private Double height;
    private Double innerWidth;
    private Double outerWidth;
    private Integer holes;
    private String brakeType;
    private Boolean tubeless;
    private Integer diameter;
    private Integer erd;
    private String material;

}
