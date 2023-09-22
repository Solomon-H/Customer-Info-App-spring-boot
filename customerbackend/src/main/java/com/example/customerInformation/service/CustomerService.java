package com.example.customerInformation.service;

import com.example.customerInformation.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public Customer addCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public Customer getCustomerById(long id);
    public List<Customer> getCustomers();
    public void deleteCustomer(long id);

}