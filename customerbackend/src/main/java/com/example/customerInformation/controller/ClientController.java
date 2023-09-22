package com.example.customerInformation.controller;

import com.example.customerInformation.model.Customer;
import com.example.customerInformation.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class ClientController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public String addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        return "Customer Added Successfully.";
    }

    @RequestMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable("id") long id){
        return customerService.getCustomerById(id);
    }

    @RequestMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @PutMapping("/customer")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable("id") long id){
        customerService.deleteCustomer(id);
        return "Customer Deleted";
    }
}

