package com.workintech.s18d4.dto;

public class AccountResponse {
    private long id;
    private String accountName;
    private Double moneyAmount;
    private CustomerResponse customerResponse;

    public AccountResponse() {}
    public AccountResponse(long id, String accountName, Double moneyAmount, CustomerResponse customerResponse) {
        this.id = id; this.accountName = accountName; this.moneyAmount = moneyAmount; this.customerResponse = customerResponse;
    }
    public long id() { return id; }
    public String accountName() { return accountName; }
    public Double moneyAmount() { return moneyAmount; }
    public CustomerResponse customerResponse() { return customerResponse; }
    
    public long getId() { return id; }
    public String getAccountName() { return accountName; }
    public Double getMoneyAmount() { return moneyAmount; }
    public CustomerResponse getCustomerResponse() { return customerResponse; }
}
