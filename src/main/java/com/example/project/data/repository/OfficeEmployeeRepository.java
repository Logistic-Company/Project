package com.example.project.data.repository;

import com.example.project.data.entity.CourierEmployee;
import com.example.project.data.entity.OfficeEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfficeEmployeeRepository extends JpaRepository<OfficeEmployee, Long> {
}
