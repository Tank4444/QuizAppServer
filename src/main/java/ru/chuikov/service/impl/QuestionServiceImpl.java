package ru.chuikov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.chuikov.entity.quiz.Question;
import ru.chuikov.repository.quiz.QuestionRepository;
import ru.chuikov.service.QuestionService;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question add(Question question) throws Exception {
        if(question.getId()!=null){
            var check = questionRepository.findById(question.getId());
            if(check.isPresent()) throw  new Exception("question with id "+question.getId()+" exist");
        }
        return questionRepository.save(question);
    }

    @Override
    public List<Question> addAll(Collection<Question> questions) {
        return questionRepository.saveAll(questions);
    }

    @Override
    public Question getById(Long id) throws Exception {
        return null;
    }

    @Override
    public Question update(Question question) throws FileNotFoundException {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteById(Question question) {

    }

    @Override
    public Collection<Question> getAll() {
        return null;
    }
}
