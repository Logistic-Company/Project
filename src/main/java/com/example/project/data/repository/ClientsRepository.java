package com.example.project.data.repository;
import com.example.project.data.dto.LogisticsCompanyDTO;
import com.example.project.data.entity.Clients;
import com.example.project.data.entity.LogisticsCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ClientsRepository extends JpaRepository<Clients, Long> {
    List<Clients> findAllByName(String name);
}
