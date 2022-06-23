package com.lorenchess.demo.payloadDTO;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


/**
 * Class created with the reason to not expose directly the entity class.
 * */

@Data
public class EmployeeDTO {
    private Long id;

    @NotEmpty
    @Size(min = 2, message = "Name should be at list two characters")
    private String name;

    private String email;

    @NotEmpty
    @Size(min = 2, message = "Job title should be at list two characters")
    private String jobTitle;

    @Size(min = 10, message = "Phone number must be 10 characters long")
    private String phoneNumber;

    private String imageUrl;

    private String employeeCode;
}
