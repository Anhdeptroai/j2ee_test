package com.example.SGUCharity_Project.Service;

import com.example.SGUCharity_Project.Model.Role;
import com.example.SGUCharity_Project.Model.User;
import com.example.SGUCharity_Project.Model.UserRole;
import com.example.SGUCharity_Project.Repository.Role_Repo;
import com.example.SGUCharity_Project.Repository.User_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthService {
    @Autowired
    private User_Repo userRepository;

    @Autowired
    private Role_Repo roleRepository;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void saveUser(User user, Set<Role> roles) {
        // Mã hóa mật khẩu trước khi lưu
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Chuyển đổi Set<Role> thành Set<UserRole> và gán vào User
        Set<UserRole> userRoles = roles.stream()
                .map(role -> new UserRole(user, role)) // Cần đảm bảo `UserRole` có constructor `UserRole(User, Role)`
                .collect(Collectors.toSet());

        user.setUserRoles(userRoles); // Gán Set<UserRole> vào user

        // Lưu user vào database
        userRepository.save(user);
    }

    public Set<Role> getUserRoles(User user) {
        return user.getUserRoles().stream().map(UserRole::getRole).collect(Collectors.toSet());
    }
}

