package com.raphaowl.gamification.repository;

import java.util.Optional;

import com.raphaowl.gamification.model.StudentProgress;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentProgressRepository extends MongoRepository<StudentProgress, String> {
    Optional<StudentProgress> findByStudentIdAndSessionId(String studentId, String sessionId);
}
