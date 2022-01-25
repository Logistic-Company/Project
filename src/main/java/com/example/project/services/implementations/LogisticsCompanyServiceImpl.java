package com.example.project.services.implementations;

import com.example.project.data.entity.Address;
import com.example.project.data.entity.LogisticsCompany;
import com.example.project.data.repository.LogisticsCompanyRepository;
import com.example.project.services.LogisticsCompanyService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LogisticsCompanyServiceImpl implements LogisticsCompanyService {

    private final LogisticsCompanyRepository logisticsCompanyRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<LogisticsCompany> getLogisticsCompanies() {
        return logisticsCompanyRepository.findAll();
    }

    @Override
    public LogisticsCompany getLogisticCompany(long id) {
        return logisticsCompanyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Logistics Company ID: " + id));
    }

    @Override
    public LogisticsCompany create(LogisticsCompany logisticsCompany) {
        return logisticsCompanyRepository.save(logisticsCompany);
    }

    @Override
    public LogisticsCompany updateLogisticCompany(long id, LogisticsCompany logisticsCompany) {
        LogisticsCompany logisticsCompany1 = modelMapper.map(logisticsCompany, LogisticsCompany.class);
        logisticsCompany1.setId(1);
        return  logisticsCompanyRepository.save(logisticsCompany);
    }

    @Override
    public void deleteLogisticCompany(long id) {
        logisticsCompanyRepository.deleteById(id);
    }

    @Override
    public List<LogisticsCompany> getLogisticsCompany() {
        return logisticsCompanyRepository.findAll();
    }
}
