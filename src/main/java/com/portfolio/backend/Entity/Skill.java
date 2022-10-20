package com.portfolio.backend.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameSkill;
    private String levelSkill;

    private String categorySkill;

    private String subCategorySkill;

    public Skill() {
    }

    public Skill(String nameSkill, String levelSkill, String categorySkill, String subCategorySkill) {
        this.nameSkill = nameSkill;
        this.levelSkill = levelSkill;
        this.categorySkill = categorySkill;
        this.subCategorySkill = subCategorySkill;
    }
}
