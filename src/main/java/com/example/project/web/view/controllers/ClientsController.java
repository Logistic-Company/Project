package com.example.project.web.view.controllers;

import com.example.project.data.entity.Clients;
import com.example.project.services.ClientsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/clients")
public class ClientsController {
    private ClientsService clientsService;

    @GetMapping
    public String getClients(Model model) {
        final List<Clients> clients = clientsService.getClients();
        model.addAttribute("clients", clients);
        return "/clients/clients.html";
    }

    @GetMapping("/create-client")
    public String showCreateClientsForm(Model model) {
        model.addAttribute("client", new Clients());
        return "/clients/create-client";
    }

    @PostMapping("/create")
    public String createClient(@Valid @ModelAttribute Clients client) {
        clientsService.create(client);
        return "redirect:/clients";
    }

    @GetMapping("/edit-client/{id}")
    public String showEditAddressForm(Model model, @PathVariable Long id) {
        model.addAttribute("client", clientsService.getClient(id));
        return "/clients/edit-client";
    }

    @PostMapping("/update/{id}")
    public String updateClient(Model model, long id, Clients client) {
        clientsService.updateClient(id, client);
        return "redirect:/clients";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        clientsService.deleteClient(id);
        return "redirect:/addresses";
    }
}
