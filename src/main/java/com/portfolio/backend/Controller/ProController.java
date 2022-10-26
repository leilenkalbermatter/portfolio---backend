package com.portfolio.backend.Controller;

import com.portfolio.backend.Dto.ProDto;
import com.portfolio.backend.Entity.Project;
import com.portfolio.backend.Security.Controller.Message;
import com.portfolio.backend.Service.ProService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
//@CrossOrigin(origins = "https://leilenkalbermatter-portfolio.web.app")
@CrossOrigin(origins = "http://localhost:4200")
public class ProController {
    @Autowired
    ProService proService;

    @GetMapping("/list")
    public ResponseEntity<List<Project>> list(){
        List<Project> list = proService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Project> getById(@PathVariable("id") int id){
        if(!proService.existsById(id))
            return new ResponseEntity(new Message("No existe en la base de datos"), HttpStatus.NOT_FOUND);
        Project project = proService.getOne(id).get();
        return new ResponseEntity(project, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!proService.existsById(id))
            return new ResponseEntity(new Message("No existe en la base de datos"), HttpStatus.NOT_FOUND);
        proService.delete(id);
        return new ResponseEntity(new Message("Datos eliminados"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProDto proDto){
        if(StringUtils.isBlank(proDto.getNameProject()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(proService.existsByNameProject(proDto.getNameProject()))
            return new ResponseEntity(new Message("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Project project = new Project(proDto.getNameProject(),
                proDto.getDescriptionProject(), proDto.getLinkProject(), proDto.getPathImageProject(), proDto.getUrlImageProject());
        proService.save(project);

        return new ResponseEntity(new Message("Datos cargados"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>  update(@PathVariable("id") int id, @RequestBody ProDto proDto){
        if(!proService.existsById(id))
            return new ResponseEntity(new Message("No existe en la base de datos"), HttpStatus.NOT_FOUND);
        if(proService.existsByNameProject(proDto.getNameProject()) && proService.getOne(id).get().getNameProject() != proDto.getNameProject())
            return new ResponseEntity(new Message("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(proDto.getNameProject()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Project project = proService.getOne(id).get();
        project.setNameProject(proDto.getNameProject());
        project.setDescriptionProject(proDto.getDescriptionProject());
        project.setLinkProject(proDto.getLinkProject());
        project.setPathImageProject(proDto.getPathImageProject());
        project.setUrlImageProject(proDto.getUrlImageProject());

        proService.save(project);
        return new ResponseEntity(new Message("Datos actualizados"), HttpStatus.OK);
    }
}
