package com.workshop.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Seatpost extends BicyclePart {

    private Double length;
    private Double diameter;
    private String material;
    private Boolean suspension;
    private Integer seatpostOffset;

    //dropper seatPost section
    private Integer travel;
    //inner, outer
    private String cableRouteType;
    //dropper seatPost section

}
