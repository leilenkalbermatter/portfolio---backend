package com.portfolio.backend.Repository;

import com.portfolio.backend.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProRepo extends JpaRepository<Project, Integer> {
    public Optional<Project> findByNameProject(String nameProject);
    public boolean existsByNameProject(String nameProject);
}
