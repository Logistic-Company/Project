package com.example.project.services;

import com.example.project.data.entity.LogisticsCompany;
import java.util.List;

public interface LogisticsCompanyService {

    List<LogisticsCompany> getLogisticsCompanies();

    LogisticsCompany getLogisticCompany(long id);

    LogisticsCompany create(LogisticsCompany logisticsCompany);

    LogisticsCompany updateLogisticCompany(long id, LogisticsCompany logisticsCompany);

    void deleteLogisticCompany(long id);

    List<LogisticsCompany> getLogisticsCompany();
}
