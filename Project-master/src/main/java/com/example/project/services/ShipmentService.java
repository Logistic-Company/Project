package com.example.project.services;

import ch.qos.logback.core.net.server.Client;
import com.example.project.data.dto.CreateShipmentDTO;
import com.example.project.data.dto.ShipmentDTO;
import com.example.project.data.dto.UpdateShipmentDTO;
import com.example.project.data.entity.Clients;
import com.example.project.data.entity.OfficeEmployee;
import com.example.project.data.entity.Shipment;
import java.util.List;

public interface ShipmentService {

    List<ShipmentDTO> getShipments();

    ShipmentDTO getShipment(long id);

    Shipment create(CreateShipmentDTO createShipmentDTO);

    Shipment updateShipment(long id, UpdateShipmentDTO updateShipmentDTO);

    void deleteShipment(long id);

    List<Shipment> getAllShipmentsForOfficeEmployee(OfficeEmployee officeEmployee);

    List<Shipment> getAllShipmentsForClient(Clients client, Clients client1);
}
