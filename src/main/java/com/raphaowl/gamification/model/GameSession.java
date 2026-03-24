package com.raphaowl.gamification.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "game_sessions")
@Data
public class GameSession {

    @Id
    private String id;
    private Boss boss;
    private boolean finished;
}
