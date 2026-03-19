package com.raphaowl.gamification.dto;

import lombok.Data;

@Data
public class NextTurnResponse {
    public Long studentId;
    public String studentName;
    public String studentColor;

    public Long questionId;
    public String question;

    public int bossHp;
    public int bossMaxHp;
    public String bossImageUrl;
}
