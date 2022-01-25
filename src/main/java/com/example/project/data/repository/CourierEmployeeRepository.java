package com.example.project.data.repository;

import com.example.project.data.entity.Clients;
import com.example.project.data.entity.CourierEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourierEmployeeRepository extends JpaRepository<CourierEmployee, Long> {
    List<CourierEmployee> findAllByName(String name);

}
