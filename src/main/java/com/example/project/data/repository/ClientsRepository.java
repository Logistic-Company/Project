package com.example.project.data.repository;

import com.example.project.data.entity.Address;
import com.example.project.data.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientsRepository extends JpaRepository<Clients, Long> {
    List<Clients> findAllByName(String name);
}