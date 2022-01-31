package com.example.project.services;

import com.example.project.data.dto.CreateOfficeEmployeeDTO;
import com.example.project.data.dto.OfficeEmployeeDTO;
import com.example.project.data.dto.UpdateOfficeEmployeeDTO;
import com.example.project.data.entity.OfficeEmployee;
import java.util.List;

public interface OfficeEmployeeService {

    List<OfficeEmployeeDTO> getOfficeEmployees();

    OfficeEmployeeDTO getOfficeEmployee(long id);

    OfficeEmployee create(CreateOfficeEmployeeDTO createOfficeEmployeeDTO);

    OfficeEmployee updateOfficeEmployee(long id, UpdateOfficeEmployeeDTO updateOfficeEmployeeDTO);

    void deleteOfficeEmployee(long id);
}
