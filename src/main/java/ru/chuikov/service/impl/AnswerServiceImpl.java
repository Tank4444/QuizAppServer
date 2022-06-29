package ru.chuikov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.chuikov.entity.quiz.Answer;
import ru.chuikov.repository.quiz.AnswerRepository;
import ru.chuikov.service.AnswerService;

import java.util.Collection;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Answer add(Answer answer) throws Exception {
        return answerRepository.save(answer);
    }

    @Override
    public List<Answer> addAll(Collection<Answer> answers) {
        return answerRepository.saveAll(answers);
    }

    @Override
    public Answer getById(Long id) throws Exception {
        return answerRepository.findById(id).orElseThrow(Exception::new);
    }

    @Override
    public Answer update(Answer answer) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteById(Answer answer) {

    }

    @Override
    public Collection<Answer> getAll() {
        return null;
    }
}
