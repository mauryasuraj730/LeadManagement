package com.example.LeadManagement.entity;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "lead")
public class LeadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer leadId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobileNumber;
    private String gender;
    private String dob;
    private String email;
}
