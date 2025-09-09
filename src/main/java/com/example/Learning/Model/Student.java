package com.example.Learning.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "Student")
@Data
@Getter
@Setter
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
    private String major;
    private Double cgpa;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "major = " + major + ", " +
                "name = " + name + ", " +
                "eMail = " + eMail + ", " +
                "dateOfBirth = " + dateOfBirth + ", " +
                "cgpa = " + cgpa + ")";
    }
}



