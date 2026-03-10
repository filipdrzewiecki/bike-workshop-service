package com.workshop.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Tyre extends BicyclePart{

    private Integer width;
    private Boolean tubeless;
    private Integer diameter;
    private String type;
    private String tpi;
}
