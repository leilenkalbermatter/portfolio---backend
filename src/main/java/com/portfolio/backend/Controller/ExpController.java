package com.portfolio.backend.Controller;

import com.portfolio.backend.Dto.ExpDto;
import com.portfolio.backend.Entity.Experience;
import com.portfolio.backend.Security.Controller.Message;
import com.portfolio.backend.Service.ExpService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experience")
@CrossOrigin(origins = "https://leilenkalbermatter-fullstackdv.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class ExpController {
    @Autowired
    ExpService expService;

    @GetMapping("/list")
    public ResponseEntity<List<Experience>> list(){
        List<Experience> list = expService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experience> getById(@PathVariable("id") int id){
        if(!expService.existsById(id))
            return new ResponseEntity(new Message("No existe en la base de datos"), HttpStatus.NOT_FOUND);
        Experience experience = expService.getOne(id).get();
        return new ResponseEntity(experience, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!expService.existsById(id))
            return new ResponseEntity(new Message("No existe en la base de datos"), HttpStatus.NOT_FOUND);
        expService.delete(id);
        return new ResponseEntity(new Message("Datos eliminados"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ExpDto expDto){
        if(StringUtils.isBlank(expDto.getNameExperience()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(expService.existsByNameExperience(expDto.getNameExperience()))
            return new ResponseEntity(new Message("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Experience experience = new Experience(expDto.getNameExperience(),
                expDto.getDescriptionExperience(), expDto.getDateExperience(), expDto.getPathImageExperience(), expDto.getUrlImageExperience());
        expService.save(experience);

        return new ResponseEntity(new Message("Datos cargados"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>  update(@PathVariable("id") int id, @RequestBody ExpDto expDto){
        if(!expService.existsById(id))
            return new ResponseEntity(new Message("No existe en la base de datos"), HttpStatus.NOT_FOUND);
//        if(expService.existsByNameExperience(expDto.getNameExperience()) && expService.getOne(id).get().getNameExperience() != expDto.getNameExperience())
//            return new ResponseEntity(new Message("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(expDto.getNameExperience()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Experience experience = expService.getOne(id).get();
        experience.setNameExperience(expDto.getNameExperience());
        experience.setDescriptionExperience(expDto.getDescriptionExperience());
        experience.setDateExperience(expDto.getDateExperience());
        experience.setPathImageExperience(expDto.getPathImageExperience());
        experience.setUrlImageExperience(expDto.getUrlImageExperience());

        expService.save(experience);
        return new ResponseEntity(new Message("Datos actualizados"), HttpStatus.OK);
    }
}
