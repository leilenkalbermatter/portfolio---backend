package com.portfolio.backend.Security.Repository;

import com.portfolio.backend.Security.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InterfaceUserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);

    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
}
