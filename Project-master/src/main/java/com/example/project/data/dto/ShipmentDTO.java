package com.example.project.data.dto;

import com.example.project.data.entity.Address;
import com.example.project.data.entity.Clients;
import com.example.project.data.entity.OfficeEmployee;
import com.example.project.data.entity.Shipment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ShipmentDTO {
    private long id;
    private Clients sender;
    private Clients receiver;
    private Address address;
    private double weight;
    private OfficeEmployee officeEmployee;
    private int deleted;
    private boolean isRecieved;
}
