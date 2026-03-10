package com.workshop.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class BottomBracket extends BicyclePart {


    //Integrated, Cartridge
    private String type;

    //Threaded(BSA), Press-fit
    private String insertType;

    //Integrated
    private String bottomBracketShellDiameter;
    private Double axleDiameter;
    //Integrated

    //Cartridge
    private Double axleLength;
    //Cartridge

    private String shellWidth;


}
