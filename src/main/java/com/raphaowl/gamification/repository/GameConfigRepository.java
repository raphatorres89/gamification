package com.raphaowl.gamification.repository;

import com.raphaowl.gamification.model.GameConfig;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GameConfigRepository extends JpaRepository<GameConfig, Long> {
}
