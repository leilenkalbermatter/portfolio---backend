package com.portfolio.backend.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class ProDto {
    @NotBlank
    private String nameProject;
    @NotBlank
    private String descriptionProject;
    @NotBlank
    private String linkProject;
    @NotBlank
    private String pathImageProject;
    @NotBlank
    private String urlImageProject;

    public ProDto() {
    }

    public ProDto(String nameProject, String descriptionProject, String linkProject, String pathImageProject, String urlImageProject) {
        this.nameProject = nameProject;
        this.descriptionProject = descriptionProject;
        this.linkProject = linkProject;
        this.pathImageProject = pathImageProject;
        this.urlImageProject = urlImageProject;
    }

}