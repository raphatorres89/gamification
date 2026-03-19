package com.raphaowl.gamification.repository;

import java.util.Optional;

import com.raphaowl.gamification.model.StudentProgress;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentProgressRepository extends JpaRepository<StudentProgress, Long> {
    Optional<StudentProgress> findByStudentIdAndSessionId(Long studentId, Long sessionId);
}
