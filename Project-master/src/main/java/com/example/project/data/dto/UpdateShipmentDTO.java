package com.example.project.data.dto;

import com.example.project.data.entity.Address;
import com.example.project.data.entity.Clients;
import com.example.project.data.entity.OfficeEmployee;
import com.example.project.data.entity.Shipment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateShipmentDTO {
    private Clients sender;
    private Clients receiver;
    private Address address;
    private double weight;
    private OfficeEmployee officeEmployee;
    private int deleted;
}