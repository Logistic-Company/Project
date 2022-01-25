package com.example.project.services.implementations;

import com.example.project.data.entity.Office;
import com.example.project.data.repository.OfficeRepository;
import com.example.project.services.OfficeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OfficeServiceImpl implements OfficeService {

    private final OfficeRepository officeRepository;

    @Override
    public List<Office> getOffices() {
        return officeRepository.findAll();
    }

    @Override
    public Office getOffice(long id) {
        return officeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Office ID: " + id));
    }

    @Override
    public Office create(Office office) {
        return officeRepository.save(office);
    }

    @Override
    public Office updateOffice(long id, Office office) {
        return null;
    }

    @Override
    public void deleteOffice(long id) {}
}
