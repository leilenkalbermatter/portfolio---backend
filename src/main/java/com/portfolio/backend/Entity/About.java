package com.portfolio.backend.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter @Setter
@Entity
public class About {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
    private String nameAbout;
    @NotNull
    @Size(min = 2, max = 30, message = "Surname must be between 2 and 30 characters")
    private String lastNameAbout;
    @NotNull
    @Size(min = 2, max = 255, message = "Email must be between 2 and 30 characters")
    private String emailAbout;

    @NotNull
    @Size(min = 1, max = 500)
    private String linkedinAbout;

    @NotNull
    @Size(min = 1, max = 500)
    private String githubAbout;
    @NotNull
    @Size(min = 1, max = 500, message = "Description must be between 1 and 500 characters")
    private String descriptionAbout;

    public About() {
    }

    public About(String nameAbout, String lastNameAbout, String emailAbout, String descriptionAbout, String linkedinAbout, String githubAbout) {
        this.nameAbout = nameAbout;
        this.lastNameAbout = lastNameAbout;
        this.emailAbout = emailAbout;
        this.descriptionAbout = descriptionAbout;
        this.linkedinAbout = linkedinAbout;
        this.githubAbout = githubAbout;
    }


}
