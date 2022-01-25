package com.example.project.services.implementations;

import com.example.project.data.entity.CourierEmployee;
import com.example.project.data.repository.CourierEmployeeRepository;
import com.example.project.services.CourierEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourierEmployeeServiceImpl implements CourierEmployeeService {

    private final CourierEmployeeRepository courierEmployeeRepository;

    @Override
    public List<CourierEmployee> getCourierEmployees() {
        return courierEmployeeRepository.findAll();
    }

    @Override
    public CourierEmployee getCourierEmployee(long id) {
        return courierEmployeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException
                ("Invalid Courier Employee ID: " + id));
    }

    @Override
    public CourierEmployee create(CourierEmployee courierEmployee) {
        return courierEmployeeRepository.save(courierEmployee);
    }

    @Override
    public CourierEmployee updateCourierEmployee(long id, CourierEmployee courierEmployee) {
        return null;
    }

    @Override
    public void deleteCourierEmployee(long id) {}

    @Override
    public List<CourierEmployee> findAllByName(String name) {
        return null;
    }
}
