package com.example.project.services;

import com.example.project.data.entity.Shipment;
import java.util.List;

public interface ShipmentService {

    List<Shipment> getShipments();

    Shipment getShipment(long id);

    Shipment create(Shipment shipment);

    Shipment updateShipment(long id, Shipment shipment);

    void deleteShipment(long id);
}
