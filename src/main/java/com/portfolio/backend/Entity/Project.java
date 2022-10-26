package com.portfolio.backend.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameProject;
    private String descriptionProject;
    private String linkProject;
    private String pathImageProject;

    private String urlImageProject;



    public Project() {
    }

    public Project(String nameProject, String descriptionProject, String linkProject, String pathImageProject, String urlImageProject) {
        this.nameProject = nameProject;
        this.descriptionProject = descriptionProject;
        this.linkProject = linkProject;
        this.pathImageProject = pathImageProject;
        this.urlImageProject = urlImageProject;
    }
}
