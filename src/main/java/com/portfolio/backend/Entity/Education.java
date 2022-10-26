package com.portfolio.backend.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Getter @Setter
@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameEducation;
    private String descriptionEducation;
    private String dateEducation;

    private String pathImageEducation;

    private String urlImageEducation;



    public Education() {
    }

    public Education(String nameEducation, String descriptionEducation, String dateEducation, String pathImageEducation, String urlImageEducation) {
        this.nameEducation = nameEducation;
        this.descriptionEducation = descriptionEducation;
        this.dateEducation = dateEducation;
        this.pathImageEducation = pathImageEducation;
        this.urlImageEducation = urlImageEducation;
    }
}
