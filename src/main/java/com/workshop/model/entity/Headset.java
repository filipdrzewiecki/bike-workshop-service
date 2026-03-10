package com.workshop.model.entity;

import com.workshop.model.enums.HeadsetType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Headset extends BicyclePart {

    private Double topFrameDiameter;
    private Double topHeadTubeDiameter;

    private Double bottomFrameDiameter;
    private Double bottomHeadTubeDiameter;

    @Enumerated(EnumType.STRING)
    private HeadsetType type;

}
