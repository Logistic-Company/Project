package com.example.project.services.implementations;

import com.example.project.data.entity.Address;
import com.example.project.data.repository.AddressRepository;
import com.example.project.services.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddress(long id) {
        return addressRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Address ID: " + id));
    }

    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(long id, Address address) {
        return null;
    }

    @Override
    public void deleteAddress(long id) {}



    @Override
    public List<Address> findAllByName(String name){
        return addressRepository.findAllByAddress(name);
    }
}
