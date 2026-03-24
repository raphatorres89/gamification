package com.raphaowl.gamification.repository;

import java.util.Optional;

import com.raphaowl.gamification.model.GameSession;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameSessionRepository extends MongoRepository<GameSession, String> {
    Optional<GameSession> findFirstByFinishedFalse();
}
