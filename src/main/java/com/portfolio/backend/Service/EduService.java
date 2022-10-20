package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.Education;
import com.portfolio.backend.Repository.EduRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EduService {
    @Autowired
    EduRepo eduRepo;

    public List<Education> list() {
        return eduRepo.findAll();
    }

    public Optional<Education> getOne(int id) {
        return eduRepo.findById(id);
    }

    public Optional<Education> getByNameEducation(String nameEducation) {
        return eduRepo.findByNameEducation(nameEducation);
    }

    public void save(Education education) {
        eduRepo.save(education);
    }

    public void delete(int id) {
        eduRepo.deleteById(id);
    }

    public boolean existsById(int id) {
        return eduRepo.existsById(id);
    }

    public boolean existsByNameEducation(String nameEducation) {
        return eduRepo.existsByNameEducation(nameEducation);
    }
}