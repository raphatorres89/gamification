package com.raphaowl.gamification.config;

import com.raphaowl.gamification.model.GameConfig;
import com.raphaowl.gamification.model.Question;
import com.raphaowl.gamification.model.Student;
import com.raphaowl.gamification.repository.GameConfigRepository;
import com.raphaowl.gamification.repository.QuestionRepository;
import com.raphaowl.gamification.repository.StudentRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoSeedConfig {
    @Bean
    CommandLineRunner seedData(
            StudentRepository studentRepo,
            QuestionRepository questionRepo,
            GameConfigRepository configRepo
    ) {
        return args -> {
            if (studentRepo.count() == 0) {
                studentRepo.save(new Student("Lucca", "#3498db"));
                studentRepo.save(new Student("Lívia", "#3498db"));
                studentRepo.save(new Student("Ana", "#3498db"));
                studentRepo.save(new Student("Helena", "#3498db"));

                studentRepo.save(new Student("Júlia Renata", "#e74c3c"));
                studentRepo.save(new Student("Cecília", "#e74c3c"));
                studentRepo.save(new Student("Vallentina", "#e74c3c"));
                studentRepo.save(new Student("Stefany", "#e74c3c"));
                studentRepo.save(new Student("Carlos", "#e74c3c"));
                studentRepo.save(new Student("Bernardo", "#e74c3c"));

                studentRepo.save(new Student("Júlia de Bem", "#2ecc71"));
                studentRepo.save(new Student("Jordana", "#2ecc71"));
                studentRepo.save(new Student("Piter", "#2ecc71"));
                studentRepo.save(new Student("Felipe Araújo", "#2ecc71"));
                studentRepo.save(new Student("Gustavo", "#2ecc71"));
                studentRepo.save(new Student("Arthur", "#2ecc71"));
            }

            if (questionRepo.count() == 0) {
                Question q1 = new Question();
                q1.setStatement("Qual o sobrenome do Mestre?");
                q1.setAnswer("Sabka");
                questionRepo.save(q1);

                Question q2 = new Question();
                q2.setStatement("Qual o nível do Mestre?");
                q2.setAnswer("99");
                questionRepo.save(q2);
            }

            if (configRepo.findById("default").isEmpty()) {
                GameConfig config = new GameConfig();
                config.setId("default");
                config.setXpOnCorrect(10);
                config.setXpOnWrong(0);
                config.setDamageMin(5);
                config.setDamageMax(15);
                config.setDamageOnWrong(0);
                config.setBossName("Jovem Sabka");
                config.setBossMaxHp(100);
                config.setBossImageUrl("https://i.imgur.com/XDG7OIT.png");
                configRepo.save(config);
            }
        };

    }
}
