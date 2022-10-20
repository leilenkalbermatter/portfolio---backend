package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.Skill;
import com.portfolio.backend.Repository.SkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SkillService {
    @Autowired
    SkillRepo skillRepo;

    public List<Skill> list() {
        return skillRepo.findAll();
    }

    public Optional<Skill> getOne(int id) {
        return skillRepo.findById(id);
    }

    public Optional<Skill> getByNameSkill(String nameSkill) {
        return skillRepo.findByNameSkill(nameSkill);
    }

    public void save(Skill skill) {
        skillRepo.save(skill);
    }

    public void delete(int id) {
        skillRepo.deleteById(id);
    }

    public boolean existsById(int id) {
        return skillRepo.existsById(id);
    }

    public boolean existsByNameSkill(String nameSkill) {
        return skillRepo.existsByNameSkill(nameSkill);
    }
}
