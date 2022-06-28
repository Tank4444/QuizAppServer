package ru.chuikov.controller.api;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.chuikov.entity.actor.User;
import ru.chuikov.entity.dto.quiz.GameDto;
import ru.chuikov.entity.quiz.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/game")
@Log4j2
public class GameController {

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseBody
    public Game addGame(@AuthenticationPrincipal User user, @RequestBody Map newGame){
        log.info("User {} try add new game",user.getId());
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
        return game;
    }
}
