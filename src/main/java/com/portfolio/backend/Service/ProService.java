package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.Project;
import com.portfolio.backend.Repository.ProRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProService {
    @Autowired
    ProRepo proRepo;

    public List<Project> list() {
        return proRepo.findAll();
    }

    public Optional<Project> getOne(int id) {
        return proRepo.findById(id);
    }

    public Optional<Project> getByNameProject(String nameProject) {
        return proRepo.findByNameProject(nameProject);
    }

    public void save(Project project) {
        proRepo.save(project);
    }

    public void delete(int id) {
        proRepo.deleteById(id);
    }

    public boolean existsById(int id) {
        return proRepo.existsById(id);
    }

    public boolean existsByNameProject(String nameProject) {
        return proRepo.existsByNameProject(nameProject);
    }
}
