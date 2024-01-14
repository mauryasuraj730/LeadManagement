package com.example.LeadManagement.modal;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
public class LeadPayload {
    @Pattern(regexp = "[0-9]+" ,message="Please Enter valid Lead Id ")
    private String leadId;


    @Pattern(regexp = "[a-zA-Z]+" ,message="Please Enter correct Name ")
    private String firstName;

    private String middleName;

    @Pattern(regexp = "[a-zA-Z]+" ,message="Please Enter correct Name ")
    private String lastName;

    @Pattern(regexp = "[6-9]\\d{9}" ,message="Please Enter correct Moblie Number ")
    private String mobileNumber;

    @Pattern(regexp = "[a-zA-Z]+" ,message="Please Enter correct gender ")
    private String gender;

    @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Invalid date format. The expected format is dd/MM/yyyy ")
    private String dob;

    @Email(message = "Please Enter Correct Email Address ")
    private String email;

}
