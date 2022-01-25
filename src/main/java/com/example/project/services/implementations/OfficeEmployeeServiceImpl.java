package com.example.project.services.implementations;

import com.example.project.data.entity.OfficeEmployee;
import com.example.project.data.repository.OfficeEmployeeRepository;
import com.example.project.services.OfficeEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OfficeEmployeeServiceImpl implements OfficeEmployeeService {

    private final OfficeEmployeeRepository officeEmployeeRepository;

    @Override
    public List<OfficeEmployee> getOfficeEmployees() {
        return officeEmployeeRepository.findAll();
    }

    @Override
    public OfficeEmployee getOfficeEmployee(long id) {
        return officeEmployeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException
                ("Invalid Office Employee ID: " + id));
    }

    @Override
    public OfficeEmployee create(OfficeEmployee officeEmployee) {
        return officeEmployeeRepository.save(officeEmployee);
    }

    @Override
    public OfficeEmployee updateOfficeEmployee(long id, OfficeEmployee officeEmployee) {
        return null;
    }

    @Override
    public void deleteOfficeEmployee(long id) {}
}
