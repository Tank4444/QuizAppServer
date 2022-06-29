package ru.chuikov.service;

import ru.chuikov.entity.quiz.Game;

import java.util.List;

public interface GameService extends CommonService<Game>{

    List<Game> getListByCreatorId(Long creatorId);
}
