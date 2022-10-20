package com.portfolio.backend.Repository;

import com.portfolio.backend.Entity.About;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AboutRepo extends JpaRepository<About, Integer> {
    public Optional<About> findByNameAbout(String nameAbout);
    public boolean existsByNameAbout(String nameAbout);
}
