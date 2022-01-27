package com.example.project.data.dto;

import com.example.project.data.entity.CourierEmployee;
import com.example.project.data.entity.Office;
import com.example.project.data.entity.OfficeEmployee;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class LogisticsCompanyDTO {
    private String name;
    private Set<Office> offices;
    private Set<OfficeEmployee> officeEmployees;
    private Set<CourierEmployee> courierEmployees;
    private int deleted;
}
