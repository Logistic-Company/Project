package com.example.project.services.implementations;

import com.example.project.data.dto.ClientsDTO;
import com.example.project.data.dto.CreateLogisticsCompanyDTO;
import com.example.project.data.dto.LogisticsCompanyDTO;
import com.example.project.data.dto.UpdateLogisticsCompanyDTO;
import com.example.project.data.entity.Clients;
import com.example.project.data.entity.LogisticsCompany;
import com.example.project.data.repository.ClientsRepository;
import com.example.project.data.repository.LogisticsCompanyRepository;
import com.example.project.services.LogisticsCompanyService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LogisticsCompanyServiceImpl implements LogisticsCompanyService {

    private final LogisticsCompanyRepository logisticsCompanyRepository;
    private final ClientsRepository clientsRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<LogisticsCompanyDTO> getLogisticsCompanies() {
        return logisticsCompanyRepository.findAll().stream()
                .map(this::convertToLogisticsCompanyDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<LogisticsCompanyDTO> getLogisticsCompanies2() {
        return logisticsCompanyRepository.findAll().stream()
                .map(this::convertToLogisticsCompanyDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LogisticsCompanyDTO getLogisticCompany(long id) {
        return modelMapper
                .map(logisticsCompanyRepository.findById(id).orElseThrow(()
                        -> new IllegalArgumentException("Invalid Logistics Company ID: " + id)),
                        LogisticsCompanyDTO.class);
    }

    @Override
    public LogisticsCompany create(CreateLogisticsCompanyDTO createLogisticsCompanyDTO) {
        return logisticsCompanyRepository.save(modelMapper.map(createLogisticsCompanyDTO, LogisticsCompany.class));
    }

    @Override
    public LogisticsCompany updateLogisticCompany(long id, UpdateLogisticsCompanyDTO logisticsCompanyDTO) {
        LogisticsCompany logisticsCompany1 = modelMapper.map(logisticsCompanyDTO, LogisticsCompany.class);
        logisticsCompany1.setId(id);
        return  logisticsCompanyRepository.save(logisticsCompany1);
    }

    @Override
    public void deleteLogisticCompany(long id) {
        logisticsCompanyRepository.deleteById(id);
    }

    private LogisticsCompanyDTO convertToLogisticsCompanyDTO(LogisticsCompany logisticsCompany) {
              return modelMapper.map(logisticsCompany, LogisticsCompanyDTO.class);
    }

    private ClientsDTO convertToClientsDTO(Clients clients) {
        return modelMapper.map(clients, ClientsDTO.class);
    }

    @Override
    public List<ClientsDTO> getClientsList() {
        return clientsRepository.findAll().stream()
                .map(this::convertToClientsDTO)
                .collect(Collectors.toList());
    }


    /*@Override
    public List<ClientsDTO> getClientsListByCompanyId(long id) {
        return logisticsCompanyRepository.findAllById(id);
    }*/
}
