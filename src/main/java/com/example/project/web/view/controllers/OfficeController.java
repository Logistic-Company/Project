package com.example.project.web.view.controllers;

import com.example.project.data.entity.Office;
import com.example.project.services.OfficeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/offices")
public class OfficeController {

    private OfficeService officeService;

    @GetMapping
    public String getOffices(Model model){
        final List<Office> offices = officeService.getOffices();
        model.addAttribute("offices", offices);
        return "/offices/offices.html";
    }

    @GetMapping("/create-office")
    public String showCreateOfficeForm(Model model){
        model.addAttribute("office", new Office());
        return "/offices/create-office";
    }

    @PostMapping("/create")
    public String createOffice(@Valid @ModelAttribute Office office){
        officeService.create(office);
        return "redirect:/offices";
    }

    @GetMapping("/edit-office/{id}")
    public String showEditOfficeForm(Model model, @PathVariable Long id){
        model.addAttribute("office", officeService.getOffice(id));
        return "/offices/edit-office";
    }

    @PostMapping("/update/{id}")
    public String updateOffice(Model model, long id, Office office){
        officeService.updateOffice(id, office);
        return "redirect:/offices";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id){
        officeService.deleteOffice(id);
        return "redirect:/offices";
    }
}
