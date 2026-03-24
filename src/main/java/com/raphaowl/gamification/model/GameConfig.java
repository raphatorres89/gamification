package com.raphaowl.gamification.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "game_config")
@Data
public class GameConfig {

    @Id
    private String id = "default";

    private int xpOnCorrect;
    private int xpOnWrong;

    private int damageMin;
    private int damageMax;
    private int damageOnWrong;

    private String bossName;
    private int bossMaxHp;
    private String bossImageUrl;
}
