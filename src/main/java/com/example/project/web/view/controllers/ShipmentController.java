package com.example.project.web.view.controllers;

import com.example.project.data.entity.Shipment;
import com.example.project.services.ShipmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/shipments")
public class ShipmentController {
    private ShipmentService shipmentService;

    @GetMapping
    public String getShipments(Model model){
        final List<Shipment> shipments = shipmentService.getShipments();
        model.addAttribute("shipments", shipments);
        return "/shipments/shipments.html";
    }

    @GetMapping("/create-shipment")
    public String showCreateShipmentForm(Model model){
        model.addAttribute("shipment", new Shipment());
        return "/shipments/create-shipment";
    }

    @PostMapping("/create")
    public String createAddress(@Valid @ModelAttribute Shipment shipment){
        shipmentService.create(shipment);
        return "redirect:/shipments";
    }

    @GetMapping("/edit-shipment/{id}")
    public String showEditShipmentForm(Model model, @PathVariable Long id){
        model.addAttribute("shipment", shipmentService.getShipment(id));
        return "/shipments/edit-shipment";
    }

    @PostMapping("/update/{id}")
    public String updateShipment(Model model, @PathVariable long id, Shipment shipment){
        shipmentService.updateShipment(id, shipment);
        return "redirect:/shipments";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id){
        shipmentService.deleteShipment(id);
        return "redirect:/shipments";
    }
}
