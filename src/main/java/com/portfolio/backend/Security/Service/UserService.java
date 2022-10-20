package com.portfolio.backend.Security.Service;

import com.portfolio.backend.Security.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.portfolio.backend.Security.Repository.InterfaceUserRepo;

import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    InterfaceUserRepo interfaceUserRepo;

    public Optional<User> getByUserName(String userName){
        return interfaceUserRepo.findByUserName(userName);
    }

    public boolean existsByUserName(String userName){
        return interfaceUserRepo.existsByUserName(userName);
    }

    public boolean existsByEmail(String email){
        return interfaceUserRepo.existsByEmail(email);
    }

    public void save(User user){
        interfaceUserRepo.save(user);
    }
}
