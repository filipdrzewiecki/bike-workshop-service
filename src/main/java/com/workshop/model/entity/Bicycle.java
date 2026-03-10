package com.workshop.model.entity;
import com.workshop.config.security.entity.Profile;
import com.workshop.model.enums.BicycleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Data
public class Bicycle {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    private String brand;
    private String model;

    private BicycleType type;

    private Double predefinedWeight;
    private Double countedWeight;

    private Long year;

    private Long imageId;

    private Boolean isOfficial;

    @OneToOne
    @JoinColumn(name = "frame_id")
    private Frame frame;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
}
