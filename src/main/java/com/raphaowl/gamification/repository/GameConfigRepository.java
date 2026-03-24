package com.raphaowl.gamification.repository;

import com.raphaowl.gamification.model.GameConfig;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameConfigRepository extends MongoRepository<GameConfig, String> {
}
