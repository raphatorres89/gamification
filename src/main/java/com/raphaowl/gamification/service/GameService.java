package com.raphaowl.gamification.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.raphaowl.gamification.dto.AnswerResult;
import com.raphaowl.gamification.dto.NextTurnResponse;
import com.raphaowl.gamification.model.Boss;
import com.raphaowl.gamification.model.GameConfig;
import com.raphaowl.gamification.model.GameSession;
import com.raphaowl.gamification.model.Question;
import com.raphaowl.gamification.model.Student;
import com.raphaowl.gamification.model.StudentProgress;
import com.raphaowl.gamification.repository.BossRepository;
import com.raphaowl.gamification.repository.GameConfigRepository;
import com.raphaowl.gamification.repository.GameSessionRepository;
import com.raphaowl.gamification.repository.QuestionRepository;
import com.raphaowl.gamification.repository.StudentProgressRepository;
import com.raphaowl.gamification.repository.StudentRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameService {

    private final StudentRepository studentRepo;
    private final QuestionRepository questionRepo;
    private final GameSessionRepository sessionRepo;
    private final StudentProgressRepository progressRepo;
    private final GameConfigRepository configRepo;
    private final BossRepository bossRepo;

    private Long lastStudentId;

    public Student getRandomStudent() {
        List<Student> students = studentRepo.findAll();

        Student selected;
        do {
            selected = students.get(new Random().nextInt(students.size()));
        } while (selected.getId().equals(lastStudentId));

        lastStudentId = selected.getId();
        return selected;
    }

    public Question getRandomQuestion() {
        List<Question> questions = questionRepo.findAll();

        if (questions.isEmpty()) {
            throw new RuntimeException("Nenhuma pergunta cadastrada!");
        }

        return questions.get(new Random().nextInt(questions.size()));
    }

    private void addXp(Student student, GameSession session, int xp) {
        StudentProgress progress = progressRepo
                .findByStudentIdAndSessionId(student.getId(), session.getId())
                .orElseGet(() -> {
                    StudentProgress p = new StudentProgress();
                    p.setStudent(student);
                    p.setSession(session);
                    p.setExperience(0);
                    return p;
                });

        progress.setExperience(progress.getExperience() + xp);
        progressRepo.save(progress);
    }

    private void damageBoss(Boss boss, int damage) {
        boss.setCurrentHp(Math.max(0, boss.getCurrentHp() - damage));
    }

    public Optional<GameSession> getActiveSession() {
        return sessionRepo.findFirstByFinishedFalse();
    }

    public List<StudentProgress> getRanking() {
        return progressRepo.findAll()
                .stream()
                .sorted((a,b) -> Integer.compare(b.getExperience(), a.getExperience()))
                .toList();
    }

    public AnswerResult processAnswer(Long studentId, Long questionId, boolean correct) {

        GameSession session = getActiveSession().get();

        Student student = studentRepo.findById(studentId).orElseThrow();
        Question question = questionRepo.findById(questionId).orElseThrow();
        GameConfig config = configRepo.findById(1L).orElseThrow();

        int xp = correct ? config.getXpOnCorrect() : config.getXpOnWrong();
        int damage;

        if (correct) {
            int min = config.getDamageMin();
            int max = config.getDamageMax();

            damage = new Random().nextInt(max - min + 1) + min;
        } else {
            damage = config.getDamageOnWrong();
        }

        addXp(student, session, xp);
        damageBoss(session.getBoss(), damage);

        boolean defeated = session.getBoss().getCurrentHp() <= 0;

        if (defeated) {
            session.setFinished(true);
        }

        bossRepo.save(session.getBoss());
        sessionRepo.save(session);

        AnswerResult result = new AnswerResult();
        result.setCorrect(correct);
        result.setCorrectAnswer(question.getAnswer());
        result.setDamage(damage);
        result.setXpGained(xp);
        result.setBossDefeated(defeated);

        // 👇 ESSENCIAL pro SPA atualizar UI
        result.setBossHp(session.getBoss().getCurrentHp());
        result.setBossMaxHp(session.getBoss().getMaxHp());

        return result;
    }

    public NextTurnResponse nextTurn() {
        Student student = getRandomStudent();
        Question question = getRandomQuestion();
        Boss boss = getActiveSession().get().getBoss();

        NextTurnResponse res = new NextTurnResponse();
        res.studentId = student.getId();
        res.studentName = student.getName();
        res.studentColor = student.getColor();
        res.questionId = question.getId();
        res.question = question.getStatement();
        res.bossHp = boss.getCurrentHp();
        res.bossMaxHp = boss.getMaxHp();
        res.bossName = boss.getName();

        GameConfig config = getConfig();
        res.bossImageUrl = config.getBossImageUrl();

        return res;
    }

    public NextTurnResponse startGame() {
        progressRepo.deleteAll();

        sessionRepo.deleteAll();

        GameSession session = new GameSession();

        GameConfig config = getConfig();

        Boss boss = new Boss();
        boss.setName(config.getBossName());
        boss.setMaxHp(config.getBossMaxHp());
        boss.setCurrentHp(config.getBossMaxHp());

        session.setBoss(boss);
        session.setFinished(false);

        sessionRepo.save(session);

        return nextTurn();
    }

    public GameConfig getConfig() {
        return configRepo.findById(1L).orElseThrow();
    }

    public GameConfig updateConfig(GameConfig request) {
        GameConfig config = configRepo.findById(1L).orElseThrow();

        config.setXpOnCorrect(request.getXpOnCorrect());
        config.setXpOnWrong(request.getXpOnWrong());
        if (config.getDamageMin() > config.getDamageMax()) {
            throw new IllegalArgumentException("Dano mínimo não pode ser maior que o máximo");
        }
        config.setDamageMin(request.getDamageMin());
        config.setDamageMax(request.getDamageMax());
        config.setDamageOnWrong(request.getDamageOnWrong());
        config.setBossName(request.getBossName());
        config.setBossMaxHp(request.getBossMaxHp());
        config.setBossImageUrl(request.getBossImageUrl());

        return configRepo.save(config);
    }
}
