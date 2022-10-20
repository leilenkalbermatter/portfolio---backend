package com.portfolio.backend.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class SkillDto {
    @NotBlank
    private String nameSkill;
    @NotBlank
    private String levelSkill;

    @NotBlank
    private String categorySkill;

    @NotBlank
    private String subCategorySkill;

    public SkillDto() {
    }

    public SkillDto(String nameSkill,String levelSkill, String categorySkill, String subCategorySkill) {
        this.nameSkill = nameSkill;
        this.levelSkill = levelSkill;
        this.categorySkill = categorySkill;
        this.subCategorySkill = subCategorySkill;
    }
}
