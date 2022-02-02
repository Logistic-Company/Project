package com.example.project.services;

import com.example.project.data.dto.ClientsDTO;
import com.example.project.data.dto.CreateLogisticsCompanyDTO;
import com.example.project.data.dto.LogisticsCompanyDTO;
import com.example.project.data.dto.UpdateLogisticsCompanyDTO;
import com.example.project.data.entity.Clients;
import com.example.project.data.entity.LogisticsCompany;
import java.util.List;

public interface LogisticsCompanyService {

    List<LogisticsCompanyDTO> getLogisticsCompanies();

    List<LogisticsCompanyDTO> getLogisticsCompanies2();

    LogisticsCompanyDTO getLogisticCompany(long id);

    LogisticsCompany create(CreateLogisticsCompanyDTO createLogisticsCompanyDTO);

    LogisticsCompany updateLogisticCompany(long id, UpdateLogisticsCompanyDTO updateLogisticsCompanyDTO);

    void deleteLogisticCompany(long id);

    //List<LogisticsCompany> getLogisticsCompany();

    List<ClientsDTO> getClientsList();
}
