package com.raphaowl.gamification.repository;

import com.raphaowl.gamification.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
