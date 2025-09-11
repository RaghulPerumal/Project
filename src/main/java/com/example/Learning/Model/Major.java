package com.example.Learning.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "Major")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NonNull
    private String name;
    private int durationYears;
    private String description;
}
