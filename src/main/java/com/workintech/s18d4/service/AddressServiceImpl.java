package com.workintech.s18d4.service;
import com.workintech.s18d4.repository.AddressRepository;
import com.workintech.s18d4.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    @Autowired public AddressServiceImpl(AddressRepository addressRepository) { this.addressRepository = addressRepository; }
    @Override public List<Address> findAll() { return addressRepository.findAll(); }
    @Override public Address find(long id) { return addressRepository.findById(id).orElse(null); }
    @Override public Address save(Address address) { return addressRepository.save(address); }
    @Override public Address delete(long id) { 
        Address addr = find(id); 
        if(addr != null) { addressRepository.delete(addr); } 
        return addr; 
    }
}
