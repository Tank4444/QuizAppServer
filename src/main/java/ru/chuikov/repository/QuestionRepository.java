package ru.chuikov.repository;

import org.springframework.stereotype.Repository;
import ru.chuikov.entity.Question;

@Repository
public interface QuestionRepository extends CommonRepository<Question> {
}