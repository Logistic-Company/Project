package com.example.project.web.view.controllers;

import com.example.project.data.dto.CreateShipmentDTO;
import com.example.project.data.dto.ShipmentDTO;
import com.example.project.data.dto.UpdateShipmentDTO;
import com.example.project.data.entity.Shipment;
import com.example.project.services.ShipmentService;
import com.example.project.web.view.model.CreateShipmentViewModel;
import com.example.project.web.view.model.ShipmentViewModel;
import com.example.project.web.view.model.UpdateShipmentViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/shipments")
public class ShipmentController {
    private ShipmentService shipmentService;
    private final ModelMapper modelMapper;


    @GetMapping
    public String getShipments(Model model){
        final List<ShipmentViewModel> shipments = shipmentService.getShipments()
                        .stream().map(this::convertToShipmentViewModel)
                        .collect(Collectors.toList());
        model.addAttribute("shipments", shipments);
        return "/shipments/shipments.html";
    }

    @GetMapping("/create-shipment")
    public String showCreateShipmentForm(Model model){
        model.addAttribute("shipment", new CreateShipmentViewModel());
        return "/shipments/create-shipment";
    }

    @PostMapping("/create")
    public String createShipment(@Valid @ModelAttribute("shipment") CreateShipmentViewModel shipment,
                                 BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "shipments/create-shipment";
        }
        shipmentService.create(modelMapper.map(shipment, CreateShipmentDTO.class));
        return "redirect:/shipments";
    }

    @GetMapping("/edit-shipment/{id}")
    public String showEditShipmentForm(Model model, @PathVariable Long id){
        model.addAttribute("shipment", modelMapper.map(shipmentService.getShipment(id),
                UpdateShipmentViewModel.class));
        return "/shipments/edit-shipment";
    }

    @PostMapping("/update/{id}")
    public String updateShipment(@PathVariable long id, @Valid @ModelAttribute("shipment") UpdateShipmentViewModel shipment,
                                 BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "shipments/edit-shipment";
        }
        shipmentService.updateShipment(id, modelMapper.map(shipment, UpdateShipmentDTO.class));
        return "redirect:/shipments";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id){
        shipmentService.deleteShipment(id);
        return "redirect:/shipments";
    }

    private ShipmentViewModel convertToShipmentViewModel(ShipmentDTO shipmentDTO) {
        return modelMapper.map(shipmentDTO, ShipmentViewModel.class);
    }
}
