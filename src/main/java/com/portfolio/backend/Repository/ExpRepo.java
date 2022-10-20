package com.portfolio.backend.Repository;

import com.portfolio.backend.Entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpRepo extends JpaRepository<Experience, Integer> {
    public Optional<Experience> findByNameExperience(String nameExperience);
    public boolean existsByNameExperience(String nameExperience);
}
