package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.Experience;
import com.portfolio.backend.Repository.ExpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExpService {
    @Autowired
    ExpRepo expRepo;

    public List<Experience> list() {
        return expRepo.findAll();
    }

    public Optional<Experience> getOne(int id) {
        return expRepo.findById(id);
    }

    public Optional<Experience> getByNameExperience(String nameExperience) {
        return expRepo.findByNameExperience(nameExperience);
    }

    public void save(Experience experience) {
        expRepo.save(experience);
    }

    public void delete(int id) {
        expRepo.deleteById(id);
    }

    public boolean existsById(int id) {
        return expRepo.existsById(id);
    }

    public boolean existsByNameExperience(String nameExperience) {
        return expRepo.existsByNameExperience(nameExperience);
    }
}
