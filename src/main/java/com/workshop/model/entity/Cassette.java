package com.workshop.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Cassette extends BicyclePart {


    //smallest cog - usually 10 or 11 teeth
    private Integer smallest;

    //biggest cog - i.e. 42
    private Integer biggest;

    private Integer speeds;

    //Shimano, Sram, Campagnolo
    private String freewheelBody;

}