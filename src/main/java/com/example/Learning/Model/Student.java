package com.example.Learning.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "Student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    public Student(@NonNull String name, String eMail) {
        this.name = name;
        this.eMail = eMail;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    private String eMail;
    private LocalDate dateOfBirth;
    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;
    private Double cgpa;

}



