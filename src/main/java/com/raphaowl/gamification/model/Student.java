package com.raphaowl.gamification.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "students")
@Data
public class Student {
    @Id
    private String id;
    private String name;
    private String color;

    public Student(String name, String color) {
        this.name = name;
        this.color = color;
    }
}
