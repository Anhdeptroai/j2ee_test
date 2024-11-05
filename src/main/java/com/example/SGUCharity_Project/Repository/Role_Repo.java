package com.example.SGUCharity_Project.Repository;

import com.example.SGUCharity_Project.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Role_Repo extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);

}
