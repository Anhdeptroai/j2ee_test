package com.example.SGUCharity_Project.Model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;
    private String description;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<UserRole> userRoles; // Quan hệ với UserRole

    public String getRoleName() {
        return roleName;
    }

    public void setPassword(String password) {
        this.roleName = roleName;
    }
}
