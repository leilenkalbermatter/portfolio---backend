package com.portfolio.backend.Controller;

import com.portfolio.backend.Dto.SkillDto;
import com.portfolio.backend.Entity.Skill;
import com.portfolio.backend.Security.Controller.Message;
import com.portfolio.backend.Service.SkillService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
@CrossOrigin(origins = "https://leilenkalbermatter-portf-872a2.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class SkillController {
    @Autowired
    SkillService skillService;

    @GetMapping("/list")
    public ResponseEntity<List<Skill>> list() {
        List<Skill> list = skillService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id) {
        if (!skillService.existsById(id))
            return new ResponseEntity(new Message("No existe en la base de datos"), HttpStatus.NOT_FOUND);
        Skill skill = skillService.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!skillService.existsById(id))
            return new ResponseEntity(new Message("No existe en la base de datos"), HttpStatus.NOT_FOUND);
        skillService.delete(id);
        return new ResponseEntity(new Message("Datos eliminados"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody SkillDto skillDto) {
        if (StringUtils.isBlank(skillDto.getNameSkill()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (skillService.existsByNameSkill(skillDto.getNameSkill()))
            return new ResponseEntity(new Message("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Skill skill = new Skill(skillDto.getNameSkill(), skillDto.getLevelSkill(), skillDto.getCategorySkill(), skillDto.getSubCategorySkill());
        skillService.save(skill);

        return new ResponseEntity(new Message("Datos cargados"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody SkillDto skillDto) {
        if (!skillService.existsById(id))
            return new ResponseEntity(new Message("No existe en la base de datos"), HttpStatus.NOT_FOUND);
//        if (skillService.existsByNameSkill(skillDto.getNameSkill()) && skillService.getOne(id).get().getNameSkill() != skillDto.getNameSkill())
//            return new ResponseEntity(new Message("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(skillDto.getNameSkill()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Skill skill = skillService.getOne(id).get();
        skill.setNameSkill(skillDto.getNameSkill());
        skill.setLevelSkill(skillDto.getLevelSkill());
        skill.setCategorySkill(skillDto.getCategorySkill());
        skill.setSubCategorySkill(skillDto.getSubCategorySkill());
        skillService.save(skill);
        return new ResponseEntity(new Message("Datos actualizados"), HttpStatus.OK);
    }

}
