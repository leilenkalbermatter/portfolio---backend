package com.portfolio.backend.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter @Setter
public class EduDto {
    @NotBlank
    private String nameEducation;
    @NotBlank
    private String descriptionEducation;
    @NotBlank
    private String dateEducation;
    @NotBlank
    private String imageEducation;

    public EduDto() {
    }

    public EduDto(String nameEducation, String descriptionEducation, String dateEducation, String imageEducation) {
        this.nameEducation = nameEducation;
        this.descriptionEducation = descriptionEducation;
        this.dateEducation = dateEducation;
        this.imageEducation = imageEducation;
    }

}
