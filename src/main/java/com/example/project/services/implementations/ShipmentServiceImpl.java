package com.example.project.services.implementations;

import com.example.project.data.entity.Shipment;
import com.example.project.data.repository.ShipmentRepository;
import com.example.project.services.ShipmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Shipment> getShipments() {
        return shipmentRepository.findAll();
    }

    @Override
    public Shipment getShipment(long id) {
        return shipmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Shipment ID: " + id));
    }

    @Override
    public Shipment create(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    @Override
    public Shipment updateShipment(long id, Shipment parcel) {
        Shipment shipment = modelMapper.map(parcel, Shipment.class);
        shipment.setId(id);
        return shipmentRepository.save(parcel);
    }

    @Override
    public void deleteShipment(long id) {
        shipmentRepository.deleteById(id);
    }
}
