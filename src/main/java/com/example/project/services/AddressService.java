package com.example.project.services;

import com.example.project.data.entity.Address;
import java.util.List;

public interface AddressService {

    List<Address> getAddresses();

    Address getAddress(long id);

    Address create(Address address);

    Address updateAddress(long id, Address address);

    void deleteAddress(long id);

    List<Address>findAllByName(String name);
}
