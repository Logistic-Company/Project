package com.example.project.services;

import com.example.project.data.dto.CourierEmployeeDTO;
import com.example.project.data.dto.CreateCourierEmployeeDTO;
import com.example.project.data.dto.UpdateCourierEmployeeDTO;
import com.example.project.data.entity.Clients;
import com.example.project.data.entity.CourierEmployee;
import java.util.List;

public interface CourierEmployeeService {

    List<CourierEmployeeDTO> getCourierEmployees();

    CourierEmployeeDTO getCourierEmployee(long id);

    CourierEmployee create(CreateCourierEmployeeDTO createCourierEmployeeDTO);

    CourierEmployee updateCourierEmployee(long id, UpdateCourierEmployeeDTO updateCourierEmployeeDTO);

    void deleteCourierEmployee(long id);

    //List<CourierEmployee>findAllByName(String name);

}
