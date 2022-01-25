package com.example.project.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "logisticsCompany")
@Entity
public class LogisticsCompany extends BaseEntity{
    private String name;

    @OneToMany(mappedBy="logisticsCompany")
    @JsonIgnoreProperties("logisticsCompany")
    private Set<Office> offices;

    @OneToMany(mappedBy="logisticsCompany")
    @JsonIgnoreProperties("logisticsCompany")
    private Set<OfficeEmployee> officeEmployees;

    @OneToMany(mappedBy="logisticsCompany")
    @JsonIgnoreProperties("logisticsCompany")
    private Set<CourierEmployee> courierEmployees;

}
