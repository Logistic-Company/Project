package com.example.project.web.view.controllers;

import com.example.project.data.entity.LogisticsCompany;
import com.example.project.services.LogisticsCompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/logisticCompanies")
public class LogisticCompanyController {

    private LogisticsCompanyService logisticsCompanyService;

    @GetMapping
    public String getLogisticsCompany(Model model){
        final List<LogisticsCompany> logisticsCompanies = logisticsCompanyService.getLogisticsCompanies();
        model.addAttribute("logisticCompanies", logisticsCompanies);
        return "/logisticCompanies/logisticCompanies.html";
    }

    @GetMapping("/create-logisticCompany")
    public String showCreateLogisticCompanyForm(Model model){
        model.addAttribute("logisticCompany", new LogisticsCompany());
        return "/logisticCompanies/create-logisticCompany";
    }

    @PostMapping("/create")
    public String createLogisticsCompany(@Valid @ModelAttribute LogisticsCompany logisticsCompany){
        logisticsCompanyService.create(logisticsCompany);
        return "redirect:/logisticCompanies";
    }

    @GetMapping("/edit-logisticCompany/{id}")
    public String showEditLogisticCompanyForm(Model model, @PathVariable Long id){
        model.addAttribute("logisticCompany", logisticsCompanyService.getLogisticCompany(id));
        return "/logisticCompanies/edit-logisticCompany";
    }

    @PostMapping("/update/{id}")
    public String updateLogisticsCompany(Model model, long id, LogisticsCompany logisticsCompany){
        logisticsCompanyService.updateLogisticCompany(id, logisticsCompany);
        return "redirect:/logisticCompanies";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id){
        logisticsCompanyService.deleteLogisticCompany(id);
        return "redirect:/logisticCompanies";
    }
}
