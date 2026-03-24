package com.raphaowl.gamification.controller;

import java.util.List;

import com.raphaowl.gamification.dto.AnswerResult;
import com.raphaowl.gamification.dto.NextTurnResponse;
import com.raphaowl.gamification.model.StudentProgress;
import com.raphaowl.gamification.service.GameService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class GameController {

    private final GameService service;

    @GetMapping("/")
    public String home() {
        return "game";
    }

    @GetMapping("/admin/questions")
    public String questionsPage() {
        return "questions";
    }

    @GetMapping("/admin/config")
    public String configPage() {
        return "config.html";
    }

    @PostMapping("/answer")
    @ResponseBody
    public AnswerResult answer(@RequestParam String studentId,
            @RequestParam String questionId,
            @RequestParam boolean correct) {

        return service.processAnswer(studentId, questionId, correct);
    }

    @GetMapping("/ranking")
    @ResponseBody
    public List<StudentProgress> ranking() {
        return service.getRanking();
    }

    @GetMapping("/next")
    @ResponseBody
    public NextTurnResponse nextTurn() {
        return service.nextTurn();
    }

    @GetMapping("/start")
    @ResponseBody
    public NextTurnResponse startGame() {
        return service.startGame();
    }
}
