package ru.chuikov.service;

import ru.chuikov.entity.quiz.Game;

import java.util.List;

public interface QuizService {

    Game addGame(Game game) throws Exception;

    Game getGameById(Long id) throws Exception;

    List<Game> getGamesListByCreatorId(long id) throws Exception;
}
