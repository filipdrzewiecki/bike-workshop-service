package com.workshop.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class BrakeLever extends BicyclePart {


    //Left, Right
    private String side;

    //Mineral, DOT
    private String oilType;

    //SM-BH90-SBM, SM-BH90-SBLS
    private String hoseType;

    private String type;
}
