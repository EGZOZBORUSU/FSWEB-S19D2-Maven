package com.workintech.s18d4.controller;
import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping({"/workintech/customers", "/customer", "/customers"})
public class CustomerController {
    private final CustomerService customerService;
    @Autowired public CustomerController(CustomerService customerService) { this.customerService = customerService; }
    
    @GetMapping public List<Customer> findAll() { return customerService.findAll(); }
    
    @GetMapping("/{id}") public CustomerResponse find(@PathVariable long id) {
        Customer c = customerService.find(id); 
        if(c == null) return null;
        return new CustomerResponse(c.getId(), c.getEmail(), c.getSalary());
    }
    
    @PostMapping public CustomerResponse save(@RequestBody Customer customer) {
        Customer saved = customerService.save(customer); 
        return new CustomerResponse(saved.getId(), saved.getEmail(), saved.getSalary());
    }
    
    @PutMapping("/{id}") public CustomerResponse update(@RequestBody Customer customer, @PathVariable long id) {
        Customer existing = customerService.find(id);
        if(existing != null) { customer.setAddress(existing.getAddress()); }
        customer.setId(id); 
        Customer saved = customerService.save(customer);
        return new CustomerResponse(saved.getId(), saved.getEmail(), saved.getSalary());
    }
    
    @DeleteMapping("/{id}") public CustomerResponse delete(@PathVariable long id) {
        Customer c = customerService.delete(id); 
        if(c == null) return null;
        return new CustomerResponse(c.getId(), c.getEmail(), c.getSalary());
    }
}
