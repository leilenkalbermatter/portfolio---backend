package com.portfolio.backend.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameEducation;
    private String descriptionEducation;
    private String dateEducation;
    private String imageEducation;

    public Education() {
    }

    public Education(String nameEducation, String descriptionEducation, String dateEducation, String imageEducation) {
        this.nameEducation = nameEducation;
        this.descriptionEducation = descriptionEducation;
        this.dateEducation = dateEducation;
        this.imageEducation = imageEducation;
    }
}
