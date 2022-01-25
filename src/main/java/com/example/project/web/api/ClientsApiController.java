package com.example.project.web.api;

import com.example.project.data.entity.Clients;
import com.example.project.services.ClientsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ClientsApiController {

    private final ClientsService clientsService;

    //private final ModelMapper modelMapper;
    @GetMapping(value = "/api/clients")
    public List<Clients> getClients() {
        return clientsService.getClients();
    }

    @RequestMapping("/api/clients/{id}")
    public Clients getClient(@PathVariable("id") int id) {
        return clientsService.getClient(id);
    }

    @PostMapping(value = "/api/clients")
    public Clients createClient(@RequestBody Clients clients) {
        return clientsService.create(clients);
    }

    //@RequestMapping(method = RequestMethod.POST, value = "/api/logistics_company")
    //public LogisticsCompany createLogisticsCompany(LogisticsCompany logisticsCompany) {
    //return logisticsCompanyService.create(logisticsCompany);
    //}

    @RequestMapping(method = RequestMethod.PUT, value = "/api/clients/{id}")
    public Clients updateClient(@PathVariable("id") long id, @RequestBody Clients clients) {
        return clientsService.updateClient(id, clients);
    }

    @DeleteMapping(value = "/api/clients/{id}")
    public void deleteClient(@PathVariable long id) {
        clientsService.deleteClient(id);
    }

//    @RequestMapping("/api/clients/names/{name}")
//    public List<Clients> findAllByName(@PathVariable String name) {
//        return clientsService.findAllByName(name);
//    }

}
