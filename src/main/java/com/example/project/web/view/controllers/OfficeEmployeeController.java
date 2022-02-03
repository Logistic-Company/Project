package com.example.project.web.view.controllers;

import com.example.project.data.dto.*;
import com.example.project.data.entity.OfficeEmployee;
import com.example.project.services.OfficeEmployeeService;
import com.example.project.web.view.model.*;
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
@RequestMapping("/officeEmployees")
public class OfficeEmployeeController {

    private OfficeEmployeeService officeEmployeeService;
    private final ModelMapper modelMapper;

    @GetMapping
    public String getOfficeEmployees(Model model){
        final List<OfficeEmployeeViewModel> officeEmployees = officeEmployeeService.getOfficeEmployees()
                .stream().map(this::convertToOfficeEmployeeViewModel)
                .collect(Collectors.toList());
        model.addAttribute("officeEmployees", officeEmployees);
        return "/officeEmployees/officeEmployees.html";
    }

    @GetMapping("/create-officeEmployee")
    public String showCreateOfficeEmployeeForm(Model model){
        model.addAttribute("officeEmployee", new CreateOfficeEmployeeViewModel());
        return "/officeEmployees/create-officeEmployee";
    }

    @PostMapping("/create")
    public String createOfficeEmployee(@Valid @ModelAttribute("officeEmployee")
                                               CreateOfficeEmployeeViewModel officeEmployee,
                                       BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "officeEmployees/create-officeEmployee";
        }
        officeEmployeeService.create(modelMapper.map(officeEmployee, CreateOfficeEmployeeDTO.class));
        return "redirect:/officeEmployees";
    }

    @GetMapping("/edit-officeEmployee/{id}")
    public String showEditOfficeEmployeeForm(Model model, @PathVariable Long id){
        model.addAttribute("officeEmployee", modelMapper.map(officeEmployeeService.getOfficeEmployee(id),
                UpdateOfficeEmployeeViewModel.class));
        return "/officeEmployees/edit-officeEmployee";
    }

    @PostMapping("/update/{id}")
    public String updateOfficeEmployee(@PathVariable long id, @Valid @ModelAttribute("officeEmployee")
            UpdateOfficeEmployeeViewModel officeEmployee, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "officeEmployees/edit-officeEmployee";
        }
        officeEmployeeService.updateOfficeEmployee(id, modelMapper.map(officeEmployee, UpdateOfficeEmployeeDTO.class));
        return "redirect:/officeEmployees";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id){
        officeEmployeeService.deleteOfficeEmployee(id);
        return "redirect:/officeEmployees";
    }

    private OfficeEmployeeViewModel convertToOfficeEmployeeViewModel(OfficeEmployeeDTO officeEmployeeDTO) {
        return modelMapper.map(officeEmployeeDTO, OfficeEmployeeViewModel.class);
    }

}