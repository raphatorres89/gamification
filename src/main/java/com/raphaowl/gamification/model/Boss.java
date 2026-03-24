package com.raphaowl.gamification.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "bosses")
@Data
@NoArgsConstructor
public class Boss {
    @Id
    private String id;
    private String name;
    private int maxHp;
    private int currentHp;

    public Boss(String name, int maxHp, int currentHp){
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = currentHp;
    }
}
