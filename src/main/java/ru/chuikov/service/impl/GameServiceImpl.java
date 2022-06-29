package ru.chuikov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.chuikov.entity.quiz.Game;
import ru.chuikov.repository.quiz.GameRepository;
import ru.chuikov.service.GameService;
import ru.chuikov.service.UserService;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private UserService userService;


    @Override
    public Game add(Game game) throws Exception {
        if(game.getId()!=null){
            var check = gameRepository.findById(game.getId());
            if(check.isPresent()) throw new Exception("game with id "+game.getId()+" exist");
        }
        var user = userService.getById(game.getCreator().getId());
        game.setCreator(user);
        return gameRepository.save(game);
    }

    @Override
    public List<Game> addAll(Collection<Game> games) {
        return null;
    }

    @Override
    public Game getById(Long id) throws FileNotFoundException {
        var game = gameRepository.findById(id);
        if(game.isEmpty()) throw new FileNotFoundException("game with id"+id+" not found");
        return game.get();
    }

    @Override
    public Game update(Game game) throws FileNotFoundException {
        var check = gameRepository.findById(game.getId());
        if(check.isEmpty()) throw new FileNotFoundException("game with id"+game.getId()+" not found");
        game.setId(check.get().getId());
        game.setCreator(check.get().getCreator());
        return gameRepository.save(game);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteById(Game game) {

    }

    @Override
    public Collection<Game> getAll() {
        return null;
    }

    @Override
    public List<Game> getListByCreatorId(Long creatorId) {
        return gameRepository.findAllByCreatorId(creatorId);
    }
}
