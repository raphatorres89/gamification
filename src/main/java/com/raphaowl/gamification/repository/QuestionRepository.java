package com.raphaowl.gamification.repository;

import com.raphaowl.gamification.model.Question;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository<Question, String> {
}
