package com.workshop.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Damper extends BicyclePart {
    
    private Integer stroke;
    private Integer eyeToEyeLength;
    private Integer bodyLength;

}
