package com.example.project.data.repository;

import com.example.project.data.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Long> {
    Roles findByName(String name);
}
