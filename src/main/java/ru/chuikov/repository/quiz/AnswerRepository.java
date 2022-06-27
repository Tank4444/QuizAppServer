package ru.chuikov.repository.quiz;

import org.springframework.stereotype.Repository;
import ru.chuikov.entity.quiz.Answer;
import ru.chuikov.repository.CommonRepository;

@Repository
public interface AnswerRepository extends CommonRepository<Answer> {
}
