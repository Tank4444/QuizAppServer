package ru.chuikov.controller.api;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.chuikov.entity.actor.User;
import ru.chuikov.entity.dto.quiz.GameDto;
import ru.chuikov.entity.quiz.Game;
import ru.chuikov.service.GameService;
import ru.chuikov.service.QuizService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/game")
@Log4j2
public class GameController {

    @Autowired
    private QuizService quizService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(path = "/add")
    public ResponseEntity addGame(@AuthenticationPrincipal User user, @RequestBody GameDto newGame){
        log.info("User {} try add new game",user.getId());
        /*
        var game = Game.builder()
                .gameType(GameType.QUIZ)
                .questions(
                        List.of(
                                Question.builder()
                                        .text("abs")
                                        .questionType(QuestionType.MANY_ANSWERS)
                                        .answers(List.of(
                                                Answer.builder()
                                                        .text("1")
                                                        .isRight(true)
                                                        .build(),
                                                Answer.builder()
                                                        .text("2")
                                                        .isRight(false)
                                                        .build(),
                                                Answer.builder()
                                                        .text("3")
                                                        .isRight(false)
                                                        .build()
                                        ))
                                        .build(),
                                Question.builder()
                                        .text("cfq")
                                        .questionType(QuestionType.MANY_ANSWERS)
                                        .answers(List.of(
                                                Answer.builder()
                                                        .text("1")
                                                        .isRight(true)
                                                        .build(),
                                                Answer.builder()
                                                        .text("2")
                                                        .isRight(false)
                                                        .build(),
                                                Answer.builder()
                                                        .text("3")
                                                        .isRight(false)
                                                        .build()
                                        ))
                                        .build(),
                                Question.builder()
                                        .text("xcv")
                                        .questionType(QuestionType.MANY_ANSWERS)
                                        .answers(List.of(
                                                Answer.builder()
                                                        .text("1")
                                                        .isRight(true)
                                                        .build(),
                                                Answer.builder()
                                                        .text("2")
                                                        .isRight(false)
                                                        .build(),
                                                Answer.builder()
                                                        .text("3")
                                                        .isRight(false)
                                                        .build()
                                        ))
                                        .build(),
                                Question.builder()
                                        .text("qwe")
                                        .questionType(QuestionType.MANY_ANSWERS)
                                        .answers(List.of(
                                                Answer.builder()
                                                        .text("1")
                                                        .isRight(true)
                                                        .build(),
                                                Answer.builder()
                                                        .text("2")
                                                        .isRight(false)
                                                        .build(),
                                                Answer.builder()
                                                        .text("3")
                                                        .isRight(false)
                                                        .build()
                                        ))
                                        .build()
                        )
                )
                .build();
        //var gamedto = modelMapper.map(game,GameDto.class);
         */
        var game = modelMapper.map(newGame,Game.class);
        game.setCreator(user);
        try {
            quizService.addGame(game);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(null);
    }

    @GetMapping(path = "/list")
    public ResponseEntity getListOfGames(@AuthenticationPrincipal User user){
        log.info("user with id {} request list of games",user.getId());
        List<Game> or = null;
        try {
            or = quizService.getGamesListByCreatorId(user.getId());
//            var ret = or
//                    .stream()
//                    .map(game -> modelMapper
//                            .typeMap(Game.class,GameDto.class)
//                            .addMappings(
//                                    mapping -> {
//                                        mapping.skip(GameDto::setCreator);
//                                    }
//                            ).map(game))
//                    .toList();
            var ret = or
                    .stream()
                    .map(game -> modelMapper.map(game,GameDto.class))
                    .toList();
            return ResponseEntity.ok(ret);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
