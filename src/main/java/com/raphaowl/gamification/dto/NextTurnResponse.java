package com.raphaowl.gamification.dto;

import lombok.Data;

@Data
public class NextTurnResponse {
    public String studentId;
    public String studentName;
    public String studentColor;

    public String questionId;
    public String question;

    public int bossHp;
    public int bossMaxHp;
    public String bossName;
    public String bossImageUrl;
}
