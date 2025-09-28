package com.example.Learning.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PostDTO {
    private Long id;
    private Long userId;
    private String title;
    private String body;

}
