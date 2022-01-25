package com.example.project.web.view.controllers;

import com.example.project.data.entity.OfficeEmployee;
import com.example.project.services.OfficeEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/officeEmployees")
public class OfficeEmployeeController {

    private OfficeEmployeeService officeEmployeeService;

    @GetMapping
    public String getOfficeEmployees(Model model){
        final List<OfficeEmployee> officeEmployees = officeEmployeeService.getOfficeEmployees();
        model.addAttribute("officeEmployees", officeEmployees);
        return "/officeEmployees/officeEmployees.html";
    }

    @GetMapping("/create-officeEmployee")
    public String showCreateAddressForm(Model model){
        model.addAttribute("officeEmployee", new OfficeEmployee());
        return "/officeEmployees/create-officeEmployee";
    }

    @PostMapping("/create")
    public String createOfficeEmployee(@Valid @ModelAttribute OfficeEmployee officeEmployee){
        officeEmployeeService.create(officeEmployee);
        return "redirect:/officeEmployees";
    }

    @GetMapping("/edit-officeEmployee/{id}")
    public String showEditOfficeEmployeeForm(Model model, @PathVariable Long id){
        model.addAttribute("officeEmployee", officeEmployeeService.getOfficeEmployee(id));
        return "/officeEmployees/edit-officeEmployee";
    }

    @PostMapping("/update/{id}")
    public String updateOfficeEmployee(Model model, long id, OfficeEmployee officeEmployee){
        officeEmployeeService.updateOfficeEmployee(id, officeEmployee);
        return "redirect:/officeEmployees";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id){
        officeEmployeeService.deleteOfficeEmployee(id);
        return "redirect:/officeEmployees";
    }

}
