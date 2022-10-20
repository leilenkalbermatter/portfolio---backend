package com.portfolio.backend.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

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

    public AboutDto() {
    }

    public AboutDto(@NotBlank String nameAbout, @NotBlank String lastNameAbout, @NotBlank String emailAbout, @NotBlank String descriptionAbout) {
        this.nameAbout = nameAbout;
        this.lastNameAbout = lastNameAbout;
        this.emailAbout = emailAbout;
        this.descriptionAbout = descriptionAbout;
    }

}
