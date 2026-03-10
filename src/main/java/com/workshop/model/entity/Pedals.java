package com.workshop.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedals extends BicyclePart{

    private String type;
    private Boolean spd;
    private String block;
}
