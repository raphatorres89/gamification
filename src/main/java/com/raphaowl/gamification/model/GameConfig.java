package com.raphaowl.gamification.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.Data;

@Entity
@Data
public class GameConfig {

    @Id
    private Long id = 1L;

    private int xpOnCorrect;
    private int xpOnWrong;

    private int damageMin;
    private int damageMax;
    private int damageOnWrong;

    private String bossName;
    private int bossMaxHp;
    private String bossImageUrl;
}
