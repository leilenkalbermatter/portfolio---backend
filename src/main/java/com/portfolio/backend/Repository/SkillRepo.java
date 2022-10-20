package com.portfolio.backend.Repository;

import com.portfolio.backend.Entity.Experience;
import com.portfolio.backend.Entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillRepo extends JpaRepository<Skill, Integer> {
    public Optional<Skill> findByNameSkill(String nameSkill);
    public boolean existsByNameSkill(String nameSkill);
}
