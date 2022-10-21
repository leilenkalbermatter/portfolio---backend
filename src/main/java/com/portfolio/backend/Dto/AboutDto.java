package com.portfolio.backend.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter @Setter
public class AboutDto {
    @NotBlank
    private String nameAbout;
    @NotBlank
    private String lastNameAbout;
    @NotBlank
    private String emailAbout;
    @NotBlank
    private String descriptionAbout;
    @NotBlank
    private String linkedinAbout;

    @NotBlank
    private String githubAbout;


    public AboutDto() {
    }

    public AboutDto (String nameAbout, String lastNameAbout, String emailAbout, String descriptionAbout, String linkedinAbout, String githubAbout) {
        this.nameAbout = nameAbout;
        this.lastNameAbout = lastNameAbout;
        this.emailAbout = emailAbout;
        this.descriptionAbout = descriptionAbout;
        this.linkedinAbout = linkedinAbout;
        this.githubAbout = githubAbout;
    }

}
