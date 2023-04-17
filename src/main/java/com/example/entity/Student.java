package com.example.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;
    @NotNull(message = "First Name should not be null")
    private String firstName;
    @NotNull(message = "Last Name should not be null")
    private String lastName;
    @Email(message = "Entered email not valid")
    private String email;
    @NotNull(message = "Mobile should not be null")
    @Pattern(regexp = "^\\d{10}$", message = "Invalid Mobile number.")
    private String mobile;
    private String gender;
    @NotNull(message = "City should not be null")
    private String city;
    @NotNull(message = "State should not be null")
    private String state;
    @NotNull(message = "Country should not be null")
    private String country;
    @NotNull(message = "Zip should not be null")
    private int zip;
    @NotNull(message = "Course should not be null")
    private String course;
}
