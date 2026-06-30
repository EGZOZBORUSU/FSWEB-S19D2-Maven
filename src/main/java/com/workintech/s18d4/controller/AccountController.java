package com.workintech.s18d4.controller;
import com.workintech.s18d4.dto.AccountResponse;
import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.AccountService;
import com.workintech.s18d4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping({"/workintech/accounts", "/account", "/accounts"})
public class AccountController {
    private final AccountService accountService;
    private final CustomerService customerService;
    @Autowired public AccountController(AccountService accountService, CustomerService customerService) {
        this.accountService = accountService; this.customerService = customerService;
    }
    
    @GetMapping public List<Account> findAll() { return accountService.findAll(); }
    
    @GetMapping("/{id}") public Account find(@PathVariable long id) { return accountService.find(id); }
    
    @PostMapping("/{customerId}") public AccountResponse save(@PathVariable long customerId, @RequestBody Account account) {
        Customer customer = customerService.find(customerId);
        if(customer == null) return null;
        account.setCustomer(customer); 
        Account saved = accountService.save(account);
        return new AccountResponse(saved.getId(), saved.getAccountName(), saved.getMoneyAmount(), 
               new CustomerResponse(customer.getId(), customer.getEmail(), customer.getSalary()));
    }
    
    @PutMapping("/{customerId}") public AccountResponse update(@PathVariable long customerId, @RequestBody Account account) {
        Customer customer = customerService.find(customerId);
        if(customer == null) return null;
        account.setCustomer(customer); 
        Account saved = accountService.save(account);
        return new AccountResponse(saved.getId(), saved.getAccountName(), saved.getMoneyAmount(), 
               new CustomerResponse(customer.getId(), customer.getEmail(), customer.getSalary()));
    }
    
    @DeleteMapping("/{id}") public AccountResponse delete(@PathVariable long id) {
        Account account = accountService.find(id); 
        if(account == null) return null;
        accountService.delete(id);
        return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount(), 
               new CustomerResponse(account.getCustomer().getId(), account.getCustomer().getEmail(), account.getCustomer().getSalary()));
    }
}
