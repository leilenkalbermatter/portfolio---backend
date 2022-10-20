package com.portfolio.backend.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class ExpDto {
    @NotBlank
    private String nameExperience;
    @NotBlank
    private String descriptionExperience;
    @NotBlank
    private String dateExperience;
    @NotBlank
    private String imageExperience;

    public ExpDto() {
    }

    public ExpDto(String nameExperience, String descriptionExperience, String dateExperience, String imageExperience) {
        this.nameExperience = nameExperience;
        this.descriptionExperience = descriptionExperience;
        this.dateExperience = dateExperience;
        this.imageExperience = imageExperience;
    }

}
