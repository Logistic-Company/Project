package com.example.project.web.api;

import com.example.project.data.entity.Address;
import com.example.project.services.AddressService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/logistics_company")
@AllArgsConstructor

public class AddressApiController {

    private final AddressService addressService;


    @GetMapping(value = "/api/address")
    public List<Address> getLogisticCompanies() {
        return addressService.getAddresses();
    }

    @RequestMapping("/api/address/{id}")
    public Address getAddress(@PathVariable("id") int id) {
        return addressService.getAddress(id);
    }

    @PostMapping(value = "/api/address")
    public Address createAddress(@RequestBody Address address) {
        return addressService.create(address);
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/api/logistics_company")
//    public LogisticsCompany createLogisticsCompany(LogisticsCompany logisticsCompany) {
//    return logisticsCompanyService.create(logisticsCompany);
//    }

    @RequestMapping(method = RequestMethod.PUT, value = "/api/address/{id}")
    public Address updateAddress(@PathVariable("id") long id, @RequestBody Address address) {
        return addressService.updateAddress(id, address);
    }

    @DeleteMapping(value = "/api/address/{id}")
    public void deleteAddress(@PathVariable long id) {
        addressService.deleteAddress(id);
    }

    @RequestMapping("/api/address/names/{name}")
    public List<Address> findAllByName(@PathVariable String name) {
        return addressService.findAllByName(name);
    }

}
