package ru.chuikov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.chuikov.entity.quiz.Answer;
import ru.chuikov.entity.quiz.Game;
import ru.chuikov.entity.quiz.Question;
import ru.chuikov.service.*;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private GameService gameService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private UserService userService;
    @Autowired
    private FileService fileService;

    @Override
    public Game addGame(Game game) throws Exception {
        var ngame = gameService.add(game);
        for(Question q:game.getQuestions()){
            q.setGame(ngame);
            var nq = questionService.add(q);
            for(Answer a: q.getAnswers()){
                a.setQuestion(nq);
                var na = answerService.add(a);
            }
        }
        return null;
    }

    @Override
    public Game getGameById(Long id) {
        return null;
    }

    @Override
    public List<Game> getGamesListByCreatorId(long id) {
        return gameService.getListByCreatorId(id);
    }
}
