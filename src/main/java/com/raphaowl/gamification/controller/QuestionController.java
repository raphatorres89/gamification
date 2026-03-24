package com.raphaowl.gamification.controller;

import java.util.List;

import com.raphaowl.gamification.model.Question;
import com.raphaowl.gamification.repository.QuestionRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionRepository questionRepo;

    @PostMapping
    public Question create(@RequestBody Question q) {
        return questionRepo.save(q);
    }

    @GetMapping
    public List<Question> list() {
        return questionRepo.findAll();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Question update(@PathVariable String id, @RequestBody Question q) {

        Question existing = questionRepo.findById(id).orElseThrow();

        existing.setStatement(q.getStatement());
        existing.setAnswer(q.getAnswer());

        return questionRepo.save(existing);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        questionRepo.deleteById(id);
    }
}
