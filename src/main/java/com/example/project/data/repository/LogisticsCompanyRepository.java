package com.example.project.data.repository;

import com.example.project.data.entity.CourierEmployee;
import com.example.project.data.entity.LogisticsCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogisticsCompanyRepository extends JpaRepository<LogisticsCompany, Long> {
    List<LogisticsCompany> findAllByName(String name);

}
