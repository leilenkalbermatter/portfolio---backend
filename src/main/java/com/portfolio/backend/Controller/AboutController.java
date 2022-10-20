package com.portfolio.backend.Controller;

import com.portfolio.backend.Dto.AboutDto;
import com.portfolio.backend.Entity.About;
import com.portfolio.backend.Security.Controller.Message;
import com.portfolio.backend.Service.AboutService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/about")
//@CrossOrigin(origins = "https://leilenkalbermatter-portfolio.web.app")
@CrossOrigin(origins = "http://localhost:4200")
public class AboutController {
    @Autowired
    AboutService aboutService;

    @GetMapping("/list")
    public ResponseEntity<List<About>> list(){
        List<About> list = aboutService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<About> getById(@PathVariable("id") int id){
        if(!aboutService.existsById(id))
            return new ResponseEntity(new Message("No existe en la base de datos"), HttpStatus.NOT_FOUND);
        About about = aboutService.getOne(id).get();
        return new ResponseEntity(about, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!aboutService.existsById(id))
            return new ResponseEntity(new Message("No existe en la base de datos"), HttpStatus.NOT_FOUND);
        aboutService.delete(id);
        return new ResponseEntity(new Message("Datos eliminados"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody AboutDto aboutDto){
        if(StringUtils.isBlank(aboutDto.getNameAbout()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(aboutService.existsByNameAbout(aboutDto.getNameAbout()))
            return new ResponseEntity(new Message("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        About about = new About(aboutDto.getNameAbout(), aboutDto.getLastNameAbout(),
                  aboutDto.getEmailAbout(), aboutDto.getDescriptionAbout());
        aboutService.save(about);

        return new ResponseEntity(new Message("Datos cargados"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>  update(@PathVariable("id") int id, @RequestBody AboutDto aboutDto){
        if(!aboutService.existsById(id))
            return new ResponseEntity(new Message("No existe en la base de datos"), HttpStatus.NOT_FOUND);
        if(aboutService.existsByNameAbout(aboutDto.getNameAbout()) && aboutService.getOne(id).get().getNameAbout() != aboutDto.getNameAbout())
            return new ResponseEntity(new Message("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(aboutDto.getNameAbout()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        About about = aboutService.getOne(id).get();
        about.setNameAbout(aboutDto.getNameAbout());
        about.setDescriptionAbout(aboutDto.getDescriptionAbout());
        about.setLastNameAbout(aboutDto.getLastNameAbout());
        about.setEmailAbout(aboutDto.getEmailAbout());

        aboutService.save(about);
        return new ResponseEntity(new Message("Datos actualizados"), HttpStatus.OK);
    }
}
