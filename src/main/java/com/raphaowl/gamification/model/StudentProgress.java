package com.raphaowl.gamification.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "student_progress")
@Data
public class StudentProgress {

    @Id
    private String id;
    private Student student;
    private GameSession session;
    private int experience;
}
