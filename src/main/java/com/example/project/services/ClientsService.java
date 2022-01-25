package com.example.project.services;

import com.example.project.data.entity.Address;
import com.example.project.data.entity.Clients;
import java.util.List;

public interface ClientsService {

    List<Clients> getClients();

    Clients getClient(long id);

    Clients create(Clients clients);

    Clients updateClient(long id, Clients clients);

    void deleteClient(long id);

    List<Clients>findAllByName(String name);

}
