package com.example.project.web.view.controllers;

import com.example.project.data.dto.*;
import com.example.project.data.entity.LogisticsCompany;
import com.example.project.services.ClientsService;
import com.example.project.services.LogisticsCompanyService;
import com.example.project.web.view.model.CreateLogisticCompanyViewModel;
import com.example.project.web.view.model.LogisticCompanyViewModel;
import com.example.project.web.view.model.UpdateLogisticCompanyViewModel;
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
@RequestMapping("/logisticCompanies")
public class LogisticCompanyController {

    private LogisticsCompanyService logisticsCompanyService;
    private ClientsService clientsService;
    private final ModelMapper modelMapper;

    @GetMapping
    public String getLogisticsCompany(Model model){
        final List<LogisticCompanyViewModel> logisticsCompanies = logisticsCompanyService.getLogisticsCompanies()
                        .stream().map(this::convertToLogisticsCompanyViewModel)
                        .collect(Collectors.toList());
        model.addAttribute("logisticCompanies", logisticsCompanies);
        return "/logisticCompanies/logisticCompanies.html";
    }

    @GetMapping("select")
    public String getLogisticsCompany2(Model model){
        final List<LogisticCompanyViewModel> logisticsCompanies = logisticsCompanyService.getLogisticsCompanies()
                .stream().map(this::convertToLogisticsCompanyViewModel)
                .collect(Collectors.toList());
        model.addAttribute("logisticCompanies", logisticsCompanies);
        return "/logisticCompanies/select";

    }

    @GetMapping("/create-logisticCompany")
    public String showCreateLogisticCompanyForm(Model model){
        model.addAttribute("logisticCompany", new CreateLogisticCompanyViewModel());
        return "/logisticCompanies/create-logisticCompany";
    }

    @PostMapping("/create")
    public String createLogisticsCompany(@Valid @ModelAttribute("logisticCompany")
                                         CreateLogisticCompanyViewModel logisticsCompany,
                                         BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "logisticCompanies/create-logisticCompany";
        }
        logisticsCompanyService.create(modelMapper.map(logisticsCompany, CreateLogisticsCompanyDTO.class));
        return "redirect:/logisticCompanies";
    }

    

    @GetMapping("/edit-logisticCompany/{id}")
    public String showEditLogisticCompanyForm(Model model, @PathVariable Long id){
        model.addAttribute("logisticCompany", modelMapper.map(logisticsCompanyService.getLogisticCompany(id),
                UpdateLogisticCompanyViewModel.class));
        return "/logisticCompanies/edit-logisticCompany";
    }

    @PostMapping("/update/{id}")
    public String updateLogisticsCompany(@PathVariable long id, @Valid @ModelAttribute("logisticCompany")
            UpdateLogisticCompanyViewModel logisticsCompany, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "logisticCompanies/edit-logisticCompany";
        }
        logisticsCompanyService.updateLogisticCompany(id, modelMapper.map(logisticsCompany, UpdateLogisticsCompanyDTO.class));
        return "redirect:/logisticCompanies";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id){
        logisticsCompanyService.deleteLogisticCompany(id);
        return "redirect:/logisticCompanies";
    }

    private LogisticCompanyViewModel convertToLogisticsCompanyViewModel(LogisticsCompanyDTO logisticsCompanyDTO) {
        return modelMapper.map(logisticsCompanyDTO, LogisticCompanyViewModel.class);
    }

    @GetMapping("/referenceForCompanies")
    public String getClientsList(Model model) {
        /**List<User> userList = service.listAll();*/
        List<ClientsDTO> clientsList = clientsService.getClients();
        model.addAttribute("clientsList", clientsList);
        return "logisticCompanies/referenceForClients";
    }
}
