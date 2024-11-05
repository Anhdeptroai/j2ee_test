package com.example.SGUCharity_Project.Repository;

import com.example.SGUCharity_Project.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User_Repo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
