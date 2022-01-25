package com.example.project.services.implementations;

import com.example.project.data.entity.Address;
import com.example.project.data.entity.Clients;
import com.example.project.data.repository.ClientsRepository;
import com.example.project.services.ClientsService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientsServiceImpl implements ClientsService {
    
    private final ClientsRepository clientsRepository;
    private final ModelMapper modelMapper;

    @Override
    public List <Clients> getClients() {
        return clientsRepository.findAll();
    }

    @Override
    public Clients getClient(long id) {
        return clientsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Client ID: " + id));
    }

    @Override
    public Clients create(Clients clients) {
        return clientsRepository.save(clients);
    }

    @Override
    public Clients updateClient(long id, Clients clients) {
        Clients client = modelMapper.map(clients, Clients.class);
        client.setId(id);
        return clientsRepository.save(clients);
    }

    @Override
    public void deleteClient(long id) {
        clientsRepository.deleteById(id);
    }

    @Override
    public List<Clients> findAllByName(String name){
        return clientsRepository.findAllByName(name);
    }
}
