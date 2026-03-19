package com.raphaowl.gamification.repository;

import java.util.Optional;

import com.raphaowl.gamification.model.GameSession;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GameSessionRepository extends JpaRepository<GameSession, Long> {
    Optional<GameSession> findFirstByFinishedFalse();
}
