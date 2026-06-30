package com.workintech.s18d4.dto;

public class CustomerResponse {
    private long id;
    private String email;
    private Double salary;

    public CustomerResponse() {}
    public CustomerResponse(long id, String email, Double salary) {
        this.id = id; this.email = email; this.salary = salary;
    }
    public long id() { return id; }
    public String email() { return email; }
    public Double salary() { return salary; }
    
    public long getId() { return id; }
    public String getEmail() { return email; }
    public Double getSalary() { return salary; }
}
