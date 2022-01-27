package com.example.project.services;

import com.example.project.data.dto.CreateLogisticsCompanyDTO;
import com.example.project.data.dto.LogisticsCompanyDTO;
import com.example.project.data.dto.UpdateLogisticsCompanyDTO;
import com.example.project.data.entity.LogisticsCompany;
import java.util.List;

public interface LogisticsCompanyService {

    List<LogisticsCompanyDTO> getLogisticsCompanies();

    LogisticsCompanyDTO getLogisticCompany(long id);

    LogisticsCompany create(CreateLogisticsCompanyDTO createLogisticsCompanyDTO);

    LogisticsCompany updateLogisticCompany(long id, UpdateLogisticsCompanyDTO updateLogisticsCompanyDTO);

    void deleteLogisticCompany(long id);

    //List<LogisticsCompany> getLogisticsCompany();
}
