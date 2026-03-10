package com.workshop.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Grips extends BicyclePart {


    //Regular Grips, Road Tape
    private String gripType;

}
