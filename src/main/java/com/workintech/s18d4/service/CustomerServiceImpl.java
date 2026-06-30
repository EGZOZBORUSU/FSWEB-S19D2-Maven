package com.workintech.s18d4.service;
import com.workintech.s18d4.repository.CustomerRepository;
import com.workintech.s18d4.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    @Autowired public CustomerServiceImpl(CustomerRepository customerRepository) { this.customerRepository = customerRepository; }
    @Override public List<Customer> findAll() { return customerRepository.findAll(); }
    @Override public Customer find(long id) { return customerRepository.findById(id).orElse(null); }
    @Override public Customer save(Customer customer) { return customerRepository.save(customer); }
    @Override public Customer delete(long id) { 
        Customer c = find(id); 
        if(c != null) { customerRepository.delete(c); } 
        return c; 
    }
}
