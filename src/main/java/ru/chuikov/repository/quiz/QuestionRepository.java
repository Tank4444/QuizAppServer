package ru.chuikov.repository.quiz;

import org.springframework.stereotype.Repository;
import ru.chuikov.entity.quiz.Question;
import ru.chuikov.repository.CommonRepository;

@Repository
public interface QuestionRepository extends CommonRepository<Question> {
}
