package com.workshop.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;


@Entity
@Data
@NoArgsConstructor
public class Saddle extends BicyclePart {

    private Integer length;
    private Integer width;
    private String material;

}
