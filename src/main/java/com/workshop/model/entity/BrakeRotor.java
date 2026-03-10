package com.workshop.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class BrakeRotor extends BicyclePart {

    private Integer diameter;
    private String padType;

}
