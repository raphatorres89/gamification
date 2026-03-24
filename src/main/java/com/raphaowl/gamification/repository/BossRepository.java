package com.raphaowl.gamification.repository;

import com.raphaowl.gamification.model.Boss;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BossRepository extends MongoRepository<Boss, String> {
}
