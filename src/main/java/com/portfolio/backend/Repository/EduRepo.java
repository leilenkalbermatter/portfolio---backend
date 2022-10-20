package com.portfolio.backend.Repository;

import com.portfolio.backend.Entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EduRepo extends JpaRepository<Education, Integer> {
    public Optional<Education> findByNameEducation(String nameEducation);
    public boolean existsByNameEducation(String nameEducation);
}
