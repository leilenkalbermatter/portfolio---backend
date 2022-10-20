package com.portfolio.backend.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameExperience;
    private String descriptionExperience;
    private String dateExperience;
    private String imageExperience;

    public Experience() {
    }

    public Experience(String nameExperience, String descriptionExperience, String dateExperience, String imageExperience) {
        this.nameExperience = nameExperience;
        this.descriptionExperience = descriptionExperience;
        this.dateExperience = dateExperience;
        this.imageExperience = imageExperience;
    }
}
