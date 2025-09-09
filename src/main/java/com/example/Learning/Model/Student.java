package com.example.Learning.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "Student")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Student {

    public Student(@NonNull String name, String passportNumber) {
        this.name = name;
        this.passportNumber = passportNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    private String passportNumber;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "passportNumber = " + passportNumber + ", " +
                "name = " + name + ")";
    }
}



