package com.example.project.web.view.controllers;

import com.example.project.data.entity.Address;
import com.example.project.data.entity.CourierEmployee;
import com.example.project.services.CourierEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/courierEmployees")
public class CourierController {

    private CourierEmployeeService courierEmployeeService;

    @GetMapping
    public String getCourierEmployees(Model model){
        final List<CourierEmployee> courierEmployees = courierEmployeeService.getCourierEmployees();
        model.addAttribute("courierEmployees", courierEmployees);
        return "/courierEmployees/courierEmployees.html";
    }

    @GetMapping("/create-courierEmployee")
    public String showCreateCourierEmployeeForm(Model model){
        model.addAttribute("courierEmployee", new Address());
        return "/courierEmployees/create-courierEmployee";
    }

    @PostMapping("/create")
    public String createCourierEmployee(@Valid @ModelAttribute CourierEmployee courierEmployee){
        courierEmployeeService.create(courierEmployee);
        return "redirect:/courierEmployees";
    }

    @GetMapping("/edit-courierEmployee/{id}")
    public String showEditCourierEmployeeForm(Model model, @PathVariable Long id){
        model.addAttribute("courierEmployee", courierEmployeeService.getCourierEmployee(id));
        return "/courierEmployees/edit-courierEmployee";
    }

    @PostMapping("/update/{id}")
    public String updateCourierEmployee(Model model, @PathVariable long id, CourierEmployee courierEmployee){
        courierEmployeeService.updateCourierEmployee(id, courierEmployee);
        return "redirect:/courierEmployees";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id){
        courierEmployeeService.deleteCourierEmployee(id);
        return "redirect:/courierEmployees";
    }
}
