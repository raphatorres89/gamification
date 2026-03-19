package com.raphaowl.gamification.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Boss {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int maxHp;
    private int currentHp;

    public Boss(String name, int maxHp, int currentHp){
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = currentHp;
    }
}
