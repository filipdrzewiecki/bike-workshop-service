package com.workshop.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Stem extends BicyclePart {


    private Integer length;
    private Integer angle;
    private Double headtubeDiameter;
    private Double handlebarDiameter;

}
