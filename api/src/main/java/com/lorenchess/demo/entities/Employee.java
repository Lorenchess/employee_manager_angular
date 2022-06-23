package com.lorenchess.demo.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Employee implements Serializable {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "guid")
    @SequenceGenerator(name="seq",sequenceName="oracle_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private Long id;
    @NotNull
    private String name;

    private String email;

    @NotNull
    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(nullable = false, updatable = false, name = "employee_code")
    private String employeeCode;

}
