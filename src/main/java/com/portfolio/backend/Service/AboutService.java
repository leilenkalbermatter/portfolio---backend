package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.About;
import com.portfolio.backend.Repository.AboutRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AboutService {
    @Autowired
    AboutRepo aboutRepo;

    public List<About> list() {
        return aboutRepo.findAll();
    }

    public Optional<About> getOne(int id) {
        return aboutRepo.findById(id);
    }

    public Optional<About> getByNameAbout(String nameAbout) {
        return aboutRepo.findByNameAbout(nameAbout);
    }

    public void save(About about) {
        aboutRepo.save(about);
    }

    public void delete(int id) {
        aboutRepo.deleteById(id);
    }

    public boolean existsById(int id) {
        return aboutRepo.existsById(id);
    }

    public boolean existsByNameAbout(String nameAbout) {
        return aboutRepo.existsByNameAbout(nameAbout);
    }

}


