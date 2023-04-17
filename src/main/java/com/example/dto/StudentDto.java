package com.example.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDto {

    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String mobile;
    private String city;
    private String state;
    private String country;
    private int zip;
    private String course;
    private String studentUuid;
}
