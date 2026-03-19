package com.raphaowl.gamification.dto;

import lombok.Data;

@Data
public class AnswerResult {
    private boolean correct;
    private String correctAnswer;
    private int damage;
    private int xpGained;
    private boolean bossDefeated;

    private int bossHp;
    private int bossMaxHp;
}
