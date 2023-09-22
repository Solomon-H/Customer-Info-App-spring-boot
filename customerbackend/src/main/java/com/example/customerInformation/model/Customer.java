package com.example.customerInformation.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="customer_table")
public class Customer {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    private String gender;

}