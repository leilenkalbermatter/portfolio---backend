package com.portfolio.backend.Controller;

import com.portfolio.backend.Dto.EduDto;
import com.portfolio.backend.Entity.Education;
import com.portfolio.backend.Security.Controller.Message;
import com.portfolio.backend.Service.EduService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/education")
//@CrossOrigin(origins = "https://leilenkalbermatter-portfolio.web.app")
@CrossOrigin(origins = "http://localhost:4200")
public class EduController {
    @Autowired
    EduService eduService;

    @GetMapping("/list")
    public ResponseEntity<List<Education>> list(){
        List<Education> list = eduService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") int id){
        if(!eduService.existsById(id))
            return new ResponseEntity(new Message("No existe en la base de datos"), HttpStatus.NOT_FOUND);
        Education education = eduService.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!eduService.existsById(id))
            return new ResponseEntity(new Message("No existe en la base de datos"), HttpStatus.NOT_FOUND);
        eduService.delete(id);
        return new ResponseEntity(new Message("Datos eliminados"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EduDto eduDto){
        if(StringUtils.isBlank(eduDto.getNameEducation()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(eduService.existsByNameEducation(eduDto.getNameEducation()))
            return new ResponseEntity(new Message("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Education education = new Education(eduDto.getNameEducation(),
                eduDto.getDescriptionEducation(), eduDto.getDateEducation(), eduDto.getPathImageEducation(), eduDto.getUrlImageEducation());
        eduService.save(education);

        return new ResponseEntity(new Message("Datos cargados"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>  update(@PathVariable("id") int id, @RequestBody EduDto eduDto){
        if(!eduService.existsById(id))
            return new ResponseEntity(new Message("No existe en la base de datos"), HttpStatus.NOT_FOUND);
        if(eduService.existsByNameEducation(eduDto.getNameEducation()) && eduService.getOne(id).get().getNameEducation() != eduDto.getNameEducation())
            return new ResponseEntity(new Message("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(eduDto.getNameEducation()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Education education = eduService.getOne(id).get();
        education.setNameEducation(eduDto.getNameEducation());
        education.setDescriptionEducation(eduDto.getDescriptionEducation());
        education.setDateEducation(eduDto.getDateEducation());
        education.setPathImageEducation(eduDto.getPathImageEducation());
        education.setUrlImageEducation(eduDto.getUrlImageEducation());

        eduService.save(education);
        return new ResponseEntity(new Message("Datos actualizados"), HttpStatus.OK);
    }
}
