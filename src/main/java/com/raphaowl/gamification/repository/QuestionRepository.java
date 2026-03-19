package com.raphaowl.gamification.repository;

import com.raphaowl.gamification.model.Question;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
