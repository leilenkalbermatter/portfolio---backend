package com.portfolio.backend.Security.Service;

import com.portfolio.backend.Security.Entity.Role;
import com.portfolio.backend.Security.Enums.RoleName;
import com.portfolio.backend.Security.Repository.InterfaceRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RoleService {
    @Autowired
    InterfaceRoleRepo interfaceRoleRepo;

    public Optional<Role> getByRoleName(RoleName roleName){
        return interfaceRoleRepo.findByRoleName(roleName);
    }

    public void save(Role role){
        interfaceRoleRepo.save(role);
    }
}
