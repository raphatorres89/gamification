package com.raphaowl.gamification.repository;

import com.raphaowl.gamification.model.Student;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
}
