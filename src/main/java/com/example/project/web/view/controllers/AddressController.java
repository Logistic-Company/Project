package com.example.project.web.view.controllers;

import com.example.project.data.entity.Address;
import com.example.project.services.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/addresses")
public class AddressController {

    private AddressService addressService;

    @GetMapping
    public String getAddresses(Model model){
        final List<Address> addresses = addressService.getAddresses();
        model.addAttribute("addresses", addresses);
        return "/addresses/addresses.html";
    }

    @GetMapping("/create-address")
    public String showCreateAddressForm(Model model){
        model.addAttribute("address", new Address());
        return "/addresses/create-address";
    }

    @PostMapping("/create")
    public String createAddress(@Valid @ModelAttribute Address address){
        addressService.create(address);
        return "redirect:/addresses";
    }

    @GetMapping("/edit-address/{id}")
    public String showEditAddressForm(Model model, @PathVariable Long id){
        model.addAttribute("address", addressService.getAddress(id));
        return "/addresses/edit-address";
    }

    @PostMapping("/update/{id}")
    public String updateAddress(Model model, @PathVariable long id, Address address){
        addressService.updateAddress(id, address);
        return "redirect:/addresses";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id){
        addressService.deleteAddress(id);
        return "redirect:/addresses";
    }

}
