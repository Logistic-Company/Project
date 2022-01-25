package com.example.project.services;

import com.example.project.data.entity.Clients;
import com.example.project.data.entity.CourierEmployee;
import java.util.List;

public interface CourierEmployeeService {

    List<CourierEmployee> getCourierEmployees();

    CourierEmployee getCourierEmployee(long id);

    CourierEmployee create(CourierEmployee courierEmployee);

    CourierEmployee updateCourierEmployee(long id, CourierEmployee courierEmployee);

    void deleteCourierEmployee(long id);

    List<CourierEmployee>findAllByName(String name);

}
