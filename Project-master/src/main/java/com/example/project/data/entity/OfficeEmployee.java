package com.example.project.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="officeEmployee")
public class OfficeEmployee extends BaseEntity{
    private String name;

    @ManyToOne
    @JoinColumn(name="logisticsCompany_id")
    private LogisticsCompany logisticsCompany;

    /*@ManyToOne
    @JoinColumn(name="office_id")
    private LogisticsCompany Office;*/
}
