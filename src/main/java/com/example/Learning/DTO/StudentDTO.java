package com.example.Learning.DTO;


import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDTO {
    private String name;
    private String eMail;
    private LocalDate dateOfBirth;
    private Double cgpa;
    private Long majorId;
}