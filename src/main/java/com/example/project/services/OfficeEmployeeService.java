package com.example.project.services;

import com.example.project.data.entity.OfficeEmployee;
import java.util.List;

public interface OfficeEmployeeService {

    List<OfficeEmployee> getOfficeEmployees();

    OfficeEmployee getOfficeEmployee(long id);

    OfficeEmployee create(OfficeEmployee officeEmployee);

    OfficeEmployee updateOfficeEmployee(long id, OfficeEmployee officeEmployee);

    void deleteOfficeEmployee(long id);
}
